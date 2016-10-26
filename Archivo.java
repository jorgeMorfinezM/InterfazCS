/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author Jorge
 */
import java.io.*;
public class Archivo
{
        public String nombrearchivo;
	public File escribirArchivo(String mensaje)
        {
            if(mensaje.equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, " Imposible abrir el archivo para escribir ", " Archivo ", javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
        else{
        nombrearchivo = "datosfocos" + ".txt";
    	//String dir = "C:/Historiales aspirantes";

        //boolean existe;
    	//existe = new File(dir).mkdir();

        File arch = new File(nombrearchivo);
    	FileWriter escribir;
        //Date date = new Date();

    	try
    	{
     	    escribir = new FileWriter(arch);
            PrintWriter pw = new PrintWriter(arch);
            pw.println(mensaje);
            
            pw.close();
            escribir.close();
        }
        catch(IOException e)
    	{
            javax.swing.JOptionPane.showMessageDialog(null, " Imposible abrir el archivo para escribir ", " Archivo ", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    	}
        catch(Exception e){
            e.printStackTrace();
        }
        return arch;
        }
        }
        public static String[] leerCadenas(String archivo)
	{
		try{
			BufferedReader x = new BufferedReader(
					   new FileReader(archivo));
			String cadena = "";
			int cont=0;
			while((cadena=x.readLine())!=null){
			      cont++;
			}
			//System.out.println("Numero de lineas: " + cont);
			String [] valores = new String[cont];
			x.close();
			x = new BufferedReader(
			    new FileReader(archivo));
			cont = 0;
			while((cadena=x.readLine())!=null){
			      valores[cont] = cadena;
			      //System.out.println("valores["+cont+"] = " + valores[cont]);
			      cont++;
			}
			x.close();
			return valores;
		}
		catch(IOException exc)
		{
			System.out.println("Imposible abrir el archivo para leer!" + exc);
		}
		return null;
	}
	public static boolean buscaCadena(String cad, String nombreArchivo)
	{
		boolean esta=true;
		try{
		     BufferedReader x = new BufferedReader(
			                new FileReader(nombreArchivo));
		     String cadena="";
		     while((cadena=x.readLine())!=null){
		           if(cadena.equals(cad)){
		               esta=true;
			       break;
			   }
		           else
		               esta=false;
		     }
		     x.close();
		     return esta;
		}
		catch(IOException exc){
			System.out.println("Imposible abrir el archivo para buscar!" + exc);
		}
		return false;
	}
	public static boolean buscaPalabra(String palabra, String nombreArchivo)
	{
		boolean esta=true;
		try{
		     BufferedReader x = new BufferedReader(
			                new FileReader(nombreArchivo));
		     String cadena="";
		     while((cadena=x.readLine())!=null){
		           if(cadena.indexOf(palabra)!=-1){
		               esta=true;
			       break;
			   }
		           else
		               esta=false;
		     }
		     x.close();
		     return esta;
		}
		catch(IOException exc){
			System.out.println("Imposible abrir el archivo para buscar!" + exc);
		}
		return false;
	}
}

