module com.unbeatablettt.unbeatable_tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unbeatablettt.unbeatable_tictactoe to javafx.fxml;
    exports com.unbeatablettt.unbeatable_tictactoe;
}