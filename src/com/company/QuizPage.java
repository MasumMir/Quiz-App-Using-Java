package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizPage extends JFrame {

    private ImageIcon img;
    private JLabel img_label,serial,question;
    private JRadioButton option1,option2,option3,option4;
    private ButtonGroup group;
    private JButton lifeline_btn,next_btn,submit_btn;
    private String q[][] = new String[10][5];
    private String pa[][] = new String[10][1];
    private String qa[][] = new String[10][2];
    public static int count = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;

    String username;
    QuizPage(String username){
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100,50,900,600);
        getContentPane().setBackground(Color.white);

        img = new ImageIcon(getClass().getResource("img/QuizTimeNight.jpg"));
        group = new ButtonGroup();

        img_label = new JLabel(img);
        img_label.setBounds(0,0,1000,300);
        add(img_label);

        serial = new JLabel("");
        serial.setBounds(70,320,60,20);
        serial.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(serial);

        question = new JLabel("");
        question.setBounds(100,320,900,20);
        question.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java program?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "Which of the following is not a Java features?";
        q[1][1] = "Dynamic";
        q[1][2] = "Architecture Neutral";
        q[1][3] = "Use of pointers";
        q[1][4] = "Object-oriented";

        q[2][0] = "What is the return type of the hashCode() method in the Object class?";
        q[2][1] = "Object";
        q[2][2] = "int";
        q[2][3] = "long";
        q[2][4] = "void";

        q[3][0] = "In which process, a local variable has the same name as one of the instance variables?";
        q[3][1] = "Serialization";
        q[3][2] = "Variable Shadowing";
        q[3][3] = "Abstraction";
        q[3][4] = "Multi-threading";

        q[4][0] = "An interface with no fields or methods is known as a ______. ";
        q[4][1] = "Runnable Interface";
        q[4][2] = "Marker Interface ";
        q[4][3] = "Abstract Interface ";
        q[4][4] = "CharSequence Interface ";

        q[5][0] = "Which of the following is a reserved keyword in Java? ";
        q[5][1] = "object ";
        q[5][2] = "strictfp";
        q[5][3] = "main ";
        q[5][4] = "system ";

        q[6][0] = "Which keyword is used for accessing the features of a package? ";
        q[6][1] = "package ";
        q[6][2] = "import ";
        q[6][3] = "extends ";
        q[6][4] = "export ";

        q[7][0] = "What is the default encoding for an OutputStreamWriter? ";
        q[7][1] = "UTF-8 ";
        q[7][2] = "Default encoding of the host platform ";
        q[7][3] = "UTF-12 ";
        q[7][4] = "None of the above ";

        q[8][0] = "In character stream I/O, a single read/write operation performs____.";
        q[8][1] = "Two bytes read/write at a time.";
        q[8][2] = "Eight bytes read/write at a time.";
        q[8][3] = "One byte read/write at a time.";
        q[8][4] = "Five bytes read/ write at a time.";

        q[9][0] = " What is the result of the following program?";
        q[9][1] = "It prints A and B with a 1000 seconds delay between them";
        q[9][2] = "It only prints A and exits";
        q[9][3] = "It only prints B and exits";
        q[9][4] = "A will be printed, and then an exception is thrown.";

        qa[0][1] = "JDB";
        qa[1][1] = "Use of pointers";
        qa[2][1] = "int";
        qa[3][1] = "Variable Shadowing";
        qa[4][1] = "Marker Interface";
        qa[5][1] = "strictfp";
        qa[6][1] = "import";
        qa[7][1] = "Default encoding of the host platform";
        qa[8][1] = "Two bytes read/write at a time.";
        qa[9][1] = "A will be printed, and then an exception is thrown.";

        option1 = new JRadioButton("");
        option1.setBounds(100,355,400,20);
        option1.setBackground(Color.white);
        add(option1);
        option2 = new JRadioButton("");
        option2.setBounds(100,380,400,20);
        option2.setBackground(Color.white);
        add(option2);
        option3 = new JRadioButton("");
        option3.setBounds(100,405,400,20);
        option3.setBackground(Color.white);
        add(option3);
        option4 = new JRadioButton("");
        option4.setBounds(100,430,400,20);
        option4.setBackground(Color.white);
        add(option4);

        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        lifeline_btn = new JButton("50-50 Lifeline");
        lifeline_btn.setBounds(680,380,120,30);
        lifeline_btn.setBackground(Color.blue);
        lifeline_btn.setForeground(Color.white);
        lifeline_btn.setFont(new Font("Arial",Font.BOLD,12));
        add(lifeline_btn);

        next_btn = new JButton("Next");
        next_btn.setBounds(680,430,120,30);
        next_btn.setBackground(Color.blue);
        next_btn.setForeground(Color.white);
        next_btn.setFont(new Font("Arial",Font.BOLD,12));
        add(next_btn);

        submit_btn = new JButton("Submit");
        submit_btn.setBounds(680,480,120,30);
        submit_btn.setBackground(Color.blue);
        submit_btn.setForeground(Color.white);
        submit_btn.setEnabled(false);
        submit_btn.setFont(new Font("Arial",Font.BOLD,12));
        add(submit_btn);

        Handler handler = new Handler();
        next_btn.addActionListener(handler);
        submit_btn.addActionListener(handler);
        lifeline_btn.addActionListener(handler);

        start(0);
    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==next_btn){
                repaint();
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(true);
                option4.setEnabled(true);
                ans_given = 1;
                if(group.getSelection() == null){
                    pa[count][0] = "";
                }else{
                    pa[count][0] = group.getSelection().getActionCommand();
                }
                if(count == 8){
                    next_btn.setEnabled(false);
                    submit_btn.setEnabled(true);
                }
                count++;
                start(count);
            }else if(e.getSource()==submit_btn){
                ans_given = 1;
                if(group.getSelection()==null){
                    pa[count][0]="";
                }else{
                    pa[count][0] = group.getSelection().getActionCommand();
                }

                for(int i =0;i<pa.length;i++){
                    if (pa[i][0].equals(qa[i][1])){
                        score += 10;
                    }else{
                        score += 0;
                    }
                }
                setVisible(false);
                new ScorePage(username,score).setVisible(true);
            }else if(e.getSource()==lifeline_btn){
                if(count == 2 ||count == 4 || count ==6 || count ==8 || count ==9){
                    option2.setEnabled(false);
                    option3.setEnabled(false);
                }else{
                    option1.setEnabled(false);
                    option4.setEnabled(false);
                }
                lifeline_btn.setEnabled(false);

            }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        String time = "Time left - " + timer + " seconds";   //15
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma",Font.BOLD,15));

        if(timer > 0){
            g.drawString(time,680,350);
        }else{
            g.drawString("Time Up!!",680,350);
        }

        timer--;    //14

        try{
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(ans_given == 1){
            ans_given = 0;
            timer =15 ;
        }else if(timer < 0){
            timer = 15;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

                if(count == 8){
                    next_btn.setEnabled(false);
                    submit_btn.setEnabled(true);
                }
                if(count == 9){
                    if(group.getSelection()==null){
                        pa[count][0]="";
                    }else{
                        pa[count][0] = group.getSelection().getActionCommand();
                    }

                    for(int i =0;i<pa.length;i++){
                        if (pa[i][0].equals(qa[i][1])){
                            score += 10;
                        }else{
                            score += 0;
                        }
                    }
                    this.setVisible(false);
                    //new Score().setVisible(true);
                }else{
                    if(group.getSelection() == null){
                        pa[count][0]="";
                    }else{
                        pa[count][0] = group.getSelection().getActionCommand();
                    }
                    count++;
                    start(count);
                }
        }
    }

    public void start(int count){
        serial.setText(""+ (count + 1) +". ");
        question.setText(q[count][0]);
        option1.setLabel(q[count][1]);
        option1.setActionCommand(q[count][1]);
        option2.setLabel(q[count][2]);
        option2.setActionCommand(q[count][2]);
        option3.setLabel(q[count][3]);
        option3.setActionCommand(q[count][3]);
        option4.setLabel(q[count][4]);
        option4.setActionCommand(q[count][4]);
        group.clearSelection();
    }


    public static void main(String[] args) {
        new QuizPage("").setVisible(true);
    }
}
