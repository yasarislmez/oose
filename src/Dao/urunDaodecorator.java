/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import oose.urunInterface;

/**
 *
 * @author ubuntu
 */
public abstract class urunDaodecorator implements urunInterface{
    private urunInterface urundao= new urunDAO();

    public urunInterface getUrundao() {
        return urundao;
    }

    public void setUrundao(urunInterface urundao) {
        this.urundao = urundao;
    }
    
    
    
}
