(function() {

  var app = angular.module("AddReservModule", []);
  var AddReservationController = function($scope, $http) {

    var onUserComplete = function(response) {
      $scope.rooms = response.data;
    };

    var onError = function(reason) {
      $scope.error = reason;
    };

    $http.get("http://localhost:8080/reservations/rooms")
      .then(onUserComplete, onError);

    $scope.newReservation = function() {
        var guest = {
            name: $scope.name,
            contactNumber: $scope.contactNumber
        };
        var duration = {
            bookingDate: $scope.bookingDate,
            startTime: $scope.startTime,
            endTime: $scope.endTime
        };
        var reservation = {
              reservationNumber:  $scope.name + "_1",
              guest: guest,
              room: "ROOM_MEDIUM",
              duration: duration,
              status: "STATUS_BOOKED"
        };

        var onComplete = function(response) {
              $scope.addReservation = "Reservation Added Sucessfully...!";
        };

        var onError = function(reason) {
             $scope.addReservation = reason;
        };
        $http.post("http://localhost:8080/reservations", reservation).then(onComplete, onError);
      };
  };

  app.controller("AddReservationController", AddReservationController);

}());