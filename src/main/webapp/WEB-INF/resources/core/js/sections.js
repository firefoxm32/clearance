section = function () {
    var sId = 0;
    var initialize = function () {
        courseOnChange();
        btnSaveOnClick();
        yearOnChange();
        btnUpdateOnClick();
    };

    var courseOnChange = function () {
        $('#course').change(function () {
            var val = $(this).val();
            console.log(val);
            $('#sections').empty();
            $('#section').val("");
            if (0 == val) {
                $('#year').empty();
                return;
            }
            getCourseYears(val);
        });
    };

    var getCourseYears = function (id) {
        $.ajax({
            url: '/clearance/api/course/' + id,
            method: 'GET',
            success: function (result) {
                populateYears(result.courseYears);
            }
        });
    };

    var populateYears = function (courseYears) {
        var arrSuff = new Array("st", "nd", "rd", "th", "th", "th", "th", "th", "th", "th");
        $('#year').empty();
        $('#year').append('<option value=0>SELECT YEAR</option>');
        $.each(courseYears, function (idx, cy) {
            $('#year').append('<option value=' + cy.id + '>' + cy.yearName + arrSuff[idx] + ' Year</option>');
        });
    }; //end of populate years

    var btnSaveOnClick = function () {
        $('#save').click(function () {
            var yearId = $('#year').val();
            var sectionName = $('#section').val();
            if (yearId <= 0 || sectionName === "") {
                return alertMessage('Incomplete!!');
            }
            save(yearId, sectionName);
        });
    };

    var save = function (yearId, sectionName) {
        $.ajax({
            url: '/clearance/api/save-section',
            method: 'POST',
            data: {
                year_id: yearId,
                section_name: sectionName,
                section_id: sId
            },
            success: function (response) {
                alertMessage('Successfully ' + response);
                $('#section').val("");
                getSectionsByYearId($('#year').val());
            }
        });
    }; // end of save

    var yearOnChange = function () {
        $('#year').change(function () {
            var val = $(this).val();
            $('#sections').empty();
            $('#section').val("");
            if (0 == val) {
                return;
            }
            getSectionsByYearId(val);
        });
    };

    var getSectionsByYearId = function (courseYearId) {
        $('#sections').empty();
        $('#section').val("");
        $('#sections').append("<tr style=width: auto;border: black solid>\n\
            <th>SECTION ID</th>\n\
            <th>SECTION NAME</th>\n\
            <th>ACTION</th>\n\
            </tr>");
        $.ajax({
            url: '/clearance/api/sections/' + courseYearId,
            method: 'GET',
            success: function (result) {
                if (result.length == 0) {
                    return alertMessage("No sections yet!");
                }
                $.each(result, function (idx, section) {
                    populateTableSection(section.sectionId, section.sectionName);
                });
            }
        }).done(function () {
            console.log("hello");
            $('#sections').find('td').css({"border-color": "black",
                "border-width": "1px",
                "border-style": "solid"});
            
        });
    };

    var populateTableSection = function (id, sectionName) {
        $('#sections').append('<tr>\n\
            <td class="js-td">' + id + '</td>\n\
            <td class="js-td">' + sectionName + '</td>\n\
            <td class="js-td"><button data-section-name="'+sectionName+'" data-id="'+ id +'" class="btnupdate">UPDATE</button></td>\n\
            </tr>');
    }; // end of displaying list of section by course and year

    var btnUpdateOnClick = function () {
        $('#sections').on('click', '.btnupdate', function () {
            // this === button update
            var sectionName = $(this).closest('tr').find('td:nth-child(2)').text();
            console.log(sectionName);
        });
    };

    var alertMessage = function (msg) {
        alert(msg);
    };

    return {
        init: initialize
    };
}();

section.init();