/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tcc.controller;

import br.com.crescer.tcc.Models.PartidaModelGet;
import br.com.crescer.tcc.Models.PartidaModelPost;
import br.com.crescer.tcc.entity.Partida;
import br.com.crescer.tcc.entity.UsuarioPartida;
import br.com.crescer.tcc.service.PartidaService;
import br.com.crescer.tcc.service.UsuarioPartidaService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luanp
 */
@RestController
@RequestMapping("/partida")
@RequiredArgsConstructor
public class PartidaController {
    
    @Autowired
    private final PartidaService partidaService;
       
    @Autowired
    private final UsuarioPartidaService usuarioPartidaService;
    
    @GetMapping("/{id}")
    public Partida getPartidaById(@PathVariable Long id) {
	return partidaService.loadById(id);
    }
    
    @GetMapping("/lista/{id}")
    public List<Partida> list(@PathVariable Long id) {
	return partidaService.lista(id);
    }
    
    @PostMapping("/nova-partida")
    public ResponseEntity<Partida> save(@RequestBody @Valid PartidaModelPost partidaModel) {
        return partidaService.save(partidaModel);
    }
    
    @GetMapping("/nova-partida/padrao/{id}")
    public PartidaModelGet getPartidaModel(@PathVariable Long id) {
        return partidaService.partidaModelRetorno(id);
    }
    
    @GetMapping("/aceita-partida/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id) {
        return usuarioPartidaService.update(id);
    }
    
    @GetMapping("/lista-jogadores/{id}")
    public List<UsuarioPartida> listaJogadores(@PathVariable Long id) {
	return usuarioPartidaService.listaDeParticipantesPartida(id);
    }
    
    @GetMapping("/sorteia-times/{id}")
    public List<UsuarioPartida> sorteiaTimes(@PathVariable Long id) {
	return usuarioPartidaService.sortearTime(id);
    }
    
    @GetMapping("/confirma-partida/{id}")
    public Partida confirmarPartida(@PathVariable Long id) {
	return partidaService.confirmarPartida(id);
    }
}
