app.controller('MantenimientoTipo', ['blockUI', '$translate', 'servicio-tipo',
    '$scope', 'ngTableParams', '$http', 'Alertify', 'ngNotify',
    function (blockUI, $translate, servicioTipo, $scope, ngTableParams, $http, Alertify,ngNotify) {
        var controller = this;
        controller.lstTipo = [];
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
                    "orderBy": params.sorting()};
                blockUI.start();
                var response = $http.post('listarTipoPaginado_json.json', paramFilter);
                response.success(function (data, status, headers, config) {
                    controller.lstTipo = data.items;
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

        controller.guardar = function(obj){
            controller.objInsertar = angular.copy(obj);
            blockUI.start();
            var response = $http.post('registrarTipo_json.json', controller.objInsertar);
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
            blockUI.start();

            var response = $http.post('eliminarTipo_json.json', controller.objEliminar);
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


        controller.validaDato = function (dato) {
            var filtro = '1234567890';
            controller.objDato.valor = '';
            controller.objDato.valor = validarCaracteres(dato, filtro);
        };

        function validarCaracteres (texto, filtro) {
            var out = '';
            if (texto != undefined) {
                for (var i = 0; i < texto.length; i++) {
                    if (filtro.indexOf(texto.charAt(i)) != -1) {
                        out += texto.charAt(i);
                    }
                }
            }

            return out;
        }


    }]);