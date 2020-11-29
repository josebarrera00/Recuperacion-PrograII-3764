/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import BaseDatos.BS_formu;
import BaseDatos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALMITA L
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Conexion conexion = new Conexion();
        conexion.conectar();
        
        Writer ajaxSalir = response.getWriter();  
        BS_formu bd_form = new BS_formu();
        StringBuilder respuestaBS = new StringBuilder(); 
        StringBuffer respuestaA = new StringBuffer(); 
        StringBuffer respuestaB = new StringBuffer(); 
         
       
        response.setContentType("text/html;charset=UTF-8");
        try {
                    String comando= request.getParameter("comando");
                    switch(comando){
                
                        case "registro_Grado":
                            String id_grado = (respuestaBS.append(bd_form.nextIdGrado())).toString();
                            String grado = request.getParameter("grado");
                            String respuesta1 =(bd_form.registro_Grado(id_grado,grado));
                            response.getWriter().print(respuesta1);
                        break;
                        
                                               
                        case "sel_grado":

                            respuestaBS.append(bd_form.sel_grado());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        
                        case "registro_catedratico":
                            String id_catedratico = (respuestaBS.append(bd_form.nextIdCatedra())).toString();
                            String nombrecate = request.getParameter("nombrecate");
                            String generocate = request.getParameter("generocate");
                            String gradosel = request.getParameter("gradosel");
                           
                            respuestaA =bd_form.selectc(gradosel);
                            gradosel = respuestaA.toString();
                            System.out.println(gradosel);
                            String respuesta2 =(bd_form.registro_catedratico(id_catedratico,nombrecate,generocate,gradosel));
                            System.out.println(respuesta2);
                            System.out.println(gradosel);
                            response.getWriter().print(respuesta2);
                        break;
                        case "registro_Alumno":
                            String id_Alumno = (respuestaBS.append(bd_form.nextIdAlumno())).toString();
                            String nombrealumno = request.getParameter("nombrealumno");
                            String genero = request.getParameter("genero");
                            String fechnac = request.getParameter("fechnac");
                            String numerocel = request.getParameter("numerocel");
                            String respuesta3 =(bd_form.registro_Alumno(id_Alumno,nombrealumno,genero,fechnac,numerocel));
                            response.getWriter().print(respuesta3);
                        break;
                        case "registro_Inscrip":
                            String id_inscri = (respuestaBS.append(bd_form.nextIdInscri())).toString();
                            String fechainscri = request.getParameter("fechainscri");
                            String nombreins = request.getParameter("nombreins");
                            String graselec = request.getParameter("graselec");
                           
                            respuestaB =bd_form.selecalu(nombreins);
                             nombreins= respuestaB.toString();
                             System.out.println(nombreins);
                            respuestaA =bd_form.selectc(graselec);
                            gradosel = respuestaA.toString();
                            System.out.println(gradosel);
                            String respuesta4 =(bd_form.registro_Inscrip(id_inscri,fechainscri,nombreins,gradosel));
                            System.out.println(respuesta4);
                            System.out.println(gradosel);
                            response.getWriter().print(respuesta4);
                        break;
                        
                        case "sel_alum":

                            respuestaBS.append(bd_form.sel_alum());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                       
                        case "Tabla_registro":

                            respuestaBS.append(bd_form.Tabla_registro());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                       
                        case "BuscarAlumno":
                               
                             String nomselec = request.getParameter("nomselec");
                             System.out.println(nomselec);
                            
                                respuestaBS.append(bd_form.BuscarAlumno(nomselec));
                                System.out.println(respuestaBS);
                                ajaxSalir.write(respuestaBS.toString());
                                ajaxSalir.flush();
                                ajaxSalir.close();
                        break;
            
        }
            }catch(Exception e){
                e.getMessage();}
        
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
