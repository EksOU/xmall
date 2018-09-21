var app = angular.module("xmall", []);

app.controller("brandController", function ($scope, $http) {
    $scope.list = function () {
        $http.get("../brand/list").success(function (response) {
            $scope.brandList = response;
        })
    }
});