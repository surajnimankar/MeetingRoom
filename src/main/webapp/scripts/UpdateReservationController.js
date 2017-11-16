(function() {

  var app = angular.module("MeetingRoom");
  var UpdateReservationController = function($scope, $http, $location, $routeParams) {
    var onUserComplete = function(response) {
          $scope.rooms = response.data;
        };

        var onError = function(reason) {
          $scope.error = reason;
        };

        $http.get("http://localhost:8080/reservations/rooms")
          .then(onUserComplete, onError);

     getReservationById = function(id) {
         var onComplete = function(response) {
            $scope.name = response.data.guest.name;
            $scope.contactNumber = response.data.guest.contactNumber;
            $scope.bookingDate = response.data.duration.bookingDate.dayOfMonth + "/"
            + response.data.duration.bookingDate.monthValue + "/" + response.data.duration.bookingDate.year;
            $scope.startTime = response.data.duration.startTime.hour + ":" + response.data.duration.startTime.minute;
            $scope.endTime = response.data.duration.endTime.hour + ":" + response.data.duration.endTime.minute;
            $scope.rooms = response.data.room;
            $scope.reservationNumber = response.data.reservationNumber;
            $scope.id = response.data.id;
         };

         var onError = function(reason) {
                $scope.error = reason;
         };
         $http.get("http://localhost:8080/reservations/" + id).then(onComplete, onError);
      };
     getReservationById($routeParams.id);

    $scope.updateReservation = function() {
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
              id: $scope.id,
              reservationNumber:  $scope.reservationNumber,
              guest: guest,
              room: $scope.rooms,
              duration: duration,
              status: "STATUS_BOOKED"
        };
        var onComplete = function(response) {
              $location.path("/reservations");
              $scope.successMsg = "Reservation Updated Successfully..!";
        };

        var onError = function(reason) {
             $scope.addReservation = reason;
        };
        $http.put("http://localhost:8080/reservations", reservation).then(onComplete, onError);
      };
    };

  app.controller("UpdateReservationController", UpdateReservationController);

}());