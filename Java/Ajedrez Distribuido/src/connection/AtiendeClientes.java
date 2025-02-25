package connection;

import ajedrezjava.getSet;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class AtiendeClientes extends Thread implements Serializable{ //Creamos proceso
	Socket socket;
	String mensaje;
	ArrayList<Socket> listaCliente;
        ArrayList<getSet> getUser;
        int cliente;
       
	AtiendeClientes(ArrayList<Socket> lista, ArrayList<getSet> getUser, Socket socket)   // Recibe el ArrayList de Sockets Cliente que actualmente se están atendiendo
		{
                this.getUser = getUser;
		this.listaCliente = lista;
		this.socket=socket;
                start();
		}
        
	public void run(){
            
		while(true){   // Bucle infinito para lectura y escritura
	  	    try {
			InputStream is = socket.getInputStream(); // Se abre flujo de lectura
                        DataInputStream flujo = new DataInputStream(is);
                        String mensaje = flujo.readUTF();
                        // Permanece escuchando hasta que alguno de los clientes le envía un mensaje
			for(int cont=0;cont<listaCliente.size();cont++)    //Cuando recibe un mensaje, lo replica a todos los Clientes recorriendo el ArrayList de Sockets y escribe al flujo de cada uno de ellos
                        {
                            OutputStream os = listaCliente.get(cont).getOutputStream();
                            DataOutputStream flujoDOS = new DataOutputStream(os);
                            flujoDOS.writeUTF(mensaje);
                        }
		          }
		      catch(Exception e) {}
		    }
		}
	}
