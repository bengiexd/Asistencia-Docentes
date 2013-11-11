package libCapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import libCapaLogica.CEntidad;

import javax.swing.ImageIcon;

public class frmMantenimiento extends JFrame implements FocusListener,KeyListener{

	/* Variables*/
	private boolean aEsNuevo;
	protected CEntidad aEntidad;

	private JPanel contentPane;	
	protected JPanel jpnl_superior;
	protected JPanel jpnl_centro;
	protected JPanel jpnl_inferior;	
	protected JLabel lblTitulo;
	protected JLabel lbl_GIF_PLANETA;
	protected JButton btnGrabar;
	private JButton btnSalir;
	private JButton btnBorrar; 
	private JButton btnNuevo;

	/* Variables para controlar atajos */
	boolean pres_control=false;

	public void InicializarComponentes(){		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnl_superior = new JPanel();
		jpnl_superior.setBounds(0, 0, 596, 41);
		contentPane.add(jpnl_superior);
		jpnl_superior.setLayout(null);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(251, 12, 48, 17);
		jpnl_superior.add(lblTitulo);

		jpnl_inferior = new JPanel();
		jpnl_inferior.setForeground(Color.BLACK);
		jpnl_inferior.setBounds(0, 356, 596, 41);
		contentPane.add(jpnl_inferior);
		jpnl_inferior.setLayout(null);

		btnGrabar = new JButton("Grabar");		
		btnGrabar.setBounds(12, 12, 92, 25);
		jpnl_inferior.add(btnGrabar);

		btnNuevo = new JButton("Nuevo");		
		btnNuevo.setBounds(123, 12, 92, 25);
		jpnl_inferior.add(btnNuevo);

		btnBorrar = new JButton("Borrar");		
		btnBorrar.setBounds(227, 12, 92, 25);
		jpnl_inferior.add(btnBorrar);

		btnSalir = new JButton("Salir");		
		btnSalir.setBounds(492, 12, 92, 25);
		jpnl_inferior.add(btnSalir);

		jpnl_centro = new JPanel();
		jpnl_centro.setBounds(0, 41, 596, 316);		
		contentPane.add(jpnl_centro);
		jpnl_centro.setLayout(null);

		//this.setFocusable(true);		
		//this.requestFocusInWindow();
		//this.addKeyListener(this);

		lbl_GIF_PLANETA = new JLabel("");
		lbl_GIF_PLANETA.setBounds(12, 229, 84, 75);
		jpnl_centro.add(lbl_GIF_PLANETA);
		lbl_GIF_PLANETA.setIcon(new ImageIcon("/run/media/knick/Information/WProgram/Entornos de programación/Java/IDE/Eclipse/Workspace/Punto de Venta/Archivos/GIF/tierra.gif"));
	}

	/**
	 * Create the frame.
	 */
	protected frmMantenimiento() {
		addKeyListener(this);
		InicializarComponentes();
		AgregarEventos();
		aEsNuevo = true;
	}

	/* Metodo para especificar con que entidad trabajar*/
	public void AsignarEntidad(CEntidad pEntidad){
		aEntidad = pEntidad;
	}

	protected ArrayList GenerarAtributos(){
		return null;
	}

	protected void RecuperarDatos(){

	}

	public void ProcesarClave(){
		ArrayList atributos = GenerarAtributos();
		System.out.println("Generando atributos");
		if(atributos!=null){			
			if(aEntidad.ExisteCodigo(atributos)){				
				RecuperarDatos();
				System.out.println("existe");
				aEsNuevo=false;
			}else{
				aEsNuevo=true;
				IniciarNoClave();
				System.out.println("no existe");
			}
		}
	}		


	protected void IniciarNoClave(){

	}

	protected void Listar(){

	}

	protected void Eliminar(){
		ArrayList atributos = GenerarAtributos();
		if(atributos!=null){			
			if(aEntidad.ExisteCodigo(atributos)){
				if(aEntidad.Eliminar(atributos))
					JOptionPane.showMessageDialog(null,"datos eliminados satisfactoriamente");
				else
					JOptionPane.showMessageDialog(null,"error al eliminar datos");
			}else{
				JOptionPane.showMessageDialog(null,"codigo no existe");
			}
		}
	}

	protected void Grabar(){
		if(RevisarDatosAntesDeEnviar()){
			ArrayList atributos = GenerarAtributos();
			if(atributos!=null){
				if(aEntidad.ExisteCodigo(atributos)){
					if(aEntidad.Actualizar(atributos)){
						JOptionPane.showMessageDialog(null,"datos actualizados correctamente");
						Listar();													
					}else{
						JOptionPane.showMessageDialog(null,"error al actualizar datos, codigo no existe");
					}
				}else{
					if(aEntidad.Insertar(atributos)){
						JOptionPane.showMessageDialog(null,"datos insertados correctamente");
						Listar();
					}else{						
						JOptionPane.showMessageDialog(null,"error al insertar datos");
					}					
				}	
			}else{
				JOptionPane.showMessageDialog(null,"datos nulos");
			}
		}	
	}

	protected void Limpiar(){

	}

	protected boolean RevisarDatosAntesDeEnviar(){
		return false;
	}

	public void AgregarEventos(){
		/* Boton Grabar */
		this.btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Grabar();
				Listar();
			}
		});

		/* Boton Salir */
		this.btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				setVisible(false);
			}
		});

		/* Boton Eliminar*/
		this.btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eliminar();
				Listar();
			}
		});


		/* Boton Nuevo*/
		this.btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Limpiar();
				aEsNuevo=true;
			}
		});
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// controlar las combinaciones de teclas

		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			//pres_control=true;			
		}else if(pres_control && e.getKeyCode()==KeyEvent.VK_N){
			// Ctrl + N 			
			Limpiar();
			//aEsNuevo = true;
			//pres_control=false;							
		}else if(pres_control && e.getKeyCode()==KeyEvent.VK_Q){
			// Ctrl + Q	
			//System.exit(0); // Salir
			//pres_control=false;
		}else if(pres_control && e.getKeyCode()==KeyEvent.VK_G){
			// Ctrl + G	
			//Grabar();
			//Listar();
			pres_control=false;
		}else if(pres_control && e.getKeyCode()==KeyEvent.VK_E){
			// Ctrl + E
			//Eliminar();
			//Listar();
			pres_control=false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
















