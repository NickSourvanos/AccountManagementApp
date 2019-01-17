<!DOCTYPE html>
<html lang="en">
<head>
    <#import "/spring.ftl" as spring />
    <#include "partials/head.ftl">
    <title>Home</title>
</head>

<body>


<div class="container" style="padding-top: 3rem;">
    <div class="card">
        <div class="card-body">
            <div class="container-fluid">
                <form id="registerForm" name="registerForm" class="form-horizontal" action="/registration" method="POST">
                    <h4 class="title">Register</h4><hr/>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" name="firstName" class="form-control" placeholder="Enter first name" required="true">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" name="lastName" class="form-control" placeholder="Enter last name" required="true">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <@spring.bind "registerForm.email"/>
                                <input id="email" type="email" name="email" class="form-control" placeholder="Enter email" required="true">
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="companyName">Company</label>
                                <input type="text" name="companyName" class="form-control" placeholder="Enter Company Name" required="true">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="pass">Password</label>
                                <@spring.bind "registerForm.pass" />
                                <input type="password" name="pass" class="form-control" placeholder="Enter password" required="true">
                                <#list spring.status.errorMessages as error>
                                    <span>${error}</span>
                                </#list>
                            </div>
                        </div>
                        <input type="hidden" name="role" value="USER"/>
                        <!--<div class="col-md-6">
                            <div class="form-group">
                                <label for="pass">Re-enter password</label>
                                <input type="password" name="pass2" class="form-control" placeholder="Re-enter password">
                            </div>
                        </div>-->
                    </div>

                </form>

            </div>
        </div>
        <div class="card-footer">
            <button type="submit" onclick="document.getElementById('registerForm').submit();" class="btn btn-primary">Register</button>
        </div>

    </div>

</div>


<#include "partials/scripts.ftl">

</body>
</html>
