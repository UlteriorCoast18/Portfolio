package ajedrezjava;

import javax.swing.JButton;


public class getSet implements java.io.Serializable {
    
    private String[][] posArr;
    private String mov;
    private char turn;
    private String name;
    private boolean endGame;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
    
    public String[][] getPosArr() {
        return posArr;
    }

    public void setPosArr(String[][] posArr) {
        this.posArr = posArr;
    }

    public String getMov() {
        return mov;
    }

    public void setMov(String mov) {
        this.mov = mov;
    }

    public char getTurn() {
        return turn;
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }
}
