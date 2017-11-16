(function() {
var myApp = angular.module('MeetingRoom', ["ngRoute"]);

myApp.config(function($routeProvider){
    $routeProvider.
    when('/reservations', {
        templateUrl: '/html/Reservations.html',
        controller: 'ReservationsController'
        })
    .when('/update/:id', {
        templateUrl: '/html/UpdateReservation.html',
        controller: 'UpdateReservationController'
        })
    .when('/new', {
        templateUrl: '/html/NewReservation.html',
        controller: 'NewReservationController'
        })
    .when('/play', {
        templateUrl: '/html/PlayGround.html',
        controller: 'PlayGroundController'
        })
    .otherwise({
        redirectTo: '/reservations'
        });
    });
}());
