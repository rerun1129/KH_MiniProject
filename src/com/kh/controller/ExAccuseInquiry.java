package com.kh.controller;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.*;

import com.kh.view.Admin;
import com.kh.view.User;


public class ExAccuseInquiry extends JFrame implements ActionListener {


    private JLabel name, phoneNum;
    private JTextField nameT, phoneNumT;
 
    
    private ImageIcon quitImage = new ImageIcon("images/quit.png");
    private ImageIcon inquiryImage = new ImageIcon("images/조회버튼.png");

    private JButton quitButton = new JButton(quitImage);
    private JButton  inquiryButton = new JButton(inquiryImage);
    
    


    public ExAccuseInquiry() {

        super("수출신고 조회");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수출신고조회배경.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();


        Font f = new Font("맑은 고딕", Font.BOLD, 25);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);


        name = new JLabel("•이름 : ");
        phoneNum = new JLabel("•연락처 : ");
        

        nameT = new JTextField(20);
        phoneNumT = new JTextField(20);
        







        inquiryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                inquiryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mousePressed(MouseEvent e) {
                result();
            }
        });




        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new User();
            }

        });


        name.setBounds(20, 160, 400, 25);
        phoneNum.setBounds(20, 220, 400, 25);
   

        nameT.setBounds(250, 160, 550, 25);
        phoneNumT.setBounds(250, 220, 550, 25);
      


        inquiryButton.setBounds(830, 145, 100, 25);
        
       

        JPanel panel = new JPanel();
        panel.add(label);

        name.setFont(f);
        phoneNum.setFont(f);
       
        inquiryButton.setFont(g);
        quitButton.setFont(g);
       

        name.setForeground(Color.white);
        phoneNum.setForeground(Color.white);
     
        add(name);
        add(phoneNum);
     

        add(nameT);
        add(phoneNumT);
       


        add(inquiryButton);
        inquiryButton.setBounds(400, 360, 150, 75);
        inquiryButton.setBorderPainted(false);
        inquiryButton.setContentAreaFilled(false);
        inquiryButton.setFocusPainted(false);

        
        add(quitButton);
        quitButton.setBounds(400, 430, 150, 75);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);


        add(panel);

        label.setIcon(new ImageIcon(img));

        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



    public void result() {

        File file = new File("src/com/kh/dat/exportConfirm.dat");

        String str;
        String[] tokens;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((str = br.readLine()) != null) {
                tokens = str.split("/");
                if (tokens[5].equals(nameT.getText()) && tokens[6].equals(phoneNumT.getText())) {
                    UIManager.put("OptionPane.messageFont",new Font("맑은 고딕",Font.BOLD,15));
                    UIManager.put("OptionPane.buttonFont",new Font("맑은 고딕",Font.BOLD,12));
                    JOptionPane.showMessageDialog(null, toString(tokens), "수출신고 허가여부", JOptionPane.PLAIN_MESSAGE);
                    nameT.setText("");
                    phoneNumT.setText("");
                    i = 1;
                    break;
                }
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"정확하게 입력해주세요.");
                nameT.setText("");
                phoneNumT.setText("");
            }
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "파일이 없습니다.");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "문제가 생겼습니다.");
        }
    }
    public String toString(String [] token){

        return  "신고 번호 : " + token[0]+ "\r\n"+
                "물품명 : " + token[1] + "\r\n" +
                "종류 : " + token[2] + "\r\n"  +
                "수량 : " + token[3] + "EA \r\n"  +
                "단가 : " + token[4] + "원 \r\n"  +
                "신고인 : " + token[5] + " 님\r\n"  +
                "연락처 : " + token[6] + "\r\n"  +
                "출발지 : " + token[7] + "\r\n"  +
                "도착지 : " + token[8] + "\r\n"+
                "세관 결정 : " + token[9];
    }
}