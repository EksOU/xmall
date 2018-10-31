xmall.service("itemService", function ($http) {

    this.listCategory = function (parentId) {
        return $http.get("../item/listCategory?parentId=" + parentId);
    }
});