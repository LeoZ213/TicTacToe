package com.unbeatablettt.unbeatable_tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TicTacToe {
    private String turn;
    private Button[][] board;

    @FXML
    private Label turnLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    public void initialize() {
        this.board = new Button[][]{
                {button1, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}
        };
        turn = "O";
    }

    public boolean checkForTie() {
        for (Button[] buttons : board) {
            for (Button button : buttons) {
                if (button.getText().isBlank()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        // Check rows for win
        for (Button[] buttons : board) {
            if (buttons[0].getText().equals(buttons[1].getText())
                    && buttons[1].getText().equals(buttons[2].getText())
                    && !buttons[0].getText().isBlank()) {
                return true;
            }
        }

        // Check columns for win
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col].getText().equals(board[1][col].getText())
                    && board[1][col].getText().equals(board[2][col].getText())
                    && !board[0][col].getText().isBlank()) {
                return true;
            }
        }

        // Check diagonals for win
        if (board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())
                && !board[0][0].getText().isBlank()) {
            return true;
        }
        return board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())
                && !board[0][2].getText().isBlank();

        // No win condition found
    }

    @FXML
    public void onClicked(ActionEvent event) {
        //Gets reference to the button that got clicked
        Button button = (Button) event.getSource();
        //mark the button with the turn
        if (button.getText().isBlank()) {
            button.setText(turn);
        } else {
            return;
        }
        if (checkForWin()) {
            setWinMessage();
            disableButtons();
            return;
        }
        //changes the turn
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
        //Changes the turn on the label
        turnLabel.setText("Turn: " + turn);

        //Check for win tie
        if (checkForTie()) {
            turnLabel.setText("Draw");
            disableButtons();
        }
    }

    public void setWinMessage() {
        turnLabel.setText(turn + " won the game!");
    }

    public void disableButtons() {
        for (Button[] buttons : board) {
            for (Button button : buttons) {
                button.setDisable(true);
            }
        }
    }
}
