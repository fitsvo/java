package ru.geekbrains.java2.chat.client.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.geekbrains.java2.chat.client.ClientChat;
import ru.geekbrains.java2.chat.client.models.Network;

import java.awt.event.MouseListener;
import java.io.IOException;

public class ViewController {

    private static String receiver;
    @FXML
    public ListView<String> usersList;

    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;
    private Network network;
    private Stage primaryStage;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(ClientChat.USERS_TEST_DATA));
        textField.requestFocus();

        usersList.setCellFactory(lv ->{
            MultipleSelectionModel<String> selectionModel = usersList.getSelectionModel();
            ListCell<String> cell = new ListCell<>();
            cell.textProperty().bind(cell.itemProperty());
            cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
                usersList.requestFocus();
                if (!cell.isEmpty()) {
                    int index = cell.getIndex();
                    if (selectionModel.getSelectedIndices().contains(index)) {
                        selectionModel.clearSelection(index);
                        receiver = null;
                    }
                    else{
                        selectionModel.select(index);
                        receiver = cell.getItem();
                    }
                    event.consume();
                }
            });

            return cell;
        });

    }

    @FXML
    private void sendMessage() {
        if (textField.getText().length() != 0) {
            String message = textField.getText();
            appendMessage("Я: " + message);
            textField.clear();

            try {
                if (receiver != null) {
                    network.sendPrivateMessage(receiver, message);
                } else {
                    network.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                String errorMessage = "Failed to send message";
                ClientChat.showNetworkError(e.getMessage(), errorMessage, primaryStage);
            }
        }
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void appendMessage(String message) {
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
    }

    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public TextField getTextField() {
        return textField;
    }

    @FXML
    public void MouseClick(MouseEvent mouseEvent) {
//        if(usersList.getSelectionModel().getSelectedItem() != null){
//            receiver = usersList.getSelectionModel().getSelectedItem();
//            textField.clear();
//            textField.appendText("to " + receiver + ": ");
//        }
    }
}