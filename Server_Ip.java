import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ip {
    public static void main(String[] args) {
        try{
            int puerto = 4500;
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor en linea "+puerto);

            Socket cliente = serverSocket.accept();
            System.out.println("Conexion establecida" + cliente.getInetAddress().getHostAddress());

            while (true) {


                DataInputStream entrada = new DataInputStream(cliente.getInputStream());

                String mensaje = (String)entrada.readUTF();
                System.out.println(mensaje);


            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

