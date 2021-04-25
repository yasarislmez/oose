/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.urunDAO;
import Entity.urunler;
import java.util.List;

/**
 *
 * @author ubuntu
 */
public class urunController {
    
    private List<urunler> ulist ;
    private urunler urunler;
    private urunDAO udao;

    public List<urunler> getUlist() {
        return ulist;
    }

    public void setUlist(List<urunler> ulist) {
        this.ulist = ulist;
    }

    public urunler getUrunler() {
        return urunler;
    }

    public void setUrunler(urunler urunler) {
        this.urunler = urunler;
    }

    public urunDAO getUdao() {
        return udao;
    }

    public void setUdao(urunDAO udao) {
        this.udao = udao;
    }
    
}
