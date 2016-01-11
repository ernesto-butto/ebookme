angular.module('app.services', [])

.factory('BlankFactory', [function(){

}])



.factory('EbookMeService', ['$resource',
      function($resource){

          var restConvert=function(){
              return  $resource('http://ebookme.herokuapp.com/convert',null,
                  {
                      'sendUrl': {method:'POST'}
                  });
          };

          return {
            restConvert:restConvert
          }
      }])



.service('BlankService', [function(){

}]);

