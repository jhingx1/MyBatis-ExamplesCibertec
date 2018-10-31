package pruebas;

import dto.Tutoriales;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.session.SqlSession;

public class TutorialesAnotaciones {

    public static void main(String[] args) {
        List<Tutoriales> list;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
            list = mapper.tutorialesQry();//Para obtener la lista
        }
        if (list != null) {
            for (Tutoriales p : list) {
                System.out.println(String.format("%-4d%-40s%-10s%8.2f",
                        p.getIdtutorial(), p.getTitulo(),
                        p.getTipo(), p.getPrecio()));
            }
        } else {
            System.out.println("consulta sin resultados...");
        }
    }

}
