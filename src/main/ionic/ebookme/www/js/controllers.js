angular.module('app.controllers', ['ngResource'])

  .controller('ebookmeCtrl', function($scope,EbookMeService,$ionicLoading,$timeout,$stateParams) {

    if($stateParams.suggestion){
      $scope.urlToConvert = {title:$stateParams.suggestion.title,url:$stateParams.suggestion.url,email:"",format:"HTML"};
    }else
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
        $scope.successMessage = "Url successfully converted, check your email";
        $scope.convertForm.$setPristine();


      },function(er){

        $ionicLoading.hide();
        $scope.errorMessage = "The convertion of your content failed, please try again later";

      })
    };


    $scope.reset=function(){

      if ($scope.convertForm)
        $scope.convertForm.$setPristine();

      $scope.urlToConvert = {title:"",url:"",email:"",format:"HTML"};
      $scope.successMessage = undefined;
      $scope.errorMessage = undefined;

    }

    $scope.copyText = function(value) {
      $cordovaClipboard.copy(value).then(function() {
        console.log("Copied text");
      }, function() {
        console.error("There was an error copying");
      });
    }


  })

  .controller('suggestionsCtrl', function($scope,$state) {


    $scope.sendToForm = function(item){

      $state.go("tabsController.ebookme",{suggestion:{title:item.title,url:item.url}}) ;
    };

    $scope.listLinks = [
      {
        title:"Stressful",
        url:"http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html",
        category:"Coding"
      } ,
      {
        title:"Code Refactoring",
        url:"http://jessewarden.com/2008/11/agile-chronicles-2-code-refactoring.html",
        category:"Coding"
      },
      {
        title:"Branch Workflow",
        url:"http://jessewarden.com/2008/11/agile-chronicles-3-branch-workflow.html" ,
        category:"Coding"
      } ,
      {
        title:"French onion soup recipe",
        url:"http://www.seriouseats.com/recipes/2016/01/pressure-cooker-french-onion-soup-recipe.html",
        category:"Cooking"
      } ,
      {
        title:"Where to Eat the Best Kouign Amann in NYC",
        url:"http://www.seriouseats.com/2015/09/best-kouign-amann-nyc.html",
        category:"Cooking"
      }
    ];



  });

