import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaChat extends JFrame {
    private JTextArea chat;
    private JTextField texto;
    private JButton boton;

    public VentanaChat(){
        setTitle("Chat Global");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chat =  new JTextArea();
        chat.setEditable(false);
        chat.setLineWrap(true);
        chat.setWrapStyleWord(true);
        JScrollPane chatScroll = new JScrollPane(chat);

        boton = new JButton("Enviar");
        texto = new JTextField();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(texto, BorderLayout.CENTER);
        inputPanel.add(boton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(chatScroll, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);


        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarmensaje();
            }
        });

        texto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarmensaje();
            }
        });

    }

    private void  enviarmensaje(){
        String mensaje = texto.getText().trim();

        if(!mensaje.isEmpty()){
            chat.append("Tu: "+mensaje+"\n");
            texto.setText("");
        }
    }















}
