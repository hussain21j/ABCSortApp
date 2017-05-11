
/* ------------------------------------------------------- 

* Description:  This file contains all the controller and Java script code for the HnMSortApp
* Author:       Tayab Hussain

---------------------------------------------------------*/

var app = angular.module('HMSortApp', []);

  app.controller('MainCtrl', function($scope, $http) {
  $scope.numbers = [{id: 'number1'}, {id: 'number2'}];
  $scope.addNewNumber = function() {
    var newItemNo = $scope.numbers.length+1;
    $scope.numbers.push({'id':'number'+newItemNo});
  };
    
  $scope.removeNumber = function() {
    var lastItem = $scope.numbers.length-1;
    $scope.numbers.splice(lastItem);
  };
  
  
  $scope.getSorted = function(){
	//call the rest service and set a response into a variable of $session scope

      var response =   $http.post('http://localhost:8080/sort/sortdata', $scope.numbers)

      response.success(function(data, status, headers, config) {
          $scope.sortedInfoData = data;
      });

      response.error(function(data, status, headers, config) {
          alert("Please check your Data");
      });
  };
  
  
  $scope.getHistorySorts = function(){
	  // $http.defaults.useXDomain = true;
	  
	//call the rest service and set a response into a variable of $session scope
	     $http.get('http://localhost:8080/sort/getSortHistory')
	        .then(function(respose){
	            $scope.sortDataInfoList = respose.data;
	    });
  };
});
