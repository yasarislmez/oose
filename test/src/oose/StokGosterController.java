/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oose;

import Dao.stokDao;
import Dao.urunDAO;
import Entity.stok;
import Entity.urunler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    ObservableList<stok> stokList;
    ObservableList<urunler> urunList;
    private int sayi;

    @FXML
    private TextField stok_idTextarea;
    @FXML
    private TableView<urunler> urunTablosu;
       
    @FXML
    private TableView<stok> stokTablosu;
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
    private Button ButtonAra;
    @FXML
    private Button ButtonGeri;
    @FXML
    private TableColumn<stok, Integer> stok_id;
    @FXML
    private TableColumn<stok, Integer> stokAdet;

    @FXML
    private Label idKontrol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stokDao Sdao = new stokDao();
        urunDAO udao = new urunDAO();

        colUrunid.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        colurunAdi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
        colAfiyati.setCellValueFactory(new PropertyValueFactory<>("a_fiyati"));
        colSfiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));
        colKategoriid.setCellValueFactory(new PropertyValueFactory<>("kategori_id"));
        colFirmaid.setCellValueFactory(new PropertyValueFactory<>("firma_id"));
        stok_id.setCellValueFactory(new PropertyValueFactory<>("stok_id"));
        stokAdet.setCellValueFactory(new PropertyValueFactory<>("adet"));
        urunList = FXCollections.observableArrayList(udao.read());
        stokList =FXCollections.observableArrayList(Sdao.read());
        urunTablosu.setItems(urunList);
        stokTablosu.setItems(stokList);
    }

    @FXML
    private void araButton(ActionEvent event) {

        if (stok_idTextarea.getText().isEmpty()) {
            idKontrol.setText("id alani bostur");
        } else {
            sayi = Integer.parseInt(stok_idTextarea.getText());
            urunDAO udao = new urunDAO();
            stokDao Sdao = new stokDao();

            colUrunid.setCellValueFactory(new PropertyValueFactory<>("u_id"));
            colurunAdi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
            colAfiyati.setCellValueFactory(new PropertyValueFactory<>("a_fiyati"));
            colSfiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));

            urunList = FXCollections.observableArrayList(udao.read(sayi));
            stokList = FXCollections.observableArrayList(Sdao.read(sayi));
            urunTablosu.setItems(urunList);
            stokTablosu.setItems(stokList);
        }
    }
    
    
    @FXML
    private void geriButton(ActionEvent event) {
        urunDAO udao = new urunDAO();
        stokDao Sdao = new stokDao();

        colUrunid.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        colurunAdi.setCellValueFactory(new PropertyValueFactory<>("u_adi"));
        colAfiyati.setCellValueFactory(new PropertyValueFactory<>("a_fiyati"));
        colSfiyati.setCellValueFactory(new PropertyValueFactory<>("s_fiyati"));
        colKategoriid.setCellValueFactory(new PropertyValueFactory<>("kategori_id"));
        colFirmaid.setCellValueFactory(new PropertyValueFactory<>("firma_id"));
        urunList = FXCollections.observableArrayList(udao.read());
        stokList = FXCollections.observableArrayList(Sdao.read());
        urunTablosu.setItems(urunList);
        stokTablosu.setItems(stokList);
        stok_idTextarea.setText("");
    }

    }


