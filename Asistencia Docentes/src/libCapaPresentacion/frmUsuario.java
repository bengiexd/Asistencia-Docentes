package libCapaPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import libCapaLogica.CUsuario;

public class frmUsuario extends frmMantenimiento{
	private JTextField txt_dni;
	private JTextField txt_usuario;
	private JTextField txt_password;
	private JTextField txt_cargo;
	private JTextField txt_nombres;
	private JTextField txt_ape_paterno;
	private JTextField txt_ape_materno;
	private JTextField txt_email;
	private JTextField txt_celular;
	private JTable table;
	private CUsuario aUsuario;
	
	/**
	 * Create the frame.
	 */
	public frmUsuario() {
		jpnl_inferior.setBounds(0, 356, 1364, 41);
		jpnl_centro.setBounds(0, 41, 1364, 316);
		
		JPanel panel = new JPanel();
		panel.setFocusable(true);		
		panel.requestFocusInWindow();
		panel.addKeyListener(this);
		panel.setLayout(null);
		panel.setBounds(12, 12, 243, 249);		
		jpnl_centro.add(panel);			
				
		JLabel label = new JLabel("DNI");
		label.setBounds(12, 12, 47, 15);
		panel.add(label);
		
		txt_dni = new JTextField();
		txt_dni.setColumns(10);
		txt_dni.setBounds(117, 10, 114, 19);
		txt_dni.addFocusListener(this);		
		panel.add(txt_dni);
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setBounds(117, 33, 114, 19);		
		panel.add(txt_usuario);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(117, 57, 114, 19);
		panel.add(txt_password);
		
		txt_cargo = new JTextField();
		txt_cargo.setColumns(10);
		txt_cargo.setBounds(117, 80, 114, 19);
		panel.add(txt_cargo);
		
		txt_nombres = new JTextField();
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(117, 102, 114, 19);
		panel.add(txt_nombres);
		
		txt_ape_paterno = new JTextField();
		txt_ape_paterno.setColumns(10);
		txt_ape_paterno.setBounds(117, 124, 114, 19);
		panel.add(txt_ape_paterno);
		
		txt_ape_materno = new JTextField();
		txt_ape_materno.setColumns(10);
		txt_ape_materno.setBounds(117, 146, 114, 19);
		panel.add(txt_ape_materno);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(117, 168, 114, 19);
		panel.add(txt_email);
		
		txt_celular = new JTextField();
		txt_celular.setColumns(10);
		txt_celular.setBounds(117, 190, 114, 19);
		panel.add(txt_celular);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(12, 57, 93, 15);
		panel.add(label_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 79, 93, 15);
		panel.add(lblTipo);
		
		JLabel label_3 = new JLabel("Nombres");
		label_3.setBounds(13, 102, 93, 15);
		panel.add(label_3);
		
		JLabel lblApellidoPat = new JLabel("Apellido Pat.");
		lblApellidoPat.setBounds(13, 124, 105, 15);
		panel.add(lblApellidoPat);
		
		JLabel lblApellidoMat = new JLabel("Apellido Mat.");
		lblApellidoMat.setBounds(13, 146, 105, 15);
		panel.add(lblApellidoMat);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(13, 168, 93, 15);
		panel.add(lblEmail);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(12, 190, 93, 15);
		panel.add(lblCelular);
		
		JLabel label_9 = new JLabel("Usuario");
		label_9.setBounds(12, 35, 66, 15);
		panel.add(label_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(280, 12, 1072, 249);
		jpnl_centro.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 5, 1043, 237);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "Usuario", "Password", "Cargo", "Nombres", "Apellido Pat.", "Apellido Mat.", "email", "Celular"
			}
		));
		scrollPane.setViewportView(table);
		
		jpnl_superior.setBounds(0, 0, 1364, 41);
		lblTitulo.setBounds(232, 12, 79, 17);
		lblTitulo.setText("Usuarios");
		setBounds(100, 100, 1392, 427);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		aUsuario = new CUsuario();
		AsignarEntidad(aUsuario);		

		/* activar para conectar a la base de datos */
		//Listar();
	}
	
	public ArrayList GenerarAtributos(){
		ArrayList Atributos = new ArrayList();						
		Atributos.add(new String[]{txt_dni.getText(),"String"});
		Atributos.add(new String[]{txt_usuario.getText(),"String"});
		Atributos.add(new String[]{txt_password.getText(),"String"});
		Atributos.add(new String[]{txt_cargo.getText(),"String"});
		Atributos.add(new String[]{txt_nombres.getText(),"String"});
		Atributos.add(new String[]{txt_ape_paterno.getText(),"String"});
		Atributos.add(new String[]{txt_ape_materno.getText(),"String"});
		Atributos.add(new String[]{txt_email.getText(),"String"});
		Atributos.add(new String[]{txt_celular.getText(),"String"});		
		return Atributos;
	}
	
	public void Listar(){		
		ArrayList Atributos = GenerarAtributos();
		ArrayList lista = aUsuario.Listar(Atributos);
		Object[][] cuerpo_modelo = new Object[lista.size()][9];
		
		for(int i=0;i<lista.size();i++){
			ArrayList fila = (ArrayList)lista.get(i);			
			for(int j=0;j<fila.size();j++){
				cuerpo_modelo[i][j]= fila.get(j);
			}
		}		
		
		table.setModel(new DefaultTableModel(
			cuerpo_modelo,
			new String[] {
				"DNI", "Usuario", "Password", "Cargo", "Nombres", "Apellido Pat.", "Apellido Mat.", "email", "Celular"
			}
		));		
	}
	
	public void Limpiar(){
		txt_usuario.setText("");
		txt_password.setText("");
		txt_cargo.setText("");
		txt_nombres.setText("");
		txt_ape_paterno.setText("");
		txt_ape_materno.setText("");
		txt_email.setText("");
		txt_celular.setText("");
		txt_dni.setText("");
		txt_dni.requestFocus();
	}
	
	public void RecuperarDatos(){		
		txt_usuario.setText(aUsuario.RecuperarAtributo(1));
		txt_password.setText(aUsuario.RecuperarAtributo(2));
		txt_cargo.setText(aUsuario.RecuperarAtributo(3));
		txt_nombres.setText(aUsuario.RecuperarAtributo(4));
		txt_ape_paterno.setText(aUsuario.RecuperarAtributo(5));
		txt_ape_materno.setText(aUsuario.RecuperarAtributo(6));
		txt_email.setText(aUsuario.RecuperarAtributo(7));
		txt_celular.setText(aUsuario.RecuperarAtributo(8));		
	}
	
	public void IniciarNoClave(){
		txt_usuario.setText("");
		txt_password.setText("");
		txt_cargo.setText("");
		txt_nombres.setText("");
		txt_ape_paterno.setText("");
		txt_ape_materno.setText("");
		txt_email.setText("");
		txt_celular.setText("");		
		txt_usuario.requestFocus();
	}

	public boolean RevisarDatosAntesDeEnviar(){
		if(!txt_usuario.getText().equals("") &&
				!txt_password.getText().equals("") &&
				!txt_cargo.getText().equals("") &&
				!txt_nombres.getText().equals("") &&
				!txt_ape_paterno.getText().equals("") &&
				!txt_ape_materno.getText().equals("") &&					
				!txt_usuario.getText().equals(""))
			return true;
		return false;
	}
	
	/* Metodo para revisar la clave luego de dejar el focus */
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		ProcesarClave();
	}			
}
