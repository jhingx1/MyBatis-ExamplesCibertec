package pruebas;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.Tutoriales;
import java.util.List;

public class TuturialesSelect {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select contact all contacts		
        List<Tutoriales> tutoriales = session.selectList("dto.Tutoriales.getAll");

        for (Tutoriales ts : tutoriales) {
            System.out.println(ts.getIdtutorial());
            System.out.println(ts.getPrecio());
            System.out.println(ts.getTipo());
            System.out.println(ts.getTitulo());            
        }

        System.out.println("Ejecucion Satisfactoria");
        session.commit();
        session.close();

    }

}
