package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		// 処理内容(シーケンス図から)
				HttpSession session = req.getSession(); // セッションの開始
				Teacher teacher = (Teacher)session.getAttribute("user");

				int entYear = 0; //入学年度
				LocalDate todaysDate = LocalDate.now(); // LocalDateインスタンスを取得
				int year = todaysDate.getYear(); // 現在の年を取得
				SubjectDao sDao = new SubjectDao(); // 科目Dao
				ClassNumDao cNumDao = new ClassNumDao(); // クラス番号Daoを初期化
				Map<String, String> errors = new HashMap<>(); // エラーメッセージ

			// DBからデータを取得
			// ログインユーザーの学校コードをもとにクラス番号一覧を取得
				List<String> list = cNumDao.filter(teacher.getSchool());

			// リストを初期化
				List<Integer> entYearSet = new ArrayList<>();
			//	10年前から1年後まで年をリストに追加
				for (int i = year - 10; i < year + 1; i++) {
					entYearSet.add(i);
				}

			// レスポンス値をセット
			// リクエストにデータをセット
				req.setAttribute("class_num_set", list);//クラス一覧
				req.setAttribute("ent_year_set", entYearSet);//入学年度一覧
				List<Subject> subjects = sDao.filter(teacher.getSchool());//科目一覧
				req.setAttribute("subjects",subjects);
				String entYearStr = req.getParameter("f1");//入学年度の取得
				String classNum = req.getParameter("f2");//入学年度の取得
				String subjectcode = req.getParameter("f3");//入学年度の取得

				Subject subject = sDao.get(subjectcode,teacher.getSchool());
				if (entYearStr != null) {
					// 数値に変換
					entYear = Integer.parseInt(entYearStr);
				}

				//subjectデータを用意(指定した)科目
		TestListSubjectDao TLSDao = new TestListSubjectDao();
		List<TestListSubject> tests = TLSDao.filter(entYear,classNum,subject,teacher.getSchool());
		req.setAttribute("tests",tests);


		// JSPへフォワード
		req.getRequestDispatcher("test_list_subject.jsp").forward(req, res);
	}


}