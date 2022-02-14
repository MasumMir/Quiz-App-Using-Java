package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesPage extends JFrame {

    private JLabel text1,text2;
    private JButton back_btn,start_btn;
    String username;
    RulesPage(String username){
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100,50,1000,600);
        getContentPane().setBackground(Color.white);


        text1 = new JLabel("Welcome "+username+" to Quiz App");
        text1.setBounds(60,10,500,30);
        text1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
        text1.setForeground(Color.blue);
        add(text1);

        text2 = new JLabel();
        text2.setBounds(30,70,900,300);
        text2.setText(
                "<html>"+
                        "1. The interviewer should be an active listener. He should not interrupt unnecessarily." + "<br><br>" +
                        "2. The interviewer should be considerate enough. Even if the interviewer does not agree with the interviewee, he must respect the latter’s feelings." + "<br><br>" +
                        "3. The interviewer should be friendly and understanding. He should begin the interview in a friendly manner, some friendly conversation and then show concern in family background, hobbies, etc. This will make the interviewee more relaxed and comfortable." + "<br><br>" +
                        "4. The interviewer should restrain to the time allotted. He shouldn’t indulge in arguments unnecessarily. He should try to be precise." + "<br><br>" +
                        "5. The interviewer must be thoroughly prepared for the questions that are likely to be asked. He should be a good planner." + "<br><br>" +
                        "6. The interviewer must focus attention on the interviewee. He should use positive gestures when conducting the interview." + "<br><br>" +
                        "7. Encourage/invite questions from the interviewee. Ensure that the interviewee clarifies the question he has. When selected a candidate should not feel he was not told about a certain aspect of the job." + "<br><br>" +
                        "8. Avoid distraction in the interview area.Ensure that there is no or minimal distraction where the interview is being conducted. A phone ringing all the time in the background can distract the interviewer and interviewee." + "<br><br>" +
                "<html>"
        );
        add(text2);

        back_btn = new JButton("Back");
        back_btn.setBounds(200,400,70,30);
        back_btn.setBackground(Color.blue);
        back_btn.setForeground(Color.white);
        add(back_btn);

        start_btn = new JButton("Start");
        start_btn.setBounds(600,400,70,30);
        start_btn.setBackground(Color.blue);
        start_btn.setForeground(Color.white);
        add(start_btn);

        Handler handler = new Handler();
        back_btn.addActionListener(handler);
        start_btn.addActionListener(handler);

        setVisible(true);
    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==back_btn){

                setVisible(false);
                new SimpleMinds().setVisible(true);

            }else if(e.getSource()==start_btn){
                setVisible(false);
                new QuizPage(username).setVisible(true);
            }
        }
    }


    public static void main(String[] args) {
        new RulesPage("");
    }
}
