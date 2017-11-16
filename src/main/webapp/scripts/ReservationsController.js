(function() {

  var app = angular.module("MeetingRoom");
  var ReservationsController = function($scope, $http, $location) {

    var onUserComplete = function(response) {
      $scope.reservations = response.data;
    };

    var onError = function(reason) {
      $scope.error = reason;
    };

    $http.get("http://localhost:8080/reservations")
      .then(onUserComplete, onError);

      $scope.cancelReservation = function(id) {
          var onCancel = function(response) {
              $location.path("/#/reservations");
          };
          var onError = function(reason) {
          $scope.error = reason;
          };
          $http.delete("http://localhost:8080/reservations/" + id).then(onCancel, onError);
     };
    };

  app.controller("ReservationsController", ReservationsController);

}());