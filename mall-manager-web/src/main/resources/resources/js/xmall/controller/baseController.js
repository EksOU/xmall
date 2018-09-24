xmall.controller("baseController", function ($scope) {

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

    $scope.selectedIds = [];
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