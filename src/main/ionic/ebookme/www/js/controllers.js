angular.module('app.controllers', ['ngResource'])

  .controller('EbookmeCtrl', function($scope,EbookMeService,$ionicLoading,$timeout,$stateParams,StorageService) {


    $scope.emailsSaved = StorageService.get('emailsSaved');



    if($stateParams.title && $stateParams.url && $stateParams.author){

      $scope.urlToConvert = {title:$stateParams.title,url:$stateParams.url,email:'',author:$stateParams.author,format:"PDF"};

    }else

      $scope.urlToConvert = {title:"ebook_content",url:"",email:'',format:"PDF",author:""};


    var checkIfEmailExist = function(email){

      for(var i=0; i < $scope.emailsSaved.length;i++){

        if($scope.emailsSaved[i].indexOf(email)> -1){

          return true;

        }
      }

      return false;

    };

    var addEmailToLocalStorage = function (email){


      if(!checkIfEmailExist(email)){
        $scope.emailsSaved.push(email);
      }

      StorageService.set('emailsSaved',$scope.emailsSaved);

    };

    var resetForm=function(form){

      if (form)
        form.$setPristine();

      $scope.urlToConvert = {title:"",url:"",email:"",format:"HTML",author:""};


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
      $scope.validateEmail();

    };




    $scope.validateEmail = function(){

      var EMAIL_REGEXP = /^[_a-zA-Z0-9]+(\.[_a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.[a-zA-Z]{2,4})$/;

      $scope.urlToConvert.email= $scope.urlToConvert.email.toLowerCase();

      $scope.validEmail =   EMAIL_REGEXP.test($scope.urlToConvert.email);


    };

  })



  .controller('SuggestionsCtrl', function($scope,$state,$ionicLoading,EbookMeService) {


    $ionicLoading.show({

      content: 'Loading',
      animation: 'fade-in',
      showBackdrop: true,
      maxWidth: 200,
      showDelay: 0

    });

    EbookMeService.restConvert().getSuggestionsList(function(preFetchSuggestionsList){

      $ionicLoading.hide();
      $scope.listLinks = preFetchSuggestionsList;

    },function(error){

      $ionicLoading.hide();
      $scope.listLinks = [];

    });

    $scope.sendToForm = function(item){

      $state.go("tabsController.ebookme",{title:item.title,url:item.url,author:item.author},{ reload: true }) ;
    };


  });

