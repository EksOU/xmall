xmall.service("typeTemplateService", function ($http) {

    this.list = function (pageNum, pageSize, entity) {
        return $http.post("../typeTemplate/list?pageNum=" + pageNum + "&pageSize=" + pageSize, entity);
    };

    this.save = function (entity) {
        return $http.post("../typeTemplate/save", entity);
    };

    this.update = function (entity) {
        return $http.post("../typeTemplate/update", entity);
    };

    this.findById = function (id) {
        return $http.get("../typeTemplate/findById?id=" + id);
    };

    this.del = function (selectedIds) {
        return $http.post("../typeTemplate/delete", selectedIds);
    };

});