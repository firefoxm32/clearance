subject = function () {

    $subject = $('.subject-container');
    $table = $('.js-table');
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $inputName = $('.js-input-name');
    $btnSave = $('.js-button-save');
    $sId = 0;

    var initialize = function () {
        bindEventListener();
    };

    var bindEventListener = function () {
        $subject.find($selectCourse).change(function () {
            $id = $selectCourse.val();
            $table.find('tbody').empty();
            if ($id == 0) {
                $selectYear.empty();
                $inputName.val("");
                $selectYear.append('<option value="0">SELECT YEAR</option>');
                return;
            }
            populateSelectYear($id);
        });
        
        $subject.find($selectYear).change(function () {
            populateTable();
        });
        
        $subject.find($btnSave).click(function () {
            if ($selectYear.val() == 0 || $inputName.text() === ""){
                console.log('Incomplete!'); 
                return;
            }
            save();
        });
        
        $subject.find($table).on('click', '.js-btn-update', function () {
            $inputName.val($(this).data("name"));
            $sId = $(this).data("id");
        });
    };
    
    var populateSelectYear = function (id) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/course/" + id,
            success: function (result) {
                $selectYear.empty();
                $inputName.val("");
                renderSelectYear(result);
            }
        });
    };

    var renderSelectYear = function (data) {
        $inputName.val();
        var template = $('#subject_template').html();
        var rendered = Mustache.render(template, data);
        $selectYear.append(rendered);
    };
    
    var populateTable = function () {
        var yId = $selectYear.val();
        $.ajax({
            type: 'GET',
            url: "/clearance/api/subjects/" + yId,
            success: function (data) {
                renderTable(data);
            }
        });
    };

    var renderTable = function (data) {
        $table.find('tbody').empty();
        $inputName.val("");
        var template = $('#subject_template2').html();
        var rendered = Mustache.render(template, data);
        $table.find('tbody').append(rendered);
    };
    
    var save = function () {
        var yId = $selectYear.val();
        var sName = $inputName.val();
        console.log("ID: "+yId+" NAME: "+sName);
        $.ajax({
            type: 'POST',
            url: "/clearance/api/save-subject",
            data: {
                year_id: yId,
                subject_name: sName,
                subject_id: $sId
            },
            success: function (result) {
                console.log('RESULT: ' + result);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };
    
    return {init: initialize};

}();
subject.init();
