<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">


<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
          rel='stylesheet' type='text/css'>

    <!-- Bootstrap and Font css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="css/animate.css" rel="stylesheet">

    <!-- Theme stylesheet -->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet -->
    <link href="css/custom.css" rel="stylesheet">

    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>


<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>List of Accounts</h1>
            </div>

        </div>
    </div>
</div>

<div id="content">
    <div class="container">

        <div class="row">

            <div class="col-md-9" id="customer-orders">


                <div class="box">

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Account number</th>
                                <th>Account type</th>
                                <th>Sum</th>
                                <th>Status</th>
                                <th>Currency</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>


                            <c:forEach items="${list}" var="s">
                                <tr>
                                    <td><c:out value="${s.getNumber()}"/></td>
                                    <td><c:out value="${s.getType()}"/></td>
                                    <td><c:out value="${s.getSum().getSum()}"/></td>
                                    <td><c:out value="${s.getStatus()}"/></td>
                                    <td><c:out value="${s.getCurrency()}"/></td>
                                    <td>
                                        <form action="transferMoney" method="post">
                                            <div class="text-left">
                                                <button type="submit" class="btn btn-template-main"
                                                        value="${s.getNumber()}" name="number"><i
                                                        class="fa fa-user-md"></i> Transfer
                                                </button>
                                            </div>
                                        </form>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-md-3">

                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title">Account section</h3>
                    </div>

                    <div class="panel-body">

                        <ul class="nav nav-pills nav-stacked">
                            <li class="active">
                                <a href="account"><i class="fa fa-user"></i> Create account</a>
                            </li>
                            <li>
                                <a href="customerAccount"><i class="fa fa-list"></i> Settings</a>
                            </li>
                            <li>
                                <a href="status"><i class="fa fa-adjust"></i> Set account status</a>
                            </li>
                            <li>
                                <a href="/bank"><i class="fa fa-sign-out"></i> Logout</a>
                            </li>
                        </ul>
                    </div>

                </div>

            </div>

        </div>


    </div>

</div>


<div id="copyright">
    <div class="container">
        <div class="col-md-12">
            <p class="pull-right">2016. Diplom bank</p>
        </div>
    </div>
</div>

</div>


<!-- #### JAVASCRIPT FILES ### -->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
    window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
</script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="js/jquery.cookie.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/jquery.parallax-1.1.3.js"></script>
<script src="js/front.js"></script>


</body>

</html>