package com.kh.controller;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.model.vo.LimitList;
import com.kh.view.Admin;
import com.kh.view.User;

public class ManagerIE extends JFrame implements ActionListener {


    private JLabel exLimit, imLimit, exNot, imNot;
    private JTextField exLimitT, imLimitT, exNotT, imNotT;
    private JButton addBtn1, addBtn2, addBtn3, addBtn4, delBtn1, delBtn2, delBtn3, delBtn4;
    private ImageIcon quitImage = new ImageIcon("images/quit.png");

    private JButton quitButton = new JButton(quitImage);

    LimitList ll = new LimitList();


    public ManagerIE() {

        super("수출입 관리");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수출입관리.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();


        Font f = new Font("맑은 고딕", Font.BOLD, 25);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);


        exLimit = new JLabel("•수출 제한 물품 : ");
        imLimit = new JLabel("•수입 제한 물품 : ");
        exNot = new JLabel("•수출 금지 물품 : ");
        imNot = new JLabel("•수입 금지 물품 : ");

        exLimitT = new JTextField(20);
        imLimitT = new JTextField(20);
        exNotT = new JTextField(20);
        imNotT = new JTextField(20);


        addBtn1 = new JButton("추가");
        addBtn1.addActionListener(e -> {

            ll.EL(exLimitT.getText());
        });


        addBtn2 = new JButton("추가");
        addBtn2.addActionListener(e -> {

            ll.IL(imLimitT.getText());
        });


        addBtn3 = new JButton("추가");
        addBtn3.addActionListener(e -> {

            ll.EI(exNotT.getText());
        });


        addBtn4 = new JButton("추가");
        addBtn4.addActionListener(e -> {

            ll.II(imNotT.getText());
        });


        delBtn1 = new JButton("삭제");
        delBtn1.addActionListener(e -> {
            ll.ELD(exLimitT.getText());
        });


        delBtn2 = new JButton("삭제");
        delBtn2.addActionListener(e -> {

            ll.ILD(imLimitT.getText());
        });


        delBtn3 = new JButton("삭제");
        delBtn3.addActionListener(e -> {
            ll.EID(exNotT.getText());

        });


        delBtn4 = new JButton("삭제");
        delBtn4.addActionListener(e -> {

            ll.IID(imNotT.getText());

        });


        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new Admin();
            }

        });


        exLimit.setBounds(20, 160, 400, 25);
        imLimit.setBounds(20, 220, 400, 25);
        exNot.setBounds(20, 280, 400, 25);
        imNot.setBounds(20, 340, 400, 25);


        exLimitT.setBounds(250, 160, 550, 25);
        imLimitT.setBounds(250, 220, 550, 25);
        exNotT.setBounds(250, 280, 550, 25);
        imNotT.setBounds(250, 340, 550, 25);


        addBtn1.setBounds(830, 145, 100, 25);
        addBtn2.setBounds(830, 205, 100, 25);
        addBtn3.setBounds(830, 265, 100, 25);
        addBtn4.setBounds(830, 325, 100, 25);
        delBtn1.setBounds(830, 175, 100, 25);
        delBtn2.setBounds(830, 235, 100, 25);
        delBtn3.setBounds(830, 295, 100, 25);
        delBtn4.setBounds(830, 355, 100, 25);

        JPanel panel = new JPanel();
        panel.add(label);

        exLimit.setFont(f);
        imLimit.setFont(f);
        exNot.setFont(f);
        imNot.setFont(f);
        addBtn1.setFont(g);
        addBtn2.setFont(g);
        addBtn3.setFont(g);
        addBtn4.setFont(g);
        delBtn1.setFont(g);
        delBtn2.setFont(g);
        delBtn3.setFont(g);
        delBtn4.setFont(g);

        exLimit.setForeground(Color.white);
        imLimit.setForeground(Color.white);
        exNot.setForeground(Color.white);
        imNot.setForeground(Color.white);

        add(exLimit);
        add(imLimit);
        add(exNot);
        add(imNot);

        add(exLimitT);
        add(imLimitT);
        add(exNotT);
        add(imNotT);


        add(addBtn1);
        add(addBtn2);
        add(addBtn3);
        add(addBtn4);
        add(delBtn1);
        add(delBtn2);
        add(delBtn3);
        add(delBtn4);

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

}