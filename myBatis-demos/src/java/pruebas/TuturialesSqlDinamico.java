package pruebas;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.Tutoriales;
import java.util.List;

public class TuturialesSqlDinamico {

    public static void main(String args[]) throws IOException {

        String req_name = "Trabajo";
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        Tutoriales stud = new Tutoriales();
        stud.setTitulo(req_name);

        //select contact all contacts		
        //List<Student> student = session.selectList("getRecByName",stud);
        stud.setIdtutorial(1);
        List<Tutoriales> student = session.selectList("getRecByName", stud);

        for (Tutoriales st : student) {

            System.out.println("++++++++++++++details of the student named Mohammad are " + "+++++++++++++++++++");

            System.out.println("Id :  " + st.getIdtutorial());
            System.out.println("Titulo :  " + st.getTitulo());
            System.out.println("Tipo :  " + st.getTipo());
            System.out.println("Precio :  " + st.getPrecio());            
        }

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();

    }

}
