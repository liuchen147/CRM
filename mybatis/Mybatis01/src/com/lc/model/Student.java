package com.lc.model;

public class Student {
		private Integer id;
		private String name;
		private Integer age;
		private int gradeId;
		
		public Student() {
			super();
		
		}
		
		public Student(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
			
		}
		

		public Student(Integer id, String name, Integer age, int gradeId) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.gradeId = gradeId;
		}

		public Student(Integer id, String name, Integer age) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
		}
		

		public int getGradeId() {
			return gradeId;
		}

		public void setGradeId(int gradeId) {
			this.gradeId = gradeId;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		
}
