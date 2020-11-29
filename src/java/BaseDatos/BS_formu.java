
package BaseDatos;
import BaseDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ALMITA L
 */
public class BS_formu {
    
    private Conexion conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
                StringBuffer respuesta =  new StringBuffer();
   
    public BS_formu(){
        conn= new Conexion();
        cn=conn.conectar();
        
    }
    public StringBuffer nextIdGrado()
    {
        int x=0;
        String sql= "SELECT * FROM REG_GRADO ";;
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();
            System.out.println(result);
            System.out.println(sql);
                while (result.next()){
                x++;
                    System.out.println(respuesta);
                }
                if(x==0){
                    respuesta.append(x=1);
                    System.out.println(respuesta + " if");
                }
                else{
                    x++;
                    respuesta.append(x++);
                    System.out.println(respuesta + "else");
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
    
       public String registro_Grado (String ID_GRADO, String GRADO ){
        String sql = "INSERT INTO REG_GRADO ( ID_GRADO, GRADO )";
        sql += "VALUES(?,?)";
        
        System.out.println(sql);
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_GRADO);
            prstmt.setString(2, GRADO);
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }
  
       
         
    public StringBuffer nextIdCatedra()
    {
        int x=0;
        String sql= "SELECT * FROM REG_CATEDRATICO ";;
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();
            System.out.println(result);
            System.out.println(sql);
                while (result.next()){
                x++;
                    System.out.println(respuesta);
                }
                if(x==0){
                    respuesta.append(x=1);
                    System.out.println(respuesta + " if");
                }
                else{
                    x++;
                    respuesta.append(x++);
                    System.out.println(respuesta + "else");
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
    
        public String registro_catedratico(String ID_CATEDRATICO, String NOMBRE_CATED, String GENERO,  String REG_GRADO_ID_GRADO ){
        String sql = "INSERT INTO REG_CATEDRATICO (ID_CATEDRATICO,NOM_CATED,GENERO,REG_GRADO_ID_GRADO)";  
        sql += "VALUES(?,?,?,?)";
        
        System.out.println(sql);
        
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_CATEDRATICO);
            prstmt.setString(2, NOMBRE_CATED);
            prstmt.setString(3, GENERO);
            prstmt.setString(4, REG_GRADO_ID_GRADO);
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }
         
         
    public StringBuffer sel_grado()
    {
        String sql= "SELECT GRADO FROM REG_GRADO  ";
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();  
                respuesta.append("<option>Seleccione su Grado</option>");
                while (result.next()){
                
                respuesta.append("<option>").append(result.getString("GRADO")).append("</option>");
              
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
          
    
      public StringBuffer selectc(String grado)
    {
        StringBuffer respuestaA = new StringBuffer();
        prstmt = null;
        result = null;
       
        try{
             String sql= "SELECT * FROM REG_GRADO  WHERE GRADO ='"+grado+"'";
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();  
                
                while (result.next()){
                
                respuestaA.append(result.getString("ID_GRADO"));
              
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuestaA;
        }
          
    public StringBuffer nextIdAlumno()
    {
        int x=0;
        String sql= "SELECT * FROM REG_ALUMNO ";;
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();
            System.out.println(result);
            System.out.println(sql);
                while (result.next()){
                x++;
                    System.out.println(respuesta);
                }
                if(x==0){
                    respuesta.append(x=1);
                    System.out.println(respuesta + " if");
                }
                else{
                    x++;
                    respuesta.append(x++);
                    System.out.println(respuesta + "else");
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
       
      public String registro_Alumno (String ID_ALUMNO, String NOMBRE_ALUMNO, String GENERO,String FECHA_NACI,String NUMERO_TEL ){
        String sql = "INSERT INTO REG_ALUMNO ( ID_ALUMNO, NOMBRE_ALUMNO,GENERO,FECHA_NACI,NUMERO_TEL )";
        sql += "VALUES(?,?,?,?,?)";
        System.out.println(ID_ALUMNO);
           System.out.println(NOMBRE_ALUMNO);
        System.out.println(sql);
            
                
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_ALUMNO);
            prstmt.setString(2, NOMBRE_ALUMNO);
            prstmt.setString(3, GENERO);
            prstmt.setString(4, FECHA_NACI);
            prstmt.setString(5, NUMERO_TEL);
            
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }public StringBuffer nextIdInscri()
    {
        int x=0;
        String sql= "SELECT * FROM INSCRIPCION ";;
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();
            System.out.println(result);
            System.out.println(sql);
                while (result.next()){
                x++;
                    System.out.println(respuesta);
                }
                if(x==0){
                    respuesta.append(x=1);
                    System.out.println(respuesta + " if");
                }
                else{
                    x++;
                    respuesta.append(x++);
                    System.out.println(respuesta + "else");
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
    
        public String registro_Inscrip (String ID_INSCRIP, String FECHA_INSCRIP,  String REG_ALUMNO_ID_ALUMNO, String REG_GRADO_ID_GRADO ){
        String sql = "INSERT INTO INSCRIPCION (ID_INSCRIP, FECHA_INSCRIP, REG_ALUMNO_ID_ALUMNO, REG_GRADO_ID_GRADO)";
        sql += "VALUES(?,?,?,?)";
        
        System.out.println(sql);
            
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_INSCRIP);
            prstmt.setString(2, FECHA_INSCRIP);
            prstmt.setString(3, REG_ALUMNO_ID_ALUMNO);
            prstmt.setString(4, REG_GRADO_ID_GRADO);
            
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }
    
     public StringBuffer sel_alum()
    {
        String sql= "SELECT NOMBRE_ALUMNO FROM REG_ALUMNO   ";
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();  
                respuesta.append("<option>Seleccione su Nombre</option>");
                while (result.next()){
                
                respuesta.append("<option>").append(result.getString("NOMBRE_ALUMNO")).append("</option>");
              
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
          
    
    public StringBuffer selecalu(String NomAlum)
    {
        StringBuffer respuestaB = new StringBuffer();
        prstmt = null;
        result = null;
       
        try{
             String sql= "SELECT * FROM REG_ALUMNO  WHERE NOMBRE_ALUMNO='"+NomAlum+"' ";
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();  
                
                while (result.next()){
                
                respuestaB.append(result.getString("ID_ALUMNO"));
              
                }
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuestaB;
        }
            
    public StringBuffer Tabla_registro()
    {
        String sql= "select i.fecha_inscrip, a.nombre_alumno,a.genero, g.grado,c.nom_cated\n"+
                    "from inscripcion i, reg_alumno a, reg_grado g, reg_catedratico c\n"+
                    "WHERE i.reg_alumno_id_alumno=a.id_alumno\n"+
                    "and i.reg_grado_id_grado=g.id_grado\n"+
                    "and c.reg_grado_id_grado=g.id_grado\n"+
                    "and i.fecha_inscrip like '%' ORDER BY i.fecha_inscrip";
      
                  
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("fecha_inscrip")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre_alumno")).append("</td>");
                respuesta.append("<td >").append(result.getString("genero")).append("</td>");
                respuesta.append("<td >").append(result.getString("grado")).append("</td>");
                respuesta.append("<td >").append(result.getString("nom_cated")).append("</td>");
              
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
       
    
       public StringBuffer BuscarAlumno(String Nom_Alum)
    {
        String sql= "select i.fecha_inscrip, a.nombre_alumno,a.genero, g.grado,c.nom_cated\n"+
                    "from inscripcion i, reg_alumno a, reg_grado g, reg_catedratico c\n"+
                    "WHERE i.reg_alumno_id_alumno=a.id_alumno\n"+
                    "and i.reg_grado_id_grado=g.id_grado\n"+
                    "and c.reg_grado_id_grado=g.id_grado\n"+
                    "and upper (a.nombre_alumno) like upper ('"+Nom_Alum+"%')";
             
            System.out.println(sql);
           
           
        try{
        prstmt = cn.prepareStatement(sql);
        result = prstmt.executeQuery(); 
            
                while (result.next()){
                 respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("fecha_inscrip")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre_alumno")).append("</td>");
                respuesta.append("<td >").append(result.getString("genero")).append("</td>");
                respuesta.append("<td >").append(result.getString("grado")).append("</td>");
                respuesta.append("<td >").append(result.getString("nom_cated")).append("</td>");
                respuesta.append("</tr>");}
                System.out.println(respuesta);
                return respuesta; 
                
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
       
        }
       
      
}