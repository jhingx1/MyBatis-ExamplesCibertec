package pruebas;
import dto.Productos;
import mybatis.SessionFactory;
import mybatis.mapper.ProductosMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
public class productosUpd {
    public static void main(String[] args) {
        Productos pro1 = new Productos();
        pro1.setIdproducto(5);
        
        pro1.setPrecio(33.2);
        pro1.setTipo("Paciencia");
        pro1.setTitulo("Disiplina");
                
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        ProductosMapper mapper = session.getMapper(ProductosMapper.class);
        
        try {
            mapper.productosUpd(pro1);            
            session.commit();
            System.out.println("operacion exitosa...");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }     
    }
}
