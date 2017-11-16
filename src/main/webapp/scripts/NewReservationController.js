(function() {

  var app = angular.module("MeetingRoom");
  var NewReservationController = function($scope, $http, $location) {

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
              room: $scope.rooms,
              duration: duration,
              status: "STATUS_BOOKED"
        };

        var onComplete = function(response) {
              $location.path("/reservations");
              $scope.successMsg = "Reservation Done..!";
        };

        var onError = function(reason) {
             $scope.addReservation = reason;
        };
        $http.post("http://localhost:8080/reservations", reservation).then(onComplete, onError);
      };
  };

  app.controller("NewReservationController", NewReservationController);

}());