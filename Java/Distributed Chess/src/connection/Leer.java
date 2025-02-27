package connection;

import ajedrezjava.darMate;
import ajedrezjava.getSet;
import ajedrezjava.loadPieces;
import ajedrezjava.mainFrame;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Leer extends Thread implements Serializable {
	transient Socket socket;
        getSet RUser;
        mainFrame mF;
        
        public Leer(Socket socket, getSet RUser, mainFrame mF)
                {
		this.socket = socket;
                this.RUser = RUser;
                this.mF = mF;
		start();
		}
	
        public void run(){
            int i = 0;
            try {
			while(true){
                                loadPieces lP = new loadPieces();
                                lP.repintarCeldas(mF.tablero);
                            
                                InputStream aux = socket.getInputStream();
				DataInputStream flujo = new DataInputStream( aux );
                                String result = flujo.readUTF();
                                String[] resuls = result.split(";");
                                
                                if (mF.Mov.getText().substring((mF.Mov.getText().length()-resuls[5].length()),mF.Mov.getText().length()).equals(resuls[5])) {}

                                if(!mF.Mov.getText().substring((mF.Mov.getText().length()-resuls[5].length()),mF.Mov.getText().length()).equals(resuls[5])){
                                    mF.Mov.setText(mF.Mov.getText()+"\n"+resuls[5]);
                                }

                                boolean active = false;

                                if (mF.isActive) {
                                    active = false;
                                }

                                if (!mF.isActive) {
                                    active = true;
                                }
                                mF.isActive = active;

                                //colocar las cosas en su lugar
                                //set vacio al bloque anterior
                                int oldPosX = Integer.parseInt(resuls[2]);
                                int oldPosY = Integer.parseInt(resuls[3]);
                                mF.posPie[oldPosX][oldPosY] = "";

                                //set a la nueva pieza
                                int newPosX = Integer.parseInt(resuls[0]);
                                int newPosY = Integer.parseInt(resuls[1]);
                                mF.posPie[newPosX][newPosY] = resuls[4];

                                //Setear el tablero del pospie con el jbuttons
                                setTableroArray(mF.tablero, mF.posPie);

                                if (resuls[6].equals("true")) {
                                    String piece = "";
                                    if (resuls[4].substring(1,2).equals("B")) {
                                        piece = "blancos";
                                    }
                                    else if(resuls[4].substring(1,2).equals("N")){
                                        piece = "negros";
                                    }
                                    JOptionPane.showMessageDialog(null, "F, haz perdido, los "+piece+" ganaron.");
                                    lP.repintarCeldas(mF.tablero);
                                    if (resuls[7].equals("true")) {
                                        mF.posPie = lP.cargeAll(0, mF.tablero);
                                        if (mF.turn.equals("B")) {
                                            mF.isActive = true;
                                        }
                                        else{
                                            mF.isActive = false;
                                        }
                                    }
                                    else{
                                        System.exit(0);
                                    }
                                    }
                                }
                            } catch (IOException ex) {
                Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e){
                
            }
			}
        
        public void setTableroArray(JButton[][] tablero, String[][] posPie){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (posPie[i][j].equals("PB")) {
                        ImageIcon imCon = new ImageIcon("src/img/peonB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("PN")) {
                        ImageIcon imCon = new ImageIcon("src/img/peonN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(35, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("CN")) {
                        ImageIcon imCon = new ImageIcon("src/img/caballoN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("CB")) {
                        ImageIcon imCon = new ImageIcon("src/img/caballoB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("AN")) {
                        ImageIcon imCon = new ImageIcon("src/img/alfilN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("AB")) {
                        ImageIcon imCon = new ImageIcon("src/img/alfilB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(51, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("TN")) {
                        ImageIcon imCon = new ImageIcon("src/img/torreN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("TB")) {
                        ImageIcon imCon = new ImageIcon("src/img/torreB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(39, 48, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("DN")) {
                        ImageIcon imCon = new ImageIcon("src/img/damaN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("DB")) {
                        ImageIcon imCon = new ImageIcon("src/img/damaB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 50, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("RN")) {
                        ImageIcon imCon = new ImageIcon("src/img/reyN.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else if (posPie[i][j].equals("RB")) {
                        ImageIcon imCon = new ImageIcon("src/img/reyB.png");
                        ImageIcon imSca = new ImageIcon(imCon.getImage().getScaledInstance(52, 52, java.awt.Image.SCALE_SMOOTH));
                        tablero[i][j].setIcon(imSca);
                    }
                    else{
                        tablero[i][j].setIcon(null);
                    }
                }
            }
        }
}
