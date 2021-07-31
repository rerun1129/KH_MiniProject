package com.kh.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.view.Admin;

public class InfoSearch extends JFrame {
    private JLabel sort, user, depart, arrival;
    private JTextField sortT, userT, departT, arrivalT;
    private JButton sortBtn, userBtn, departBtn, arrivalBtn, finish;

    public InfoSearch() {
        super("정보조회");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/정보조회.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();

        Font f = new Font("맑은 고딕", Font.BOLD, 25);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);

        sort = new JLabel("•종류 조회");
        user = new JLabel("•사용자 조회");
        depart = new JLabel("•출발지 조회");
        arrival = new JLabel("•도착지 조회");

        sortT = new JTextField(20);
        userT = new JTextField(20);
        departT = new JTextField(20);
        arrivalT = new JTextField(20);

        sortBtn = new JButton("조회");
        userBtn = new JButton("조회");
        departBtn = new JButton("조회");
        arrivalBtn = new JButton("조회");

        ImageIcon myImg = new ImageIcon("images/quit.png");
        finish = new JButton(myImg);
        finish.setBorderPainted(false);
        finish.setContentAreaFilled(false);
        finish.setFocusPainted(false);

        sortBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 저장된 데이터를 불러와서 대조

            }

        });

        userBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });
        // 출발지 조회
        departBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            }

        });
        // 도착지 조회
        arrivalBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

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

        sort.setBounds(20, 160, 400, 25);
        user.setBounds(20, 220, 400, 25);
        depart.setBounds(20, 280, 400, 25);
        arrival.setBounds(20, 340, 400, 25);

        sortT.setBounds(250, 160, 500, 25);
        userT.setBounds(250, 220, 500, 25);
        departT.setBounds(250, 280, 500, 25);
        arrivalT.setBounds(250, 340, 500, 25);

        sortBtn.setBounds(830, 160, 80, 25);
        userBtn.setBounds(830, 220, 80, 25);
        departBtn.setBounds(830, 280, 80, 25);
        arrivalBtn.setBounds(830, 340, 80, 25);
        finish.setBounds(400, 430, 150, 75);

        sort.setFont(f);
        user.setFont(f);
        depart.setFont(f);
        arrival.setFont(f);

        sortBtn.setFont(g);
        userBtn.setFont(g);
        departBtn.setFont(g);
        arrivalBtn.setFont(g);

        sort.setForeground(Color.white);
        user.setForeground(Color.white);
        depart.setForeground(Color.white);
        arrival.setForeground(Color.white);

        add(sort);
        add(user);
        add(depart);
        add(arrival);

        add(sortT);
        add(userT);
        add(departT);
        add(arrivalT);

        add(sortBtn);
        add(userBtn);
        add(departBtn);
        add(arrivalBtn);
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

    }

}
