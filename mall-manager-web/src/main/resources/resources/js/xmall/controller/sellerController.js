xmall.controller('sellerController', function ($scope, $controller, sellerService) {
    $controller('baseController', {$scope: $scope});

    $scope.searchEntity = {};
    $scope.sellerEntity = {};

    /**
     * 获取商家列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     */
    $scope.list = function (pageNum, pageSize) {
        sellerService.list(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.sellerList = response.list;
            $scope.paginationConf.totalItems = response.total;
        })
    };

    /**
     * 获取商家详情
     * @param sellerId 商家id
     */
    $scope.findById = function (sellerId) {
        sellerService.findById(sellerId).success(function (response) {
            $scope.sellerEntity = response;
        })
    };

    /**
     * 商家状态设置
     * @param sellerId 商家ids
     * @param status 要设置的状态
     */
    $scope.updateStatus = function (sellerId, status) {
        sellerService.updateStatus(sellerId, status).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
            } else {
                alert(response.message)
            }
        });
    }

});	
