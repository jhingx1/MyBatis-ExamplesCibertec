package web.servlets;

import dto.Notas;
import dto.DataSp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mybatis.SessionFactory;
import mybatis.mapper.NotasMapper;
import org.apache.ibatis.session.SqlSession;

@WebServlet(name = "ServletNotas", urlPatterns = {"/Notas"})
public class ServletNotas extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String accion = request.getParameter("accion");
        String result = null;
        String target = null;
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        try {
            NotasMapper mapper = session.getMapper(NotasMapper.class);
            if (accion == null) {
                result = "Solicitud no recibida.";
            } else if (accion.equals("QRY")) {
                List<Notas> list = mapper.query();
                request.getSession().setAttribute("query", list);
                target = "view/notasQry.jsp";
            } else if (accion.equals("INS")) {
                String alumno = request.getParameter("alumno");
                String nota1 = request.getParameter("nota1");
                String nota2 = request.getParameter("nota2");
                String nota3 = request.getParameter("nota3");
                String comentario = request.getParameter("comentario");
                Notas notas = new Notas();
                notas.setAlumno(alumno);
                notas.setNota1(Short.valueOf(nota1));
                notas.setNota2(Short.valueOf(nota2));
                notas.setNota3(Short.valueOf(nota3));
                notas.setComentario(comentario);
                int ctos = mapper.insert(notas);
                session.commit();
                if (ctos == 0) {
                    result = "0 filas afectadas.";
                } else {
                    List<Notas> list = mapper.query();
                    request.getSession().setAttribute("query", list);
                    target = "view/notasQry.jsp";
                }
            } else if (accion.equals("DEL")) {
                String idalumno = request.getParameter("idalumno");
                int ctos = mapper.delete(Integer.valueOf(idalumno));
                session.commit();
                if (ctos == 0) {
                    result = "0 filas afectadas.";
                } else {
                    List<Notas> list = mapper.query();
                    request.getSession().setAttribute("query", list);
                    target = "view/notasQry.jsp";
                }
            } else if (accion.equals("GET")) {
                String idalumno = request.getParameter("idalumno");
                Notas notas = mapper.get(Integer.valueOf(idalumno));
                request.getSession().setAttribute("notas", notas);
                target = "view/notasUpd.jsp";
            } else if (accion.equals("UPD")) {
                String idalumno = request.getParameter("idalumno");
                String alumno = request.getParameter("alumno");
                String nota1 = request.getParameter("nota1");
                String nota2 = request.getParameter("nota2");
                String nota3 = request.getParameter("nota3");
                String comentario = request.getParameter("comentario");
                Notas notas = new Notas();
                notas.setIdalumno(Integer.valueOf(idalumno));
                notas.setAlumno(alumno);
                notas.setNota1(Short.valueOf(nota1));
                notas.setNota2(Short.valueOf(nota2));
                notas.setNota3(Short.valueOf(nota3));
                notas.setComentario(comentario);
                int ctos = mapper.update(notas);
                session.commit();
                if (ctos == 0) {
                    result = "0 filas afectadas.";
                } else {
                    List<Notas> list = mapper.query();
                    request.getSession().setAttribute("query", list);
                    target = "view/notasQry.jsp";
                }
            } else if (accion.equals("PRO")) {
                String idalumno = request.getParameter("idalumno");
                DataSp dataSp = new DataSp();
                dataSp.setIdalumno(Integer.valueOf(idalumno));
                mapper.promedio(dataSp);
                String msg = dataSp.getNombre()
                        + " tiene promedio: " + dataSp.getPromedio();
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(msg);
            } else {
                result = "Solicitud no reconocida.";
            }
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            session.close();
        }
        if (result != null) {
            request.getSession().setAttribute("msg", result);
            target = "mensaje.jsp";
        }
        if (target != null) {
            response.sendRedirect(target);
        }
    }
// doGet y doPost

    // <editor-fold defaultstate="collapsed" desc="doGet y doPost.">
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
