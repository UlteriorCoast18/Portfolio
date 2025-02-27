package connection;

import ajedrezjava.getSet;
import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor implements Serializable{       	
   AtiendeClientes cte;
   ArrayList<Socket> listaCliente=new ArrayList();
   ArrayList<getSet> listaUsuarios = new ArrayList();
   char oldTurn = 'C';
   char turn = 'A';
   
   public Servidor()    
      {        
       try        
            {            
            ServerSocket ss = new ServerSocket (5000);			
            Socket cliente;
            int conexiones = 0;
            while(conexiones < 2 && oldTurn != turn){
                    cliente = ss.accept();
                    conexiones++;
                    InputStream is = cliente.getInputStream();
                    DataInputStream flujo = new DataInputStream(is);
//                  
//                  cliente = ss.accept();
//                  cliente.getLocalSocketAddress().toString();
//                  cliente.getOutputStream();
//                  String name = flujo.readUTF();

                    byte[] name = new byte[1024];
                    flujo.read(name);
                  
//                  listaCliente.add(cliente);
                  
//                  String info = flujo.readUTF();
//                  System.out.println(info);
//                  System.out.println("Ojos negros uwu");
//                  cte = new AtiendeClientes(listaCliente,cliente,"usu");
                  
                    ByteArrayInputStream BAIS= new ByteArrayInputStream(name); // bytes es el byte[]
                    ObjectInputStream OIS = new ObjectInputStream(BAIS);
                    getSet objget = (getSet)OIS.readObject();
                    
                    if (oldTurn == 'C') {
                        turn = objget.getTurn();
                        if (turn == 'N') {
                            oldTurn = 'B';
                        }
                        else{
                            oldTurn = 'N';
                        }
                        System.out.println(objget.getName());
                            //verificar si tiene o no el mismo turno
                            turn = objget.getTurn();
                            System.out.println(conexiones);
                            
                            BAIS.close();
                            OIS.close();
                            
                            listaUsuarios.add(objget);
                            listaCliente.add(cliente);
                            cte = new AtiendeClientes(listaCliente,listaUsuarios,cliente);
                    }
                    else{
                        if (oldTurn == objget.getTurn()) {
                            System.out.println(objget.getName());
                            //verificar si tiene o no el mismo turno
                            turn = objget.getTurn();
                            System.out.println(conexiones);
                            
                            BAIS.close();
                            OIS.close();
                            
                            listaUsuarios.add(objget);
                            listaCliente.add(cliente);
                            cte = new AtiendeClientes(listaCliente,listaUsuarios,cliente);
                        }
                        else{
                            cliente.close();
                            conexiones--;
                        }
                    }
                }
                if (conexiones == 2) {
                    for (int i = 0; i < listaCliente.size(); i++) {
                        OutputStream OS = listaCliente.get(i).getOutputStream();
                        DataOutputStream DOS = new DataOutputStream(OS);
                        System.out.println(listaUsuarios.get(i).getName());
                        String realCon = "TODO CONECTADO";
                        DOS.writeUTF(realCon);
                        System.out.println(realCon);
                    }
                }
            }        
           catch (Exception e){    
               System.out.println("error; "+e.getMessage());   
           }    
     }    
     }
