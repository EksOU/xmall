xmall.controller('sellerController', function ($scope, $controller, sellerService) {
    $controller('baseController', {$scope: $scope});

    //商实申请注册
    $scope.register = function () {
        sellerService.register($scope.entity).success(
            function (response) {
                if (response.code === 200) {
                    location.href = "shoplogin.html";
                } else {
                    alert(response.message);
                }
            }
        );
    };

});	
