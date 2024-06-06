import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ip {
    private static final int puerto = 4500;

    public static void main(String[] args) {


        try(ServerSocket serverSocket = new ServerSocket(puerto);){

            System.out.println("Servidor en linea "+puerto);


            while (true) {

                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + cliente.getInetAddress().getHostAddress());
                new ClientHandler(cliente).run();

            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class ClientHandler extends Thread{
    private Socket cliente;

    public ClientHandler(Socket cliente){
        this.cliente =  cliente;

    }

    @Override
    public void run(){
        try(
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()))
        ){

            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            String mensaje = (String)entrada.readUTF();
            System.out.println(mensaje);


        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        }finally {
            try {
                cliente.close();
            }catch (IOException e){
                System.err.println("Error al cerrar la conexión del cliente: " + e.getMessage());
            }
        }
    }
}

