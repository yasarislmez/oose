/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oose;

import Dao.urunDAO;
import Entity.urunler;
import com.sun.deploy.util.FXLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class GirisEkraniController implements Initializable {

    ObservableList<urunler> urunlist;
    private int sayi;

    /*Tanımlamalar*/
    @FXML
    private MenuBar menubar;
    @FXML
    private TextField urun_idTextarea;
    @FXML
    private TextField urun_adi_id;
    @FXML
    private TextField urun_fiyat_id;
    @FXML
    private TextField urun_satis_id;
    @FXML
    private Button urunArabutton;
    
    @FXML
    private Button create_update_button;
    
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    
    @FXML
    private TableView<urunler> urunLİstele_tableView;
    @FXML
    private Label toplamSatisLabel;
    @FXML
    private TableColumn<urunler, Integer> urun_id;
    @FXML
    private TableColumn<urunler, String> urun_Adi;
    @FXML
    private TableColumn<urunler, Double> urun_fiyat;

    @FXML
    private TableColumn<urunler, Double> satis_fiyati;
    @FXML
    private MenuItem stokgoster;
    @FXML
    private TableColumn<?, ?> indirim;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        create_update_button.setDisable(true);
    }
    
    @FXML
    private void urunara(ActionEvent event) {

        sayi = Integer.parseInt(urun_idTextarea.getText());
        urunDAO udao = new urunDAO();

        urun_id.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        urun_Adi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
        urun_fiyat.setCellValueFactory(new PropertyValueFactory<>("a_fiyati"));
        satis_fiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));

        urunlist = FXCollections.observableArrayList(udao.read(sayi));
        urunLİstele_tableView.setItems(urunlist);
        

    }

    @FXML
    private void showInsertButton(ActionEvent event) {                      
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        create_update_button.setText("Ekle");
        create_update_button.setDisable(false);        
    }

    @FXML
    private void showEditButton(ActionEvent event) {               
        editButton.setDisable(false);
        create_update_button.setDisable(true);
        create_update_button.setText("Güncelle");
        deleteButton.setDisable(true);
    }
    @FXML
    private void showDeleteButton(ActionEvent event) {
        
        deleteButton.setDisable(false);
        editButton.setDisable(true);
        create_update_button.setDisable(true);
    }
    @FXML
    private void urunEdit(ActionEvent event) {  
        create_update_button.setDisable(false);
        create_update_button.setText("Güncelle");        
        sayi = Integer.parseInt(urun_idTextarea.getText());
        urunDAO udao = new urunDAO();
        ArrayList<urunler> list = (ArrayList<urunler>) udao.read(sayi);
        urunler urun = list.get(0);
        System.out.println(urun);
        urun_adi_id.setText(urun.getU_adi());
        urun_fiyat_id.setText(urun.getA_fiyati() + "");
        urun_satis_id.setText((urun.getS_fiyati() + ""));

    }

    @FXML
    private void urunDelete(ActionEvent event) {
        sayi = Integer.parseInt(urun_idTextarea.getText());
        urunDAO udao = new urunDAO();
        udao.delete(sayi);
        urunara(event);

    }

    @FXML
    private void urunEkle(ActionEvent event) {// Ekle Güncelleme
        urunDAO udao = new urunDAO();
        urunler urun = new urunler();

        urun.setU_adi(urun_adi_id.getText());
        urun.setA_fiyati(Double.parseDouble(urun_fiyat_id.getText()));
        urun.setS_fiyati(Double.parseDouble(urun_satis_id.getText()));
        if(sayi > 0){// sayi == id if id > 0 Update else insert
            urun.setU_id(sayi);
            udao.update(urun);                        
            create_update_button.setText("Ekle");
            urunara(event);
        }
        else{
            udao.create(urun);
        }
        
        urun_adi_id.setText("");
        urun_fiyat_id.setText("");
        urun_satis_id.setText((""));    
        create_update_button.setDisable(true);
                
    }

    @FXML
    private void stoksayfasiGecis(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("stokGoster.fxml"));

        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
