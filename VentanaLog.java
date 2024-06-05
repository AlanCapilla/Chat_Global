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

        componentsGIU();
    }

    public void componentsGIU(){
        botones();
        labels();
        textfiel();
    }

    public void botones(){
        chatear = new JButton("Chatear");
        chatear.setBounds(230,170,100,30);
        add(chatear);

        chatear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ventanaChat.setVisible(true);
            }
        });
    }
    public void textfiel(){
        apodo = new TextField();
        apodo.setBounds(210,90,150,25);
        add(apodo);

    }
    public void labels(){
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

    }



}

