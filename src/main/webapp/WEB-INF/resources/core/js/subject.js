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
            console.log('a'+$selectCourse.val()+'b');
            $table.find('tbody').empty();
            $selectYear.empty();
            $selectYear.append('<option value="">SELECT YEAR</option>');
            if ($selectCourse.val() !== "") {
                console.log('hello');
                $.populateSelectYear($selectCourse.val(), $subject, "");
            }
        });
        
        $subject.find($selectYear).change(function () {
            console.log('a'+$selectCourse.val()+'b');
            if($selectYear.val() !== ""){
                populateTable();
            }
        });
        
        $subject.find($btnSave).click(function () {
            if ($selectYear.val() === "" || $inputName.text() === ""){
                console.log('Incomplete!'); 
                return;
            }
            console.log('complete!'); 
            save();
        });
        
        $subject.find($table).on('click', '.js-btn-update', function () {
            $inputName.val($(this).data("name"));
            $sId = $(this).data("id");
        });
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
    
    return {
        init: initialize()
    };

}();
subject.init;
