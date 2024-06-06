import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para el login del nuevo usuario,
 * en esta ventana se hara el tomar el nombre, para que
 * sea reconocido el usuario dentro del chat.
 *
 * Crearemos la clase, junto con todos los componentes que tendra nuestra ventana
 *
 * @Author: Alan Capilla
 */
public class VentanaLog extends JFrame {
    private VentanaChat ventanaChat =  new VentanaChat();
    private JButton chatear;
    private TextField apodo;
    private JLabel text_us, text_chat;
    public VentanaLog(){
        this.setSize(600,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));

        
        /**
         * Creamos el texto donde pondremos el nombre del chat,
         * ademas de poner el texto de complemento para el campo vacio
         * donde pondran el nickname.
         */

        //Nombre del chat
        text_chat = new JLabel("Chat Global");
        text_chat.setBounds(210,20,200,35);
        text_chat.setFont(new Font("comic sans ms",Font.ITALIC,30));
        add(text_chat);


        //Nickname
        text_us = new JLabel("Apodo: ");
        text_us.setBounds(120,90,80,25);
        text_us.setFont(new Font("Kristen ITC",Font.ITALIC,20));
        add(text_us);

        /**
         * Agregamos los textField donde almacenaremos el nombre del usuario
         */
        apodo = new TextField();
        apodo.setBounds(210,90,150,25);
        add(apodo);

        /**
         * Creamos el boton y el evento que llamara un metodo
         * para acceder al chat
         */
        chatear = new JButton("Chatear");
        chatear.setBounds(230,170,100,30);
        add(chatear);


        /**
         * Apartado para los evetos
         */

        chatear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrarChat();
            }
        });


    }


    /**
     * Metodo para acceder al chat,
     * en esta parte se verifica que el text fiel no esta vacio, en dado caso esta no entra,
     * si tiene texto entra
     */
    public void entrarChat(){
       String tx_Apodo = apodo.getText().trim();

       if (!tx_Apodo.isEmpty()){
           dispose();
           ventanaChat.setVisible(true);
       }
    }



}


