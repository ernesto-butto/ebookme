angular.module('app.routes', [])

  .config(function($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider


      .state('tabsController', {
        url: '/init',
        abstract:true,
        templateUrl: 'templates/tabsController.html'
      })




      .state('tabsController.ebookme', {
        url: '/convert',
        params:{
          title:null ,
          url:null
        },
        views: {
          'tab3': {
            templateUrl: 'templates/ebookme.html',
            controller: 'EbookmeCtrl'
          }
        }
      })

      .state('tabsController.suggestions', {
        url: '/suggestions',
        views: {
          'tabSuggestions': {
            templateUrl: 'templates/suggestions.html',
            controller: 'SuggestionsCtrl'

          }
        }
      })


    ;

    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/init/convert');

  });
