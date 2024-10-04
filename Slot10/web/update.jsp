<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Currency</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .container {
                width: 50%;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #000;
            }
            .header {
                background-color: #f2f2f2;
                padding: 20px;
                text-align: center;
                font-size: 36px;
                font-weight: bold;
            }
            .form-group {
                margin: 10px 0;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #000;
                border-radius: 4px;
            }
            .btn {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            .btn:hover {
                background-color: #45a049;
            }
            .nav {
                margin-bottom: 20px;
            }
            .nav a {
                margin-right: 15px;
                text-decoration: none;
                color: #000;
            }
            .nav a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="header">Update Currency</div>

            <div class="nav">
                <a href="home">Currency List</a>
            </div>

            <h3>Update Currency Information</h3>

            <form action="home?action=saveUpdate" method="POST">
                <div class="form-group">
                    <label for="code">Code:</label>
                    <input type="text" id="code" name="code" readonly value="${currency.code}">
                </div>

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${currency.name}">
                </div>

                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description" value="${currency.description}">
                </div>

                <div class="form-group">
                    <label for="rate">Rate:</label>
                    <input type="text" id="rate" name="rate" value="${currency.rate}">
                </div>

                <button type="submit" class="btn">Update Rate</button>
            </form>
        </div>

    </body>
</html>
