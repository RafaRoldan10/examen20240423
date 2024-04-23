package examen20240423.jpa.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import examen20240423.jpa.controllers.ControladorUsuario;
import examen20240423.jpa.model.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	private JPasswordField jtfContrasenia;
	private JComboBox<String> jcbColor;
	private Usuario usuario;
	private JTextField txtGestionUsuario;

	/**
	 * Create the panel.
	 */
	public PanelUsuario(Usuario u) {
		this.usuario = u;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtGestionUsuario = new JTextField();
		txtGestionUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtGestionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionUsuario.setText("Gestion Usuario");
		GridBagConstraints gbc_txtGestionUsuario = new GridBagConstraints();
		gbc_txtGestionUsuario.gridwidth = 3;
		gbc_txtGestionUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtGestionUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGestionUsuario.gridx = 1;
		gbc_txtGestionUsuario.gridy = 1;
		add(txtGestionUsuario, gbc_txtGestionUsuario);
		txtGestionUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 3;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 3;
		gbc_jtfUsuario.gridy = 3;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfContrasenia = new JPasswordField();
		GridBagConstraints gbc_jtfContrasenia = new GridBagConstraints();
		gbc_jtfContrasenia.insets = new Insets(0, 0, 5, 0);
		gbc_jtfContrasenia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfContrasenia.gridx = 3;
		gbc_jtfContrasenia.gridy = 4;
		add(jtfContrasenia, gbc_jtfContrasenia);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 3;
		gbc_jtfEmail.gridy = 5;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbColor = new JComboBox();
		jcbColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor((String) jcbColor.getSelectedItem());
			}
		});
		GridBagConstraints gbc_jcbColor = new GridBagConstraints();
		gbc_jcbColor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColor.gridx = 3;
		gbc_jcbColor.gridy = 6;
		add(jcbColor, gbc_jcbColor);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guarda();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 7;
		add(btnGuardar, gbc_btnGuardar);
		cargaColores();
		muestraUsuario();

	}
	
	private void muestraUsuario() {
		this.jtfId.setText(this.usuario.getId()+"");
		this.jtfEmail.setText(this.usuario.getEmail()+"");
		this.jtfUsuario.setText(this.usuario.getNombreUsuario());
		String colorAlmacenado = this.usuario.getColorPreferido();
	    
	    // Actualizar el color del panel
	    if (colorAlmacenado != null && !colorAlmacenado.isEmpty()) {
	        setColor(colorAlmacenado);
	    } else {
	        // Si no hay color almacenado, puedes establecer un color por defecto
	       setColor("#ffffff");
	    }
	    this.jtfContrasenia.setText(this.usuario.getPassword());
	}
	
	public void setColor(String hexColor) {
	    if (hexColor != null && hexColor.length() >= 6) {
	        if (!hexColor.startsWith("#")) {
	            hexColor = "#" + hexColor;
	        }
	        
	        this.setBackground(Color.decode(hexColor)); // Cambia el color del panel principal
	    }
	}
	
	public void cargaColores() {
		this.jcbColor.addItem("#FF00FF");
		this.jcbColor.addItem("#9890A5");
		this.jcbColor.addItem("#765456");
		this.jcbColor.addItem("#879876");
				
	}
	
	public void guarda() {
		if(!vacios() && correo()) {
			this.usuario.setEmail(this.jtfEmail.getText());
			this.usuario.setNombreUsuario(this.jtfUsuario.getText());
			this.usuario.setPassword(this.jtfContrasenia.getText());
			this.usuario.setColorPreferido((String)this.jcbColor.getSelectedItem());
			ControladorUsuario.getInstance().update(usuario);
		}
		else {
			JOptionPane.showMessageDialog(null, "no has insertado bien algun campo");
		}
		
	}
	
	public boolean vacios() {
		if(this.jtfContrasenia.getText().isEmpty() || this.jtfUsuario.getText().isEmpty())return true;
		return false;
	}
	
	public boolean correo() {
		if(this.jtfEmail.getText().matches(".*[@].*[.].*"))return true;
		return false;
	}

}
