/**
 * 
 */

'use strict';

var myNoteApp = angular.module('myNoteApp', [])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.jsp',
        controller: 'myNoteController'
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);