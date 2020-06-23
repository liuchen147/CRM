package com.lc.mappers;



import java.util.List;

import com.lc.model.Student;

public interface StudentMapper {
	public int add(Student student);
	
	public int update(Student student);
	
	public int delete(Integer student);
	
	public Student findById(Integer id);
	
	public List<Student> find();
	
}
