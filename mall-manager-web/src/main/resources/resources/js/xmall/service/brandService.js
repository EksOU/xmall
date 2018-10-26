xmall.service("brandService", function ($http) {

    this.list = function (pageNum, pageSize, entity) {
        return $http.post("../brand/list?pageNum=" + pageNum + "&pageSize=" + pageSize, entity);
    };

    this.save = function (entity) {
        return $http.post("../brand/save", entity);
    };

    this.update = function (entity) {
        return $http.post("../brand/update", entity);
    };

    this.findById = function (id) {
        return $http.get("../brand/findById?id=" + id);
    };

    this.del = function (selectedIds) {
        return $http.post("../brand/delete", selectedIds);
    };

    this.listOptions = function () {
        return $http.get("../brand/listOptions");
    }
});