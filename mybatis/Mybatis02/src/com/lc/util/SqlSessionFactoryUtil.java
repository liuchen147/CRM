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
				//����mybatis�������ļ�
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
			//ͨ�����������һ�����ݿ�
			return getSqlSessionFactory().openSession();
			
			
		}
}
