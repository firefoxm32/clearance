<%-- 
    Document   : section-template
    Created on : Feb 24, 2017, 2:31:53 PM
    Author     : All
--%>

<script id="section_template" type="text/template">
    <option value="">SELECT YEAR</option>
    {{#courseYears}}
        <option value={{id}}>{{yearName}}</option>
    {{/courseYears}}
</script>

<script id="section_template2" type="text/template">
    {{#items}}
        <tr>
            <td>{{sectionId}}</td>
            <td>{{sectionName}}</td>
            <td><button data-id="{{sectionId}}" data-name="{{sectionName}}" class="js-btn-update">UPDATE</button></td>
        </tr>
    {{/items}}
</script>