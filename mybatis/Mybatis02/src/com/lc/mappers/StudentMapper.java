package com.lc.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.lc.model.Student;

public interface StudentMapper {
	
		public List<Student> searchStudents(Map<String, Object> map);
		
		public List<Student> searchStudents2(Map<String, Object> map);
		
		public List<Student> searchStudents3(Map<String, Object> map);
		
		public List<Student> searchStudents4(Map<String, Object> map);
		
		public List<Student> searchStudents5(Map<String, Object> map);
		
		public int updateStudent(Student student);
		
		public int insertStudent(Student student);
		
		public Student getStudentById(Integer id);
		
		
		public List<Student> searchStudents6(String name,Integer age);
		
		//逻辑分页，一次性取出所有数据，再来分页
		public List<Student> findStudent(RowBounds rowBounds);
		
		//物理分页,先分页，在查询
		public List<Student> findStudent2(Map<String, Object> map);
		
		
}
