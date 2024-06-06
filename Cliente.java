
/**
 * Clase Cliente
 */
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static Socket cliente;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion=0;
		try {
			cliente = new Socket("172.16.4.106", 4500);


			/***** ESCRIBIMOS ****/
			//Mandamos saludo al servidor
			// cerrar socket desde cliente

			menu();

		} catch(IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void menu() throws IOException {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do{
			System.out.println("Ingresa una opcion 1 para escrbir msj, 3 para salir");
			opcion = sc.nextInt();
			switch (opcion){
				case 1:
					escrbirMensaje();
					break;
				case 2:
					break;
				case 3:
					cerrarConexion();
					return;

				default:
					System.out.println("Ingresa una opcion adecuada");
			}
		}while (opcion != 3);



	}

	public static void escrbirMensaje() throws IOException {
		Scanner sc = new Scanner(System.in);
		mensaje = new DataOutputStream(cliente.getOutputStream());//DataOutputStream- envia informacion al socket del servidor

		System.out.println("Ingresa un texto");
		String txt = sc.nextLine();
		mensaje.writeUTF(txt);
		mensaje.flush();
		sc.reset();




	}
	private static DataInputStream bufferDeEntrada = null;
	private static DataOutputStream mensaje = null;
	public static void cerrarConexion() {
		try {
			bufferDeEntrada.close();
			//	bufferDeSalida.close();
			cliente.close();
		} catch (IOException e) {

		} finally {

			System.exit(0);

		}
	}
}


