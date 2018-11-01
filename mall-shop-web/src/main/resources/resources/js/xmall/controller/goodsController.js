xmall.controller('goodsController', function ($scope, $controller, goodsService) {
    $controller('baseController', {$scope: $scope});

    $scope.goodsEntity = {};

    /**
     * 保存新增商品
     */
    $scope.save = function () {
        var goodsEntity = $scope.goodsEntity;
        goodsEntity.desc.introduction = editor.html();
        goodsService.save(goodsEntity).success(function (response) {
            if (response.code === 200) {
                $scope.goodsEntity = {};
                editor.html("");
            }
            alert(response.message);
        });
    };

});	
