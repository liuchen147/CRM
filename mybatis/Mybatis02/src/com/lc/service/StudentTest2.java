package com.lc.service;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lc.mappers.StudentMapper;
import com.lc.model.Student;
import com.lc.util.SqlSessionFactoryUtil;


class StudentTest2 {
	
	private static Logger logger =Logger.getLogger(StudentTest2.class);
	
	private SqlSession session =null;
	private StudentMapper studentMapper =null;
	//����ǰִ�еķ���
	@BeforeEach
	void setUp() throws Exception {
		 session =SqlSessionFactoryUtil.getSqlsession();
		 studentMapper =session.getMapper(StudentMapper.class);
	}
	//������ɺ�ִ�еķ���
	@AfterEach
	void tearDown() throws Exception {
		session.close();
	}

	@Test
	public  void testSearchStudents() {
		logger.info("��ѯѧ��");
		//�����ύ
		Map<String, Object> map=new HashMap<>();
		map.put("gradeId", 1);
		//map.put("name", "%��%");
		//map.put("age", 15);
		
		List<Student> studentList = studentMapper.searchStudents(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		session.commit();
	}

	@Test
	public void testSearchStudents2() {
		logger.info("��ѯѧ��");
		//�����ύ
		Map<String, Object> map=new HashMap<>();
		map.put("searchBy", "name");
		map.put("gradeId", 1); 
		map.put("name", "%��%");
		map.put("age", "15");
		List<Student> studentList = studentMapper.searchStudents2(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//�����ύ
		session.commit();
	}
	
	@Test
	public void testSearchStudents3() {
		logger.info("��ѯѧ��");
		//�����ύ
		Map<String, Object> map=new HashMap<>();
		
		map.put("gradeId", 1); 
		map.put("name", "%��%");
		map.put("age", "15");
		List<Student> studentList = studentMapper.searchStudents3(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//�����ύ
		session.commit();
	}
	
	@Test
	public void testSearchStudents4() {
		logger.info("��ѯѧ��");
		//�����ύ
		Map<String, Object> map=new HashMap<>();
		
		map.put("gradeId", 1); 
		map.put("name", "%��%");
		//map.put("age", "15");
		List<Student> studentList = studentMapper.searchStudents4(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//�����ύ
		session.commit();
	}
	
	@Test
	public void testSearchStudents5() {
		logger.info("��ѯѧ��");
		//�����ύ
		Map<String, Object> map=new HashMap<>();
		List<Integer> gradeIds = new ArrayList<>();
		
		gradeIds.add(2);
		map.put("gradeIds", gradeIds);
		List<Student> studentList = studentMapper.searchStudents5(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//�����ύ
		session.commit();
	}
	@Test
	public void testUpdateStudent() {
		logger.info("�޸�ѧ��");
		Student student = new Student();
		student.setId(3);
		student.setName("����4");
		student.setAge(14);
		studentMapper.updateStudent(student);
		//�����ύ
		session.commit();
	}
}
