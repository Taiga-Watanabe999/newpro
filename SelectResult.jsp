<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BEAN.info ,java.util.ArrayList"%>
<%@ page import="java.util.List"%>




<%
ArrayList<info> selectList = (ArrayList<info>) request.getAttribute("リスト");
%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>セレクト結果画面</title>
</head>
<body>
<% out.print(selectList.size()); %>
	<div class="mx-auto text-center" style="width: 70%;">
		<h2 class="text-center mb-3">一覧表示</h2>
	<table class="table table-striped table-bordered">
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>登録日時</th>
		</tr>
		<%
		for (int i = 0; i < selectList.size(); i++) {
		%>

		<tr>
			<td>
				<%
				out.print(selectList.get(i).getId());
				%>
			</td>
			<td>
				<%
				out.print(selectList.get(i).getProductName());
				%>
			</td>
			<td>
				<%
				out.print(selectList.get(i).getPrice());
				%>
			</td>
			<td>
				<%
				out.print(selectList.get(i).getDate());
				%>
			</td>
	
			
		</tr>
		<%
		}
		%>

	</table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
		</div>
</body>
</html>