angular.module('app').directive('user', function(){
  
      return {
          scope: {
              user: '=userItem'
          },
          templateUrl: 'componentes/userlist/userlist.html'
      };
  });
  