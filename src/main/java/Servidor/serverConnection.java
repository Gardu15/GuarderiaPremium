package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverConnection implements Runnable{

	static Socket socket = null;
    List<Socket> clientSckt = new ArrayList<>();    //Array para almacenar clientes

    public serverConnection(Socket sck) {
        this.socket = sck;
        clientSckt.add(socket);
    }
	
	@Override
	public void run() {
		try {
			System.out.println("Cliente aceptado");
	        socket.setKeepAlive(true);
	        //Canal de entrada
	        DataInputStream Recibe = new DataInputStream(socket.getInputStream());
	
	        //Canal Salida
	        OutputStream flujoS = socket.getOutputStream();
	        DataOutputStream Salida = new DataOutputStream(flujoS);
	        //Leemos mensaje del Server
	        String Mensaje = Recibe.readUTF();
	        //Lista para separar recibida del cliente
	        List<String> Desplegado = new ArrayList<>(Arrays.asList(Mensaje.split(",")));
	        Statement st;
	        ResultSet rs;
	        //Iniciamos conexion
	        Conexion.Conexion();
	        st = Conexion.con.createStatement();
	        
	        
	        
		}catch (IOException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
		}
		
	}

}
