<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Landing Page - Start Bootstrap Theme</title>

<!-- Bootstrap core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https:/fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<link href="/resources/css/upload.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand" href="">File registration</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/todo/index">Back
						to the List</a></li>

				</li>
			</ul>
		</div>
	</div>
	</nav>




	<!-- Header -->
	<header class="intro-header">
	<div class="container">
		<div class="intro-message">
			<h1>File Upload</h1>
			<div>
				<br> <br> <br>
				<center>
					<h2 id="reply-title" class="comment-reply-title">
						<small><a rel="nofollow" id="cancel-comment-reply-link"
							href="/40-high-quality-free-responsive-bootstrap-html5-templates-all-time/#respond"
							style="display: none;">Cancel reply</a></small>
					</h2>


					<p style="display: none;">
						<input type="hidden" id="akismet_comment_nonce"
							name="akismet_comment_nonce" value="8abe9ea5bd">
					</p>
					<p style="display: none;"></p>
					<input type="hidden" id="ak_js" name="ak_js" value="1503562081861">

					<script type="text/javascript">
						jQuery(document).ready(
								function() {

									jQuery(document).pjax(
											'a.pjax, .header-second-menu a',
											'#pjax-container', {
												timeout : 2000
											});

									jQuery(document).on('pjax:send',
											function() {
												jQuery('#pjax_loading').show();
											});
									jQuery(document).on('pjax:complete',
											function(xhr, textStatus, options) {
												console.log(options);
												jQuery('#pjax_loading').hide();
												jQuery(document).scrollTop(2);
											});

								});
					</script>
			</div>
			<h3>Choose Files</h3>
			<hr class="intro-divider">
			<p>
			<form method="post">
				<center>
					<label>Title</label><input type="text" name="title"> <label>
						Writer</label><input type="text" name="writer">
					<button>Confirm</button>
				</center>
			</form>



			</p>
			<br> <br>
		</div>
	</div>
	</header>


	<div class="container">
		<ul class="list-inline">


		</ul>

	</div>



	<!-- Bootstrap core JavaScript -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/popper/popper.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>

