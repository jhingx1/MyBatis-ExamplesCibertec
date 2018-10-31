package pruebas;
import dto.Productos;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.ProductosMapper;
import org.apache.ibatis.session.SqlSession;
public class productosGet {
    public static void main(String[] args) {
        Productos pro1 = new Productos();
        pro1.setIdproducto(1);
        Productos list = new Productos();
        
        try(SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            ProductosMapper mapper = session.getMapper(ProductosMapper.class);
            list = mapper.productosGet(pro1.getIdproducto());//Para obtener la lista
            
        } catch (Exception e) {
        }
        
        if(list != null){
            System.out.println("ID : "+list.getIdproducto());
            System.out.println("Titulo : " + list.getTitulo());
            System.out.println("Tipo : "+list.getTipo());
            System.out.println("Precio : "+list.getPrecio());            
        }
        
        
       
        
    }
}
