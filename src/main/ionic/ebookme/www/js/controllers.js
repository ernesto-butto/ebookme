angular.module('app.controllers', ['ngResource'])

  .controller('EbookmeCtrl', function($scope,EbookMeService,$ionicLoading,$timeout,$stateParams,StorageService,emailFilteredFilter) {


    $scope.emailsSaved = StorageService.get('emailsSaved');



    if($stateParams.title && $stateParams.url){

      $scope.urlToConvert = {title:$stateParams.title,url:$stateParams.url,email:'',format:"HTML"};

    }else

      $scope.urlToConvert = {title:"",url:"",email:'',format:"HTML"};


    var addEmailToLocalStorage = function (email){



      var flag =false;

      for(var i=0; i < $scope.emailsSaved.length;i++){

        if($scope.emailsSaved[i].indexOf(email)> -1){

          flag=true;

        }
      }

      if(!flag){
        $scope.emailsSaved.push(email);
      }


      StorageService.set('emailsSaved',$scope.emailsSaved);

    };

    var resetForm=function(form){

      if (form)
        form.$setPristine();

      $scope.urlToConvert = {title:"",url:"",email:"",format:"HTML"};


    };

    $scope.sendUrlToConvert = function(form){

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
        addEmailToLocalStorage($scope.urlToConvert.email);
        resetForm(form);

      },function(er){

        $ionicLoading.hide();
        $scope.errorMessage = "The convertion of your content failed, please try again later";

      });



    };




    $scope.resetAll = function (form){
      resetForm(form);
      $scope.successMessage = undefined;
      $scope.errorMessage = undefined;
    };




    $scope.setEmail = function (email){
      $scope.urlToConvert.email=email;

    };

    $scope.search = function(){

      $scope.urlToConvert.emailsSaved =  emailFilteredFilter($scope.urlToConvert.email,$scope.urlToConvert.emailsSaved)

    };


  })

  .filter('emailFiltered', function() {
    return function (email,emailsList) {
      return function (email,emailsList) {
        var filteredList = [];
        for(var i = 0 ; i < emailsList.length ; i++){
          if(emailsList[i].indexOf(email)>= 0){
            filteredList.push(emailsList[i]);
          }
        }


      };
    }
  })

  .controller('SuggestionsCtrl', function($scope,$state) {


    $scope.sendToForm = function(item){

      $state.go("tabsController.ebookme",{title:item.title,url:item.url}) ;
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

