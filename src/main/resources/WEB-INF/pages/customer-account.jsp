<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
          rel='stylesheet' type='text/css'>

    <!-- Bootstrap and css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="css/animate.css" rel="stylesheet">

    <!-- Theme stylesheet-->
    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet-->
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
                <h1>Account holder: <c:out value="${client.getName()} "></c:out><c:out
                        value="${client.getSurname()} "></c:out></h1>
            </div>
            <div class="col-md-5">
                <ul class="breadcrumb">

                </ul>
            </div>
        </div>
    </div>
</div>

<div id="content" class="clearfix">
    <div class="container">
        <div class="row">
            <div class="col-md-9 clearfix" id="customer-account">
                <p class="lead">Change your personal details or your password here.</p>


                <div class="box">

                    <div class="heading">
                        <h3 class="text-uppercase">Change password</h3>
                    </div>

                    <form action="changePassword" method="post">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="password_old">Old password</label>
                                    <input type="password" class="form-control" id="password_old" name="oldPassword">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="password_1">New password</label>
                                    <input type="password" class="form-control" id="password_1" name="newPassword">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="password_2">Retype new password</label>
                                    <input type="password" class="form-control" id="password_2" name="confirmPassword">
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->

                        <div class="text-center">
                            <button type="submit" class="btn btn-template-main"><i class="fa fa-save"></i> Save new
                                password
                            </button>
                        </div>
                    </form>

                </div>


                <div class="box clearfix">
                    <div class="heading">
                        <h3 class="text-uppercase">Personal details</h3>
                    </div>

                    <form action="clientSettings" method="post">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="firstname">Firstname</label>
                                    <input type="text" class="form-control" id="firstname" name="firstname"
                                           value="<c:out value="${client.getName()}"></c:out>">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="lastname">Lastname</label>
                                    <input type="text" class="form-control" id="lastname" name="lastname"
                                           value="<c:out value="${client.getSurname()}"></c:out>">
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="middleName">Middle Name</label>
                                    <input type="text" class="form-control" id="middleName" name="middlename"
                                           value="<c:out value="${client.getMiddleName()}"></c:out>">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="phone">Telephone</label>
                                    <input type="text" class="form-control" id="phone" name="telephone"
                                           value="<c:out value="${client.getTelephone()}"></c:out>">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="passportSerial">Passport Serial №</label>
                                    <input type="text" class="form-control" id="passportSerial"
                                           name="passportSerial"
                                           value="<c:out value="${client.getPassportSerial()}"></c:out>">
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="passportNumber">Passport №</label>
                                    <input type="text" class="form-control" id="passportNumber"
                                           name="passportNumber"
                                           value="<c:out value="${client.getPassportNumber()}"></c:out>">
                                </div>
                            </div>

                            <div class="col-sm-12 text-center">
                                <button type="submit" class="btn btn-template-main"><i class="fa fa-save"></i> Save
                                    changes
                                </button>

                            </div>

                        </div>

                    </form>

                </div>

            </div>


            <div class="col-md-3">

                <div class="panel panel-default sidebar-menu">

                    <div class="panel-heading">
                        <h3 class="panel-title">Customer section</h3>
                    </div>

                    <div class="panel-body">

                        <ul class="nav nav-pills nav-stacked">
                            <li class="active">

                            <li>

                            </li>
                            <li>

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

            <p class="pull-right">2016. Diplom Bank
            </p>

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