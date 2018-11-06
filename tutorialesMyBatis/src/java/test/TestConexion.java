package test;

import mybatis.SessionFactory;
import org.apache.ibatis.session.SqlSession;

public class TestConexion {

    public static void main(String[] args) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            if (session.getConnection() != null) {
                System.out.println("conexion exitosa...");
            } else {
                System.out.println("problemas de conexion...");
            }
        }
    }
}
