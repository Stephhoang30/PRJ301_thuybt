<%-- 
    Document   : show
    Created on : Sep 27, 2024, 9:31:46 AM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructors Page</title>
    </head>
    <body>

        <form action="show?action=searchBySubID" method="POST">
            List of Subjects: 
            <select name="subjectID" onchange="this.form.submit()">

                <option value="">All subjects</option>
                <c:forEach items="${listSubjects}" var="s">
                    <option value="${s.getSubjectID()}" ${subjectID == s.getSubjectID() ? 'selected' : ''}>${s.getSubjectName()}</option>             
                </c:forEach>          

            </select>
        </form>

        <br/>

        <div>
            <p>List of Instructors:</p>     
            <table border="1">
                <tbody>

                    <tr>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Date of birth</td>
                        <td>Gender</td>
                        <td>Subject</td>
                        <td>Select</td>
                    </tr>

                    <c:forEach items="${listInstructors}" var="ins">
                        <tr>
                            <td name="id">${ins.getInstructorID()}</td>
                            <td name="name">${ins.getInstructorName()}</td>
                            <td name="dob">${ins.getBirthDate()}</td>
                            <td name="gender">${ins.getGender() == 1 ? "Male" : "Female"}</td>
                            <td name="sname">
                                <c:forEach items="${listSubjects}" var="s">
                                    <c:if test="${ins.getSubjectID() == s.getSubjectID()}">
                                        ${s.getSubjectName()}
                                    </c:if> 
                                </c:forEach>
                            </td>
                            <td>
                                <a href="#" onclick="Select(this)">Select</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>

        <br/>

        <div>
            Detail information:
            <form id="detail-form">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Code:</td>
                            <td>
                                <input type="text" name="code"/>
                            </td>
                            <td>Name:</td>
                            <td>
                                <input type="text" name="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Date of birth:</td>
                            <td>
                                <input type="text" name="dob"/>
                            </td>
                            <td>Gender:</td>
                            <td>
                                <input type="radio" name="gender" value="male" />Male
                                <input type="radio" name="gender" value="female" checked="checked" />Female
                            </td>
                        </tr>
                        <tr>
                            <td>Subject</td>
                            <td>
                                <input type="text" name="subject"/>
                            </td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

        <script>
            function Select(element) {

                // lay data tu table
                let tr = element.closest('tr');
                let id = tr.querySelector('td[name="id"]').innerText.trim();
                let name = tr.querySelector('td[name="name"]').innerText.trim();
                let dob = tr.querySelector('td[name="dob"]').innerText.trim();
                let gender = tr.querySelector('td[name="gender"]').innerText.trim();
                let subject = tr.querySelector('td[name="sname"]').innerText.trim();

                // dien vao form(id)
                let form = document.querySelector('#detail-form');
                form.querySelector('input[name="code"]').value = id;
                form.querySelector('input[name="name"]').value = name;
                form.querySelector('input[name="dob"]').value = dob;

                if (gender === "Male") {
                    form.querySelector('input[name="gender"][value="male"]').checked = true;
                } else {
                    form.querySelector('input[name="gender"][value="female"]').checked = true;
                }

                form.querySelector('input[name="subject"]').value = subject;
            }
        </script>

    </body>



</html>
