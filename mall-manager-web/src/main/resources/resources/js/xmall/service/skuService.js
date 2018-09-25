xmall.service("skuService", function ($http) {

    this.list = function (pageNum, pageSize, entity) {
        return $http.post("../sku/list?pageNum=" + pageNum + "&pageSize=" + pageSize, entity);
    };

    this.save = function (entity) {
        return $http.post("../sku/save", entity);
    };

    this.update = function (entity) {
        return $http.post("../sku/update", entity);
    };

    this.findById = function (id) {
        return $http.get("../sku/findById?id=" + id);
    };

    this.del = function (selectedIds) {
        return $http.post("../sku/delete", selectedIds);
    };

    //下拉列表
    this.listOptions = function () {
        return $http.get('../sku/listOptions');
    }
});