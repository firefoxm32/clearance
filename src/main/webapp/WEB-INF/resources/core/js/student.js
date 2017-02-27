student = function () {

    $datePicker = $('.js-date-picker');
    $studentContainer = $('.student-container');
    $formStudent = $('.form-student-container');
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $selectSection = $('.js-select-section');
    $table = $('.js-table');
    $tbody = $('tbody');

    var initialize = function () {
        loadDatePicker();
        bindEventListener();
    };

    var loadDatePicker = function () {
        $datePicker.datepicker({
            dateFormat: 'yy-mm-dd'
        });

    };

    var bindEventListener = function () {
        $formStudent.find($selectYear).change(function () {
            populateSelectSection($selectYear.val());
        });
        $studentContainer.find($selectCourse).change(function () {
            populateStudentTable();
            $selectYear.empty();
            $selectYear.append('<option value="">SELECT YEAR</option>');
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectCourse.val() !== "") {
                populateSelectYear($selectCourse.val());
            }
        });
        $studentContainer.find($selectYear).change(function () {
            populateStudentTable();
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectYear.val() !== "") {
                populateSelectSection($selectYear.val());
            }
        });
        $studentContainer.find($selectSection).change(function () {
            populateStudentTable();
        });
        $studentContainer.find($table).on('click', '.js-btn-update', function () {
            showStudentFormUpdate($(this).data('id'));
        });
//        $studentContainer.ready(populateStudentTable());
    };

    var populateSelectYear = function (id) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/course/" + id,
            success: function (result) {
                $selectYear.empty();
                renderSelectYear(result);
            }
        });
    };

    var renderSelectYear = function (data) {
        var template = $('#student_course_template').html();
        var rendered = Mustache.render(template, data);
        $selectYear.append(rendered);
    };

    var populateSelectSection = function (id) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/sections/" + id,
            success: function (data) {
                renderSelectSection(data);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };

    var renderSelectSection = function (data) {
        $selectSection.empty();
        var template = $('#student_section_template').html();
        var html = Mustache.render(template, data);
        $studentContainer.find($selectSection).append(html);
    };

    var populateStudentTable = function () {
        $tbody.empty();
        $courseId = $selectCourse.val();
        $yearId = $selectYear.val();
        $sectionId = $selectSection.val();
        $.ajax({
            type: 'GET',
            url: "/clearance/api/students/",
            data: {
                course_id: $courseId,
                year_id: $yearId,
                section_id: $sectionId
            },
            cache: false,
            success: function (result) {
                renderStudentTable(result);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };

    var renderStudentTable = function (data) {
        var template = $('#student_table_template').html();
        var html = Mustache.render(template, data);
        $studentContainer.find('tbody').append(html);
    };

    var showStudentFormUpdate = function (id) {
//        $.ajax({
//            type: 'GET',
//            url: "/clearance/student/update/" + id,
//            success: function (data) {
//      
//            },
//            error: function (errorThrown) {
//                console.log(errorThrown);
//            }
//        });
        window.location.href="/clearance/student/update/"+id;
    };

    return {
        init: initialize()
    };

}();
student.init;
