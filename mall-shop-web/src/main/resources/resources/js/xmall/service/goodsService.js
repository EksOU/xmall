xmall.service('goodsService', function ($http) {

    this.save = function (goods) {
        return $http.post("../goods/save", goods);
    }
});
