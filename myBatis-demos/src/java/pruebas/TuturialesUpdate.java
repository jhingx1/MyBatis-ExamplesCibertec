package pruebas;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import dto.Tutoriales;

public class TuturialesUpdate {

    public static void main(String args[]) throws IOException {
        
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student using id		
        Tutoriales tutoriales = (Tutoriales) session.selectOne("dto.Tutoriales.getByIdUpd", 1);
        System.out.println("Los detalles actuales del Tutoriales son.");
        System.out.println(tutoriales.toString());

        //Establecer nuevos valores al correo y número de teléfono del alumno.
        tutoriales.setTitulo("Trabajo");
        tutoriales.setTipo("Alimentos");
        tutoriales.setPrecio(19.2);

        //Update the student record
        session.update("dto.Tutoriales.update", tutoriales);
        System.out.println("Actualizacion Satisfactoria");
        session.commit();
        //session.close();

        //verifying the record 
        Tutoriales std = (Tutoriales) session.selectOne("dto.Tutoriales.getByIdUpd", 1);
        System.out.println("Los detalles actuales del Tutoriales son.");
        System.out.println(std.toString());
        session.commit();
        session.close();
    }
}
