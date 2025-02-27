package ajedrezjava;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.net.Socket;
import javax.swing.*;

public class loadPieces implements Serializable{
    private boolean entronqueB = false;
    private boolean entronqueN = false;
    private String [][]pieza = new String[8][8];
    
    public String[][] cargeAll(int contMov, JButton[][] tablero){
        if (contMov == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i==1) {
                        ImageIcon imCon = new ImageIcon("src/img/peonN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "PN";
                    }
                    else if (i==6) {
                        ImageIcon imCon = new ImageIcon("src/img/peonB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "PB";
                    }
                    else if (i==0 && (j==1 || j==6)) {
                        ImageIcon imCon = new ImageIcon("src/img/caballoN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "CN";
                    }
                    else if (i==7 && (j==1 || j==6)) {
                        ImageIcon imCon = new ImageIcon("src/img/caballoB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "CB";
                    }
                    else if (i==0 && (j==2 || j==5)) {
                        ImageIcon imCon = new ImageIcon("src/img/alfilN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "AN";
                    }
                    else if (i==7 && (j==2 || j==5)) {
                        pieza[i][j] = "AB";
                        ImageIcon imCon = new ImageIcon("src/img/alfilB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (i == 0 && (j==0 || j==7)) {
                        ImageIcon imCon = new ImageIcon("src/img/torreN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "TN";
                    }
                    else if (i == 7 && (j==0 || j==7)) {
                        ImageIcon imCon = new ImageIcon("src/img/torreB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "TB";
                    }
                    else if (i==0 && j==3) {
                        ImageIcon imCon = new ImageIcon("src/img/damaN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "DN";
                    }
                    else if (i==7 && j==3) {
                        ImageIcon imCon = new ImageIcon("src/img/damaB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "DB";
                    }
                    else if (i==0 && j==4) {
                        ImageIcon imCon = new ImageIcon("src/img/reyN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "RN";
                    }
                    else if (i==7 && j==4) {
                        ImageIcon imCon = new ImageIcon("src/img/reyB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                        pieza[i][j] = "RB";
                    }
                    else{
                        tablero[i][j].setIcon(null);
                        pieza[i][j] = "";
                    }
                }
            }
        }
        return pieza;
    }
    
    public String[][] moverPieza(String pieza, int newPosX, int newPosY, int oldPosX, int oldPosY, JButton[][] tablero, String[][] posPie, String turn, JTextArea Mov, JButton Dama, JButton Caballo, JButton Torre, JButton Alfil, getSet objget, Socket userSocket){
        if (turn.equals("B") && tablero[newPosX][newPosY].getBackground().getGreen()==255) {
            repintarCeldas(tablero);
            repintarCeldas(tablero);
            String resJA1 = "";
            posPie[oldPosX][oldPosY] = "";
            posPie[newPosX][newPosY] = pieza;
            if (pieza.equals("PB")) {
                repintarCeldas(tablero);
                if (newPosX == 0) {
                    int selec = 0;
                    int seleccion = JOptionPane.showOptionDialog( null,"Coronar", "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Caballo", "Alfil", "Torre","Dama"},"opcion 1");
                    if (seleccion != -1){
                        selec = (seleccion + 1);
                    }
                    if (selec == 1) {
                        posPie[newPosX][newPosY] = "CB";
                        ImageIcon imCon = new ImageIcon("src/img/caballoB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Caballo blanca y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 2) {
                        posPie[newPosX][newPosY] = "AB";
                        ImageIcon imCon = new ImageIcon("src/img/alfilB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Alfil blanco y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 3) {
                        posPie[newPosX][newPosY] = "TB";
                        ImageIcon imCon = new ImageIcon("src/img/torreB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Torre blanca y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 4) {
                        posPie[newPosX][newPosY] = "DB";
                        ImageIcon imCon = new ImageIcon("src/img/damaB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Dama blanca y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    repintarCeldas(tablero);
                }else{
                    ImageIcon imCon = new ImageIcon("src/img/peonB.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    tablero[oldPosX][oldPosY].setIcon(null);
                    repintarCeldas(tablero);
                    resJA1 = "\nEl Peon blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                }
            }
            else if (pieza.equals("CB")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/caballoB.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nEl Caballo blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("TB")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/torreB.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);                
                resJA1 = "\nLa Torre blanca en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("AB")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/alfilB.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nEl Alfil blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("DB")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/damaB.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nLa Dama blanca en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("RB")) {
                repintarCeldas(tablero);
                if (oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 6 && entronqueB == false) {
                    entronqueB = true;
                    ImageIcon imCon = new ImageIcon("src/img/reyB.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    imCon = new ImageIcon("src/img/torreB.png");
                    imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[7][5].setIcon(imSca);
                    tablero[7][7].setIcon(null);
                    posPie[7][5] = "TB";
                    posPie[7][7] = "";
                    resJA1 = "\nEl Rey blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX)+" hizo entronque con la torre blanca en: "+obtainY(7)+obtainX(7);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 6 && entronqueB == true) {  
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 2 && entronqueB == false) {
                    entronqueB = true;
                    ImageIcon imCon = new ImageIcon("src/img/reyB.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    imCon = new ImageIcon("src/img/torreB.png");
                    imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[7][3].setIcon(imSca);
                    tablero[7][0].setIcon(null);
                    posPie[7][3] = "TB";
                    posPie[7][0] = "";
                    resJA1 = "\nEl Rey blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX)+" hizo entronque con la torre blanca en: "+obtainY(0)+obtainX(7);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 2 && entronqueB == true) {
                    repintarCeldas(tablero);
                }
                else{
                ImageIcon imCon = new ImageIcon("src/img/reyB.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nEl Rey blanco en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
                }
            }
        }
        else if (turn.equals("N") && tablero[newPosX][newPosY].getBackground().getGreen()==255) {
            posPie[oldPosX][oldPosY] = "";
            posPie[newPosX][newPosY] = pieza;
            repintarCeldas(tablero);
            repintarCeldas(tablero);
            String resJA1 = "";
            if (pieza.equals("PN")) {
                repintarCeldas(tablero);
                if (newPosX == 7) {
                    int selec = 0;
                    int seleccion = JOptionPane.showOptionDialog( null,"Coronar", "Selector de opciones",JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null, new Object[] { "Caballo", "Alfil", "Torre","Dama"},"opcion 1");
                    if (seleccion != -1){
                        selec = (seleccion + 1);
                    }
                    if (selec == 1) {
                        posPie[newPosX][newPosY] = "CN";
                        ImageIcon imCon = new ImageIcon("src/img/caballoN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Caballo negro y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 2) {
                        posPie[newPosX][newPosY] = "AN";
                        ImageIcon imCon = new ImageIcon("src/img/alfilN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Alfil negro y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 3) {
                        posPie[newPosX][newPosY] = "TN";
                        ImageIcon imCon = new ImageIcon("src/img/torreN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Torre negra y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    else if (selec == 4) {
                        posPie[newPosX][newPosY] = "DN";
                        ImageIcon imCon = new ImageIcon("src/img/damaN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[newPosX][newPosY].setIcon(imSca);
                        tablero[oldPosX][oldPosY].setIcon(null);
                        resJA1 = "\nEl Peon negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" coronó a Dama negra y se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                        Mov.setText(Mov.getText()+resJA1);
                        repintarCeldas(tablero);
                    }
                    repintarCeldas(tablero);
                }else{
                    ImageIcon imCon = new ImageIcon("src/img/peonN.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    tablero[oldPosX][oldPosY].setIcon(null);
                    resJA1 = "\nEl Peon negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                    repintarCeldas(tablero);
                }
            }
            else if (pieza.equals("CN")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/caballoN.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);             
                resJA1 = "\nEl Caballo negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("TN")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/torreN.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nLa Torre negra en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("AN")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/alfilN.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);                
                resJA1 = "\nEl Alfil negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("DN")) {
                repintarCeldas(tablero);
                ImageIcon imCon = new ImageIcon("src/img/damaN.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);                
                resJA1 = "\nLa Dama negra en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
            }
            else if (pieza.equals("RN")) {
                repintarCeldas(tablero);
                if (oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 6 && entronqueN == false) {
                    entronqueN = true;
                    ImageIcon imCon = new ImageIcon("src/img/reyN.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    imCon = new ImageIcon("src/img/torreN.png");
                    imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[0][5].setIcon(imSca);
                    tablero[0][7].setIcon(null);
                    posPie[0][5] = "TN";
                    posPie[0][7] = "";
                    resJA1 = "\nEl Rey negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX)+" hizo entronque con la torre negra en: "+obtainY(0)+obtainX(7);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 6 && entronqueN == true) { 
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 2 && entronqueN == false) {
                    entronqueN = true;
                    ImageIcon imCon = new ImageIcon("src/img/reyN.png");
                    ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                    tablero[newPosX][newPosY].setIcon(imSca);
                    imCon = new ImageIcon("src/img/torreN.png");
                    imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                    tablero[0][3].setIcon(imSca);
                    tablero[0][0].setIcon(null);
                    posPie[0][3] = "TN";
                    posPie[0][0] = "";
                    resJA1 = "\nEl Rey negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX)+" hizo entronque con la torre negra en: "+obtainY(0)+obtainX(0);
                    Mov.setText(Mov.getText()+resJA1);
                    repintarCeldas(tablero);
                }
                else if (oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 2 && entronqueN == true) {
                    repintarCeldas(tablero);
                }
                else{
                ImageIcon imCon = new ImageIcon("src/img/reyN.png");
                ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                realizarCambios(imSca, newPosX, newPosY, oldPosX, oldPosY, tablero);
                resJA1 = "\nEl Rey negro en: "+obtainY(oldPosY)+""+obtainX(oldPosX)+" se movió a: "+obtainY(newPosY)+""+obtainX(newPosX);
                Mov.setText(Mov.getText()+resJA1);
                repintarCeldas(tablero);
                }   
            }
        }
        else{
            repintarCeldas(tablero);
            return posPie;
        }
        repintarCeldas(tablero);
        return posPie;
    }
    
    public void repintarCeldas(JButton[][] tablero){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i%2==1 && j%2==1) {
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else if (i%2==0 && j%2==0) {
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else{
                    tablero[i][j].setBackground(Color.decode("#888888"));
                }
            }
        }
    }
    
    public void repintarCeldasN(JButton[][] tablero){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i%2==1 && j%2==1) {
                    tablero[i][j].setIcon(tablero[i][j].getIcon());
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else if (i%2==0 && j%2==0) {
                    tablero[i][j].setIcon(tablero[i][j].getIcon());
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else{
                    tablero[i][j].setIcon(tablero[i][j].getIcon());
                    tablero[i][j].setBackground(Color.decode("#888888"));
                }
            }
        }
    }
    
    public String obtainX(int posX){
        String res = "";
        if (posX == 7) {
            res = "1";
        }
        if (posX == 6) {
            res = "2";
        }
        if (posX == 5) {
            res = "3";
        }
        if (posX == 4) {
            res = "4";
        }
        if (posX == 3) {
            res = "5";
        }
        if (posX == 2) {
            res = "6";
        }
        if (posX == 1) {
            res = "7";
        }
        if (posX == 0) {
            res = "8";
        }
        return res;
    }
    
    public String obtainY(int posY){
        String res = "";
        if (posY == 0) {
            res = "A";
        }
        if (posY == 1) {
            res = "B";
        }
        if (posY == 2) {
            res = "C";
        }
        if (posY == 3) {
            res = "D";
        }
        if (posY == 4) {
            res = "E";
        }    
        if (posY == 5) {
            res = "F";
        }
        if (posY == 6) {
            res = "G";
        }
        if (posY == 7) {
            res = "H";
        }
        return res;
    }

    public void realizarCambios(ImageIcon imSca, int newPosX, int newPosY, int oldPosX, int oldPosY, JButton[][] tablero){
        tablero[newPosX][newPosY].setIcon(imSca);
        tablero[oldPosX][oldPosY].setIcon(null);
    }

    public void stopVisibility(JButton Dama, JButton Torre, JButton Alfil, JButton Caballo){
        Dama.setVisible(false);
        Dama.setIcon(null);
        Dama.setName(null);
        Torre.setVisible(false);
        Torre.setIcon(null);
        Torre.setName(null);
        Alfil.setVisible(false);
        Alfil.setIcon(null);
        Alfil.setName(null);
        Caballo.setVisible(false);
        Caballo.setIcon(null);
        Caballo.setName(null);
    }
    
}