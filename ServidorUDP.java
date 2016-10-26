/**
 * @(#)ServidorUDP.java
 *
 *
 * @author Jorge Morfinez Mojica
 * @version 1.00 2011/6/15
 */
package proyecto;

import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ServidorUDP extends Frame
{
	private TextArea pantalla;
	private TextField captura;
	private Panel p;
	private Label etiq;
	private InetAddress host;
	private DatagramPacket paqEnviado;
	private DatagramPacket paqRecibido;
	private DatagramSocket envia;
	private DatagramSocket recibe;
        

	public ServidorUDP()
	{
		super(" Servidor UDP");
		setSize(400, 400);
		setLocation(100, 300);
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
				pantalla.append(" Servidor: " + captura.getText() + "\n");
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
			recibe = new DatagramSocket(5000);
			//devuelve -1 si el socket no esta conectado, es decir, que no haya envio/recepcion
			System.out.println(" Puerto de envio:     " + envia.getPort());
			System.out.println(" Puerto de recepcion: " + recibe.getPort());
		}
		catch(SocketException e)
		{
			System.out.println(" Error de socket " + e);
		}
	}
	public void enviarPaquete()
	{
		String mensaje = captura.getText();
		byte[] arreglo = new byte[100];
		arreglo = mensaje.getBytes();
		paqEnviado = new DatagramPacket(arreglo, arreglo.length, host, 5001);

		try
		{
			envia.send(paqEnviado);
		}
		catch(Exception e)
		{
			System.out.println(" Error el envia el paquete! " + e);
		}
	}
	public void recibirPaquete()
	{
		while(true)
		{
			//arreglo = arre;
                        byte[] arreglo = new byte[8];
			paqRecibido = new DatagramPacket(arreglo, arreglo.length);

			try
			{
				recibe.receive(paqRecibido);
				String mensaje = new String(paqRecibido.getData());
				host = paqRecibido.getAddress();
                                System.out.println(" Mensaje: "+mensaje);
				pantalla.append(host.getHostName() + ": " + mensaje.trim() + "\n");
                                javax.swing.JOptionPane.showMessageDialog(null, " Host del cliente: " + host.getHostName() + ", envio: " + mensaje.trim(), " Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				System.out.println(" Error al recibir paquete! " + e);
			}
		}
	}

        public static void main(String [] args)
	{
		ServidorUDP s = new ServidorUDP();
		s.setVisible(true);
		s.iniciarSockets();
		s.recibirPaquete();
	}
}
