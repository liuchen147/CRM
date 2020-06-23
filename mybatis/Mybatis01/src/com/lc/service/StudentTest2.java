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
	void testAdd() {
		logger.info("���ѧ��");
		//�����ύ
		Student student =new Student(null,"������",19,2);
		int result =studentMapper.add(student);
		session.commit();
		if (result > 0) {
			logger.info("��ӳɹ�");
		}
	}

	@Test
	void testUpdate() {
		logger.info("�޸�ѧ��");
		Student student = new Student(5,"��ն��",22);
		int result =studentMapper.update(student);
		session.commit();
		if (result >0) {
			logger.info("�޸ĳɹ�");
		}
	}
	@Test
	void testDelete() {
		logger.info("ɾ��ѧ��");
		int result =studentMapper.delete(2);
		session.commit();
		if (result>0) {
			logger.info("ɾ���ɹ�");
		}
		
	}
	@Test
	void testfindById() {
		logger.info("ͨ��ID�Ҳ�ѧ��");
		Student student= studentMapper.findById(7);
		System.out.println(student);
	}
	@Test
	void testfind() {
		logger.info("��ѯѧ���б�");
		List<Student> studentList = studentMapper.find();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
}
