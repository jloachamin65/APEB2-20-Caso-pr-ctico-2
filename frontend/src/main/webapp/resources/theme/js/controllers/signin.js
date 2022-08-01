'use strict';

app.controller('SigninFormController', ['utilStringService', 'SessionService',
    'SessionData', '$cookies', '$scope', '$timeout', '$http', '$state', 'blockUI', 'Alertify',
    function (utilStringService, SessionService, SessionData, $cookies, $scope,
              $timeout, $http, $state, blockUI, Alertify) {
        $scope.user = {};
        $scope.subsidiaryObj = {};
        $scope.userSubsidiaryObj = {};

        $scope.cancel = function () {
            $scope.lstSubsidiaries = undefined;
        };

        $scope.redireccionar = function () {
            blockUI.start();
            // $state.go('app.dashboard-v1');
            $state.go('app.form.manCita');
            blockUI.stop();


        };

        $scope.login = function () {

            loadUserSubsidiaries();

        };

        function loadUserSubsidiaries() {

            $scope.redireccionar();

        }

    }])
;