/**
 * @(#)UsoClienteUDP.java
 *
 *
 * @author 
 * @version 1.00 2011/6/15
 */

package proyecto;

public class UsoClienteUDP
{
	public static void main(String [] args)
	{
		ClienteUDP c = new ClienteUDP("192.168.2.106");
		c.setVisible(true);
		c.iniciarSockets();
		c.recibirPaquete();
	}
}