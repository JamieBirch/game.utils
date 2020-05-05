
(function () {
    'use strict';

    angular
        .module('app')
        .controller('WeaponController', WeaponController);

    WeaponController.$inject = ['$http'];

    function WeaponController($http) {
        var vm = this;

        vm.weapons = [];
        vm.all = all;
        vm.weapon = weapon;

        init();

        function init(){
            all();
        }

        function all(){
            var url = "/weapon-generator/all";
            var weaponsPromise = $http.get(url);
            weaponsPromise.then(function(response){
                vm.weapons = response.data;
            });
        }

        function weapon(){
            var url = "/weapon-generator/weapon/";
            var weaponsPromise = $http.get(url);
            weaponsPromise.then(function(response){
                vm.weapons = response.data;
            });
        }
    }
})();
