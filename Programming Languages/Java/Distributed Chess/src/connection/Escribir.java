package connection;

import ajedrezjava.loadPieces;
import ajedrezjava.mainFrame;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Escribir extends Thread implements Serializable
	{
	transient Socket socket;
	String thingsSend;
        mainFrame mF;
        JButton[][] tablero;
        
        boolean mate;
        boolean replay;
        boolean keep;
        
 	public Escribir(Socket socket, mainFrame mF, int oldPosX, int oldPosY, int newPosX, int newPosY, String pieza, String Mov, boolean mate, boolean replay, boolean keep, JButton[][] tablero){      //Recibe objeto de tipo Socket para identificar el Socket que está ejecutando el proceso y
                //Objeto para recibir datos desde teclado
                this.mF = mF;
		this.socket=socket;
                this.thingsSend = "" + newPosX + ";" + newPosY + ";" + oldPosX + ";" + oldPosY + ";" + pieza + ";" + Mov + ";" + mate + ";" + replay;
		this.tablero = tablero;
                this.mate = mate;
                this.replay = replay;
                this.keep = keep;
                start();  //Inicia el Hilo, se llama automáticamente al método run()
		}

    public void run(){
                int i = 0;
                    boolean end = false;
                    try {
			while(!end){
                            loadPieces lP = new loadPieces();
                            lP.repintarCeldas(mF.tablero);
                            OutputStream os= socket.getOutputStream();
                            DataOutputStream flujoDOS = new DataOutputStream(os);
                            flujoDOS.writeUTF(thingsSend);
                            if (mate) {
                                if (replay) {
                                    mF.posPie = lP.cargeAll(0, mF.tablero);
                                    if (mF.turn.equals("B")) {
                                        mF.isActive = true;
                                    }
                                    else{
                                        mF.isActive = true;
                                    }
                                }
                            }
                            if (!keep) {
                                System.exit(0);
                            }
                            return;
                        }
                        } catch (IOException ex) {
                Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
		}
	

    

