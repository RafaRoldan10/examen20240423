package examen20240423.jpa.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import examen20240423.jpa.controllers.ControladorContrato;
import examen20240423.jpa.controllers.ControladorTipoContrato;
import examen20240423.jpa.controllers.ControladorUsuario;
import examen20240423.jpa.model.Contrato;
import examen20240423.jpa.model.TipoContrato;
import examen20240423.jpa.model.Usuario;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtLimite;
	private JTextField jtfFecha;
	private JComboBox<Usuario> jcbUsuario;
	@SuppressWarnings("unchecked")
	private List<Usuario> usuarios =(List<Usuario>) ControladorUsuario.getInstance().findAll();
	JRadioButton btnDebito;
	JRadioButton btnCredito;
	JRadioButton btnCuenta;
	JRadioButton btnPrestamo;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private ButtonGroup grupo = new ButtonGroup();
	private Contrato contrato;
	/**
	 * Create the panel.
	 */
	public PanelContrato() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 214, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		btnPrestamo = new JRadioButton("Prestamo");
		GridBagConstraints gbc_btnPrestamo = new GridBagConstraints();
		gbc_btnPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrestamo.gridx = 2;
		gbc_btnPrestamo.gridy = 3;
		add(btnPrestamo, gbc_btnPrestamo);
		
		btnDebito = new JRadioButton("Tarjeta Debito");
		GridBagConstraints gbc_btnDebito = new GridBagConstraints();
		gbc_btnDebito.insets = new Insets(0, 0, 5, 5);
		gbc_btnDebito.gridx = 3;
		gbc_btnDebito.gridy = 3;
		add(btnDebito, gbc_btnDebito);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Contrato");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnCredito = new JRadioButton("Tarjeta Credito");
		GridBagConstraints gbc_btnCredito = new GridBagConstraints();
		gbc_btnCredito.insets = new Insets(0, 0, 5, 5);
		gbc_btnCredito.gridx = 2;
		gbc_btnCredito.gridy = 4;
		add(btnCredito, gbc_btnCredito);
		
		btnCuenta = new JRadioButton("Cuenta Bancaria");
		GridBagConstraints gbc_btnCuenta = new GridBagConstraints();
		gbc_btnCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_btnCuenta.gridx = 3;
		gbc_btnCuenta.gridy = 4;
		add(btnCuenta, gbc_btnCuenta);
		
		grupo.add(btnCredito);
		grupo.add(btnDebito);
		grupo.add(btnPrestamo);
		grupo.add(btnCuenta);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 2;
		gbc_jtfDescripcion.gridy = 5;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbUsuario = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.gridwidth = 2;
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 2;
		gbc_jcbUsuario.gridy = 6;
		add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnGestion = new JButton("Gestion Usuario");
		btnGestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				// El usuario no puede redimensionar el diálogo
				dialogo.setResizable(true);
				// título del díalogo
				dialogo.setTitle("Título");
				// Introducimos el panel creado sobre el diálogo
				dialogo.setContentPane(new PanelUsuario(((Contrato)ControladorContrato.getInstance().obtencionUnaSolaEntidad(Integer.parseInt(jtfId.getText()))).getIdUsuario()));
				// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
				dialogo.pack();
				// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
				dialogo.setModal(true);
				// Centro el di�logo en pantalla
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				// Muestro el di�logo en pantalla
				dialogo.setVisible(true);    
			}
		});
		GridBagConstraints gbc_btnGestion = new GridBagConstraints();
		gbc_btnGestion.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestion.gridx = 12;
		gbc_btnGestion.gridy = 6;
		add(btnGestion, gbc_btnGestion);
		
		JLabel lblNewLabel_4 = new JLabel("Saldo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 2;
		gbc_jtfSaldo.gridy = 7;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Limite");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtLimite = new JTextField();
		GridBagConstraints gbc_jtLimite = new GridBagConstraints();
		gbc_jtLimite.gridwidth = 2;
		gbc_jtLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jtLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtLimite.gridx = 2;
		gbc_jtLimite.gridy = 8;
		add(jtLimite, gbc_jtLimite);
		jtLimite.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha Firma");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 2;
		gbc_jtfFecha.gridy = 9;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 10;
		add(btnGuardar, gbc_btnGuardar);
		
		this.jtfId.setEditable(false);
		cargaUsuarios();

	}
	
	private void cargaUsuarios() {
		for(Usuario u : usuarios) {
			this.jcbUsuario.addItem(u);
		}
	}
	
	public void muestraContrato(Contrato c) {
		this.contrato = c;
		this.jtfId.setText(c.getId()+"");
		this.jtfFecha.setText(sdf.format(c.getFechaFirma()));
		this.jtLimite.setText(""+ c.getLimite());
		this.jtfDescripcion.setText(c.getDescripcion());
		this.jtfSaldo.setText(c.getSaldo()+"");
		if(c.getIdTipoContrato().getId() == 1)  {
			btnCuenta.setSelected(true);
		}
		if(c.getIdTipoContrato().getId() == 3)  {
			btnCredito.setSelected(true);
		}
		if(c.getIdTipoContrato().getId() == 2) {
			btnDebito.setSelected(true);
		}
		if(c.getIdTipoContrato().getId() == 4 ) {
			btnPrestamo.setSelected(true);
		}
		for(int i=0 ; i< jcbUsuario.getItemCount(); i++) {
			if(jcbUsuario.getItemAt(i).getId() == c.getIdUsuario().getId()) {
				jcbUsuario.setSelectedIndex(i);
			}
		}
	}
	
	private void guardar() {
		if(compruebaflotantes()) {
			contrato.setDescripcion(this.jtfDescripcion.getText());
			contrato.setSaldo(Float.parseFloat(this.jtfSaldo.getText()));
			contrato.setIdUsuario((Usuario) jcbUsuario.getSelectedItem());
			try {
				contrato.setFechaFirma(sdf.parse(this.jtfFecha.getText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(btnCredito.isSelected()) {
				contrato.setIdTipoContrato((TipoContrato)ControladorTipoContrato.getInstance().obtencionUnaSolaEntidad(3));
			}
			if(btnDebito.isSelected()) {
				contrato.setIdTipoContrato((TipoContrato)ControladorTipoContrato.getInstance().obtencionUnaSolaEntidad(2));
			}
			if(btnCuenta.isSelected()) {
				contrato.setIdTipoContrato((TipoContrato)ControladorTipoContrato.getInstance().obtencionUnaSolaEntidad(1));
			}
			if(btnPrestamo.isSelected()) {
				contrato.setIdTipoContrato((TipoContrato)ControladorTipoContrato.getInstance().obtencionUnaSolaEntidad(4));
			}
			contrato.setLimite(Float.parseFloat(this.jtLimite.getText()));
			ControladorContrato.getInstance().update(contrato);
		}
		else {
			JOptionPane.showMessageDialog(null, "no has introducido bien algun campo");
		}
		
	}
	
	public boolean compruebaflotantes() {
		try {
			Float.parseFloat(this.jtfSaldo.getText());
			Float.parseFloat(this.jtLimite.getText());
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
