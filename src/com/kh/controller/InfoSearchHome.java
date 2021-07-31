package com.kh.controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.view.Admin;

public class InfoSearchHome extends JFrame {
    JButton exInfoBtn, inInfoBtn, finish;


    public InfoSearchHome() {
        super("정보조회");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/정보조회.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();

        ImageIcon myImg1 = new ImageIcon("images/수출정보조회.png");
        exInfoBtn = new JButton(myImg1);
        exInfoBtn.setBorderPainted(false);
        exInfoBtn.setContentAreaFilled(false);
        exInfoBtn.setFocusPainted(false);

        ImageIcon myImg2 = new ImageIcon("images/수입정보조회.png");
        inInfoBtn = new JButton(myImg2);
        inInfoBtn.setBorderPainted(false);
        inInfoBtn.setContentAreaFilled(false);
        inInfoBtn.setFocusPainted(false);


        ImageIcon myImg3 = new ImageIcon("images/quit.png");
        finish = new JButton(myImg3);
        finish.setBorderPainted(false);
        finish.setContentAreaFilled(false);
        finish.setFocusPainted(false);


        // 수출 정보 액션
        exInfoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                finish.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
                new ExInfoSc();
            }
        });


        // 수입 정보 액션
        inInfoBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                finish.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {

                dispose();
                new ImInfoSc();

            }
        });


        // 나가기 버튼
        finish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                finish.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose(); // 홈으로 돌아감
                new Admin();
            }
        });


        exInfoBtn.setBounds(400, 140, 150, 75);
        inInfoBtn.setBounds(400, 200, 150, 75);
        finish.setBounds(400, 380, 150, 75);


        add(exInfoBtn);
        add(inInfoBtn);
        add(finish);

        JPanel panel = new JPanel();
        panel.add(label);

        add(panel);
        label.setIcon(new ImageIcon(img));
        panel.setBounds(0, 0, 960, 550);

        setSize(950, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


//		Font f = new Font("맑은 고딕", Font.BOLD, 25);
//		Font g = new Font("맑은 고딕", Font.BOLD, 15);


    }

}
