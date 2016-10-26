/**
 * @(#)ClienteUDP.java
 *
 *
 * @author 
 * @version 1.00 2011/6/15
 */
package proyecto;

import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ClienteUDP extends Frame
{
	private String         servidor;
	private TextArea       pantalla;
	private TextField      captura;
	private Panel          p;
	private Label          etiq;
	private InetAddress    host;
	private DatagramPacket paqEnviado;
	private DatagramPacket paqRecibido;
	private DatagramSocket envia;
	private DatagramSocket recibe;
        public byte[] arreglo = new byte[8];

	public ClienteUDP(String servidor)
	{
		super(" Cliente UDP");
		setSize(400, 400);
		setLocation(100, 300);
                setVisible(true);
		this.servidor = servidor;
		addComponentes();
		addEventos();
	}
	public void addComponentes()
	{
		p        = new Panel();
		etiq     = new Label("Captura el mensaje");
		captura  = new TextField(20);
		pantalla = new TextArea(20, 10);

		p.add(etiq);
		p.add(captura);
		add(p, "North");
		add(pantalla, "Center");
	}
	public void addEventos()
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		captura.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	//Ponemos el texto que se capture del TextField en el TextArea:
				pantalla.append(" Cliente: " + captura.getText() + "\n");
				enviarPaquete();
				captura.setText("");
			}
		});
	}
	public void iniciarSockets()
	{
		try
		{
			envia  = new DatagramSocket();
			recibe = new DatagramSocket(5001);
			//da la IP del nombre del cliente:
			host   = InetAddress.getByName(servidor);
			//devuelve -1 si el socket no esta conectado, es decir, que no haya envio/recepcion
			System.out.println(" Puerto de envio:     " + envia.getPort());
			System.out.println(" Puerto de recepcion: " + recibe.getPort());
		}
		catch(Exception e)
		{
			System.out.println(" Error de conexion! " + e);
		}
	}
	public void enviarPaquete(/*byte [] arre*/)
	{
		String mensaje = captura.getText();
                //arreglo=arre;
		arreglo = mensaje.getBytes();
		paqEnviado = new DatagramPacket(arreglo, arreglo.length, host, 5000);

		try
		{
			envia.send(paqEnviado);
		}
		catch(Exception e)
		{
			System.out.println(" Error al enviar el paquete! " + e);
		}
	}
	public void recibirPaquete()
	{
		while(true)
		{
			byte[] arreglo = new byte[8];
			paqRecibido = new DatagramPacket(arreglo, arreglo.length);
			try
			{
				recibe.receive(paqRecibido);
				String mensaje = new String(paqRecibido.getData());
				InetAddress origen = paqRecibido.getAddress();
				pantalla.append(origen.getHostName() + ": " + mensaje.trim() + "\n");
			}
			catch(Exception e)
			{
				System.out.println(" Error al recibir paquete! " + e);
			}
		}
	}
        
        public static void main(String [] args)
	{
		ClienteUDP c = new ClienteUDP("10.10.103.82");
		c.iniciarSockets();
		//c.recibirPaquete();
	}
}