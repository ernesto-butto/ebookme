angular.module('app.services', ['ngStorage'])

  .factory('EbookMeService', ['$resource',
    function($resource){

      var restConvert=function(){
        return  $resource('http://ebookme.herokuapp.com:8080',null,
          {
            'sendUrl': {url:'http://ebookme.herokuapp.com:8080/convert',method:'POST'},
            'getSuggestionsList': {url:'http://ebookme.herokuapp.com:8080/articleList/getList', method:'GET',isArray:true}

          });
      };

      return {
        restConvert:restConvert
      }
    }])




  .factory ('StorageService', ['$localStorage',function ($localStorage) {

  $localStorage = $localStorage.$default({
    emailsSaved: []
  });


  var _remove = function (key) {
    $localStorage.removeItem(key);
  };

  var _set = function(key, value) {
    $localStorage[key] = value;
  };

  var _get = function(key, defaultValue) {
    return $localStorage[key] || defaultValue;
  };

  var _setObject = function(key, value) {
    $localStorage[key] = JSON.stringify(value);
  };

  var _getObject = function(key) {
    return JSON.parse($localStorage[key] || '{}');
  };


  return {

    remove: _remove,
    set:_set,
    get:_get,
    setObject:_setObject,
    getObject:_getObject

  };
}])



  .factory('$localstorage', ['$window', function($window) {
    return {
      set: function(key, value) {
        $window.localStorage[key] = value;
      },
      get: function(key, defaultValue) {
        return $window.localStorage[key] || defaultValue;
      },
      setObject: function(key, value) {
        $window.localStorage[key] = JSON.stringify(value);
      },
      getObject: function(key) {
        return JSON.parse($window.localStorage[key] || '{}');
      }
    }
  }]);
