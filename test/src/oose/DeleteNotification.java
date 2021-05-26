/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oose;

/**
 *
 * @author jack
 */
public class DeleteNotification implements INotification{

    @Override
    public String getNotificaionState() {
       return "Urun Başarıyla Silindi.";
    }
    
}
