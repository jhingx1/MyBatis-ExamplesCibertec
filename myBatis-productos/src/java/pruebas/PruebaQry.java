package pruebas;

import dto.Productos;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.ProductosMapper;
import org.apache.ibatis.session.SqlSession;

public class PruebaQry {

    public static void main(String[] args) {
        List<Productos> list;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            ProductosMapper mapper = session.getMapper(ProductosMapper.class);
            list = mapper.productosQry();//Para obtener la lista
        }
        if (list != null) {
            for (Productos p : list) {
                System.out.println(String.format("%-4d%-40s%-10s%8.2f",
                        p.getIdproducto(), p.getTitulo(),
                        p.getTipo(), p.getPrecio()));
            }
        } else {
            System.out.println("consulta sin resultados...");
        }
    }

}
