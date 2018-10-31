package pruebas;

import dto.Productos;
import mybatis.SessionFactory;
import mybatis.mapper.ProductosMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class PruebaIns {

    public static void main(String[] args) {
        Productos p1 = new Productos();
        Productos p2 = new Productos();
        p1.setTitulo("aaa");
        p1.setTipo("Separata");
        p1.setPrecio(12D);
        p2.setTitulo("bbb");
        p2.setTipo("Video");
        p2.setPrecio(15d);
//
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        ProductosMapper mapper = session.getMapper(ProductosMapper.class);
        
        try {
            mapper.productosIns(p1);
            mapper.productosIns(p2);
            session.commit();
            System.out.println("operacion exitosa...");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }
}
