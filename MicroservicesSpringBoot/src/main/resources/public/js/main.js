var app = angular.module("MicroservicesSpringBoot", []);

app.controller("ForexController", function ($scope, $http){
  //  $scope.websites = [];

    $http.get('http://localhost:8099/forex-services/List').
    then(rest => {
        $scope.websites = rest.data;
    });

    $scope.delete = function (item){
        $http.delete("http://localhost:8099/forex-services/List/" + item.id).
        then(rest => {
            let ix = $scope.websites.map(item => item.id).indexOf(item.id);
            $scope.websites.splice(ix,1);
        });
    }
});
