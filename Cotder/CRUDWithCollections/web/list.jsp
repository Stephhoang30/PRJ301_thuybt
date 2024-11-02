<%-- 
    Document   : list
    Created on : Jul 15, 2024, 2:29:25 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Simple Form</title>
    </<head>

    <body>
        <form action="student?action=insert" method="post" id='form'>

            <h1 style='text-align: left'>INSERT</h1>

            <table>
                <tr>
                    <td>Id</td>
                    <td>
                        <input type="text" name="id"/>
                    </td>
                </tr> 

                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name"/>
                    </td>
                </tr>

                <tr>
                    <td>Gender</td>
                    <td>
                        <input type='radio' name='gender' value='male' checked/> Male
                        <input type='radio' name='gender' value='female'/> Female
                    </td> 
                </tr>

                <tr>
                    <td>Age</td>
                    <td>
                        <input type="text" name="age"/>
                    </td>
                </tr>

                <tr>
                    <td>Hobbies</td>
                    <td>
                        <input type="checkbox" name='hobbies' value='Football'/> Football
                        <input type="checkbox" name='hobbies' value='Cooking'/> Cooking
                        <input type="checkbox" name='hobbies' value='Programming'/> Programming
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form> 

        <h2> List of Students </h2>

        <div style='text-align: left'>
            <form action='student?action=search' method='post'>
                <input type='text' name='keyword' placeholder="Search for students..."/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
        
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Hobbies</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${list}" var="stu">
                <tr>
                    <td name='id'>${stu.getId()}</td>
                    <td name='name'>${stu.getName()}</td>
                    <td name='age'>${stu.getAge()}</td>
                    <td name='gender'>${stu.isGender() eq true ? 'male' : 'female'}</td>
                    <td name='hobbies'>
                        <c:forEach items="${stu.getHobbies()}" var="hob">
                            ${hob}
                        </c:forEach>
                    </td>

                    <td>
                        <a href='#' onclick='update(this)'>Edit</a>
                        <form action='student?action=delete' method='post'>
                            <input type='hidden' name='id' value='${stu.getId()}'/>
                            <a href='#' onclick='submitFunction(this)'>Delete</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>

        <script>

            function update(e) {

                let form = document.querySelector("#form");

                // đổi lại title h1 trong form thành update
                form.querySelector("h1").innerText = "UPDATE";

                // chuyển form với thuộc tính action ⇒ student?action=update
                form.action = "student?action=update";

                // lấy dữ liệu ở bảng list Student ⇒ đắp lên trên form
                let tr = e.closest('tr');

                let idRecord = tr.querySelector('td[name="id"]').textContent;
                let nameRecord = tr.querySelector('td[name="name"]').textContent;
                let ageRecord = tr.querySelector('td[name="age"]').textContent;
                let genderRecord = tr.querySelector('td[name="gender"]').textContent;

//                // xu li hobbies
//
//                let hobbiesRecord = tr.querySelector('td[name="hobbies"]').textContent.trim().split(' ');
//                let filteredHobbies = hobbiesRecord.filter(function (hobb) {
//                    return hobb.trim() !== '';
//                });
//
//
//
//                form.querySelector("input[name='id']").value = idRecord;
//                form.querySelector("input[name='name']").value = nameRecord;
//                form.querySelector("input[name='age']").value = ageRecord;
//                let hobbiesInput = form.querySelectorAll("input[name='hobbies']");
//
//                // bật trạng thái checked cho nút radio gender, no gap
//                if (genderRecord.trim().toLowerCase() === "male") {
//                    form.querySelector("input[name='gender'][value='male']").checked = true;
//                } else if (genderRecord.trim().toLowerCase() === "female") {
//                    form.querySelector("input[name='gender'][value='female']").checked = true;
//                }
//
//                // Xoá trạng thái checked hiện tại của các hộp kiểm hobbies
//                form.querySelectorAll("input[name='hobbies']").forEach(checkbox => {
//                    checkbox.checked = false;
//                });
//
//                filteredHobbies.forEach(function (hobby) {
//                    let checkbox = form.querySelector("input[name='hobbies'][value='" + hobby + "']");
//                    if (checkbox) {
//                        checkbox.checked = true;
//                    }
//                });

                let hobbbies = tr.querySelector("td[name='hobbies']").textContent.trim().split(' ');
                let filteredHobbies = hobbbies.filter(function (hobb) {
                    return hobb.trim() !== '';
                });

                //đắp dữ liệu lên form
                form.querySelector("input[name='id']").value = idRecord;
                form.querySelector("input[name='name']").value = nameRecord;
                form.querySelector("input[name='age']").value = ageRecord;
                let hobbiesInput = form.querySelectorAll("input[name='hobbies']");

                // Đặt trạng thái checked cho nút radio gender
                if (genderRecord.trim().toLowerCase() === "male") {
                    form.querySelector("input[name='gender'][value='male']").checked = true;
                } else if (genderRecord.trim().toLowerCase() === "female") {
                    form.querySelector("input[name='gender'][value='female']").checked = true;
                }

                // Xóa trạng thái checked hiện tại của các hộp kiểm hobbies
                form.querySelectorAll("input[name='hobbies']").forEach(checkbox => {
                    checkbox.checked = false;
                });

//                filteredHobbies.forEach(function (hobb) {
//                    hobbiesInput.forEach(function (input) {
//                        if (input.value === hobb) {
//                            input.checked = true;
//                        }
//                    });
//                });
                filteredHobbies.forEach(function (hobby) {
                    let checkbox = form.querySelector("input[name='hobbies'][value='" + hobby + "']");
                    if (checkbox) {
                        checkbox.checked = true;
                    }
                });



            }
            
            function submitFunction(e) {
                let form = e.closest('form');
                form.submit();
            }
        </script>

    </body>
</html>
