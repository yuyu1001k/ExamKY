<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>


			<c:choose>
				<c:when test="${tests.size()>0}">
					<div><h2>科目：${subject} (${sum}回)</h2></div>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>点数</th>
						</tr>
						<c:forEach var="test" item="${tests}">
							<tr>
								<td>${test.student.entYear}</td>
								<td>${test.classNum}.</td>
								<td>${test.student.no}</td>
								<td>${test.student.name}</td>
								<td><input type="number" name="point_${test.student.no}"min=0 max=100></td>
							</tr>
						</c:forEach>
					</table>
					<input type="submit" value="登録して終了">
				</c:when>
				<c:otherwise>
					<div>成績が存在しませんでした</div>
				</c:otherwise>
			</c:choose>








