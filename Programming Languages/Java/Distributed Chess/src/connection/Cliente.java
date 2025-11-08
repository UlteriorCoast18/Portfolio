package connection;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JTextArea;
public class Cliente implements Serializable
    { 
    Scanner entrada;          
     public Socket Cliente(String name, String ip)     {
         Socket skCliente = null;
       try         {
                        skCliente = new Socket (ip, 5000);    //hilo que lee, se envía como parámetro el Socket				   skCliente.close();         
                        skCliente.getInputStream();
                        return skCliente;
       }         
      catch (Exception e)    {  
          e.printStackTrace();      
      }
        return skCliente;
      }
}
