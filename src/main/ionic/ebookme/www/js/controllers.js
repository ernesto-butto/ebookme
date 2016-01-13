angular.module('app.controllers', ['ngResource'])

  .controller('ebookmeCtrl', function($scope,EbookMeService,$ionicLoading,$timeout) {

    $scope.urlToConvert = {title:"",url:"",email:"",format:"HTML"};

    $scope.sendUrlToConvert = function(){

      $scope.successMessage = undefined;
      $scope.errorMessage = undefined;

      $ionicLoading.show({
        content: 'Loading',
        animation: 'fade-in',
        showBackdrop: true,
        maxWidth: 200,
        showDelay: 0
      });

      EbookMeService.restConvert().sendUrl($scope.urlToConvert,function(){

        $ionicLoading.hide();
        $scope.successMessage = "url successfully converted, check your email";
        $scope.convertForm.$setPristine();

      },function(er){

        $ionicLoading.hide();
        $scope.errorMessage = "the convertion of your content failed, please try again later";



      })
    };


    $scope.reset=function(){

      if ($scope.convertForm)
        $scope.convertForm.$setPristine();

      $scope.urlToConvert = {title:"",url:"",email:"",format:"HTML"};
      $scope.successMessage = undefined;
      $scope.errorMessage = undefined;

    }

  });
