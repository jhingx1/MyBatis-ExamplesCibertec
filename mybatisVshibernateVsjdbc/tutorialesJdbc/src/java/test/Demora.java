package test;

import dto.Tutoriales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import parainfo.sql.ConectaDb;

public class Demora {

    public static void main(String[] args) {

        String sql = "INSERT INTO tutoriales(titulo, tipo, precio) VALUES(?, ?, ?)";

        ConectaDb db = new ConectaDb();

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            cn.setAutoCommit(false);
            boolean ok = true;

            long ini = System.currentTimeMillis();
            for (int i = 0; i < 1_000; i++) {

                Tutoriales tutoriales = new Tutoriales();
                tutoriales.setTitulo(String.format("titulo_%04d", i));
                tutoriales.setTipo("Video");
                tutoriales.setPrecio(20d);

                ps.setString(1, tutoriales.getTitulo());
                ps.setString(2, tutoriales.getTipo());
                ps.setDouble(3, tutoriales.getPrecio());

                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                cn.commit();
            } else {
                cn.rollback();
            }

            long fin = System.currentTimeMillis();
            System.out.println("duración: " + (fin - ini) + " ms.");

            cn.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
Ejecutar cada ves que se inserta para borrar los registros insertados.
SELECT * FROM tutoriales
DELETE FROM tutoriales WHERE titulo LIKE '%titulo%'
*/