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
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class TestListAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

	// 処理内容(シーケンス図から)
		HttpSession session = req.getSession(); // セッションの開始
		Teacher teacher = (Teacher)session.getAttribute("user");

		int entYear = 0; //入学年度
		LocalDate todaysDate = LocalDate.now(); // LocalDateインスタンスを取得
		int year = todaysDate.getYear(); // 現在の年を取得
		SubjectDao sDao = new SubjectDao(); // 学生Dao
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


	// JSPへフォワード
		req.getRequestDispatcher("test_list.jsp").forward(req, res);
	}
}