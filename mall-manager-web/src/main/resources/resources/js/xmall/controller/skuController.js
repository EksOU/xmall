xmall.controller("skuController", function ($scope, $controller, skuService) {
    $controller("baseController", {$scope: $scope});

    $scope.searchEntity = {};
    $scope.skuEntity = {};
    $scope.skuEntity.optionList = [];

    /**
     * 获取品牌列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     */
    $scope.list = function (pageNum, pageSize) {
        skuService.list(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.skuList = response.list;
            $scope.paginationConf.totalItems = response.total;
        })
    };

    /**
     * 保存新增品牌
     */
    $scope.save = function () {
        skuService.save($scope.skuEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.clearEditModel();
            } else {
                alert(response.message);
            }
        });
    };

    $scope.saveOrUpdate = function () {
        if ($scope.skuEntity.id == null) {
            $scope.save();
        } else {
            $scope.update();
        }
    };

    /**
     * 更新品牌
     */
    $scope.update = function () {
        skuService.update($scope.skuEntity).success(function (response) {
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
        skuService.findById(id).success(function (response) {
            $scope.skuEntity = response;
        })
    };

    /**
     * 品牌删除
     */
    $scope.del = function () {
        skuService.del($scope.selectedIds).success(function (response) {
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
        $scope.skuEntity = {};
        $scope.skuEntity.optionList = [];
    };

    /**
     * 增加规格选项行
     */
    $scope.addTableRow = function () {
        $scope.skuEntity.optionList.push({});
    };

    /**
     * 删除规格选项行
     * @param index 删除行下标
     */
    $scope.delTableRow = function (index) {
        $scope.skuEntity.optionList.splice(index, 1);
    }
});