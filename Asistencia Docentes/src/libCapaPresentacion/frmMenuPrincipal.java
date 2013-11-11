package libCapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class frmMenuPrincipal extends JFrame {

	private JPanel contentPane;	
	private JButton btnSalir;
	private JButton btn_docentes;
	private JButton btn_aulas;
	private JButton btn_horario;
	private JButton btnUsuarios;
	private JButton btn_asistencia;
	private JLabel lbl_Bienvenida;	
	
	/**
	 * Create the frame.
	 */
	public frmMenuPrincipal() {		
		construirInterfaz();
		AgregarBotonesConPrivilegios();
		AgregarEventos();
		Bienvenida();
	}
	
	public void Bienvenida(){
		lbl_Bienvenida.setText("Sistema de Asistencia de Docentes");
	}
	
	public void AgregarBotonesConPrivilegios(){
		 	
		btnUsuarios = new JButton("Usuarios");		
		btnUsuarios.setBounds(0, 0, 117, 57);
		contentPane.add(btnUsuarios);
		
		btn_docentes = new JButton("Docentes");		
		btn_docentes.setBounds(0, 55, 117, 57);
		contentPane.add(btn_docentes);
		
		btn_aulas = new JButton("Aulas");
		btn_aulas.setBounds(0, 111, 117, 57);
		contentPane.add(btn_aulas);
		
		btn_horario = new JButton("Horarios");
		btn_horario.setBounds(0, 166, 117, 57);
		contentPane.add(btn_horario);
		
		btn_asistencia = new JButton("Asistencia");
		btn_asistencia.setBounds(0, 221, 117, 57);
		contentPane.add(btn_asistencia);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(0, 276, 117, 57);
		contentPane.add(btnSalir);		
	}
	
	public void construirInterfaz(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/run/media/knick/Information/WProgram/Entornos de programación/Java/IDE/Eclipse/Workspace/Punto de Venta/Archivos/GIF/tierra.gif"));
		label.setBounds(295, 105, 87, 82);
		contentPane.add(label);
		
		lbl_Bienvenida = new JLabel("Bienvenido: ");
		lbl_Bienvenida.setBounds(235, 21, 268, 15);
		contentPane.add(lbl_Bienvenida);
		
	}
	
	public void AgregarEventos(){		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUsuario usuario = new frmUsuario();
				usuario.show();
			}
		});
		
		/*
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCliente cliente =  new frmCliente();
				cliente.show();
			}
		});
		
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmVenta venta = new frmVenta(aDatosUsuario);
				venta.show();
			}
		});
		
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUsuario usuario = new frmUsuario();
				usuario.show();
			}
		});
		
		btnCreditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDetalleCredito creditos = new frmDetalleCredito();
				creditos.show();					
			}
		});
		*/

	}
}
