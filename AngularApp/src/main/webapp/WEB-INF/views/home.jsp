<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html ng-app="myNoteApp">
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="resources/js/angular.min.js"></script>
</head>
<body>

<div ng-controller="myNoteController">

<h2>My Note</h2>

Enter a Note: <input type="text" ng-model="message"/>
<button type="button" ng-click="addTask()">Add</button>
<p>
<button ng-click="clear()">Clear</button>
</p>

<p>Number of characters left: <span ng-bind="left()"></span></p>

<table border="2">
<tr>
<td>Task Name</td>
<td>Created On</td>
<td>Status</td>
</tr>
<tr ng-repeat="row in rows">
<td>{{row.taskName}}</td>
<td>{{row.createdOn}}</td>
<td>{{row.status}}</td>
<td><button type="button" ng-click="updateTask($index,row.taskName)">Complete</button></td>
<td><button type="button" ng-click="deleteTask(row.taskName)">Delete</button></td>
</tr>
</table>
</div>
<script src="resources/js/myNoteApp.js"></script>
<script src="resources/js/myNoteController.js"></script>

</body>
</html>