<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>parainformaticos.com</title>
        <link href="../css/main.css" type="text/css" rel="stylesheet">
        <link href="../css/table.css" type="text/css" rel="stylesheet">
        <link href="../css/a.css" type="text/css" rel="stylesheet">

        <script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
        <script src="../js/notas.js" type="text/javascript"></script>
    </head>
    <body>
        <div style="width:540px;margin:auto">
            <table class="clasico">
                <caption>
                    <a href="#" onclick="ins()">
                        <img src="../images/ins.png" 
                             align="top" title="Nuevo"/></a>&nbsp;&nbsp;
                    Notas de Alumnos
                </caption>
                <thead>
                    <tr>
                        <td>alumno</td>
                        <td>nota1</td>
                        <td>nota2</td>
                        <td>nota3</td>
                        <td>comentario</td>
                        <td style="width:20px">&nbsp;</td>
                        <td style="width:20px">&nbsp;</td>
                    </tr>
                </thead>

                <tfoot>
                    <tr>
                        <td colspan="7">
                            &iexcl;Para Informáticos facilita tu aprendizaje!
                        </td>
                    </tr>
                </tfoot>

                <tbody>
                    <c:forEach var="n" items="${query}">
                        <tr>
                            <td>
                                ${n.alumno}
                                &nbsp;&nbsp;
                                <sup><a class="clasico" href="#" 
                                    onclick="promedio('${n.idalumno}')">
                                        promedio</a></sup>
                            </td>
                            <td style="text-align:center">${n.nota1}</td>
                            <td style="text-align:center">${n.nota2}</td>
                            <td style="text-align:center">${n.nota3}</td>
                            <td>${n.comentario}</td>
                            <th>
                                <a href="#" 
                                   onclick="upd('${n.idalumno}')">
                                    <img src="../images/upd.png" 
                                         title="Actualizar"></a>
                            </th>
                            <th>
                                <a href="#" 
                                   onclick="del('${n.idalumno}')">
                                    <img src="../images/del.png" 
                                         title="Retirar"></a>
                            </th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

