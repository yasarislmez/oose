/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oose;

import Dao.firmaDao;
import Entity.firmalar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ubuntu
 */
public class FirmalarController implements Initializable {

    ObservableList<firmalar> firmalist;
    @FXML
    private TableView<firmalar> firmaGosterTable;
    @FXML
    private TableColumn<firmalar, String> firma_adi;
    @FXML
    private TableColumn<firmalar, Integer> gsm;
    @FXML
    private TableColumn<firmalar, String> adres;
    @FXML
    private TableColumn<firmalar, Integer> firma_id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firmaDao fdao = new firmaDao();
        firma_id.setCellValueFactory(new PropertyValueFactory<>("f_id"));
        firma_adi.setCellValueFactory(new PropertyValueFactory<>("firma_marka_yayin_adi"));
        gsm.setCellValueFactory(new PropertyValueFactory<>("Gsm"));
        adres.setCellValueFactory(new PropertyValueFactory<>("Adres"));

        firmalist = FXCollections.observableArrayList(fdao.read());
        firmaGosterTable.setItems(firmalist);
    }

}
