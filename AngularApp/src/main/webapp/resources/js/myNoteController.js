/**
 * 
 */
'use strict';
var url = "http://localhost:8080/angular/";
myNoteApp.controller('myNoteController', function($scope, $http) {
	$scope.message = "";
	$scope.left = function() {
		return 100 - $scope.message.length;
	};
	$scope.clear = function() {
		$scope.message = "";
	};

	$http.get(url + "/tasks").success(function(data) {
		$scope.rows = data;
	}).error(function(error) {

		alert("error -----> " + error);
	});

	$scope.addTask = function() {

		$http.post(url + "/addTask/" + $scope.message).success(function(data) {
			alert("Task added");

			$scope.rows = data;

		}).error(function(error) {
			alert(error);
		})
	};

	$scope.updateTask = function(idx, taskName) {

		var id = idx;
		var comb = idx + ',' + taskName;
		$http.post(url + "/updateTask/" + comb).success(function(data) {
			alert("Task Updated");

			$scope.rows = data;

		}).error(function(error) {
			alert(error);
		})
	};

	$scope.deleteTask = function(taskName) {

		var name = taskName;

		$http.post(url + "/deleteTask/" + name).success(function(data) {
			alert("Task Deleted");

			$scope.rows = data;

		}).error(function(error) {
			alert(error);
		})
	};

});