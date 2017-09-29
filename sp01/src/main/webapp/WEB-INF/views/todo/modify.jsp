<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="./include/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--   ${cri.page}
  
 <form id="form1" action="/todo/modify" method="post">
    
    <input type='hidden' name='page' value='${cri.page}'>
    <label>TNO </label><input type='text' name='tno' value="${todo.tno }" readonly="readonly" >
    <label>Title</label><input type='text' name='title' value="${todo.title }" >
    <label>Writer</label><input type='text' name='writer'  value="${todo.writer}">
    
    
    <button class='btn' data-oper='r'>Remove</button>
    <button class='btn' data-oper='m'>Modify</button>
    <button class='btn' data-oper='l'>List</button>
  </form>
  
  <form class='f1' method="get" >
    <input type='hidden' name='page' value='${cri.page}'>
    <input type='hidden' name='tno' value='${todo.tno}'>
    
  </form>
   --%>

	<style type="text/css">
body {
	line-height: 2em;
	font-family: serif;
}

ul, li {
	list-style: none;
	text-align: center;
	padding: 0;
	margin: 0;
}

#mainWrapper {
	width: 700px;
	margin: 0 auto; /*가운데 정렬*/
}

#mainWrapper>ul>li:first-child {
	text-align: center;
	font-size: 14pt;
	height: 40px;
	vertical-align: middle;
	line-height: 30px;
}

#ulTable {
	margin-top: 10px;
}

#ulTable>li:first-child>ul>li {
	background-color: red;
	font-weight: bold;
	font-family: "맑은고딕";
	text-align: center;
}

#ulTable>li>ul {
	clear: both;
	padding: 0px auto;
	position: relative;
	min-width: 40px;
}

#ulTable>li>ul>li {
	float: left;
	font-size: 10pt;
	border-bottom: 1px solid silver;
	vertical-align: baseline;
}

#ulTable>li>ul>li:first-child {
	width: 10%;
} /*No 열 크기*/
#ulTable>li>ul>li:first-child+li {
	width: 45%;
} /*제목 열 크기*/
#ulTable>li>ul>li:first-child+li+li {
	width: 20%;
} /*작성일 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li {
	width: 15%;
} /*작성자 열 크기*/
#ulTable>li>ul>li:first-child+li+li+li+li {
	width: 10%;
} /*조회수 열 크기*/
#divPaging {
	clear: both;
	margin: 0 auto;
	width: 220px;
	height: 50px;
}

#divPaging>div {
	float: left;
	width: 30px;
	margin: 0 auto;
	text-align: center;
}

#liSearchOption {
	clear: both;
}

#liSearchOption>div {
	margin: 0 auto;
	margin-top: 30px;
	width: auto;
	height: 100px;
}

.left {
	text-align: left;
}
</style>
	<div class="bg-faded p-4 my-4 listpoint">

		<!-- 리스트 들어가는곳 -->

		<div id="mainWrapper">

			<ul>
				<!-- 게시판 제목 -->
				<li></li>

				<!-- 게시판 목록  -->
				<li>
					<ul id="ulTable">
						<li>
							<ul>
								<li>No</li>
								<li>Title</li>
								<li>Date</li>
								<!-- <li>Writer</li> -->
								<!-- <li>Views</li> -->
							</ul>
						</li>
						<!-- 게시물이 출력될 영역 -->


						<li>
							<ul>


								<form id="form1" action="/todo/modify" method="post">
									<li><input type='hidden' name='page' value='${cri.page}'>
										<label> </label><input type='text' name='tno'
										value="${todo.tno }" readonly="readonly"
										style="text-align: center; width: 2em; height: 2em;">
										<label></label><input type='text' name='title'
										value="${todo.title }"
										style="text-align: center; width: 15em; height: 2em;">
										<label></label><input type='text' name='writer'
										value="${todo.writer}"
										style="text-align: center; width: 15em; height: 2em;">
									</li>
									<li>
										<button class='btn' data-oper='r'>Remove</button>
										<button class='btn' data-oper='m'>Modify</button>
										<button class='btn' data-oper='l'>List</button>
									</li>
								</form>

								<form class='f1' method="get">
									<input type='hidden' name='page' value='${cri.page}'> <input
										type='hidden' name='tno' value='${todo.tno}'>

								</form>

							</ul>
						</li>

					</ul>
				</li>
			</ul>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>

	<script>
		$(document).ready(
				function() {

					var formObj = $(".f1")

					$(".btn").click(
							function(e) {

								e.preventDefault();

								var $this = $(this);
								var oper = $this.attr("data-oper");

								if (oper === 'r') {
									formObj.attr("action", "/todo/remove")
											.attr("method", "post");
								} else if (oper === 'l') {
									formObj.attr("action", "/todo/index")
									formObj.attr("method", "get");
								} else if (oper === 'm') {
									$("#form1").submit();
									return;
								}

								formObj.submit();
							});

				});
	</script>

</body>
<%@include file="./include/footer.jsp"%>
</html>