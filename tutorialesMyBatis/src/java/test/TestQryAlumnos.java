/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.model.Alumnos;
import java.util.List;
import mybatis.SessionFactory;
import data.dao.AlumnosMapper;
import org.apache.ibatis.session.SqlSession;

public class TestQryAlumnos {

    public static void main(String[] args) {
        List<Alumnos> list;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            AlumnosMapper mapper = session.getMapper(AlumnosMapper.class);
            list = mapper.alumnosQry();
        }
        if (list != null) {
            list.forEach(t -> {
                System.out.println(t.getIdalumno()+" - " + t.getNombre());
            });
        } else {
            System.out.println("consulta sin resultados...");
        }
    }
}
