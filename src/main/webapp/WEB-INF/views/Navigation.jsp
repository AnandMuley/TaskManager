<nav role="navigation" class="navbar navbar-inverse">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button data-target="#bs-example-navbar-collapse-9" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="${pageContext.request.contextPath}/tasks/home" class="navbar-brand">Daily Task Manager</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div id="bs-example-navbar-collapse-9" class="collapse navbar-collapse">

          <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/tasks/livetasks">Live Tasks</a></li>
            <li><a href="${pageContext.request.contextPath}/reports/home">Generate Reports</a></li>
          </ul>
           <%--<form method="post" action="search" class="navbar-form navbar-left" role="search">--%>
                <%--<div class="form-group">--%>
                    <%--<input name="title" type="text" class="form-control" placeholder="Search by title">--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-default">Search</button>--%>
           <%--</form>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" style="color: #ffffff;">Developer - Anand Muley</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>