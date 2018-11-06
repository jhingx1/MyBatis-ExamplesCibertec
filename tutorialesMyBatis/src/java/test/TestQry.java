/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.Tutoriales;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.session.SqlSession;

public class TestQry {

    public static void main(String[] args) {
        List<Tutoriales> list;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
            list = mapper.tutorialesQry();
        }
        if (list != null) {
            list.forEach(t -> {
                System.out.println(String.format("%-4d%-40s%-10s%8.2f",
                        t.getIdtutorial(), t.getTitulo(),
                        t.getTipo(), t.getPrecio()));
            });
        } else {
            System.out.println("consulta sin resultados...");
        }
    }
}
