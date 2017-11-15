(function() {
var myApp = angular.module('MeetingRoom', ["ngRoute"]);

myApp.config(function($routeProvider){
    $routeProvider.
    when('/reservations', {
        templateUrl: '/Reservations.html',
        controller: 'ReservationsController'
        })
    .when('/update/:id', {
        templateUrl: '/EditReservation.html',
        controller: 'EditController'
        })
    .when('/new', {
        templateUrl: '/NewReservation.html',
        controller: 'NewReservationController'
        })
    .otherwise({
        redirectTo: '/reservations'
        });
    });
}());
