<%-- 
    Document   : list
    Created on : Jul 17, 2024, 10:47:59 AM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>


            </tr>
            <div style='text-align: left'>
                <form action='product?action=search' method='post'>
                    <input type='text' name='keyword' placeholder="Search for products..."/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>

            <br/>

            <button onclick="addProduct()">Add</button>

            <c:forEach items="${listProduct}" var="pro">
                <tr>
                    <td name='id'>${pro.getId()}</td>
                    <td name='name'>${pro.getName()}</td>
                    <td name='quantity'>${pro.getQuantity()}</td>
                    <td name='price'>${pro.getPrice()}</td>
                    <td>
                        <a href="#" onclick="editProduct(this)">Edit</a>
                        <form action="product?action=delete" style="display:inline" method="post">
                            <input type="hidden" name="id" value="${pro.getId()}"/>
                            <a href="#" onclick="return this.closest('form').submit()">Delete</a>
                        </form>

                    </td>
                </tr>
            </c:forEach>

        </table>

        <form action="product?action=insert" method="post" id="formAddEdit" style="display: none">
            <h1>Form</h1>
            <input type="hidden" name="id" value="0"/>
            Name <input type="text" name="name"/>
            <br/>
            Quantity <input type="number" name="quantity"/>
            <br/>
            Price <input type="text" name="price"/>
            <br/>

            <input type="submit" value="Submit"/>
        </form>

        <script>

            function addProduct(e) {
                displayForm();
            }

            function editProduct(e) {
                // display form

                displayForm();
                // get data from table

                let tr = e.closest('tr');
                let id = tr.querySelector('td[name="id"]').innerHTML;
                let name = tr.querySelector('td[name="name"]').innerHTML;
                let quantity = tr.querySelector('td[name="quantity"]').innerHTML;
                let price = tr.querySelector('td[name="price"]').innerHTML;

                // set Data

                let form = document.querySelector("#formAddEdit");
                form.querySelector('input[name="name"]').value = name;
                form.querySelector('input[name="quantity"]').value = quantity;
                form.querySelector('input[name="price"]').value = price;
                form.querySelector('input[name="id"]').value = id;

                // set action
                form.action = "product?action=update";

            }
            
//            funciton deleteProduct(e) {
//                
//                let form = e.closest('form');
//                form.submit();
//            }

            function displayForm() {
                let form = document.querySelector("#formAddEdit");
                if (form.style.display === 'none') {
                    form.style.display = 'block';
                } else {
                    form.style.display = 'none';
                }
            }

        </script>


    </body>
</html>
