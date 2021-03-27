package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPConection extends Thread{

    private Main elRecordatorio;

    public void run() {
        try {
        	
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Esperando cliente...");
            Socket socket = server.accept();
            System.out.println("Cliente esta conectado");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader breader = new BufferedReader(isr);

            
            while (true) {

                System.out.println("Esperando mensaje...");
                String mensajeRecibido = breader.readLine();
                
                System.out.println(mensajeRecibido);
                
                Gson gson = new Gson();
                Recordatorios recordatorio = gson.fromJson(mensajeRecibido, Recordatorios.class);

                System.out.println(recordatorio.getPosX());
                System.out.println(recordatorio.getPosY());
                System.out.println(recordatorio.getColor());
                System.out.println(recordatorio.getTextoRecordatorio());
                
                if(recordatorio.getEstado().contentEquals("viendo")) {
                	
                	elRecordatorio.Visualizar(recordatorio);
                	
                }else if(recordatorio.getEstado().contentEquals("confirmado")) {
                	
                	elRecordatorio.Confirmar(recordatorio);
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    

	public void setMain(Main main) {
		this.elRecordatorio = main;
		
	}
    }