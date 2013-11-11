package libCapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import libCapaConexion.CConexion;
import libCapaLogica.CUsuario;

public class frmLogin extends JFrame {

	//*************************Atributos**********************
    private CConexion aConexion; 
    
	private JPanel contentPane;
	private JPasswordField psw_txt_contrasenia;
	private JButton btnEntrar;
	private JTextField txt_usuario;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
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
	public void ContruirInterfaz(){
		setTitle("Acceso al Sistema de Asistencia de Docentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 51, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInicioDeSesin = new JLabel("Inicio de Sesión");
		lblInicioDeSesin.setForeground(Color.WHITE);
		lblInicioDeSesin.setFont(new Font("Dialog", Font.BOLD, 25));
		lblInicioDeSesin.setBounds(42, 30, 243, 41);
		panel.add(lblInicioDeSesin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(110, 154, 70, 15);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setBounds(86, 198, 106, 15);
		panel.add(lblContrasea);
		
		txt_usuario = new JTextField();
		txt_usuario.setForeground(Color.WHITE);
		txt_usuario.setFont(new Font("Dialog", Font.PLAIN, 12));
		txt_usuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txt_usuario.setBackground(new Color(0, 0, 102));
		txt_usuario.setBounds(185, 146, 214, 32);
		panel.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		btnEntrar = new JButton("Entrar");		
		btnEntrar.setBorder(new CompoundBorder());
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(0, 0, 153));
		btnEntrar.setBounds(211, 247, 121, 49);
		panel.add(btnEntrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/run/media/knick/Information/WProgram/Entornos de programación/Java/IDE/Eclipse/Workspace/Punto de Venta/Archivos/GIF/tierra.gif"));
		label.setBounds(390, 30, 84, 75);
		panel.add(label);
		
		psw_txt_contrasenia = new JPasswordField();
		psw_txt_contrasenia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		psw_txt_contrasenia.setBackground(new Color(0, 0, 102));
		psw_txt_contrasenia.setForeground(Color.WHITE);
		psw_txt_contrasenia.setBounds(185, 190, 214, 32);
		panel.add(psw_txt_contrasenia);
	}
	
	public frmLogin() {
		ContruirInterfaz();
		AgregarEventos();
		aConexion=new CConexion("root", "mysql", "3306");
    	aConexion.CrearConexionDB("SARAD");
	}
	
	public void AgregarEventos(){
		/* Boton Entrar */
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String usuario = txt_usuario.getText();
				String pass = psw_txt_contrasenia.getText();
				ArrayList datos = new ArrayList();
				datos.add(usuario);
				datos.add(pass);
				/*
				aConexion.correrProcedimientoAlmacenado("Usuario",datos,"Acceso");
				ArrayList respuesta = aConexion.getResultadoA();
				if(respuesta.size()==1){
					JOptionPane.showMessageDialog(null,"Vuelva a intentar");
				}else{
					setVisible(false);
					frmMenuPrincipal menu = new frmMenuPrincipal(respuesta);
					menu.show();
				}
				*/
				setVisible(false);
				frmMenuPrincipal menu = new frmMenuPrincipal();
				menu.show();
			}
		});
	}
}
