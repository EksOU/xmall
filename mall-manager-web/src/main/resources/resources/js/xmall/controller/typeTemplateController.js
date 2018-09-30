xmall.controller("typeTemplateController", function ($scope, $controller, typeTemplateService, brandService, skuService) {
    $controller("baseController", {$scope: $scope});

    $scope.searchEntity = {};
    $scope.typeTemplateEntity = {};
    $scope.typeTemplateEntity.customAttributeItems = [];

    /**
     * 获取类型模板列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     */
    $scope.list = function (pageNum, pageSize) {
        typeTemplateService.list(pageNum, pageSize, $scope.searchEntity).success(function (response) {
            $scope.typeTemplateList = response.list;
            $scope.paginationConf.totalItems = response.total;
        })
    };

    /**
     * 保存新增类型模板
     */
    $scope.save = function () {
        typeTemplateService.save($scope.typeTemplateEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.clearEditModel();
            } else {
                alert(response.message);
            }
        });
    };

    $scope.saveOrUpdate = function () {
        if ($scope.typeTemplateEntity.id == null) {
            $scope.save();
        } else {
            $scope.update();
        }
    };

    /**
     * 更新类型模板
     */
    $scope.update = function () {
        typeTemplateService.update($scope.typeTemplateEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.clearEditModel();
            } else {
                alert(response.message);
            }
        })
    };

    /**
     * 根据id获取类型模板
     * @param id 类型模板Id
     */
    $scope.findById = function (id) {
        typeTemplateService.findById(id).success(function (response) {
            $scope.typeTemplateEntity = response;
            //转换字符串为json对象（集合）
            $scope.typeTemplateEntity.brandIds = JSON.parse($scope.typeTemplateEntity.brandIds);
            $scope.typeTemplateEntity.specIds = JSON.parse($scope.typeTemplateEntity.specIds);
            $scope.typeTemplateEntity.customAttributeItems = JSON.parse($scope.typeTemplateEntity.customAttributeItems);
        })
    };

    /**
     * 类型模板删除
     */
    $scope.del = function () {
        typeTemplateService.del($scope.selectedIds).success(function (response) {
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
        $scope.typeTemplateEntity = {};
    };


    $scope.brandList = {data: []};
    /**
     * 获取品牌选项列表
     */
    $scope.listBrandOptions = function () {
        brandService.listOptions().success(function (response) {
            $scope.brandList = {data: response};
        })
    };

    $scope.skuList = {data: []};
    /**
     * 获取规格选项列表
     */
    $scope.listSkuOptions = function () {
        skuService.listOptions().success(function (response) {
            $scope.skuList = {data: response};
        })
    };

    /**
     * 增加规格选项行
     */
    $scope.addTableRow = function () {
        $scope.typeTemplateEntity.customAttributeItems.push({});
    };

    /**
     * 删除规格选项行
     * @param index 删除行下标
     */
    $scope.delTableRow = function (index) {
        $scope.typeTemplateEntity.customAttributeItems.splice(index, 1);
    }
});