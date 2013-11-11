package libCapaConexion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//import com.ibatis.common.jdbc.ScriptRunner;
//import com.ibatis.common.resources.Resources;
import com.mysql.jdbc.ResultSetMetaData;

import java.sql.CallableStatement;
import java.util.ArrayList;

public class CConexion{
	/**
	 * Variables de Conexion
	 */
	private String aUser;
	private String aPassword;
	private String aPuerto;
	
	private Connection conexion=null;
	private int aResultado; 
	private ArrayList bResultado;
	
	public String getPuerto(){
		return aPuerto;
	}
	
	public void setPuerto(String pPuerto){
		aPuerto=pPuerto;
	}
	
	public int getResultado(){
		return aResultado;
	}
	
	public ArrayList getResultadoA(){
		return bResultado;
	}
	
	/**
	 * Constructor
	 */
	public CConexion(String pUser,String pPassword,String pPuerto){
		aUser=pUser;
		aPassword=pPassword;
		aPuerto=pPuerto;		
		bResultado= new ArrayList();
	}
	
	/**
	 * Modulo para crear una conexion mysql
	 */
	public void CrearConexionDB(String bd){				
		try{
		  	//	cargar driver
		  	Class.forName("com.mysql.jdbc.Driver");
		  	// crear conexion
		  	if(bd.equals("")){		  		
		  		conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+aPuerto+"/",aUser,aPassword);		  		
		  	}else{
		  		conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+aPuerto+"/"+bd,aUser,aPassword);		  		
		  	}
		  	/*else{
		  		System.out.println("caso 3");
		  		conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+aPuerto+"/"+bd+"/"+tabla+"/",aUser,aPassword);		  		
		  	}*/		  	
		}catch(Exception e){
			System.out.println("ERROR. al crear conexion");
		}		
	}
	
	/*
	 * el parametro de entrada en un arreglo de arrglos de string de tamanio 2 */
	public void correrProcedimientoAlmacenado(String nombreTabla,ArrayList Atributos, String Tipo){
		// asi controlamos la transaccion de manera manual
		try{
			// establecemos que no sea autocommit,
			// asi controlamos la transaccion de manera manual
			conexion.setAutoCommit(false);
			String sentencia = "";
			// crear sentencia de acuerdo al tipo de procedimiento
			if(Tipo.equals("Insertar") || Tipo.equals("Actualizar")){			
				sentencia = "{ call sp"+Tipo+"_"+nombreTabla+"(";
				for(int i=0;i<Atributos.size();i++){
					if(i==Atributos.size()-1)
						sentencia+="?";
					else
						sentencia+="?,";
				}
				sentencia+=") }";			
			}else if(Tipo.equals("Listar")){
				sentencia = "{ call spListar_"+nombreTabla+"() }";
			}else if(Tipo.equals("Existe") || Tipo.equals("Eliminar")){				
				sentencia = "{ call sp"+Tipo+"_"+nombreTabla+"(?) }";
			}else if(Tipo.equals("Acceso")){
				sentencia = "{ call sp"+Tipo+"_"+nombreTabla+"(?,?) }";
			}
			
			System.out.println(sentencia);
			
			CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall(sentencia);
			
			/* Insertar atributos de acuerdo al tipo de procedimiento 
			 * --- listar no necesita parametro de entrada 
			 * */
			if(Tipo.equals("Insertar") || Tipo.equals("Actualizar")){
				for(int i=0;i<Atributos.size();i++){
					String[] Tupla = (String[])Atributos.get(i);
					if(Tupla[1].equals("int"))
						prcProcedimientoAlmacenado.setInt(i+1, Integer.parseInt(Tupla[0]));
					else if(Tupla[1].equals("String")){
						prcProcedimientoAlmacenado.setString(i+1, (Tupla[0]));							
					}
				}
			}else if (Tipo.equals("Acceso")){
				for(int i=0;i<Atributos.size();i++){
					String dato = (String)Atributos.get(i);
					prcProcedimientoAlmacenado.setString(i+1, dato);
				}
			}else if(Tipo.equals("Existe") || Tipo.equals("Eliminar")){
				String[] Tupla = (String[])Atributos.get(0);
				if(Tupla[1].equals("int"))
					prcProcedimientoAlmacenado.setInt(1, Integer.parseInt(Tupla[0]));
				else if(Tupla[1].equals("String"))
					prcProcedimientoAlmacenado.setString(1, (Tupla[0]));
			}			
			
			/* ejecutar el SP
			 * --- independientemente del tipo de procedimiento
			 */
			prcProcedimientoAlmacenado.execute();
			ResultSet rs = prcProcedimientoAlmacenado.getResultSet();
			
			/*
			 * Recuperar los resultados de los procedimientos de acuerdo a su tipo */
			if(Tipo.equals("Insertar") || Tipo.equals("Actualizar") || Tipo.equals("Eliminar")){								
				if (!rs.next())
	                System.out.println("no hay registros");
				else do {
					aResultado=rs.getInt(1);
				}while (rs.next());
			}else if(Tipo.equals("Existe")){
				bResultado = new ArrayList();  // Vaciar anteriores resultados
				if (!rs.next())
	                System.out.println("no hay registros");
				else do {
					// nro de columnas
					ResultSetMetaData metaDatos = (ResultSetMetaData)rs.getMetaData();
					int numeroColumnas = metaDatos.getColumnCount();
					if(numeroColumnas>1){
						for(int i=0;i<Atributos.size();i++){
							String[] tipoDatos = (String[])Atributos.get(i);
							if(tipoDatos[1]=="String"){
								bResultado.add(rs.getString(i+1));
							}else if(tipoDatos[1]=="int"){
								bResultado.add(rs.getInt(i+1));
							}
						}
					}else
						bResultado.add(-1);
				}while (rs.next());
			}else if(Tipo.equals("Acceso")){
				bResultado = new ArrayList();  // Vaciar anteriores resultados
				if (!rs.next())
	                System.out.println("no hay registros");
				else do {
					// nro de columnas
					ResultSetMetaData metaDatos = (ResultSetMetaData)rs.getMetaData();
					int numeroColumnas = metaDatos.getColumnCount();
					if(numeroColumnas>1){
						for(int i=0;i<numeroColumnas;i++){
							bResultado.add(rs.getString(i+1));
						}
					}else
						bResultado.add(-1);
				}while (rs.next());
			}else if(Tipo.equals("Listar")){
				bResultado = new ArrayList();	// Reiniciar la ultima salida de resultados
				if (!rs.next())
	                System.out.println("no hay registros");
				else do {
					ArrayList fila_actual = new ArrayList();
					for(int i=0;i<Atributos.size();i++){
						String[] tipoDatos = (String[])Atributos.get(i);
						if(tipoDatos[1]=="String"){
							fila_actual.add(rs.getString(i+1));
						}else if(tipoDatos[1]=="int"){
							fila_actual.add(rs.getInt(i+1));
						}
					}
					bResultado.add(fila_actual);
				}while (rs.next());
			}        			
			// confirmar si se ejecuto sin errores
			conexion.commit();
		} catch (Exception e) {
			// deshacer la ejecucion en caso de error			
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// informar por consola
			e.printStackTrace();
		}
	}	

	/*
	public void CorrerScript(String path_File) throws IOException, SQLException {
		try {
			FileReader reader = new FileReader(path_File);
	        //Reader scriptReader = Resources.getResourceAsReader(path_File);
	        ScriptRunner runner = new ScriptRunner(conexion,false,false);
	        
	        //Logs
	        PrintWriter stdOut = new PrintWriter(new FileWriter("logs.txt"));
	        runner.setLogWriter(stdOut);
	        runner.setErrorLogWriter(null);	        
	        runner.runScript(reader);
	        //conn.commit();
	        //scriptReader.close();
	        reader.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	*/
}
