section = function () {

    $section = $('.section-container');
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
        $section.find($selectCourse).change(function () {
            $table.find('tbody').empty();
            $selectYear.empty();
            $selectYear.append('<option value="">SELECT YEAR</option>');
            if ($selectCourse.val() !== "") {
                $.populateSelectYear($selectCourse.val(), $section, "");
            }
        });
        
        $section.find($selectYear).change(function () {
            $table.find('tbody').empty();
            if($selectYear.val() !== ""){
               populateSectionTable(); 
            }
        });
        
        $section.find($btnSave).click(function () {
            if($selectYear.val() === "" || $inputName.text() === ""){
                console.log('incomplete');
                return;
            }
            console.log('complete');
            save();
        });
        
        $section.find($table).on('click', '.js-btn-update', function () {
            $inputName.val($(this).data("name"));
            $sId = $(this).data("id");
        });
    };
    
    var populateSectionTable = function () {
        var yId = $selectYear.val();
        $.ajax({
            type: 'GET',
            url: "/clearance/api/sections/" + yId,
            success: function (data) {
                renderTable(data);
            }
        });
    };

    var renderTable = function (data) {
        $table.find('tbody').empty();
        $inputName.val("");
        var template = $('#section_template2').html();
        var rendered = Mustache.render(template, data);
        $table.find('tbody').append(rendered);
    };

    var save = function () {
        var yId = $selectYear.val();
        var sName = $inputName.val();
        $.ajax({
            type: 'POST',
            url: "/clearance/api/save-section",
            data: {
                year_id: yId,
                section_name: sName,
                section_id: $sId
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
section.init;