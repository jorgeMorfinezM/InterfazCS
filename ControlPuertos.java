/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author Jorge Morfinez Mojica
 */
import java.io.OutputStream;
import java.io.InputStream;
import javax.comm.CommPortIdentifier;
//import javax.comm.ParallelPort;
import parport.*;

public class ControlPuertos
{
    private CommPortIdentifier idPort;
    private ParallelPort puertoParalelo;
    private ParallelPort lpt;
    private OutputStream salida;
    private String nombre;
    public static int PARALELO=0;

    public ControlPuertos()
    {
        lpt = new ParallelPort(0x378);
    }
    public void iniciarPuerto()
    {
        try
        {
                nombre= "LPT1";
                //PARALELO = CommPortIdentifier.PORT_PARALLEL;
                idPort = CommPortIdentifier.getPortIdentifier(nombre);
                //puertoParalelo=(ParallelPort) idPort.open("Trato de conectarme!!!", 888);
               //puertoParalelo=(ParallelPort) idPort.open(nombre, 0x378);
                //salida = puertoParalelo.getOutputStream();
                System.out.println("Puerto "+nombre+" iniciado ...");
        }
        catch(Exception e)
        {
            System.out.println("Error en iniciarPuerto() \n"+e);
        }
    }
    /*public void cerrarPuerto()
    {
        try
        {
            salida.close();
        }
        catch(Exception e)
        {
            System.out.println("Error en cerrarPuerto() \n"+e);
        }

        System.out.println("Puerto "+nombre+" cerrado ...");
    }*/
    public void escribirEnPuerto(int dato)
    {
        try
        {
            //salida.write(dato);
            lpt.write(dato);

            System.out.println("Dato "+dato+" escrito en Puerto "+nombre+" ...");
        }
        catch(Exception e)
        {
            System.out.println("Error en escribirEnPuerto() \n"+e);
        }
    }
    public static void main(String args[])
    {
        try
        {
            ControlPuertos cp= new ControlPuertos();
            System.out.println("se conecto al puerto!");
            cp.iniciarPuerto();
            System.out.println("empieza a escribir en puerto!");
            //cp.escribirEnPuerto(0);
            System.out.println("envia");
            //for (int i = 0; i<5; i++)
            //{
            //    for (int j = 0; j<10; j++)
            //    {
                    cp.escribirEnPuerto(0);

            //    }
           System.out.println("termina de enviar!!!");
           // }
            //cp.cerrarPuerto();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}