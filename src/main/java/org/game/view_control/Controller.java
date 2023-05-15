package org.game.view_control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import org.game.game.MainLogic;
import org.game.game.Constants;

public class Controller {

    @FXML
    public Label startLabel;
    @FXML
    public BorderPane papa;
    @FXML
    public TextField tile1;
    @FXML
    public TextField tile2;
    @FXML
    public TextField tile3;
    @FXML
    public TextField tile4;
    @FXML
    public TextField tile5;
    @FXML
    public TextField tile6;
    @FXML
    public TextField tile7;
    @FXML
    public TextField tile8;
    @FXML
    public TextField tile9;
    @FXML
    public TextField tile10;
    @FXML
    public TextField tile11;
    @FXML
    public TextField tile12;
    @FXML
    public TextField tile13;
    @FXML
    public TextField tile14;
    @FXML
    public TextField tile15;
    @FXML
    public TextField tile16;
    @FXML
    public TextField tile17;
    @FXML
    public TextField tile18;
    @FXML
    public TextField tile19;
    @FXML
    private Label scoreLabel;
    public TextField[][] gameField;
    private final Colors colors = new Colors();

    @FXML
    public void keyPressed(KeyEvent key) {
        if(startLabel.isVisible()) {
            for (int i = 0; i < 2; i++) {
                MainLogic.generateNewTile();
            }
            updateUi();
        } else {
            MainLogic.input(key.getCode().toString());
            if(MainLogic.move()) {
                updateUi();
                scoreLabel.setText(String.valueOf(MainLogic.score));
            }

        }
    }

    public void updateUi() {
        if(startLabel.isVisible()) {
            gameField = new TextField[Constants.COUNT_TILES_Q][Constants.COUNT_TILES_R];
            gameField[0][2] = tile1;
            gameField[0][3] = tile2;
            gameField[0][4] = tile3;
            gameField[1][1] = tile4;
            gameField[1][2] = tile5;
            gameField[1][3] = tile6;
            gameField[1][4] = tile7;
            gameField[2][0] = tile8;
            gameField[2][1] = tile9;
            gameField[2][2] = tile10;
            gameField[2][3] = tile11;
            gameField[2][4] = tile12;
            gameField[3][0] = tile13;
            gameField[3][1] = tile14;
            gameField[3][2] = tile15;
            gameField[3][3] = tile16;
            gameField[4][0] = tile17;
            gameField[4][1] = tile18;
            gameField[4][2] = tile19;
            startLabel.setVisible(false);
        }
        for (int q = 0; q < Constants.COUNT_TILES_Q; q++) {
            for (int r = 0; r < Constants.COUNT_TILES_R; r++) {
                if(gameField[q][r] != null) {
                    int valOfTile = MainLogic.grid.getState(q, r);
                    String style = "-fx-background-color: " + Colors.colors.get(valOfTile) +
                            "; -fx-background-radius: 50%; -fx-padding: 4; -fx-text-fill: fafafa;";
                    gameField[q][r].setStyle(style);
                    if(valOfTile != 0) gameField[q][r].setText(String.valueOf(valOfTile));
                    else gameField[q][r].setText("");
                }
            }
        }
    }

}