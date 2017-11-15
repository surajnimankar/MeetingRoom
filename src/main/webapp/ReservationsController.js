(function() {

  var app = angular.module("MeetingRoom");
  var ReservationsController = function($scope, $http, $location) {

    var person = {
      firstName: "Suraj",
      lastName: "Nimankar",
      imgSrc: "http://localhost:8080/images/Flower.jpg"

    };

    var onUserComplete = function(response) {
      $scope.reservations = response.data;
    };

    var onError = function(reason) {
      $scope.error = reason;
    };

    $http.get("http://localhost:8080/reservations")
      .then(onUserComplete, onError);
    $scope.message = "Hello Angular.......!";
    $scope.person = person;

    $scope.search = function(username) {
      $scope.username = "Hello " + username + "..!";
    };

    $scope.nameList = [{
      "name": "Suraj",
      "contactNumber": "111111111"
    }, {
      "name": "Sachin",
      "contactNumber": "12345"
    }, {
      "name": "Amit",
      "contactNumber": "22222222"
    }, {
      "name": "Niranjan",
      "contactNumber": "12345"
    }];


    $scope.cancelReservation = function(id){
               var onCancel = function(response) {
               $location.path("/#/reservations");
            };
            var onError = function(reason) {
            };
            $http.delete("http://localhost:8080/reservations/" + id).then(onCancel, onError);

        }
  };

  app.controller("ReservationsController", ReservationsController);

}());