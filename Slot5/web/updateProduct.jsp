<%-- 
    Document   : updateProduct
    Created on : Sep 20, 2024, 10:03:09 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>
        <form action="update-product" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>ID: </td>
                        <td>
                            <input type="text" name="id" value="${p.getId()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td>
                            <input type="text" name="name" value="${p.getName()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Quantity: </td>
                        <td>
                            <input type="number" name="quantity" value="${p.getQuantity()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Price: </td>
                        <td>
                            <input type="number" name="price" value="${p.getPrice()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Release Date: </td>
                        <td>
                            <input type="date" name="rdate" value="${p.getReleaseDate()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Describe: </td>
                        <td>
                            <textarea name="describe" style="width: 100%; height: 100px; resize: both;">${p.getDescribe()}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>Image: </td>
                        <td>
                            <input type="text" name="image" value="${p.getImage()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Category ID: </td>
                        <td>
                            <input type="number" name="cid" value="${p.getCid()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Update"/>
                        </td>
                    </tr>                 
                </tbody>
            </table>

        </form>
    </body>
</html>
