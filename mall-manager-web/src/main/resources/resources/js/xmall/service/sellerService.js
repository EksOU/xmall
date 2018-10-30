xmall.service('sellerService', function ($http) {

    this.list = function (pageNum, pageSize, entity) {
        return $http.post("../seller/list?pageNum=" + pageNum + "&pageSize=" + pageSize, entity);
    };

    this.findById = function (id) {
        return $http.get("../seller/findById?id=" + id);
    };

    this.updateStatus = function (sellerId, status) {
        return $http.post("../seller/updateStatus?id=" + sellerId + "&status=" + status);
    }
});
