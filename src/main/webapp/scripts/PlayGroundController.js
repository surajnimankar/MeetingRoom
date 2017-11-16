(function() {
    var app = angular.module("MeetingRoom");
    var PlayGroundController = function($scope) {
    var person = {
          firstName: "Suraj",
          lastName: "Nimankar",
          imgSrc: "http://localhost:8080/images/Flower.jpg"

        };
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
        $scope.message = "Hello Angular.......!";
        $scope.person = person;
    };

    app.controller("PlayGroundController", PlayGroundController);

}());