package com.kh.controller;

import com.kh.view.Admin;
import com.kh.view.User;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Inquiry extends JFrame {

	
  
    private ImageIcon quitButtonImage = new ImageIcon("images/quit.png");
    private ImageIcon exAccuseImage = new ImageIcon("images/수출신고조회.png");
    private ImageIcon imAccuseImage = new ImageIcon("images/수입신고조회.png");
 

    private JButton quitButton = new JButton(quitButtonImage);
    private JButton exAccuse = new JButton(exAccuseImage);
    private JButton imAccuse = new JButton(imAccuseImage);
   

    public Inquiry() {
    	JPanel pan = new JPanel();
        setTitle("신고 조회");
        JLayeredPane lp = new JLayeredPane();
        lp.setSize(960, 540);
        lp.setLayout(null);
     
        setResizable(false);
        

        Image img = new ImageIcon("images/신고조회배경.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();


        Font f = new Font("맑은 고딕", Font.BOLD, 20);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);


    	

     	 // 수출신고조회 버튼
        exAccuse.setBounds(400, 140, 150, 75);
        exAccuse.setBorderPainted(false);
        exAccuse.setContentAreaFilled(false);
        exAccuse.setFocusPainted(false);
     	exAccuse.addMouseListener(new MouseAdapter() {
     			@Override
     			public void mouseEntered(MouseEvent e) {
     				exAccuse.setCursor(new Cursor(Cursor.HAND_CURSOR));
     			}

     			@Override
     			public void mousePressed(MouseEvent e) {
     					dispose(); // 홈으로 돌아감 

     			}
     		});
     	
     	 // 수입신고조회 버튼
     	imAccuse.setBounds(400, 200, 150, 75);
     	imAccuse.setBorderPainted(false);
     	imAccuse.setContentAreaFilled(false);
     	imAccuse.setFocusPainted(false);
     	imAccuse.addMouseListener(new MouseAdapter() {
     			@Override
     			public void mouseEntered(MouseEvent e) {
     				imAccuse.setCursor(new Cursor(Cursor.HAND_CURSOR));
     			}

     			@Override
     			public void mousePressed(MouseEvent e) {
     					dispose(); // 홈으로 돌아감 



     			}
     		});
     	

     	  
        // 나가기 버튼
  
         quitButton.setBounds(400, 380, 150, 75);
         quitButton.setBorderPainted(false);
         quitButton.setContentAreaFilled(false);
         quitButton.setFocusPainted(false);

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
         
        JPanel panel = new JPanel();
        panel.add(label);

      

        add(exAccuse);
        add(imAccuse);
        add(quitButton);
        add(panel);

        label.setIcon(new ImageIcon(img));

        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }
}