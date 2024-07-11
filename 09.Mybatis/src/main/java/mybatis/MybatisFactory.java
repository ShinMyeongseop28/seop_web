package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static SqlSession session;
		
	public static SqlSession getInstance() {
		if( session == null) {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				session = new SqlSessionFactoryBuilder().build(inputStream)
														.openSession(true);
			
			} catch (IOException e) {
			}
		}
		return session;
	}
}
