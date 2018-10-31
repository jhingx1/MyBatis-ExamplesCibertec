package pruebas;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import dto.Tutoriales;

public class TuturialesSelectWhere {
    public static void main(String args[]) throws IOException {
        //int i = 1;
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id	
        Tutoriales tutoriales = (Tutoriales) session.selectOne("dto.Tutoriales.getById", 2);

        //Print the student details
        System.out.println(tutoriales.getIdtutorial());
        System.out.println(tutoriales.getPrecio());
        System.out.println(tutoriales.getTipo());
        System.out.println(tutoriales.getTitulo());

        session.commit();
        session.close();
    }
}
