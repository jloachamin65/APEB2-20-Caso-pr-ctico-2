'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
        ['$rootScope', '$state', '$stateParams',
            function ($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]
    )
    .config(
        ['$stateProvider', '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise('/app/form/mantenimientoInformacion');

                $stateProvider
                    .state('app', {
                        abstract: true,
                        url: '/app',
                        templateUrl: 'tpl/app.html'
                    })
                    .state('app.dashboard-v1', {
                        url: '/dashboard-v1',
                        templateUrl: 'tpl/app_dashboard_v1.html',
                        resolve: {
                            deps: ['uiLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/chart.js']);
                                }]
                        }
                    })

                    .state('access.signin', {
                        url: '/signin',
                        templateUrl: 'tpl/page_signin.html',
                        resolve: {
                            deps: ['uiLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/services/generic-service.js',
                                        'js/controllers/signin.js']);
                                }]
                        }
                    })


                    .state('app.dashboard-v2', {
                        url: '/dashboard-v2',
                        templateUrl: 'tpl/manRegistro.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['js/controllers/chart.js']);
                                }]
                        }
                    })

                    .state('access.signup', {
                        url: '/signup',
                        templateUrl: 'tpl/page_signup.html',
                        resolve: {
                            deps: ['uiLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/signup.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manTipo', {
                        url: '/mantenimientoTipo',
                        templateUrl: 'tpl/refugio/manTipo.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/services/arquitectura/refugio/servicio-tipo.js',
                                        'js/controllers/refugio/manTipo.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manRaza', {
                        url: '/mantenimientoRaza',
                        templateUrl: 'tpl/refugio/manRaza.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manRaza.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manColor', {
                        url: '/mantenimientoColor',
                        templateUrl: 'tpl/refugio/manColor.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manColor.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manEstado', {
                        url: '/mantenimientoEstado',
                        templateUrl: 'tpl/refugio/manEstado.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manEstado.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manSituacion', {
                        url: '/mantenimientoSituacion',
                        templateUrl: 'tpl/refugio/manSituacion.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manSituacion.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manTamano', {
                        url: '/mantenimientoTamano',
                        templateUrl: 'tpl/refugio/manTamano.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manTamano.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manAnimal', {
                        url: '/mantenimientoAnimal',
                        templateUrl: 'tpl/refugio/manAnimal.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manAnimal.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manGenero', {
                        url: '/mantenimientoGenero',
                        templateUrl: 'tpl/refugio/manGenero.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manGenero.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manHorario', {
                        url: '/mantenimientoHorario',
                        templateUrl: 'tpl/refugio/manHorario.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manHorario.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manRol', {
                        url: '/mantenimientoRol',
                        templateUrl: 'tpl/refugio/manRol.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manRol.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manUsuario', {
                        url: '/mantenimientoUsuario',
                        templateUrl: 'tpl/refugio/manUsuario.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manUsuario.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manEmpleado', {
                        url: '/mantenimientoEmpleado',
                        templateUrl: 'tpl/refugio/manEmpleado.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manEmpleado.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.form.manCita', {
                        url: '/mantenimientoCita',
                        templateUrl: 'tpl/refugio/manCita.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/refugio/manCita.js'
                                    ]);
                                }]
                        }
                    })

                    .state('app.ui', {
                        url: '/ui',
                        template: '<div ui-view class="fade-in-up"></div>'
                    })

                    .state('app.form', {
                        url: '/form',
                        template: '<div ui-view class="fade-in"></div>',
                        resolve: {
                            deps: ['uiLoad',
                                function (uiLoad) {
                                    return uiLoad.load('js/controllers/form.js');
                                }]
                        }
                    })


                    // pages
                    .state('app.page', {
                        url: '/page',
                        template: '<div ui-view class="fade-in-down"></div>'
                    })

                    .state('access', {
                        url: '/access',
                        template: '<div ui-view class="fade-in-right-big smooth"></div>'
                    })

                    .state('layout.app', {
                        url: '/app',
                        views: {
                            '': {
                                templateUrl: 'tpl/layout_app.html'
                            },
                            'footer': {
                                templateUrl: 'tpl/layout_footer_fullwidth.html'
                            }
                        },
                        resolve: {
                            deps: ['uiLoad',
                                function (uiLoad) {
                                    return uiLoad.load(['js/controllers/tab.js']);
                                }]
                        }
                    })

                    .state('apps', {
                        abstract: true,
                        url: '/apps',
                        templateUrl: 'tpl/layout.html'
                    })
            }
        ]
    );