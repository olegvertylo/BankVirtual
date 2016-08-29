<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Universal - All In 1 Template</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
          rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <link href="css/animate.css" rel="stylesheet">

    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <link href="css/custom.css" rel="stylesheet">


</head>

<body>

<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>There is no such account
                    <br> Please re-enter your login information or register</h1>
            </div>
        </div>
    </div>
</div>

<div id="content">
    <div class="container">

        <div class="row">
            <div class="col-md-6">
                <div class="box">
                    <h2 class="text-uppercase">Create new account</h2>

                    <p class="lead">Not registered yet?</p>
                    <p>Please fill in the information below</p>
                    <p class="text-muted"><a href="contact.html"></a></p>

                    <hr>

                    <form action="customerRegisterBegin" method="post">
                        <div class="form-group">
                            <label for="name-login">Name</label>
                            <input type="text" class="form-control" id="name-login" name="name">
                        </div>
                        <div class="form-group">
                            <label for="surname-login">Surname</label>
                            <input type="text" class="form-control" id="surname-login" name="surname">
                        </div>
                        <div class="form-group">
                            <label for="middleNmae-login">Middle name</label>
                            <input type="text" class="form-control" id="middleNmae-login" name="middleName">
                        </div>
                        <div class="form-group">
                            <label for="passportSerial-login">Passport Serial Number</label>
                            <input type="text" class="form-control" id="passportSerial-login"
                                   name="passportSerial">
                        </div>
                        <div class="form-group">
                            <label for="passportNumber-login">Passport Number</label>
                            <input type="text" class="form-control" id="passportNumber-login"
                                   name="passportNumber">
                        </div>
                        <div class="form-group">
                            <label for="telephone-login">Telephone</label>
                            <input type="text" class="form-control" id="telephone-login" name="telephone">
                        </div>
                        <div class="form-group">
                            <label for="identingNumber-login">Identingnumber</label>
                            <input type="password" class="form-control" id="identingNumber-login"
                                   name="identingNumber">
                        </div>
                        <div class="form-group">
                            <label for="password-login">Password</label>
                            <input type="password" class="form-control" id="password-login" name="password">
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i>
                                Register
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-md-6">
                <div class="box">
                    <h2 class="text-uppercase">Login</h2>

                    <p class="lead">Registered already?</p>
                    <p class="text-muted">Please enter your telephone and password below</p>

                    <hr>

                    <form action="customerOrders" method="post">
                        <div class="form-group">
                            <label for="email">Telephone</label>
                            <input type="text" class="form-control" id="email" name="telephone">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-template-main"><i class="fa fa-sign-in"></i> Log in
                            </button>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>
</div>


<div id="copyright">
    <div class="container">
        <div class="col-md-12">
            <p class="pull-right">2016. Diplom Bank</a>
            </p>

        </div>
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