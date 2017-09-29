<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="./include/header.jsp"%>



</body>

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
	background-color:rgb(255, 255, 255);
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

<style>
.popup {
	position: absolute;
	top: 50%;
	left: 25%;
	width: 200px;
	height: 100px;
	margin-left: -50px;
	background-color: fuchsia;
}

.hide {
	display: none;
}

.show {
	display: block;
}
</style>

<!-- --------여기 바로 밑이 게시판 no title date user views임------------ -->


<!-- body start -->
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
							<li>User</li>
							<li>Views</li>
						</ul>
					</li>
					<!-- 게시물이 출력될 영역 -->

					<c:forEach items="${list}" var="todo">
						<li>
							<ul>
								<li>${todo.tno}</li>
								<li class="left"><a
									href="http://localhost:8080/todo/view?tno=${todo.tno} ">${todo.title }</a></li>
								<li><fmt:formatDate value="${todo.regdate}"
										pattern="yyyy-MM-dd" /></li>
								<li>-</li>
								<li>0</li>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</li>

			<!-- 게시판 페이징 영역 -->


			<style>

/* 	---- 페이징 번호 ------- */
.pageArea li {
	list-style: none;
	margin: 1em;
	width: 1.8em;
	text-align: center;
	color: white;
	background-color: rgb(90,90,90);
	float: left;
	border-radius: 5px;
}
</style>

			<ul class='pageArea'>
			</ul>




			<div class='popup hide'></div>

			<form id='form1' action="/todo/view" method='get'>
				<input type='hidden' name='tno' id='tno'> <input
					type='hidden' name='page' value='${criteria.page}'>
			</form>

			<script src="https://code.jquery.com/jquery-3.2.1.min.js"
				integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
				crossorigin="anonymous"></script>


			<script type="text/javascript" src="/resources/js/paging.js"></script>

			<script> 
					
  $(document).ready(function(){
	  
	  var pageStr = makePage(
		      {
		          total:${criteria.total},
		          current:${criteria.page},
		          pageSize:10
		      });
	  
	  console.log("==================");
	  console.log(pageStr);
	  
	  $(".pageArea").html(pageStr);
	  
	  $(".pageArea").on("click", function(e){
		 
		  e.preventDefault();
		  
		  var target = e.target;
		  
		  console.log(target.innerHTML);
		  
		  $("#form1")
		   .attr("action", "/todo/index")
		   .find("input[name='page']")
		   .val(target.innerHTML);
		  
		  $("#form1").submit();
		  
		  console.log($("#form1").find("input[name='page']") );
		  
	  });
	  
	  
	  $(".delBtn").on("click", function(e){
		 
		  var $this = $(this);
		  var tno = $this.attr("data-tno");
		  
		  
		  $("#tno").val(tno);
		  $("#form1").attr("action","/todo/remove").submit();
		  
	  });
	  
	  $(".link").on("click", function(e){
		 e.preventDefault();
		 console.log("move..........");
		 
		 var $this = $(this);
		 var tno = $this.attr("href");
		 
		 console.log("tno: " + tno);
		 
		 $("#tno").val(tno);
		 $("#form1").submit();
		 
	  });
	  
  });
  
  /* -------------페이징 번호 처리 및 게시글 조회하면 index로 돌아오는거 ----------------- */
  
  </script>

			<br></br>
			<br></br>

			<nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
			<div class="container">
				<a
					class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none"
					href="#">Start Bootstrap</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav mx-auto">
						<!-- 	<li class="nav-item active px-lg-4"><a
							class="nav-link text-uppercase text-expanded" href="modify.html">수정
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item px-lg-4"><a
							class="nav-link text-uppercase text-expanded" href="remove.html">삭제</a>
						</li> -->
						<li class="nav-item px-lg-4"><a
							class="nav-link text-uppercase text-expanded"
							href="register.html"><b>Register</b></a></li>
					</ul>
				</div>
			</div>
			</nav>

		</ul>
	</div>
</div>
<!-- body end -->
<%@include file="./include/footer.jsp"%>