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
        populateStudentTable();
        if(location.hash === '#yearandsection') {
            populateYearSection();
        }
    };

    var loadDatePicker = function () {
        $datePicker.datepicker({
            dateFormat: 'yy-mm-dd'
        });

    };

    var bindEventListener = function () {
        $formStudent.find($selectCourse).change(function () {
            $selectYear.empty();
            $selectYear.append('<option value="">SELECT YEAR</option>');
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectCourse.val() !== "") {
                $.populateSelectYear($selectCourse.val(), $formStudent, "");
            }
        });
        $formStudent.find($selectYear).change(function () {
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectYear.val() !== "") {
                $.populateSelectSection($selectYear.val(), $formStudent, "");
            }
        });

        $studentContainer.find($selectCourse).change(function () {
            populateStudentTable();
            $selectYear.empty();
            $selectYear.append('<option value="">SELECT YEAR</option>');
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectCourse.val() !== "") {
                $.populateSelectYear($selectCourse.val(), $studentContainer, "");
            }
        });
        $studentContainer.find($selectYear).change(function () {
            populateStudentTable();
            $selectSection.empty();
            $selectSection.append('<option value="">SELECT SECTION</option>');
            if ($selectYear.val() !== "") {
                $.populateSelectSection($selectYear.val(), $studentContainer, "");
            }
        });
        $studentContainer.find($selectSection).change(function () {
            populateStudentTable();
        });
        $studentContainer.find($table).on('click', '.js-btn-update', function () {
            showStudentFormUpdate($(this).data('id'));
        });
    };
    
    var populateStudentTable = function () {
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

    renderStudentTable = function (data) {
        $studentContainer.find('tbody').empty();
        var template = $('#student_table_template').html();
        var html = Mustache.render(template, data);
        $studentContainer.find('tbody').append(html);
    };
    
    var showStudentFormUpdate = function (id) {
        window.location.href = "/clearance/student/update/" + id+"#yearandsection";
    };

    var populateYearSection = function () {
        $courseVal = $formStudent.find($selectCourse).val();
        $yearVal = "";
        if($formStudent.find($selectCourse).val() !== "") {
            $yearVal = $formStudent.find($selectYear).data('val');
            $.populateSelectYear($courseVal , $formStudent, $yearVal);
        }
        if ($formStudent.find($selectYear).data('val') !== "") {
            $sectionVal = $formStudent.find($selectSection).data('val');
            $.populateSelectSection($yearVal, $formStudent, $sectionVal);
        }
    };

    return {
        init: initialize()
    };

}();
student.init;
