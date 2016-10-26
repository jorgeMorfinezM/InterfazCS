/**
 * @(#)UsoServidorUDP.java
 *
 *
 * @author Jorge Morfinez Mojica
 * @version 1.00 2011/6/15
 */
package proyecto;

public class UsoServidorUDP
{
	public static void main(String [] args)
	{
		ServidorUDP s = new ServidorUDP();
		s.setVisible(true);
		s.iniciarSockets();
		s.recibirPaquete();
	}
}