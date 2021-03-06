/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.tcc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luanp
 */
@Entity
@Getter
@Setter
@Table(name = "USUARIO_GRUPO")
@JsonIgnoreProperties({"usuarioPartida"})
public class UsuarioGrupo implements Serializable{
    
    private static final String SQ_USUARIO_GRUPO = "SQ_USUARIO_GRUPO";
    
    public UsuarioGrupo(){}
    
    public UsuarioGrupo(Usuario usuario, Grupo grupo){
        this.usuario = usuario;
        this.grupo = grupo;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_USUARIO_GRUPO)
    @SequenceGenerator(name = SQ_USUARIO_GRUPO, sequenceName = SQ_USUARIO_GRUPO, allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    
    @NotNull(message = "Campo obrigatório")
    @Basic(optional = false)
    @Column(name = "ADM")
    private boolean adm;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_GRUPO")
    private Grupo grupo;
    
    @OneToMany(mappedBy="usuarioGrupo", cascade=CascadeType.ALL)
    private List<UsuarioPartida> usuarioPartida;
    
    public boolean getAdm(){
        return this.adm;
    }
}
