package mybatis.mapper;

import dto.Productos;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProductosMapper {

    @Select(PRODUCTOS_QRY)
    public List<Productos> productosQry();

    @Select(PRODUCTOS_GET)
    public Productos productosGet(@Param("idproducto") Integer idproducto);

    @Insert(PRODUCTOS_INS)
    public int productosIns(Productos productos);

    @Update(PRODUCTOS_UPD)
    public int productosUpd(Productos productos);

    @Delete(PRODUCTOS_DEL)
    public int productosDel(@Param("ids") String ids);
// sentecias SQL
    String PRODUCTOS_QRY
            = "SELECT idproducto, titulo, tipo, precio "
            + "FROM productos ORDER BY titulo";
    String PRODUCTOS_GET
            = "SELECT idproducto, titulo, tipo, precio FROM productos "
            + "WHERE idproducto=#{idproducto}";
    String PRODUCTOS_INS
            = "INSERT INTO productos(titulo, tipo, precio) "
            + "VALUES(#{titulo}, #{tipo}, #{precio})";
    String PRODUCTOS_UPD
            = "UPDATE productos SET "
            + "titulo=#{titulo}, tipo=#{tipo}, precio=#{precio} "
            + "WHERE idproducto=#{idproducto}";
    String PRODUCTOS_DEL
            = "DELETE FROM productos WHERE idproducto IN(${ids})";
}
