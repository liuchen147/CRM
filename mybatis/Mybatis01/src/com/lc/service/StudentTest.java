package com.lc.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.lc.mappers.StudentMapper;
import com.lc.model.Student;
import com.lc.util.SqlSessionFactoryUtil;

public class StudentTest {
	
		private static Logger logger =Logger.getLogger(StudentTest.class);
		
		public static void main(String[] args) {
			//打开数据库连接
			SqlSession session =SqlSessionFactoryUtil.getSqlsession();
			StudentMapper studentMapper =session.getMapper(StudentMapper.class);
			Student student =new Student(null,"王五",25,2);
			int result =studentMapper.add(student);
			//事务提交
			session.commit();
			if (result > 0) {
				logger.info("添加成功");
				
			}
			
			
			
		}
}
