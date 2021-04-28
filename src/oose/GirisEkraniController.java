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

    /**
     * Initializes the controllerclass.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void urunara(ActionEvent event) {

        sayi = Integer.parseInt(urun_idTextarea.getText());
        urunDAO udao = new urunDAO();

        urun_id.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        urun_Adi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
        urun_fiyat.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));
        satis_fiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));

        urunlist = FXCollections.observableArrayList(udao.read(sayi));
        urunLİstele_tableView.setItems(urunlist);

    }

    @FXML
    private void urunEkle(ActionEvent event) {
        urunDAO udao = new urunDAO();
        urunler urun = new urunler();

        urun.setU_adi(urun_adi_id.getText());
        urun.setA_fiyati(Double.parseDouble(urun_fiyat_id.getText()));
        urun.setS_fiyati(Double.parseDouble(urun_satis_id.getText()));
        udao.create(urun);               

    }

    @FXML
    private void stoksayfasiGecis(ActionEvent event) {
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("stokGoster.fxml"));
        
          try {
                    Parent root=loader.load();
                    Stage stage =new Stage();
                    Scene scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
 
                } catch (IOException e) {
                    e.printStackTrace();
                }
        
    }

}
