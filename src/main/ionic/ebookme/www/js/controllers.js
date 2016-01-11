angular.module('app.controllers', ['ngResource'])

.controller('ebookmeCtrl', function($scope,EbookMeService) {

    $scope.urlToConvert = {url:"",email:"",format:"HTML"};

    $scope.sendUrlToConvert = function(){

      EbookMeService.restConvert().sendUrl($scope.urlToConvert,function(){

       alert("url successfully converted");
      },function(er){

        alert("url failure in convertion");
      })
    };

})
