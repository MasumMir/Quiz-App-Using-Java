package com.company;

import javax.swing.*;
import java.awt.*;

public class RulesPage extends JFrame {

    private JLabel text1,text2;
    private JButton back_btn,start_btn;
    RulesPage(String username){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100,50,600,500);
        getContentPane().setBackground(Color.white);


        text1 = new JLabel();
        text1.setBounds(20,10,500,40);
        text1.setText("Welcome "+username+" to Quiz App");
        text1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
        text1.setForeground(Color.blue);
        add(text1);


        setVisible(true);
    }

    public static void main(String[] args) {
        new RulesPage("");
    }
}
