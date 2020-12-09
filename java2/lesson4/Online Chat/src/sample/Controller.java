package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;
    @FXML
    private TextArea textArea;
    @FXML
    public ListView<String> friendsListView;

    @FXML
    public void initialize(){
        friendsListView.setItems(FXCollections.observableArrayList(Main.FRIENDS_LIST));
    }
    @FXML
    public void sendText(){
        if (textField.getText().length() != 0)
        {
            textArea.appendText(textField.getText()+ '\n');
            textField.clear();
        }
    }

}
