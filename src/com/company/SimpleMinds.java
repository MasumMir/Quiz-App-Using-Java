package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;

public class SimpleMinds extends JFrame {

    private ImageIcon img;
    private JLabel img_label,text_label1,text_label2;
    private JTextField textField;
    private JButton exit_btn,rules_btn;
    private Font font;
    SimpleMinds(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100,50,1000,410);
        setLayout(null);
        getContentPane().setBackground(Color.white);


        img = new ImageIcon(getClass().getResource("img/resizedImage.png"));
        font = new Font("Arial",Font.BOLD,30);
        
        img_label = new JLabel(img);
        img_label.setBounds(0,0,600,410);
        add(img_label);

        text_label1 = new JLabel("Simple Minds");
        text_label1.setBounds(700,50,200,30);
        text_label1.setFont(font);
        text_label1.setForeground(Color.blue);
        add(text_label1);

        text_label2 = new JLabel("Enter Your Name");
        text_label2.setBounds(730,100,200,30);
        text_label2.setForeground(Color.blue);
        text_label2.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,15));
        add(text_label2);

        textField = new JTextField();
        textField.setBounds(710,140,170,20);
        textField.setFont(new Font("Arial",Font.BOLD,13));
        textField.setHorizontalAlignment(JTextField.CENTER);
        add(textField);

        rules_btn = new JButton("Rules");
        rules_btn.setBounds(710,190,70,30);
        rules_btn.setBackground(Color.blue);
        rules_btn.setForeground(Color.white);
        add(rules_btn);

        exit_btn = new JButton("Exit");
        exit_btn.setBounds(810,190,70,30);
        exit_btn.setBackground(Color.blue);
        exit_btn.setForeground(Color.white);
        add(exit_btn);

        Handler handler = new Handler();
        rules_btn.addActionListener(handler);
        exit_btn.addActionListener(handler);

        setVisible(true);

    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
              if(e.getSource() == rules_btn){
                    String name = textField.getText();
                    new RulesPage(name).setVisible(true);

              }else{
               System.exit(0);
              }
        }
    }

    public static void main(String[] args) {
        new SimpleMinds();

    }
}
