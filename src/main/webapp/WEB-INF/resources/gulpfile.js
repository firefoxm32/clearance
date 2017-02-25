/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var gulp   = require('gulp');
var concat = require('gulp-concat');  
var rename = require('gulp-rename');  
var uglify = require('gulp-uglify'); 

//script paths
var jsFiles = 'core/js/**/*.js',
    jsDest = 'dist/scripts';

var mustache = 'bower_components/mustache.js/mustache.js';
var jquery = 'bower_components/jquery/dist/jquery.js';
var jqueryUi = 'bower_components/jquery-ui/jquery-ui.js';

gulp.task('vendor', function() {  
    return gulp.src([mustache, jquery, jqueryUi])
        .pipe(concat('vendor-scripts.js'))
        .pipe(uglify())
        .pipe(rename('vendor.min.js'))
        .pipe(gulp.dest(jsDest));
});

gulp.task('app-scripts', function() {  
    return gulp.src(jsFiles)
        .pipe(concat('app.js'))
        .pipe(uglify())
        .pipe(rename('app.min.js'))
        .pipe(gulp.dest(jsDest));
});

//gulp.task('watch', function() {
//
//  gulp.watch([path.source + 'scripts/**/*'], ['scripts']);
//  gulp.watch([path.source + 'fonts/**/*'], ['fonts']);
//  gulp.watch([path.source + 'images/**/*'], ['sprite','images']);
//  gulp.watch(['bower.json', 'assets/manifest.json'], ['build']);
//});

gulp.task('default', ['app-scripts','vendor'], function(){});