package test;

import hibernate.HibernateUtil;
import hibernate.Tutoriales;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Demora {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        try {
            long ini = System.currentTimeMillis();
            for (int i = 0; i < 1_000; i++) {

                Tutoriales tutoriales = new Tutoriales();
                tutoriales.setTitulo(String.format("titulo_%04d", i));
                tutoriales.setTipo("Video");
                tutoriales.setPrecio(20d);

                session.persist(tutoriales);
            }

            session.getTransaction().commit();

            long fin = System.currentTimeMillis();
            System.out.println("duración: " + (fin - ini) + " ms.");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }

        HibernateUtil.getSessionFactory().close();
    }
}
/*
Ejecutar cada ves que se inserta para borrar los registros insertados.
SELECT * FROM tutoriales
DELETE FROM tutoriales WHERE titulo LIKE '%titulo%'
*/
