app.controller('MantenimientoEmpleado', ['blockUI', '$translate',
    '$scope', 'ngTableParams', '$http', 'Alertify', 'ngNotify',
    function (blockUI, $translate, $scope, ngTableParams, $http, Alertify, ngNotify) {
        var controller = this;
        controller.lstObjeto = [];
        controller.listaTodos = [];
        controller.listaGeneros = [];
        controller.objDato = undefined;
        controller.objEliminar = undefined;
        controller.objInsertar = {};
        controller.objPerona = {};
        controller.objDireccion = {};
        controller.objEmpleado = {};
        controller.objGenero = {};

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
                var response = $http.post('listarEmpleadoPaginado_json.json', paramFilter);
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
            controller.objPersonaInsertada = {};
            controller.objGenero = controller.buscarObjetoPorCampo(controller.listaGeneros, 'idGenero', controller.objInsertar.idGenero);
            controller.objPersona = {
                nombre: angular.copy(obj.nombre),
                apellidoMaterno: angular.copy(controller.objInsertar.apellidoMaterno),
                apellidoPaterno: angular.copy(controller.objInsertar.apellidoPaterno),
                identificacion: angular.copy(controller.objInsertar.identificacion),
                fechaNacimiento: angular.copy(controller.objInsertar.fechaNacimiento),
                descripcion: angular.copy(controller.objInsertar.descripcion),
                correo: angular.copy(controller.objInsertar.correo),
                genero: angular.copy(controller.objGenero)
            };

            blockUI.start();
            var response = $http.post('registrarPersona_json.json', controller.objPersona);
            response.success(function (persona, status, headers, config) {
                ngNotify.set('Proceso ejecutado correctamente', 'success');
                controller.objPersonaInsertada = angular.copy(persona);
                controller.objDireccion = {
                    callePrincipal: angular.copy(controller.objInsertar.callePrincipal),
                    calleSecundaria: angular.copy(controller.objInsertar.calleSecundaria),
                    numeroCasa: angular.copy(controller.objInsertar.numeroCasa),
                    celular: angular.copy(controller.objInsertar.celular),
                    descripcionDireccion: angular.copy(controller.objInsertar.descripcion),
                    persona: angular.copy(controller.objPersonaInsertada),
                    telefono: angular.copy(controller.objInsertar.telefono)
                };
                response = $http.post('registrarDireccion_json.json', controller.objDireccion);
                response.success(function (data, status, headers, config) {
                    ngNotify.set('Proceso ejecutado correctamente', 'success');
                    controller.objEmpleado = {
                        codigo: angular.copy(obj.codigo),
                        cargo: angular.copy(controller.objInsertar.cargo),
                        descripcion: angular.copy(controller.objInsertar.descripcion),
                        persona: angular.copy(controller.objPersonaInsertada)
                    };
                    response = $http.post('registrarEmpleado_json.json', controller.objEmpleado);
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
                });
                response.error(function (data, status, headers, config) {
                    ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                    blockUI.stop();
                });
            });
            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });

        };

        controller.eliminar = function (obj) {
            controller.objEliminar = angular.copy(obj);
            blockUI.start();

            var response = $http.post('eliminarEmpleado_json.json', controller.objEliminar);
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

            var response = $http.post('listarEmpleado_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaTodos = angular.copy(data);
                blockUI.stop();
            });

            response.error(function (data, status, headers, config) {
                ngNotify.set('Ocurrio un error al retornar valores!', 'error');
                blockUI.stop();
            });
        };

        controller.listaTodosGeneros = function () {
            blockUI.start();

            var response = $http.post('listarGenero_json.json');
            response.success(function (data, status, headers, config) {
                controller.listaGeneros = angular.copy(data);
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
        controller.listaTodosGeneros();


    }]);