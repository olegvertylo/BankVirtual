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


</head>

<body>

<div id="heading-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1>Create account</h1>
            </div>

        </div>
    </div>
</div>
</div>

<div id="content">
    <div class="container">
        <div class="row">
            <div class="col-md-7 clearfix">
                <div class="box">
                    <p>Please fill in the information below</p>
                    <p class="text"><a href="contact.html"></a></p>

                    <hr>

                    <form action="createAccount" method="post">
                        <div class="form-group">
                            <label for="number-login">Number</label>
                            <input type="text" class="form-control" id="number-login" name="number">
                        </div>
                        <div class="form-group">
                            <label for="selectType">Type</label>
                            <select class="form-control" name="type" id="selectType">
                                <option>Debit</option>
                                <option>Credit</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sum-login">Sum</label>
                            <input type="text" class="form-control" id="sum-login" name="sum">
                        </div>
                        <div class="form-group">
                            <label for="selectCurrency">Currency</label>
                            <select class="form-control" name="currency" id="selectCurrency">
                                <option>UAH</option>
                                <option>USD</option>
                                <option>EUR</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="selectStatus">Status</label>
                            <select class="form-control" name="status" id="selectStatus">
                                <option>Opened</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="identingNumber-login">Identingnumber</label>
                            <input type="password" class="form-control" id="identingNumber-login" name="identingNumber">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-template-main"><i class="fa fa-user-md"></i>
                                Create
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


</body>

</html>