var xmall = angular.module("xmall", ['pagination']);

xmall.controller("brandController", function ($scope, $http) {

    $scope.searchEntity = {};
    /**
     * 获取品牌列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     */
    $scope.list = function (pageNum, pageSize) {
        $http.post("../brand/list?pageNum=" + pageNum + "&pageSize=" + pageSize, $scope.searchEntity)
            .success(function (response) {
                $scope.brandList = response.list;
                $scope.paginationConf.totalItems = response.total;
            })
    };


    /**
     * 分页控件配置currentPage:当前页
     * totalItems :总记录数
     * itemsPerPage:每页记录数
     * perPageOptions :分页选项
     * onChange:当页码变更后自动触发的方法
     */
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.list($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        }
    };

    /**
     * 加载分页
     */
    $scope.reloadList = function () {
        $scope.paginationConf.totalItems = 0;
        //调用list方法，在totalItems有变化情况下会造成二次请求
        //$scope.list($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };


    $scope.brandEntity = {};
    /**
     * 保存新增品牌
     */
    $scope.save = function () {
        $http.post("../brand/save", $scope.brandEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.brandEntity = {};
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
        $http.post("../brand/update", $scope.brandEntity).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.brandEntity = {};
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
        $http.get("../brand/findById?id=" + id).success(function (response) {
            $scope.brandEntity = response;
        })
    };

    $scope.selectedIds = [];
    /**
     * 品牌删除
     */
    $scope.del = function () {
        $http.post("../brand/delete", $scope.selectedIds).success(function (response) {
            if (response.code === 200) {
                $scope.reloadList();
                $scope.selectedIds = [];
            } else {
                alert(response.message);
            }
        });
    };

    /**
     * checkBox 事件监听
     * @param $event input源
     * @param id 品牌id
     */
    $scope.selectOption = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectedIds.push(id);
        } else {
            var index = $scope.selectedIds.indexOf(id);
            $scope.selectedIds.splice(index, 1);
        }
    };
});