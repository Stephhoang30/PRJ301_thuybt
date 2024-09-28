<%-- 
    Document   : listProduct
    Created on : Sep 25, 2024, 12:03:56 PM
    Author     : stephhoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <!-- List Product -->        
        <div>
            
            <!-- Search Form -->
            <form action="search-sort" method="get">
                <input type="text" name="keyword" placeholder="Search for product..." value="${keyword}"/>
                <select name="choice">
                    <option value="search-by-id" ${choice == 'search-by-id' ? 'selected' : ''}>Search By ID</option>
                    <option value="search-by-name" ${choice == 'search-by-name' ? 'selected' : ''}>Search By Name</option>
                    <option value="search-by-quantity" ${choice == 'search-by-quantity' ? 'selected' : ''}>Search By Quantity</option>
                    <option value="search-by-price" ${choice == 'search-by-price' ? 'selected' : ''}>Search By Price</option>
                </select>
                <input type="submit" value="Search"/>
            </form>

            <!-- Sort Form -->
            <form action="search-sort" method="get">
                <input type="hidden" name="keyword" value="${keyword}"/>
                <input type="hidden" name="choice" value="${choice}"/>
                Sort by: 
                <select name="sortField" id="sort-choice">
                    <option value="id" ${sortField == 'id' ? 'selected' : ''}>ID</option>
                    <option value="name" ${sortField == 'name' ? 'selected' : ''}>Name</option>
                    <option value="quantity" ${sortField == 'quantity' ? 'selected' : ''}>Quantity</option>
                    <option value="price" ${sortField == 'price' ? 'selected' : ''}>Price</option>
                </select>

                <select name="sortOrder">
                    <option value="asc" ${sortOrder == 'asc' ? 'selected' : ''}>Ascending</option>
                    <option value="desc" ${sortOrder == 'desc' ? 'selected' : ''}>Descending</option>
                </select>
                <input type="submit" value="Sort"/>
            </form>

            <!-- Add Form -->
            <form action="add-product">
                <input type="submit" value="Add a new product"/>
            </form>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Release Date</th>
                        <th>Describe</th>
                        <th>Image</th>
                        <th>Category Id</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listProduct}" var="p">
                        <tr>
                            <td>${p.getId()}</td>
                            <td>${p.getName()}</td>
                            <td>${p.getQuantity()}</td>
                            <td>${p.getPrice()}</td>
                            <td>${p.getReleaseDate()}</td>
                            <td>${p.getDescribe()}</td>
                            <td>${p.getImage()}</td>
                            <td>${p.getCid()}</td>
                            <td>
                                <a href="update-product?id=${p.getId()}">Update</a>
                                <a href="#" onclick="doDeleteProduct('${p.getId().trim()}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
                
    </body>

    <script>
        function doDeleteProduct(id) {
            if (confirm("Do you want to delete product id = " + id + " ?")) {
                window.location = "delete-product?id=" + id;
            }
        }
    </script>
</html>
