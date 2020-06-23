package com.lc.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lc.mappers.StudentMapper;
import com.lc.model.Student;
import com.lc.util.SqlSessionFactoryUtil;


class StudentTest3 {
	
	private static Logger logger =Logger.getLogger(StudentTest3.class);
	
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
	public void testInsertStudent() {
		logger.info("添加学生");
		Student student = new Student();
		student.setName("城东");
		student.setAge(20);
		student.setRemark("道法自然");
		byte pic[] =null;
		try {
			//创建一个文件对象
			File file =new File("d://dog.jpg");
			//创建文件输入流
			InputStream inputStream = new FileInputStream(file);
			pic =new byte[inputStream.available()];
			//开始读取
			inputStream.read(pic);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		student.setPic(pic);
		studentMapper.insertStudent(student);
		session.commit();
	}
	
	@Test
	public void testGetStudentById() {
		logger.info("通过ID找查学生");
		
		Student student = studentMapper.getStudentById(13);
		System.out.println(student);
		
		byte[]pic =student.getPic();
		File file =new File("e://dog2.jpg");
		
		try {
			OutputStream outputStream =new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		session.commit();
	}
	@Test
	public void testSearchStudents6() {
		logger.info("查询学生");
		List<Student> studentList = studentMapper.searchStudents6("%4%",14 );
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		session.commit();
	}
	@Test
	public void testfindStudent() {
		logger.info("查询学生:逻辑分页");
		int offset=5;
		int limit=5;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<Student> studentList = studentMapper.findStudent(rowBounds);
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		session.commit();
	}
	
	@Test
	public void testfindStudent2() {
		logger.info("查询学生:物理分页");
		Map<String, Object> map =new HashMap<>();
		map.put("start", 5);
		map.put("size", 5);
		List<Student> studentList = studentMapper.findStudent2(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//事务提交
		session.commit();
	}
}
