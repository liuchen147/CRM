package com.lc.service;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lc.mappers.StudentMapper;
import com.lc.model.Student;
import com.lc.util.SqlSessionFactoryUtil;


class StudentTest2 {
	
	private static Logger logger =Logger.getLogger(StudentTest.class);
	
	private SqlSession session =null;
	private StudentMapper studentMapper =null;
	//测试前执行的方法
	@BeforeEach
	void setUp() throws Exception {
		 session =SqlSessionFactoryUtil.getSqlsession();
		 studentMapper =session.getMapper(StudentMapper.class);
	}
	//测试完成后执行的方法
	@AfterEach
	void tearDown() throws Exception {
		session.close();
	}

	@Test
	void testAdd() {
		logger.info("添加学生");
		//事务提交
		Student student =new Student(null,"二狗子",19,2);
		int result =studentMapper.add(student);
		session.commit();
		if (result > 0) {
			logger.info("添加成功");
		}
	}

	@Test
	void testUpdate() {
		logger.info("修改学生");
		Student student = new Student(5,"刘斩仙",22);
		int result =studentMapper.update(student);
		session.commit();
		if (result >0) {
			logger.info("修改成功");
		}
	}
	@Test
	void testDelete() {
		logger.info("删除学生");
		int result =studentMapper.delete(2);
		session.commit();
		if (result>0) {
			logger.info("删除成功");
		}
		
	}
	@Test
	void testfindById() {
		logger.info("通过ID找查学生");
		Student student= studentMapper.findById(7);
		System.out.println(student);
	}
	@Test
	void testfind() {
		logger.info("查询学生列表");
		List<Student> studentList = studentMapper.find();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}
