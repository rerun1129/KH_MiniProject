package com.kh.controller;

import com.kh.view.User;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Inquiry extends JFrame {


    private final ImageIcon quitButtonImage = new ImageIcon("images/quit.png");
    private final ImageIcon exAccuseImage = new ImageIcon("images/수출신고조회.png");
    private final ImageIcon imAccuseImage = new ImageIcon("images/수입신고조회.png");
    private final ImageIcon quitButtonImage2 = new ImageIcon("images/quit2.png");
    private final ImageIcon exAccuseImage2 = new ImageIcon("images/수출신고조회2.png");
    private final ImageIcon imAccuseImage2 = new ImageIcon("images/수입신고조회2.png");


    private final JButton quitButton = new JButton(quitButtonImage);
    private final JButton exAccuse = new JButton(exAccuseImage);
    private final JButton imAccuse = new JButton(imAccuseImage);


    public Inquiry() {

        setTitle("신고 조회");
        JLayeredPane lp = new JLayeredPane();
        lp.setSize(960, 540);
        lp.setLayout(null);

        setResizable(false);


        Image img = new ImageIcon("images/신고조회배경.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();




        // 수출신고조회 버튼
        exAccuse.setBounds(400, 140, 150, 75);
        exAccuse.setBorderPainted(false);
        exAccuse.setContentAreaFilled(false);
        exAccuse.setFocusPainted(false);
        exAccuse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exAccuse.setIcon(exAccuseImage2);
                exAccuse.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                exAccuse.setIcon(exAccuseImage);


            }
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ExAccuseInquiry();
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
                imAccuse.setIcon(imAccuseImage2);
                imAccuse.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                imAccuse.setIcon(imAccuseImage);


            }
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ImAccuseInquiry();
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
                quitButton.setIcon(quitButtonImage2);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonImage);


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