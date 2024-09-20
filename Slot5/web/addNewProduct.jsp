<%-- 
    Document   : addNewProduct
    Created on : Sep 20, 2024, 7:02:34 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new product</title>
    </head>
    <body>
        <h1>Add new product</h1>
        <form action="add-product" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>
                            <input type="text" name="id" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>
                            <input type="text" name="name" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td>
                            <input type="text" name="quantity" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td>
                            <input type="text" name="price" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Release Date</td>
                        <td>
                            <input type="date" name="rdate" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Describe</td>
                        <td>
                            <input type="text" name="describe" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td>
                            <input type="text" name="image" required=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Category ID</td>
                        <td>
                            <input type="number" name="cid" min="1" max="10" required="" >
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Add"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <p style="color: red">${error}</p>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>


    </body>
</html>
