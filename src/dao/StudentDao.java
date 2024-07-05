package dao;

import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends DAO{
	private String baseSql;
		public Student get(String no) throws Exception{

		}

		private List<Student> postfilter(ResultSet rSet, School School) throws Exception {

		}

		public List<Student> filter(School school, int entyear, String classNum, boolean isAttend) throws Exception {

		}

		public List<Student> filter(School school, int entyear, boolean isAttend) throws Exception {

		}

		public List<Student> filter(School school, boolean isAttend) throws Exception {

		}

		public boolean save(Student student) throws Exception {

		}
}

