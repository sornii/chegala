/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chegala.MB;

import com.chegala.model.Caminhao;
import com.chegala.persistence.CaminhaoRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class CaminhaoMB implements Serializable {

    private Caminhao caminhao = new Caminhao();
    private List<Caminhao> caminhoes = CaminhaoRepositorio.getCaminhoes();
    
    public CaminhaoMB() {
    }
    
    public void novoCaminhao(){
        caminhao = new Caminhao();
    }
    
    public void listarCaminhoes(){
        caminhoes = CaminhaoRepositorio.getCaminhoes();
    }
    
    public void cadastrarCaminhao(){
        caminhao.salvar();
        listarCaminhoes();
        novoCaminhao();
    }
    
    public void excluirCaminhao(Caminhao caminhao){
        caminhao.excluir();
        
        listarCaminhoes();
    }
    
    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }
}