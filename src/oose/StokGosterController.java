/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oose;

import Dao.urunDAO;
import Entity.urunler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class StokGosterController implements Initializable {

    ObservableList<urunler> urunlist;
    private int sayi;

    @FXML
    private TextField barkodTextfield;
    @FXML
    private TableView<urunler> stoktableView;
    @FXML
    private TableColumn<urunler, Integer> colUrunid;

    @FXML
    private TableColumn<urunler, String> colurunAdi;
    @FXML
    private TableColumn<urunler, Double> colAfiyati;
    @FXML
    private TableColumn<urunler, Double> colSfiyati;
    @FXML
    private TableColumn<urunler, Integer> colKategoriid;
    @FXML
    private TableColumn<urunler, Integer> colFirmaid;
    @FXML
    private Button buttonAra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    urunDAO udao = new urunDAO();

        colUrunid.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        colurunAdi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
        colAfiyati.setCellValueFactory(new PropertyValueFactory<>("a_fiyati"));
        colSfiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));
        colKategoriid.setCellValueFactory(new PropertyValueFactory<>("kategori_id"));
        colFirmaid.setCellValueFactory(new PropertyValueFactory<>("firma_id"));
        urunlist = FXCollections.observableArrayList(udao.read());
        stoktableView.setItems(urunlist);
    }

    @FXML
    private void araButton(ActionEvent event) {


    }

}
