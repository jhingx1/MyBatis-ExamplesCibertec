package pruebas;

import dto.Productos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import mybatis.SessionFactory;
import mybatis.mapper.ProductosMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class productosDel {

    public static void main(String[] args) {
        Productos pro1 = new Productos();
        pro1.setIdproducto(4);

        List<Integer> ids = new ArrayList<>();
        ids.add(pro1.getIdproducto());              

        String id = "";
        
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        ProductosMapper mapper = session.getMapper(ProductosMapper.class);

        try {
            
            for(Integer x:ids){
                id=x.toString();
                mapper.productosDel(id);
            }
            
            session.commit();

            System.out.println(
                    "operacion exitosa...");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }

    
}
