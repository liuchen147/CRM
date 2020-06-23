package com.lc.util;

import java.io.IOException;
import java.io.InputStream;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionFactoryUtil {
		private static SqlSessionFactory sqlSessionFactory;
		
		public static SqlSessionFactory getSqlSessionFactory() {
			if (sqlSessionFactory == null) {
				InputStream inputStream =null;
				//加载mybatis的配置文件
				try {
					inputStream =Resources.getResourceAsStream("mybatis-config.xml");
					sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return sqlSessionFactory;
		}
		
		public static SqlSession getSqlsession() {
			//通过工厂对象打开一个数据库
			return getSqlSessionFactory().openSession();
			
			
		}
}
