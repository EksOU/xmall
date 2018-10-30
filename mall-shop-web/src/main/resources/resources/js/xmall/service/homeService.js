xmall.service("homeService", function ($http) {

    this.userInfo = function () {
        return $http.get("../index/userInfo");
    }

});