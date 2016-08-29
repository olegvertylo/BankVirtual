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

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <link href="css/animate.css" rel="stylesheet">

    <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <link href="css/custom.css" rel="stylesheet">


    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
</head>

<body>

<div id="all">

    <header>

        <div id="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5 contact">

                        <p class="hidden-md hidden-lg"><a href="#" data-animate-hover="pulse"><i
                                class="fa fa-phone"></i></a> <a href="#" data-animate-hover="pulse"><i
                                class="fa fa-envelope"></i></a>
                        </p>
                    </div>
                    <div class="col-xs-7">

                        <div class="login">
                            <a href="Login" data-toggle="modal" data-target="#login-modal"><i class="fa fa-sign-in"></i>
                                <span class="hidden-xs text-uppercase">Sign in</span></a>
                            <a href="customerRegister"><i class="fa fa-user"></i> <span
                                    class="hidden-xs text-uppercase">Register</span></a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
        <div class="modal-dialog modal-sm">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="Login">Customer login</h4>
                </div>
                <div class="modal-body">
                    <form action="customerOrders" method="post">
                        <div class="form-group">
                            <input type="telephone" class="form-control" id="email_modal" placeholder="telephone"
                                   name="telephone">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password_modal" placeholder="password"
                                   name="password">
                        </div>

                        <p class="text-center">
                            <button class="btn btn-template-main"><i class="fa fa-sign-in"></i> Log in</button>
                        </p>

                    </form>

                    <p class="text-center text-muted">Not registered yet?</p>
                    <p class="text-center text-muted"><a href="customerRegister"><strong>Register now</strong></a>! It
                        is easy and done in 1&nbsp;minute</p>

                </div>
            </div>
        </div>
    </div>
    <section>
        <div class="home-carousel">

            <div class="dark-mask"></div>

            <div class="container">
                <div class="homepage owl-carousel">
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-5 right">

                                <h1>Online banking</h1>
                                <p>Fast and comfortable way
                                    <br/>for your banking needs</p>
                            </div>
                            <div class="col-sm-7">
                                <img class="img-responsive" src="img/template-homepage.png" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">

                            <div class="col-sm-4 text-center">
                                <img class="img-responsive" src="img/template-mac.png" alt="">
                            </div>

                            <div class="col-sm-5">
                                <h2>Payments</h2>
                                <ul class="list-style-none">
                                    <li>Process credit card payments direct from your website or app</li>

                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-5 right">
                                <h1>Transfers</h1>
                                <ul class="list-style-none">
                                    <li>Transfer money online with the same convenience of checking your email or
                                        surfing the web
                                    </li>
                                    <li></li>

                                </ul>
                            </div>
                            <div class="col-sm-7">
                                <img class="img-responsive" src="img/template-easy-customize.png" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-sm-4">
                                <img class="img-responsive" src="img/template-easy-code.png" alt="">
                            </div>
                            <div class="col-sm-5">
                                <h1>Bank account management</h1>
                                <ul class="list-style-none">
                                    <li>Enables safe and efficient management of bank account</li>
                                    <li></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <div id="copyright">
        <div class="container">
            <div class="col-md-12">
                <p class="pull-right">2016. Diplom Bank</p>

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

<script src="js/owl.carousel.min.js"></script>


</body>

</html>
