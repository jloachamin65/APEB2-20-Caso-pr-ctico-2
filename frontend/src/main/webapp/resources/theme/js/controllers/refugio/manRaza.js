app.controller('MantenimientoRaza', ['blockUI', '$translate',
    '$scope', 'ngTableParams', '$http', 'Alertify', 'ngNotify',
    function (blockUI, $translate, $scope, ngTableParams, $http, Alertify, ngNotify) {
        var controller = this;
        controller.lstObjeto = [];
        controller.listaTodos = [];
        controller.objDato = undefined;
        controller.objEliminar = undefined;
        controller.objInsertar = {};

        controller.tableParams = new ngTableParams({
            page: 1,                    // show first page
            count: 10,                      // count per page
            sorting: {
                codigo: 'desc'     // initial sorting
            }
        }, {
            total: 0,           // length of data
            getData: function ($defer, params) {
                var paramFilter = {
                    "firstResult": (params.page() - 1) * params.count(),
                    "itemPerPage": params.count(),
                    "filterByFields": params.filter(),
                    "orderBy": params.sorting()
                };
                blockUI.start();
                var response = $http.post('listarRazaPaginado_json.json', paramFilter);
                response.success(function (data, status, headers, config) {
                    controller.lstObjeto = data.items;
                    $scope.items = data.items;
                    params.total(data.totalCount);
                    $defer.resolve(data.items);
                    blockUI.stop();
                });
                response.error(function (data, status, headers, config) {
                    ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                    blockUI.stop();
                });
            }
        });


        controller.cancelar = function () {
            controller.objDato = undefined;
        };

        controller.nuevo = function () {
            controller.objDato = {};

        };

        controller.guardar = function (obj) {
            controller.objInsertar = angular.copy(obj);
            var tipo;
            tipo = controller.buscarObjetoPorCampo(controller.listaTodos,'idTipo',controller.objInsertar.idTipo);
            controller.objInsertar.tipo = angular.copy(tipo);
            blockUI.start();
            var response = $http.post('registrarRaza_json.json', controller.objInsertar);
            response.success(function (data, status, headers, config) {
                ngNotify.set('Proceso ejecutado correctamente', 'success');
                controller.tableParams.reload();
                controller.cancelar();
                blockUI.stop();
            });
            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.eliminar = function (obj) {
            controller.objEliminar = angular.copy(obj);
            var tipo;
            tipo = controller.buscarObjetoPorCampo(controller.listaTodos,'idTipo',controller.objInsertar.idTipo);
            controller.objEliminar.tipo = angular.copy(tipo);
            blockUI.start();

            var response = $http.post('eliminarRaza_json.json', controller.objEliminar);
            response.success(function (data, status, headers, config) {
                ngNotify.set('Registro eliminado correctamente', 'success');
                controller.tableParams.reload();
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaTipos = function () {
            blockUI.start();

            var response = $http.post('listarTipo_json.json', controller.objEliminar);
            response.success(function (data, status, headers, config) {
                controller.listaTodos = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.buscarObjetoPorCampo = function (lista, campo, valor) {
            var obj = undefined;
            if (_.isNull(valor)
                || angular.isUndefined(valor)) {
                return obj;
            }
            if (angular.isArray(lista)) {
                for (var i = 0; i < lista.length; i++) {
                    if (String(lista[i][campo]).trim() == String(valor).trim()) {
                        obj = lista[i];
                        break;
                    }
                }
            }
            return obj;
        };

        controller.listaTipos();


    }]);