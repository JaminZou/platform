<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>temple</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resources/common/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" media="screen">
</head>
<body>
	<div class="navbar navbar-fixed-top" style="margin: -1px -1px 0;">
		<div class="navbar-inner">
			<div class="container"
				style="width: auto; padding: 0 20px; background-color: #DCDCDC;">
				<a class="brand" href="#">ZORBIT</a>
				<!--  <ul class="nav">
                    <li class="active"><a href="#">首页</a></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                  </ul> -->
			</div>
		</div>
	</div>
	<div class="row-fluid" style="padding-top: 40px;">
		<div class="span2 nav-collapse collapse"
			style="background-color: #DCDCDC; height: 100%; margin-left: 0px; position: fixed;">
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading" style="background-color: #CC3300;">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseOne"><i
							class="icon-list"></i>apsible Group Item #1 </a>
					</div>
					<div id="collapseOne" class="accordion-body collapse in">
						<div class="accordion-inner">Anim pariatur cliche...</div>
						<div class="accordion-inner">Anim pariatur cliche...</div>
						<div class="accordion-inner">Anim pariatur cliche...</div>
						<div class="accordion-inner">Anim pariatur cliche...</div>
						<div class="accordion-inner">Anim pariatur cliche...</div>
						<div class="accordion-inner">Anim pariatur cliche...</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading" style="background-color: #CC3300;">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseTwo"><i
							class="icon-list"></i>apsible Group Item #2 </a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion21" href="#collapseTwoone"><i
									class="icon-list"></i>psibleGroup Item #2 </a>
							</div>
							<div id="collapseTwoone" class="accordion-body collapse">
								<div class="accordion-inner">Anim pariatur cliche...</div>
								<div class="accordion-inner">Anim pariatur cliche...</div>
								<div class="accordion-inner">Anim pariatur cliche...</div>
								<div class="accordion-inner">Anim pariatur cliche...</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion21" href="#collapseTwotow"><i
									class="icon-list"></i> apsibleGroup Item #3 </a>
							</div>
							<div id="collapseTwotow" class="accordion-body collapse">
								<div class="accordion-inner">
									<a> Anim pariatur cliche...</a>
								</div>
								<div class="accordion-inner">
									<a> Anim pariatur cliche...</a>
								</div>
								<div class="accordion-inner">
									<a> Anim pariatur cliche...</a>
								</div>
								<div class="accordion-inner">
									<a> Anim pariatur cliche...</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="span10"
			style="background-color: #FFFFFF; margin-left: 215px; margin-top: 10px;">
			<ul class="breadcrumb">
				<li><a href="#">首页</a> <span class="divider">/</span></li>
				<li><a href="#">demo</a> <span class="divider">/</span></li>
				<li class="active">example page</li>
			</ul>
			<div class="" style="padding-left: 5px">
				<!-- Button to trigger modal -->
				<a href="#myModal" role="button" class="btn btn-primary"
					data-toggle="modal">show dialog</a> <br> <br>
				<!-- Modal -->
				<div id="myModal" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">Modal header</h3>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<input type="text" id="inputEmail" placeholder="Email">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password</label>
								<div class="controls">
									<input type="password" id="inputPassword"
										placeholder="Password">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">价格</label>
								<div class="controls">
									<div class="input-append">
										<input class="span2" id="appendedInput" type="text"> <span
											class="add-on">.00</span>
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">备注</label>
								<div class="controls">
									<textarea rows="3"></textarea>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<label class="checkbox"> <input type="checkbox">
										Remember me
									</label>
									<button type="submit" class="btn">Sign in</button>
								</div>
							</div>
						</form>
					</div>
					<!-- <div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
						<button class="btn btn-primary">Save changes</button>
					</div> -->
				</div>
				<form action="">
					<div class="row-fluid">
						<div class="span1">价格</div>
						<div class="span3">
							<div class="input-append">
								<input class="span8" id="appendedInput" type="text"> <span
									class="add-on">.00</span>
							</div>
						</div>
						<div class="span1">Email</div>
						<div class="span3">
							<input type="text" id="inputEmail" placeholder="Email">
						</div>
						<div class="span1">text</div>
						<div class="span3">
							<input type="text" >
						</div>
					</div>
				</form>
<div class="alert alert-block">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <h4>Warning!</h4>
  Best check yo self, you're not...
</div>
<div class="alert alert-error">
  ...
</div>
<div class="alert alert-success">
  ...
</div>
<div class="alert alert-info">
  ...
</div>
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th>last</th>
						<th>last</th>
						<th>last</th>
						<th>last</th>
						<th>last</th>
						<th>last</th>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>

					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
					<tr>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
						<td>last</td>
					</tr>
				</table>
				<div class="pagination pagination-right">
					<ul>
						<li><a href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid"
		style="background-color: #DCDCDC; text-align: center;">asdad</div>
	<script src="/resources/common/lib/jquery/jquery-1.9.1.min.js"></script>
	<script src="/resources/common/lib/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#myModal').modal({
			backdrop : false,
			show : false
		});
	</script>
</body>
</html>
