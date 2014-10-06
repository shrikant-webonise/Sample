/**
 * 
 */
'use strict';

myNoteApp.controller('myNoteController', function($scope) 
{
	 	$scope.message = "";
	    $scope.left  = function() {return 100 - $scope.message.length;};
	    $scope.clear = function() {$scope.message = "";};
	    $scope.save  = function() {alert("Note Saved");};
	    $scope.update  = function() {alert("Note Updated");};
	    $scope.Delete  = function() {alert("Note Deleted");};
});

$http.get('/tasks').
success(function(data) 
{
    $scope.rows = data;	         
}).error(function(error)
{
	//alert("Error in get");
	alert("error -----> "+error);
});
