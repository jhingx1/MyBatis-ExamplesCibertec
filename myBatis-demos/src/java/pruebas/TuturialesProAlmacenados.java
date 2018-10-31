package pruebas;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.Tutoriales;

public class TuturialesProAlmacenados {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id	
        Tutoriales tutoriales = (Tutoriales) session.selectOne("dto.Tutoriales.tutoalm", 3);

        //Print the student details
        System.out.println("Detaller de tutoriales es: ");
        System.out.println("Id :" + tutoriales.getIdtutorial());
        System.out.println("Titulo :" + tutoriales.getTitulo());
        System.out.println("Tipo :" + tutoriales.getTipo());
        System.out.println("Precio :" + tutoriales.getPrecio() );        
        session.commit();
        session.close();

    }

}
