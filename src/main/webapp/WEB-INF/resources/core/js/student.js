var student = function () {

    $datePicker = $('.js-date-picker');
    $studentContainer = $('.student-container');
    $formStudent = $('.form-student-container');
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $selectSection = $('.js-select-section');
    //$selectSemester = $('.js-select-semester');
    $inputStudentId = $('.js-input-student-id');
    $inputName = $('.js-input-student-name');
    $rdbGender = $('.js-rdb-gender');
    $datePicker = $('.js-date-picker');
    $inputContact = $('.js-input-contact');
    $inputEmail = $('.js-input-email');
    $inputAddress = $('.js-input-address');
    $btnSave = $('.js-btn-save');
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
        $formStudent.find($btnSave).click(function () {
            console.log('student_id: '+$inputStudentId.val());
            if ($inputStudentId.val() === "" || $inputName.val() === "" || $rdbGender.val() === "" ||
                    $datePicker.val() === "" || $inputContact.val() === "" || $inputEmail.val() === "" ||
                    $inputAddress.val() === "" || $selectSemester.val() === "" || $selectCourse.val() === "" ||
                    $selectYear.val() === "" || $selectSection.val() === "") {
                alert('Complete all inputs');
                return;
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
//        $studentContainer.find($selectSemester).change(function () {
//            var sum = Helper.add(2, 4);
//            console.log(sum);
//            Helper.semChange();
//            populateStudentTable();
//        });
        $studentContainer.find($table).on('click', '.js-btn-update', function () {
            showStudentFormUpdate($(this).data('id'));
        });
    };
    
    var populateStudentTable = function () {
        $courseId = $selectCourse.val();
        $yearId = $selectYear.val();
        $sectionId = $selectSection.val();
        $semester = $selectSemester.val();
        $.ajax({
            type: 'GET',
            url: "/clearance/api/students/",
            data: {
                course_id: $courseId,
                year_id: $yearId,
                section_id: $sectionId,
                semester: $semester
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
