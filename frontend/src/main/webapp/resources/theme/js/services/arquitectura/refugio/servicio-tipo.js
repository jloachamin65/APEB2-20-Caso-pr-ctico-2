app.service('servicio-tipo', ['$q', '$http', function ($q, $http) {
    // AngularJS will instantiate a singleton by calling "new" on this function

    this.listarTipoPaginado = function (paramFilter) {
        var defered = $q.defer();
        var response = $http.get('listarTipoPaginado_json.json/' + paramFilter);
        response.success(function (data, status, headers, config) {
            defered.resolve(data);
        }, function (data, status, headers, config) {
            defered.reject(data);
        });

        return defered.promise;
    };


}]);