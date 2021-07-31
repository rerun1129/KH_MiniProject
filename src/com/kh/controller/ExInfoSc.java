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

public class ExInfoSc extends JFrame {
    private JLabel taskNum, sort, user, depart, arrival;
    private JTextField taskNumT, sortT, userT, departT, arrivalT;
    private JButton taskNumBtn, sortBtn, userBtn, departBtn, arrivalBtn, finish;

    public ExInfoSc() {

        super("수출 정보 조회");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수출정보조회배경.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();

        Font f = new Font("맑은 고딕", Font.BOLD, 20);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);


        taskNum = new JLabel("•번호 조회");
        sort = new JLabel("•종류 조회");
        user = new JLabel("•사용자 조회");
        depart = new JLabel("•출발지 조회");
        arrival = new JLabel("•도착지 조회");

        taskNumT = new JTextField(20);
        sortT = new JTextField(20);
        userT = new JTextField(20);
        departT = new JTextField(20);
        arrivalT = new JTextField(20);


        taskNumBtn = new JButton("조회");
        sortBtn = new JButton("조회");
        userBtn = new JButton("조회");
        departBtn = new JButton("조회");
        arrivalBtn = new JButton("조회");

        ImageIcon myImg = new ImageIcon("images/quit.png");
        ImageIcon myImg2 = new ImageIcon("images/quit2.png");
        finish = new JButton(myImg);
        finish.setBorderPainted(false);
        finish.setContentAreaFilled(false);
        finish.setFocusPainted(false);







        taskNumBtn.addActionListener(e -> {

            exResult(e);

        });


        // 종류 조회
        sortBtn.addActionListener(e -> {

            exResult(e);

        });
        // 유저 조회
        userBtn.addActionListener(e -> {

            exResult(e);
        });
        // 출발지 조회
        departBtn.addActionListener(e -> {

            exResult(e);
        });
        // 도착지 조회
        arrivalBtn.addActionListener(e -> {

            exResult(e);
        });

        // 나가기 버튼
        finish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                finish.setIcon(myImg2);
                finish.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                finish.setIcon(myImg);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose(); // 홈으로 돌아감
                new InfoSearchHome();
            }
        });

        sort.setBounds(20, 130, 400, 25);
        user.setBounds(20, 190, 400, 25);
        depart.setBounds(20, 250, 400, 25);
        arrival.setBounds(20, 310, 400, 25);
        taskNum.setBounds(20,370,400,25);

        sortT.setBounds(250, 130, 500, 25);
        userT.setBounds(250, 190, 500, 25);
        departT.setBounds(250, 250, 500, 25);
        arrivalT.setBounds(250, 310, 500, 25);
        taskNumT.setBounds(250, 370, 500, 25);

        sortBtn.setBounds(830, 130, 80, 25);
        userBtn.setBounds(830, 190, 80, 25);
        departBtn.setBounds(830, 250, 80, 25);
        arrivalBtn.setBounds(830, 310, 80, 25);
        taskNumBtn.setBounds(830, 370, 80, 25);
        finish.setBounds(400, 430, 150, 75);


        sort.setFont(f);
        user.setFont(f);
        depart.setFont(f);
        arrival.setFont(f);
        taskNum.setFont(f);

        sortBtn.setFont(g);
        userBtn.setFont(g);
        departBtn.setFont(g);
        arrivalBtn.setFont(g);
        taskNumBtn.setFont(g);

        sort.setForeground(Color.white);
        user.setForeground(Color.white);
        depart.setForeground(Color.white);
        arrival.setForeground(Color.white);
        taskNum.setForeground(Color.white);

        add(sort);
        add(user);
        add(depart);
        add(arrival);
        add(taskNum);

        add(sortT);
        add(userT);
        add(departT);
        add(arrivalT);
        add(taskNumT);

        add(sortBtn);
        add(userBtn);
        add(departBtn);
        add(arrivalBtn);
        add(taskNumBtn);
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


    public void exResult(ActionEvent e) {

        File file = new File("src/com/kh/dat/exportConfirm.dat");

        String str;
        String[] tokens;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            if (taskNumBtn.equals(e.getSource())) {
                while ((str = br.readLine()) != null) {
                    tokens = str.split("/");
                    if (tokens[0].equals(taskNumT.getText())) {
                        UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                        UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                        JOptionPane.showMessageDialog(null, toString(tokens), "종류대상조회", JOptionPane.PLAIN_MESSAGE);
                        i = 1;
                    }
                }
                if (i == 0) {
                    UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                    UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                    JOptionPane.showMessageDialog(null, "해당하는 신고 번호가 신고서에 없습니다.");
                }
                taskNumT.setText("");
            }

            if (sortBtn.equals(e.getSource())) {
                while ((str = br.readLine()) != null) {
                    tokens = str.split("/");
                    if (tokens[2].equals(sortT.getText())) {
                        UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                        UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                        JOptionPane.showMessageDialog(null, toString(tokens), "종류대상조회", JOptionPane.PLAIN_MESSAGE);
                        i = 1;
                    }
                }
                if (i == 0) {
                    UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                    UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                    JOptionPane.showMessageDialog(null, "해당하는 종류가 신고서에 없습니다.");
                }
                sortT.setText("");
            }

            if (userBtn.equals(e.getSource())) {
                while ((str = br.readLine()) != null) {
                    tokens = str.split("/");
                    if (tokens[5].equals(userT.getText())) {
                        UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                        UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                        JOptionPane.showMessageDialog(null, toString(tokens), "종류대상조회", JOptionPane.PLAIN_MESSAGE);
                        i = 1;
                    }
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "해당하는 신고인이 신고서에 없습니다.");
                }
                userT.setText("");
            }

            if (departBtn.equals(e.getSource())) {
                while ((str = br.readLine()) != null) {
                    tokens = str.split("/");
                    if (tokens[7].equals(departT.getText())) {
                        UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                        UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                        JOptionPane.showMessageDialog(null, toString(tokens), "종류대상조회", JOptionPane.PLAIN_MESSAGE);
                        i = 1;
                    }
                }
                if (i == 0) {
                    UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                    UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                    JOptionPane.showMessageDialog(null, "해당하는 출발지가 신고서에 없습니다.");
                }
                departT.setText("");
            }

            if (arrivalBtn.equals(e.getSource())) {
                while ((str = br.readLine()) != null) {
                    tokens = str.split("/");
                    if (tokens[8].equals(arrivalT.getText())) {
                        UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                        UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                        JOptionPane.showMessageDialog(null, toString(tokens), "종류대상조회", JOptionPane.PLAIN_MESSAGE);
                        i = 1;
                    }
                }
                if (i == 0) {
                    UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.BOLD, 15));
                    UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.BOLD, 12));
                    JOptionPane.showMessageDialog(null, "해당하는 도착지가 신고서에 없습니다.");
                }
                arrivalT.setText("");
            }
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "파일이 없습니다.");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "문제가 생겼습니다.");
        }
    }

    public String toString(String[] token) {

        return "신고 번호 : " + token[0] + "\r\n" +
                "물품명 : " + token[1] + "\r\n" +
                "종류 : " + token[2] + "\r\n" +
                "수량 : " + token[3] + "EA \r\n" +
                "단가 : " + token[4] + "원 \r\n" +
                "신고인 : " + token[5] + " 님\r\n" +
                "연락처 : " + token[6] + "\r\n" +
                "출발지 : " + token[7] + "\r\n" +
                "도착지 : " + token[8] + "\r\n" +
                "세관 결정 : " + token[9];
    }
}

