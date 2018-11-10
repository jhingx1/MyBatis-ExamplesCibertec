package mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import mybatis.mapper.AutoresMapper;
import mybatis.mapper.FrasesMapper;

public class SessionFactory {

    protected static final SqlSessionFactory FACTORY;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(
                    "mybatis/mybatis-config.xml");

            FACTORY = new SqlSessionFactoryBuilder().build(reader);
            
            // se adicionan los mapper
            FACTORY.getConfiguration().addMapper(AutoresMapper.class);
            FACTORY.getConfiguration().addMapper(FrasesMapper.class);
            //---

        } catch (IOException e) {
            throw new RuntimeException("Error: " + e, e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return FACTORY;
    }
}

