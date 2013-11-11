package libCapaLogica;

import java.util.ArrayList;

import libCapaConexion.CConexion;


public class CEntidad {
	
	//*************************Atributos**********************
        private CConexion aConexion;        
        private String aNombreTabla;
        private String aNombreClave;        
        
        
        //*******************Metodos******************************
        //constructores
        public CEntidad(String pNombreTabla, String pNombreClave)
        {
            //creamos la sentencia de conexion
        	aConexion=new CConexion("root", "mysql", "3306");
        	aConexion.CrearConexionDB("DBVenta");
        	//if(aConexion!=null)
    		//	System.out.println("Conexion exitosa");
        	aNombreTabla = pNombreTabla;
            aNombreClave = pNombreClave;
        }
        
        
        //propiedaes
        public String getNombreTabla()
        {
            return aNombreTabla;
        }
        public void setNombreTabla(String pNombreTabla){
        	aNombreClave = pNombreTabla;
        }
        
        public String getNombreClave()
        {
            return aNombreClave;
        }
        public void setNombreClave(String pNombreClave){
        	aNombreClave=pNombreClave;
        }            
        
        public ArrayList Listar(ArrayList Atributos)
        {
        	aConexion.correrProcedimientoAlmacenado(aNombreTabla,Atributos,"Listar");
        	return aConexion.getResultadoA();
        }        
        
        //======================metodo insertar====================
        public boolean Insertar(ArrayList Atributos){
            //concatenamos la instruccion de insercion
        	System.out.println("---");
        	for(int i=0;i<Atributos.size();i++){
        		String[] s = (String[])Atributos.get(i);
        		System.out.println(s[0]+" "+s[1]);
        	}
        	System.out.println("---");
        	aConexion.correrProcedimientoAlmacenado(aNombreTabla,Atributos,"Insertar");
        	System.out.println(aConexion.getResultado());
        	if(aConexion.getResultado()==1)
            	return true;
            else
            	return false;
        }
        
        
        //=========================metodo para actualizar un registro===
        public boolean Actualizar(ArrayList Atributos){
        	aConexion.correrProcedimientoAlmacenado(aNombreTabla,Atributos,"Actualizar");
        	if(aConexion.getResultado()==1)
            	return true;
            else
            	return false;
        }
        
        //========================metodo para eliminar un registro=====
        public boolean Eliminar(ArrayList Clave){
        	aConexion.correrProcedimientoAlmacenado(aNombreTabla,Clave,"Eliminar");
        	if(aConexion.getResultado()==1)
            	return true;
            else
            	return false;
        }
        
        //===============metodo que verifica si existe un codigo
        public boolean ExisteCodigo(ArrayList Atributos){
        	// Caso Excepcional, Cuando se agrega con autoincremento        	
        	if(((String[])Atributos.get(0))[0].equals("NULO") || ((String[])Atributos.get(0))[0].equals("-1")){
        		return false;
        	}
        	aConexion.correrProcedimientoAlmacenado(aNombreTabla,Atributos,"Existe");
        	System.out.println("----");
        	for(int i=0;i<aConexion.getResultadoA().size();i++){
        		System.out.println(aConexion.getResultadoA().get(i));
        	}
        	System.out.println("----");
            if(aConexion.getResultadoA().size()>1)
            	return true;
            else
            	return false;
        }
        
        public void ActualizarProcedimiento(ArrayList Atributos)
        {
            //creamos la sentencia de actualizacion
            //string sentencia = "exec spuModificar" + aNombreTabla + " values (" + ArgumentosInsercion(Atributos) + ")";
            //ejecutamos la sentencia
            //ejecutarNoQuery(sentencia);
        }
        
        //======================metodo para recuperar un registro
        public String RecuperarAtributo(int NroCampo)
        {
            //return aDatos.Tables[0].Rows[0][NomCampo].ToString();
        	if(aConexion.getResultadoA()!=null){
        		return aConexion.getResultadoA().get(NroCampo).toString();
        	}else{
        		return "";
        	}
        }
        
        //sentencia de insercion de registro
        protected String ArgumentosInsercion(ArrayList Atributos)
        {
            return "";
        }
        
        /*
        //sentencia de Actualizacion de registro
        public virtual string ArgumentosActualizacion(params object[] Atributos)
        {
            return "";
        }
	 * */
}
