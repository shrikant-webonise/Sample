<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html ng-app="myNoteApp">
<body>

<div ng-controller="myNoteController">

<h2>My Note</h2>

<p><input type="text" ng-model="message"/></p>

<p>
<button ng_click="save()">Save</button>
<button ng_click="update()">Update</button>
<button ng_click="Delete()">Delete</button>
<button ng-click="clear()">Clear</button>
</p>

<p>Number of characters left: <span ng-bind="left()"></span></p>
</div>
<table border="2">
<tr>
<td>Task Name</td>
<td>Created On</td>
<td>Status</td>
</tr>
<tr ng-repeat="row in rows">
<td>"row.taskName"</td>
<td>"row.createdOn"</td>
<td>"row.status"</td>
</tr>
</table>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/myNoteApp.js"></script>
<script src="resources/js/myNoteController.js"></script>

</body>
</html>