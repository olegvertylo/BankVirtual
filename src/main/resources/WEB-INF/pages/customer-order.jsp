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

    <!-- Theme stylesheet-->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet -->
    <link href="css/custom.css" rel="stylesheet">

    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png"/>
</head>

<body>


<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>Account <c:out value="${number}"></c:out></h1>
            </div>
            <div class="col-md-5">
                <ul class="breadcrumb">


                </ul>
            </div>
        </div>
    </div>
</div>


<div id="content">
    <div class="container">

        <div class="row">

            <div class="col-md-9 clearfix" id="customer-order">

                <form action="accountTransfer" method="post">
                    <div class="form-group">
                        <label for="name-login">Please input account number</label>
                        <input type="text" class="form-control" id="number" name="number">
                    </div>
                    <div class="text-right">
                        <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Submit
                        </button>
                    </div>
                </form>

                <form action="moneySend" method="post">
                    <div class="form-group">
                        <label for="name-login">Please enter the sum</label>
                        <input type="text" class="form-control" id="name-login" name="ammount">
                    </div>
                    <div class="text-right">
                        <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i> Transfer
                        </button>
                    </div>
                </form>
                <br>

                <br>
                <div class="box">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Account</th>
                                <th>Account type</th>
                                <th>Sum</th>
                                <th>Status</th>
                                <th>Currency</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td> from № <c:out value="${account.getNumber()}"/></td>
                                <td><c:out value="${account.getType()}"/></td>
                                <td><c:out value="${account.getSum().getSum()}"/></td>
                                <td><c:out value="${account.getStatus()}"/></td>
                                <td><c:out value="${account.getCurrency()}"/></td>

                            </tr>
                            <tr>
                                <td> to № <c:out value="${accountTwo.getNumber()}"/></td>
                                <td><c:out value="${accountTwo.getType()}"/></td>
                                <td><c:out value="${accountTwo.getSum().getSum()}"/></td>
                                <td><c:out value="${accountTwo.getStatus()}"/></td>
                                <td><c:out value="${accountTwo.getCurrency()}"/></td>

                            </tr>
                            </tbody>
                            <tfoot>

                            </tfoot>
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

                            </li>
                            <li>

                            </li>
                            <li>
                                <a href="/bank/backToListAccount"><i class="fa fa-chevron-circle-left"></i> Back to list
                                    of accounts</a>

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