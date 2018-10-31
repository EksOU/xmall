xmall.controller("itemController", function ($scope, $controller, itemService) {
    $controller("baseController", {$scope: $scope});

    function listCategory(parentId) {
        itemService.listCategory(parentId).success(function (response) {
            $scope.itemCategoryList = response;
        })
    }

    $scope.grade = 1;
    $scope.category_1 = {};
    $scope.category_2 = {};

    $scope.upGrade = function () {
        $scope.grade = $scope.grade + 1;
    };

    $scope.listCategory = function (category) {
        if ($scope.grade === 1) {
            $scope.category_1 = {};
            $scope.category_2 = {};
        } else if ($scope.grade === 2) {
            $scope.category_1 = category;
            $scope.category_2 = {};
        } else if ($scope.grade === 3) {
            $scope.category_2 = category;
        }

        listCategory(category.id);
    }

});