<html>
<head>
    <#import "/spring.ftl" as spring />
    <#include "partials/head.ftl"/>
</head>
<body>

<div class="container" style="padding-top: 3rem;">
    <div class="card">
        <div class="card-body">
            <div class="container-fluid">
                <h3>Welcome ${user.getFirstName()} ${user.getLastName()}</h3><hr/>
                <form id="editForm" name="editForm" class="form-horizontal" action="/profile/edit" method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="hidden" name="userId" value="${user.getUserId()}"/>
                                <input type="text" name="firstName" class="form-control" value="${user.getFirstName()}" required="true">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" name="lastName" class="form-control" value="${user.getLastName()}" required="true">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" name="email" class="form-control" value="${user.getEmail()}" readonly>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="companyName">Company</label>
                                <input type="text" name="companyName" class="form-control" value="${user.getCompanyName()}" required="true">
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
        <div class="card-footer">
            <div class="d-flex bd-highlight mb-1">
                <div class="p-2 bd-highlight">
                    <button type="submit" onclick="document.getElementById('editForm').submit();" class="btn btn-primary">Update</button>
                </div>
                <div class="ml-auto p-2 bd-highlight">
                    <a href="/logout" class="btn btn-primary">Logout</a>
                </div>
            </div>
        </div>

    </div>

</div>




<#include "partials/scripts.ftl"/>
</body>
</html>
