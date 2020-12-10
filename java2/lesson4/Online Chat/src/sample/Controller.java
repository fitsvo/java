package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
        this.friendsListView.setItems(FXCollections.observableArrayList(Main.FRIENDS_LIST));
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
