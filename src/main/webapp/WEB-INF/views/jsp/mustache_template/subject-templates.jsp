<%-- 
    Document   : subject-template.jsp
    Created on : Feb 24, 2017, 10:31:17 PM
    Author     : All
--%>

<script type="text/template" id="subject_template">
    <option value="0">SELECT YEAR</option>
    {{#courseYears}}
        <option value="{{id}}">{{yearName}}</option>
    {{/courseYears}}
</script>

<script id="subject_template2" type="text/template">
    {{#items}}
        <tr>
            <td>{{subjectId}}</td>
            <td>{{subjectName}}</td>
            <td><button data-id="{{subjectId}}" data-name="{{subjectName}}" class="js-btn-update">UPDATE</button></td>
        </tr>
    {{/items}}
</script>