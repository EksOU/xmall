xmall.controller("brandController", function ($scope, $controller, brandService) {
    $controller("baseController", {$scope: $scope});

    $scope.searchEntity = {};
    $scope.brandEntity = {};

    /**
     * 获取品牌列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     */
    $scope.list = function (pageNum, pageSize) {
        brandService.list(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.brandList = response.list;
            $scope.paginationConf.totalItems = response.total;
        })
    };

    /**
     * 保存新增品牌
     */
    $scope.save = function () {
        brandService.save($scope.brandEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.clearEditModel();
            } else {
                alert(response.message);
            }
        });
    };

    $scope.saveOrUpdate = function () {
        if ($scope.brandEntity.id == null) {
            $scope.save();
        } else {
            $scope.update();
        }
    };

    /**
     * 更新品牌
     */
    $scope.update = function () {
        brandService.update($scope.brandEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.clearEditModel();
            } else {
                alert(response.message);
            }
        })
    };

    /**
     * 根据id获取品牌
     * @param id 品牌Id
     */
    $scope.findById = function (id) {
        brandService.findById(id).success(function (response) {
            $scope.brandEntity = response;
        })
    };

    /**
     * 品牌删除
     */
    $scope.del = function () {
        brandService.del($scope.selectedIds).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.selectedIds = [];
            } else {
                alert(response.message);
            }
        });
    };

    /**
     * 清空editModel
     */
    $scope.clearEditModel = function () {
        $scope.brandEntity = {};
    };
});