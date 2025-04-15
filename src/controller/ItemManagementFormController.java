package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.util.ArrayList;
import java.util.Observable;

public class ItemManagementFormController {
    public TextField txtId;
    public TextField txtQty;
    public TextField txtName;
    public TextField txtPrice;
    public TextField txtDescription;
    public TableView tblItem;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public Button btnAdd;
    public Button btnRemove;

    ArrayList<Item> itemList = new ArrayList<>();

    //METHOD TO ADD ITEM TO THE ARRAYLIST

    public void addItemOnAction(javafx.event.ActionEvent actionEvent) {
        itemList.add(new Item(Integer.parseInt(txtId.getText()),txtName.getText(),Integer.parseInt(txtQty.getText()),Double.parseDouble(txtPrice.getText()),txtDescription.getText()));


        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

        itemList.forEach(item -> {
            itemObservableList.add(item);
        });

        tblItem.setItems(itemObservableList);
    }

    //remove
    public void removeItemOnAction(ActionEvent actionEvent) {
        Item selected =(Item) tblItem.getSelectionModel().getSelectedItem();
        if(selected != null){
            itemList.remove(selected);
            updateTable();
            clearFields();
            btnAdd.setText("Add Item");
        }
    }

    private void clearFields() {
        ObservableList<Item> observableList = FXCollections.observableArrayList(itemList);
        tblItem.setItems(observableList);
    }

    private void updateTable() {
        txtId.clear();
        txtName.clear();
        txtQty.clear();
        txtPrice.clear();
        txtDescription.clear();
    }

    //update


}
