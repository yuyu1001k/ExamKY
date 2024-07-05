package scoremanager.main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSesstion sesstion = request.getSesstion();
		Teacher teacher = (Teacher)sesstion.getAttribute("user");

	}

	public void execute(HttpServletRequest reqest,HttpServletResponse response) throws Exceotion {
		HttpSession sesstion =request.getSesstion();//セッション
		Teacher teacher = (Teacher)sesstion.getSttribute("user");
	}

		String entYearStr="";//入力された学年年度
		String classNum="";//入力されたクラス番号
		String isAttendStr="";//入力された在学フラグ
		int entYear = 0;//入学年度
		boolean isAttend = false;//在学フラグ
		List<Student> students = null;//学生リスト
		LocalDate todayDate = LocalDate.now();
		int year = todayDate.getyear();
		StudentDao sDao = new StudentDao();
		ClassNumDao cNumDao = new ClassNumDao();
		Map<String, String> errors = new HashMap<>();



}
