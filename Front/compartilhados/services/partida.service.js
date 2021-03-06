(function () {
    'use strict';

    angular
        .module('app')
        .factory('PartidaService', partidaService);

    function partidaService($http) {

        var partidaService = {
            criar: criar,
            carregar: carregar,
            listar: listar,
            alterar: alterar,
            cancelarPartida: cancelar,
            buscarPorId: buscarPorId,
            excluirPartida: excluir,
            confirmar: confirmar,
            sortear: sortear,
            listaJogadores: listaJogadores,
            confirmarPartida : confirmarPartida

        }

        var urlBase = 'http://localhost:9090/partida';

        return partidaService;

        function criar(partida) {
            return $http.post(urlBase + '/nova-partida', partida);
        }

        function carregar(id) {
            return $http.get(urlBase + '/nova-partida/padrao/' + id);
        }

        function listar(id) {
            return $http.get(urlBase + '/lista/' + id);
        }

        function buscarPorId(id) {
            return $http.get(urlBase + "/" + id);
        }

        function alterar(grupo) {
            return $http.put(urlBase + '/alteracao/' + grupo.id, grupo);
        }

        function cancelar(id) {
            return $http.get(urlBase + '/lista');
        }

        function excluir(id) {
            return $http.get(urlBase + '/lista');
        }

        function confirmar(id) {
            return $http.get(urlBase + '/aceita-partida/' + id);
        }

        function sortear(id) {
            return $http.get(urlBase + '/sorteia-times/' + id);
        }

        function listaJogadores(id) {
            return $http.get(urlBase + '/lista-jogadores/' + id);
        }

        function confirmarPartida(id) {
            return $http.get(urlBase + '/confirma-partida/' + id);
        }




    }

}());