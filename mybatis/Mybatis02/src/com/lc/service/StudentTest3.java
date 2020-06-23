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
	public void testInsertStudent() {
		logger.info("���ѧ��");
		Student student = new Student();
		student.setName("�Ƕ�");
		student.setAge(20);
		student.setRemark("������Ȼ");
		byte pic[] =null;
		try {
			//����һ���ļ�����
			File file =new File("d://dog.jpg");
			//�����ļ�������
			InputStream inputStream = new FileInputStream(file);
			pic =new byte[inputStream.available()];
			//��ʼ��ȡ
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
		logger.info("ͨ��ID�Ҳ�ѧ��");
		
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
		logger.info("��ѯѧ��");
		List<Student> studentList = studentMapper.searchStudents6("%4%",14 );
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		session.commit();
	}
	@Test
	public void testfindStudent() {
		logger.info("��ѯѧ��:�߼���ҳ");
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
		logger.info("��ѯѧ��:�����ҳ");
		Map<String, Object> map =new HashMap<>();
		map.put("start", 5);
		map.put("size", 5);
		List<Student> studentList = studentMapper.findStudent2(map);
		for (Student student : studentList) {
			System.out.println(student);
		}
		//�����ύ
		session.commit();
	}
}
