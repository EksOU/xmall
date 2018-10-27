xmall.controller("homeController", function ($scope, homeService) {

    $scope.user = {};
    /**
     * 获取当前登陆的用户信息
     */
    $scope.userInfo = function () {
        homeService.userInfo().success(function (response) {
            $scope.user = response;
        })
    }

});