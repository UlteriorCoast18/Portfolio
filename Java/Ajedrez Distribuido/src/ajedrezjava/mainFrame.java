package ajedrezjava;

import connection.Escribir;
import connection.Leer;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.net.Socket;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class mainFrame extends java.awt.Frame implements ActionListener, Serializable{

    public boolean isActive = false;
    public JButton [][]tablero = new JButton[8][8];
    private int contMov = 0;
    private String lastPiece;
    private int lastPosX;
    private int lastPosY;
    private boolean selected = false;
    public String turn = "B";
    public JTextArea Mov = new JTextArea();
    JScrollPane scroll = new JScrollPane (Mov);
    
    private JButton Dama = new JButton();
    private JButton Torre = new JButton();
    private JButton Alfil = new JButton();
    private JButton Caballo = new JButton();
    
    public static getSet RUser;
    public getSet R1User = RUser;
    private static transient Socket userSocket;
    
    loadPieces lP = new loadPieces();
    chargeMoves cM = new chargeMoves();
    darMate dM = new darMate();
    public String [][]posPie;
    
    public boolean keep = true; 
    
    @Override
    public Image getIconImage() {
        Mov.setLineWrap(true);
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("img/damaB.png"));
        return retValue;
    }
    
    public mainFrame(getSet RUser, Socket userSocket){
        this.RUser = RUser;
        this.R1User = RUser;
        if (RUser.getTurn() == 'B') {
            isActive = true;
            turn = "B";
        }
        if(RUser.getTurn() == 'N'){
            isActive = false;
            turn = "N";
        }
        this.userSocket = userSocket;
        initComponents();
        cargeButtons();
        this.setTitle("Ajedrez del Acevedo y Alvarado. Usuario: "+RUser.getName());
        posPie = lP.cargeAll(contMov, tablero);
        this.setResizable(false);
        
        R1User.setPosArr(posPie);
        R1User.setMov(Mov.getText());
        
        Leer hilo1 = new Leer(this.userSocket, this.R1User, this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(552, 552));
        setMinimumSize(new java.awt.Dimension(552, 552));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setToolTipText("Ajedrez");
        mainPanel.setMaximumSize(new java.awt.Dimension(828, 552));
        mainPanel.setMinimumSize(new java.awt.Dimension(828, 552));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(828, 552));
        mainPanel.setLayout(null);
        add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargeButtons(){
        int cas = 1;    
        Mov.setName("Movimientos");
        Mov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(560, 25, 256, 320);
        mainPanel.add(scroll);
        Mov.setText("Aqui se mostrarán los movimientos realizados :D"+"\n");
        Mov.setEditable(false);
        
        Dama.setName("Dama");
        Dama.setMaximumSize(new java.awt.Dimension(64,64));
        Dama.setMinimumSize(new java.awt.Dimension(64,64));
        Dama.setPreferredSize(new java.awt.Dimension(64,64));
        Dama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Dama.setBackground(Color.decode("#888888"));
        mainPanel.add(Dama);
        Dama.setBounds(560,473,64,64);
        
        Torre.setName("Torre");
        Torre.setMaximumSize(new java.awt.Dimension(64,64));
        Torre.setMinimumSize(new java.awt.Dimension(64,64));
        Torre.setPreferredSize(new java.awt.Dimension(64,64));
        Torre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Torre.setBackground(Color.decode("#dadada"));
        mainPanel.add(Torre);
        Torre.setBounds(624,473,64,64);
        
        Alfil.setName("Torre");
        Alfil.setMaximumSize(new java.awt.Dimension(64,64));
        Alfil.setMinimumSize(new java.awt.Dimension(64,64));
        Alfil.setPreferredSize(new java.awt.Dimension(64,64));
        Alfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Alfil.setBackground(Color.decode("#888888"));
        mainPanel.add(Alfil);
        Alfil.setBounds(688,473,64,64);
        
        Caballo.setName("Torre");
        Caballo.setMaximumSize(new java.awt.Dimension(64,64));
        Caballo.setMinimumSize(new java.awt.Dimension(64,64));
        Caballo.setPreferredSize(new java.awt.Dimension(64,64));
        Caballo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Caballo.setBackground(Color.decode("#dadada"));
        mainPanel.add(Caballo);
        Caballo.setBounds(752,473,64,64);
        
        Dama.setVisible(false);
        Torre.setVisible(false);
        Alfil.setVisible(false);
        Caballo.setVisible(false);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_RIGHT);
        
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new JButton();
                //set size;
                tablero[i][j].setName(""+i+","+j);
                tablero[i][j].setMaximumSize(new java.awt.Dimension(64,64));
                tablero[i][j].setMinimumSize(new java.awt.Dimension(64,64));
                tablero[i][j].setPreferredSize(new java.awt.Dimension(64,64));
                tablero[i][j].addActionListener(this); 
                tablero[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                if (i%2==1 && j%2==1) {
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else if (i%2==0 && j%2==0) {
                    tablero[i][j].setBackground(Color.decode("#dadada"));
                }
                else{
                    tablero[i][j].setBackground(Color.decode("#888888"));
                }
                mainPanel.add(tablero[i][j]);
                tablero[i][j].setBounds(((j*64)+25),((i*64)+25),64,64);
                add(mainPanel, java.awt.BorderLayout.CENTER);
                pack();
                cas++;
            }
        }
        R1User.setPosArr(posPie);
    }
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame(RUser,userSocket).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        int posX = Integer.parseInt(e.getSource().toString().substring(20, 21));
        int posY = Integer.parseInt(e.getSource().toString().substring(22, 23));
        if (selected && turn.equals("B") && isActive) {
            if (tablero[posX][posY].getBackground().getGreen() == 255) {
                String actualText = Mov.getText() + "\n";
                posPie = lP.moverPieza(posPie[lastPosX][lastPosY], posX, posY, lastPosX, lastPosY, tablero, posPie, turn, Mov, Dama, Caballo, Torre, Alfil, R1User, userSocket);
                String newText = Mov.getText();
                String sendText = newText.replace(actualText, "");
                lP.repintarCeldas(tablero);
                boolean mate = dM.isMate(posPie, "B");
                boolean replay = false;
                if (mate == false) {
                   selected = false;
                } 
                else if (mate == true) {
                    JOptionPane.showMessageDialog(null, "GG, los blancos ganaron");
                    int reply = JOptionPane.showConfirmDialog(null, "Desea usted ganador, volver a jugar?", "Replay", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        replay = true;
                    }
                    else {
                        replay = false;
                        keep = false;
                    }
                    selected = false;
                }
                Escribir hilo2 = new Escribir(userSocket, this, lastPosX, lastPosY, posX, posY, posPie[posX][posY], sendText, mate, replay, keep, tablero);
            }
            else{   
                lP.repintarCeldas(tablero);
            }
        }
        if (selected && turn.equals("N") && isActive) {
            if (tablero[posX][posY].getBackground().getGreen() == 255) {
                String actualText = Mov.getText() + "\n";
                posPie = lP.moverPieza(posPie[lastPosX][lastPosY], posX, posY, lastPosX, lastPosY, tablero, posPie, turn, Mov, Dama, Caballo, Torre, Alfil, R1User, userSocket);
                String newText = Mov.getText();
                String sendText = newText.replace(actualText, "");
                lP.repintarCeldas(tablero);
                boolean mate = dM.isMate(posPie, "N");
                boolean replay = false;
                if (mate == false) {
                    selected = false;
                }
                else if(mate == true){
                    JOptionPane.showMessageDialog(null, "GG, los negros ganaron");
                    int reply = JOptionPane.showConfirmDialog(null, "Desea usted ganador, volver a jugar?", "Replay", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        replay = true;
                    }
                    else {
                        replay = false;
                        keep = false;
                    }
                    selected = false;
                }
                Escribir hilo2 = new Escribir(userSocket, this, lastPosX, lastPosY, posX, posY, posPie[posX][posY], sendText, mate, replay, keep, tablero);
            }
            else{
                lP.repintarCeldas(tablero);
            }
        }
        if (posPie[posX][posY] == "") {
            lP.repintarCeldas(tablero);
            selected = false;
            return;
        }
        else{
            if (posPie[posX][posY].substring(1,2).equals("B") && turn.equals("B") && isActive) {
                ejecuteAll eA = new ejecuteAll();
                selected = true;
                switch(posPie[posX][posY]){
                    case "PB":
                        cM.Peon(posPie, tablero, posX, posY, "N");
                        break;
                    case "TB":
                        cM.Torre(posPie, tablero, posX, posY, "N");
                        break;
                    case "CB":
                        cM.Caballo(posPie, tablero, posX, posY, "N");
                        break;
                    case "AB":
                        cM.Alfil(posPie, tablero, posX, posY, "N");
                        break;
                    case "DB":
                        cM.Dama(posPie, tablero, posX, posY, "N");
                        break;
                    case "RB":
                        cM.Rey(posPie, tablero, posX, posY, "B", "N");
                        break;    
                }
                lastPiece = posPie[posX][posY];
                lastPosX = posX;
                lastPosY = posY;
                selected = true;
            }
            else if(posPie[posX][posY].substring(1,2).equals("N") && turn.equals("N") && isActive){
                switch(posPie[posX][posY]){
                    case "PN":
                        cM.Peon(posPie, tablero, posX, posY, "B");
                        break;
                    case "TN":
                        cM.Torre(posPie, tablero, posX, posY, "B");
                        break;
                    case "CN":
                        cM.Caballo(posPie, tablero, posX, posY, "B");
                        break;
                    case "AN":
                        cM.Alfil(posPie, tablero, posX, posY, "B");
                        break;   
                    case "DN":
                        cM.Dama(posPie, tablero, posX, posY, "B");
                        break;
                    case "RN":
                        cM.Rey(posPie, tablero, posX, posY, "N", "B");
                        break;    
                    }
                lastPiece = posPie[posX][posY];
                lastPosX = posX;
                lastPosY = posY;
                selected = true;
            }
            else{
                return;
            }
        }
    }
    
    public void bloquearBotones(JButton[][] tablero){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j].setEnabled(false);
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
    
    public void desBloquearBotones(JButton[][] tablero){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j].setEnabled(true);
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
}
