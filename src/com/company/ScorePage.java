package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePage extends JFrame {

    private ImageIcon img;
    private JLabel img_label,text_label,text_label2;
    private JButton play_btn;
    ScorePage(String username, int score){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,50,750,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        img = new ImageIcon(getClass().getResource("score.png"));
      //  ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("score.png"));
        Image img2 = img.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);

        img_label = new JLabel(img3);
        img_label.setBounds(10,200,300,250);
        add(img_label);

        text_label = new JLabel("Thank You "+username+" for Exam Java MCQ");
        text_label.setBounds(45,30,700,30);
        text_label.setFont(new Font("Arail",Font.PLAIN,26));
        add(text_label);

        text_label2 = new JLabel("Your Score is " + score);
        text_label2.setBounds(350,200,300,30);
        text_label2.setFont(new Font("Jokerman",Font.PLAIN,26));
        text_label2.setForeground(new Color(0xc71585));
        add(text_label2);

        play_btn = new JButton("Play Again");
        play_btn.setBackground(Color.blue);
        play_btn.setForeground(Color.white);
        play_btn.setBounds(400,270,120,30);
        add(play_btn);

        Handler handler = new Handler();
        play_btn.addActionListener(handler);

    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new SimpleMinds().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ScorePage("",0).setVisible(true);
    }
}
