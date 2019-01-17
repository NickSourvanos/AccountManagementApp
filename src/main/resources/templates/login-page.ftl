<html>
<head>
    <#import "/spring.ftl" as spring />
    <#include "partials/head.ftl"/>
</head>
<body>


<div class="container" style="padding-top: 3rem; max-width: 24rem;">
    <div class="card">
        <div class="card-body">
            <div class="container-fluid">
                <form id="loginForm" name="loginForm" class="form-horizontal" action="/login" method="POST">
                    <h4 class="title">Login</h4><hr/>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="email">Email</label>

                                <input type="email" name="email" class="form-control" placeholder="Enter email" required="true">

                            </div>
                        </div>


                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="pass">Password</label>

                                <input type="password" name="pass" class="form-control" placeholder="Enter password" required="true">

                            </div>
                        </div>
                    </div>

                </form>

            </div>
        </div>
        <div class="card-footer">
            <div class="d-flex bd-highlight mb-1">
                <div class="p-2 bd-highlight">
                    <button type="submit" onclick="document.getElementById('loginForm').submit();" class="btn btn-primary">Login</button>
                </div>
                <div class="ml-auto p-2 bd-highlight">
                    <a href="/registration" class="btn btn-primary">Register</a>
                </div>
            </div>
        </div>

    </div>

</div>





<#include "partials/scripts.ftl"/>
</body>
</html>
