/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author Jorge Morfinez Mojica
 */
import java.net.*;
import java.io.*;

public class ClienteTCP
{
    private Socket conexion;
    public String servidor="192.168.1.109";
    public int puerto=8080;
    public byte [] arreglo = new byte[8];
    public String mensaje="";

    public void iniciarSocket()
    {
        try{
            conexion = new Socket(servidor, puerto);
        }
        catch(IOException ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null, " ¡Error de conexión con el servidor! " + ex, " Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    public void comunicarConServidor(byte [] focos)
    {
        try{
            //Abrir los flujos de datos:
            BufferedReader entrada = new BufferedReader(
                                     new InputStreamReader(
                                     conexion.getInputStream()
                                     ));
            BufferedWriter salida  = new BufferedWriter(
				     new OutputStreamWriter(
				     conexion.getOutputStream()));
	    //Escribir al servidor:
            arreglo = focos;
            mensaje = String.valueOf(arreglo);
	    //salida.write(" El cliente solicita informacion \n");
		//	salida.flush();
			//Leer del servidor:
			System.out.println(" Texto recibido del servidor: ");
			String lectura;
			//do
		//	{
				//lectura = entrada.read();
				//if(lectura != null)
				//	System.out.println(lectura);
		//	}
			//while(lectura != null);
			//Cierre de flujos y Socket:
			//entrada.close();
			//salida.close();
			//conexion.close();
		}
		catch(IOException e){
			System.out.println(" Error de conexion! " + e);
		}
	}
}
