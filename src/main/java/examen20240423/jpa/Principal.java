package examen20240423.jpa;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import examen20240423.jpa.controllers.ControladorContrato;
import examen20240423.jpa.controllers.DatosDeTabla;
import examen20240423.jpa.model.Contrato;
import examen20240423.jpa.vista.PanelContrato;


import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private PanelContrato panelContrato = new PanelContrato();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		this.dtm = getDefaultTableModelNoEditable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setResizeWeight(0.4);
		splitPane.setRightComponent(panelContrato);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();
				Integer id = (Integer) datosEnTabla[indiceFilaSel][0];
				Contrato c = (Contrato) ControladorContrato.getInstance().obtencionUnaSolaEntidad(id);
				panelContrato.muestraContrato(c);
			}
		});
	}
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			/**
			 * Se conocer  el dato en cada celda, es uno de los m todos fundamentales del abstractTableModel
			 */
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return datosEnTabla[rowIndex][columnIndex];
			}

			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				datosEnTabla[rowIndex][columnIndex] = aValue;
				fireTableCellUpdated(rowIndex, columnIndex);
			}
			
		};
		return dtm;
	}

}
