app.controller('MantenimientoAnimal', ['blockUI', '$translate',
    '$scope', 'ngTableParams', '$http', 'Alertify', 'ngNotify',
    function (blockUI, $translate, $scope, ngTableParams, $http, Alertify, ngNotify) {
        var controller = this;
        controller.lstObjeto = [];
        controller.listaTodos = [];
        controller.listaRaza = [];
        controller.listaColor = [];
        controller.listaTamano = [];
        controller.listaSituacion = [];
        controller.listaEstado = [];
        controller.objDato = undefined;
        controller.objDatoEditar = false;
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
                var response = $http.post('listarAnimalPaginado_json.json', paramFilter);
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
            controller.objDatoEditar = false;
        };

        controller.nuevo = function () {
            controller.objDato = {};
            controller.objDatoEditar = false;

        };

        controller.guardar = function (obj) {
            controller.objInsertar = angular.copy(obj);
            var raza, color, tamano, situacion, estado;
            raza = controller.buscarObjetoPorCampo(controller.listaRaza, 'idRaza', controller.objInsertar.idRaza);
            color = controller.buscarObjetoPorCampo(controller.listaColor, 'idColor', controller.objInsertar.idColor);
            tamano = controller.buscarObjetoPorCampo(controller.listaTamano, 'idTamano', controller.objInsertar.idTamano);
            situacion = controller.buscarObjetoPorCampo(controller.listaSituacion, 'idSituacion', controller.objInsertar.idSituacion);
            estado = controller.buscarObjetoPorCampo(controller.listaEstado, 'idEstado', controller.objInsertar.idEstado);
            controller.objInsertar.raza = angular.copy(raza);
            controller.objInsertar.color = angular.copy(color);
            controller.objInsertar.tamano = angular.copy(tamano);
            controller.objInsertar.situacion = angular.copy(situacion);
            controller.objInsertar.estado = angular.copy(estado);

            blockUI.start();
            var response = $http.post('registrarAnimal_json.json', controller.objInsertar);
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
            var raza, color, tamano, situacion, estado;
            raza = controller.buscarObjetoPorCampo(controller.listaRaza, 'idRaza', controller.objInsertar.idRaza);
            color = controller.buscarObjetoPorCampo(controller.listaColor, 'idColor', controller.objInsertar.idColor);
            tamano = controller.buscarObjetoPorCampo(controller.listaTamano, 'idTamano', controller.objInsertar.idTamano);
            situacion = controller.buscarObjetoPorCampo(controller.listaSituacion, 'idSituacion', controller.objInsertar.idSituacion);
            estado = controller.buscarObjetoPorCampo(controller.listaEstado, 'idEstado', controller.objInsertar.idEstado);
            controller.objEliminar.raza = angular.copy(raza);
            controller.objEliminar.color = angular.copy(color);
            controller.objEliminar.tamano = angular.copy(tamano);
            controller.objEliminar.situacion = angular.copy(situacion);
            controller.objEliminar.estado = angular.copy(estado);
            blockUI.start();

            var response = $http.post('eliminarAnimal_json.json', controller.objEliminar);
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

        controller.verObjeto = function (obj) {
            controller.objDato = {
                idAnimal: angular.copy(obj.idAnimal),
                codigo: angular.copy(obj.codigo),
                nombre: angular.copy(obj.nombre),
                descripcion: angular.copy(obj.descripcion),
                idRaza: angular.copy(obj.raza.idRaza),
                idColor: angular.copy(obj.color.idColor),
                idTamano: angular.copy(obj.tamano.idTamano),
                idSituacion: angular.copy(obj.situacion.idSituacion),
                idEstado: angular.copy(obj.estado.idEstado)
            };

            controller.objDatoEditar = true;
        };

        controller.actualizar = function(obj){
            controller.objInsertar = angular.copy(obj);
            var raza, color, tamano, situacion, estado;
            raza = controller.buscarObjetoPorCampo(controller.listaRaza, 'idRaza', controller.objInsertar.idRaza);
            color = controller.buscarObjetoPorCampo(controller.listaColor, 'idColor', controller.objInsertar.idColor);
            tamano = controller.buscarObjetoPorCampo(controller.listaTamano, 'idTamano', controller.objInsertar.idTamano);
            situacion = controller.buscarObjetoPorCampo(controller.listaSituacion, 'idSituacion', controller.objInsertar.idSituacion);
            estado = controller.buscarObjetoPorCampo(controller.listaEstado, 'idEstado', controller.objInsertar.idEstado);
            controller.objInsertar.raza = angular.copy(raza);
            controller.objInsertar.color = angular.copy(color);
            controller.objInsertar.tamano = angular.copy(tamano);
            controller.objInsertar.situacion = angular.copy(situacion);
            controller.objInsertar.estado = angular.copy(estado);

            blockUI.start();
            var response = $http.post('actualizarAnimal_json.json', controller.objInsertar);
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

        controller.listaTodo = function () {
            blockUI.start();

            var response = $http.post('listarAnimal_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaTodos = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaRaza = function () {
            blockUI.start();

            var response = $http.post('listarRaza_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaRaza = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaColor = function () {
            blockUI.start();

            var response = $http.post('listarColor_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaColor = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaTamano = function () {
            blockUI.start();

            var response = $http.post('listarTamano_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaTamano = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaSituacion = function () {
            blockUI.start();

            var response = $http.post('listarSituacion_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaSituacion = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaEstado = function () {
            blockUI.start();

            var response = $http.post('listarEstado_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaEstado = angular.copy(data);
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

        controller.listaTodo();
        controller.listaRaza();
        controller.listaColor();
        controller.listaTamano();
        controller.listaSituacion();
        controller.listaEstado();


    }]);