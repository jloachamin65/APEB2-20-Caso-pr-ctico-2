app.controller('MantenimientoUsuario', ['blockUI', '$translate',
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
                var response = $http.post('listarUsuarioPaginado_json.json', paramFilter);
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





    }]);