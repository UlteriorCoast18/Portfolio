package connection;

import Libraries.TextPrompt;
import Libraries.panelTransparente;
import ajedrezjava.getSet;
import ajedrezjava.mainFrame;
import connection.Cliente;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame implements Serializable{

    public panelTransparente Back;
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("img/damaB.png"));
        return retValue;
    }
    
    public Register() {
        this.setTitle("Registro Ajedrez de Alvarado y Acevedo");
        this.setLocationRelativeTo(null);
        initComponents();
        initComponents2();
        Back = new panelTransparente(Color.white);
        Back.setBounds(0, 0, 500, 500);
        this.add(Back);
        this.repaint();
        Registrarse.setBackground(Color.decode("#dadada"));
        Crear_Servidor.setBackground(Color.decode("#dadada"));
        Registrarse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Crear_Servidor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Crear_Servidor = new javax.swing.JButton();
        IP = new javax.swing.JTextField();
        Registrarse = new javax.swing.JButton();
        Select_Color = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel1.setText("Registrarse");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 80, 130, 50);
        getContentPane().add(Nombre);
        Nombre.setBounds(40, 180, 410, 30);

        Crear_Servidor.setText("Crear Servidor");
        Crear_Servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_ServidorActionPerformed(evt);
            }
        });
        getContentPane().add(Crear_Servidor);
        Crear_Servidor.setBounds(310, 380, 130, 30);

        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });
        getContentPane().add(IP);
        IP.setBounds(40, 230, 410, 30);

        Registrarse.setText("Registrarse");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(Registrarse);
        Registrarse.setBounds(50, 380, 110, 30);

        Select_Color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Color", "Blanco", "Negro" }));
        getContentPane().add(Select_Color);
        Select_Color.setBounds(160, 280, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed
    }//GEN-LAST:event_IPActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        if (Nombre.getText().equals("") || IP.getText().equals("") || Select_Color.getSelectedItem().toString().equals("Seleccionar Color")) {
            JOptionPane.showMessageDialog(null, "Coloca los datos adecuadamente");
            return;
        }
        else{
            ObjectOutputStream OOS = null;
            try {
                String name = Nombre.getText();
                String ip = IP.getText();
                char turn = 'A';
                if (Select_Color.getSelectedItem().toString().equals("Blanco")) {
                    turn = 'B';
                }   if (Select_Color.getSelectedItem().toString().equals("Negro")) {
                    turn = 'N';
                }   Back.removeAll();
                Crear_Servidor.setVisible(false);
                IP.setVisible(false);
                Nombre.setVisible(false);
                Registrarse.setVisible(false);
                jLabel1.setVisible(false);
                Select_Color.setVisible(false);
                JLabel usuario = new JLabel();
                usuario.setName("Esperando");
                usuario.setText("Esperando...");
                usuario.setFont(new Font("Nirmala UI", Font.BOLD, 30));
                usuario.setBounds(160, 130, 300, 50);
                JLabel info = new JLabel();
                info.setName("info");
                info.setText("Esperando usuario para conexión...");
                info.setFont(new Font("Nirmala UI", Font.ITALIC, 15));
                info.setBounds(125, 180, 500, 50);
                ImageIcon imCon2 = new ImageIcon("src/img/damaB.png");
                ImageIcon imSca2 = new ImageIcon(imCon2.getImage().getScaledInstance(104, 100, java.awt.Image.SCALE_SMOOTH));
                JLabel imgD2 = new JLabel();
                imgD2.setName("Dama");
                imgD2.setIcon(imSca2);
                imgD2.setBounds(130,240,128,128);
                ImageIcon imCon1 = new ImageIcon("src/img/damaN.png");
                ImageIcon imSca1 = new ImageIcon(imCon1.getImage().getScaledInstance(104, 100, java.awt.Image.SCALE_SMOOTH));
                JLabel imgD1 = new JLabel();
                imgD1.setName("Dama");
                imgD1.setIcon(imSca1);
                imgD1.setBounds(250,240,128,128);
                Back.add(usuario);
                Back.add(info);
                Back.add(imgD1);
                Back.add(imgD2);
                this.paint(this.getGraphics());
                String[][] posArr = new String[8][8];
                Cliente cl = new Cliente();
                Socket rcl = cl.Cliente(name, ip);
                
                getSet objget = new getSet();
                objget.setMov("");
                objget.setPosArr(posArr);
                objget.setTurn(turn);
                objget.setName(name);
                objget.setEndGame(false);
                
                //C convierten los parametros en bytes para su envío
                ByteArrayOutputStream BAS = new ByteArrayOutputStream();
                OOS = new ObjectOutputStream (BAS);
                OOS.writeObject(objget);  // this es de tipo DatoUdp
                byte[] bytes =  BAS.toByteArray(); // devuelve byte[]
                //Se envían a traves del socket
                OutputStream OS = rcl.getOutputStream();
                DataOutputStream DOS = new DataOutputStream(OS);
                DOS.write(bytes);
                System.out.println(bytes);
                
                InputStream aux = rcl.getInputStream();
                DataInputStream flujo = new DataInputStream( aux );
                System.out.println(flujo.readUTF());
                System.out.println(name);
                mainFrame mf = new mainFrame(objget, rcl);
                this.setVisible(false);
                mf.setVisible(true);
                mf.setLocationRelativeTo(null);
                
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    OOS.close();
                } catch (IOException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_RegistrarseActionPerformed

    private void Crear_ServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Crear_ServidorActionPerformed
        Back.removeAll();
        Crear_Servidor.setVisible(false);
        IP.setVisible(false);
        Nombre.setVisible(false);
        Registrarse.setVisible(false);
        jLabel1.setVisible(false);
        Select_Color.setVisible(false);
        
        JLabel usuario = new JLabel();
        usuario.setName("Conexion");
        usuario.setText("Conexión Activa");
        usuario.setFont(new Font("Nirmala UI", Font.BOLD, 30));
        usuario.setBounds(130, 130, 300, 50);
        
        JLabel info = new JLabel();
        info.setName("info");
        info.setText("El servidor está montado, ahora registrate e inicia una partida");
        info.setFont(new Font("Nirmala UI", Font.ITALIC, 15));
        info.setBounds(40, 180, 500, 50);
        
        ImageIcon imCon2 = new ImageIcon("src/img/damaB.png");
        ImageIcon imSca2 = new ImageIcon(imCon2.getImage().getScaledInstance(104, 100, java.awt.Image.SCALE_SMOOTH));
        JLabel imgD2 = new JLabel();
        imgD2.setName("Dama");
        imgD2.setIcon(imSca2);
        imgD2.setBounds(130,240,128,128);
        
        ImageIcon imCon1 = new ImageIcon("src/img/damaN.png");
        ImageIcon imSca1 = new ImageIcon(imCon1.getImage().getScaledInstance(104, 100, java.awt.Image.SCALE_SMOOTH));
        JLabel imgD1 = new JLabel();
        imgD1.setName("Dama");
        imgD1.setIcon(imSca1);
        imgD1.setBounds(250,240,128,128);
        
        Back.add(usuario);
        Back.add(info);
        Back.add(imgD1);
        Back.add(imgD2);
        this.paint(this.getGraphics());
        Servidor cl = new Servidor();
        System.out.println("Adelante");
    }//GEN-LAST:event_Crear_ServidorActionPerformed

    private void initComponents2(){
        TextPrompt name = new TextPrompt("Nombre", Nombre);
        name.changeAlpha(0.5f);
        TextPrompt ip = new TextPrompt("IP", IP);
        ip.changeAlpha(0.5f);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear_Servidor;
    private javax.swing.JTextField IP;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton Registrarse;
    private javax.swing.JComboBox<String> Select_Color;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
