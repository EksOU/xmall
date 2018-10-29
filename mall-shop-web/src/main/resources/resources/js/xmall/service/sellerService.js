xmall.service('sellerService', function ($http) {

    //商家申请注册
    this.register = function (entity) {
        return $http.post('../seller/register', entity);
    };
});
