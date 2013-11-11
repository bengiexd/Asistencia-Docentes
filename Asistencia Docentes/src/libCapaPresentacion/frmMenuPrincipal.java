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

import libCapaPresentacion_test.frmCliente;
import libCapaPresentacion_test.frmDetalleCredito;
import libCapaPresentacion_test.frmVenta;
import libCapaPresentacion_test.frmVentaProducto;

public class frmMenuPrincipal extends JFrame {

	private JPanel contentPane;	
	private JButton btnSalir;
	private JButton btnVentas;
	private JButton btn_Reservas;
	private JButton btnClientes;
	private JButton btnUsuarios;
	private JButton btnCreditos;
	private JLabel lbl_Bienvenida;
	
	/* Variable para manejar los privilegios del usuario */
	private ArrayList aDatosUsuario;
	
	/**
	 * Create the frame.
	 */
	public frmMenuPrincipal(ArrayList datos) {
		aDatosUsuario=datos;		
		construirInterfaz();
		AgregarBotonesConPrivilegios();
		AgregarEventos();
		Bienvenida();
	}
	
	public void Bienvenida(){
		lbl_Bienvenida.setText("Bienvenido: "+aDatosUsuario.get(4)+" "+aDatosUsuario.get(5)+" "+aDatosUsuario.get(6));
	}
	
	public void AgregarBotonesConPrivilegios(){
		String privilegio = (String)aDatosUsuario.get(3); 
		
		if(privilegio.equals("Admin")){
			btnUsuarios = new JButton("Usuarios");		
			btnUsuarios.setBounds(0, 0, 117, 57);
			contentPane.add(btnUsuarios);
			
			btnVentas = new JButton("Ventas");		
			btnVentas.setBounds(0, 55, 117, 57);
			contentPane.add(btnVentas);
			
			btn_Reservas = new JButton("Reservas");
			btn_Reservas.setBounds(0, 111, 117, 57);
			contentPane.add(btn_Reservas);
			
			btnClientes = new JButton("Clientes");
			btnClientes.setBounds(0, 166, 117, 57);
			contentPane.add(btnClientes);
			
			btnCreditos = new JButton("Créditos");
			btnCreditos.setBounds(0, 221, 117, 57);
			contentPane.add(btnCreditos);
			
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(0, 276, 117, 57);
			contentPane.add(btnSalir);
			
		}else if(privilegio.equals("Vendedor")){						
			btnVentas = new JButton("Ventas");		
			btnVentas.setBounds(0, 0, 117, 57);
			contentPane.add(btnVentas);
			
			btn_Reservas = new JButton("Reservas");
			btn_Reservas.setBounds(0, 55, 117, 57);
			contentPane.add(btn_Reservas);
			
			btnClientes = new JButton("Clientes");
			btnClientes.setBounds(0, 111, 117, 57);
			contentPane.add(btnClientes);
			
			btnCreditos = new JButton("Créditos");
			btnCreditos.setBounds(0, 166, 117, 57);
			contentPane.add(btnCreditos);
			
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(0, 221, 117, 57);
			contentPane.add(btnSalir);						
		}else{
			System.out.println("Error en Privilegios");
		}
	}
	
	public void construirInterfaz(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeVentas = new JLabel("Sistema de Ventas");
		lblSistemaDeVentas.setBounds(263, 70, 142, 37);
		contentPane.add(lblSistemaDeVentas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/run/media/knick/Information/WProgram/Entornos de programación/Java/IDE/Eclipse/Workspace/Punto de Venta/Archivos/GIF/tierra.gif"));
		label.setBounds(295, 105, 87, 82);
		contentPane.add(label);
		
		lbl_Bienvenida = new JLabel("Bienvenido: ");
		lbl_Bienvenida.setBounds(187, 23, 394, 15);
		contentPane.add(lbl_Bienvenida);
		
		JButton btnRealizarUnaVenta = new JButton("Realizar una Venta");
		btnRealizarUnaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmVentaProducto venta = new frmVentaProducto(aDatosUsuario);				
				venta.show();
			}
		});
		btnRealizarUnaVenta.setBounds(212, 294, 310, 25);
		contentPane.add(btnRealizarUnaVenta);
		
	}
	
	public void AgregarEventos(){		
		String privilegio = (String)aDatosUsuario.get(3);
		if(privilegio.equals("Admin")){
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
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
			
		}else if(privilegio.equals("Vendedor")){						
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
			btnVentas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frmVenta venta = new frmVenta(aDatosUsuario);
					venta.show();
				}
			});
			
			btnCreditos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmDetalleCredito creditos = new frmDetalleCredito();
					creditos.show();					
				}
			});
		}
	}
}
