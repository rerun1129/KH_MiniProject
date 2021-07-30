package com.kh.controller;

import com.kh.view.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ImportUser extends JFrame {

    //Todo 2. 신고처리를 누르면 Admin DB로 넘어감



    private JLabel name, sort, quantity, price, user, phoneNum, departure, arrival, imLimit, imNot;
    private JTextField nameT, sortT, quantityT, priceT, userT, phoneNumT, departureT, arrivalT;
    private JButton accuse, cancel;


    public ImportUser() {

        super("수입신고");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수입신고.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();


        Font f = new Font("맑은 고딕", Font.BOLD, 20);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);


        name = new JLabel("•물품명 : ");
        sort = new JLabel("•종류 : ");
        quantity = new JLabel("•수량 : ");
        price = new JLabel("•단가 : ");
        user = new JLabel("•신고자 : ");
        phoneNum = new JLabel("•연락처 : ");
        departure = new JLabel("•출발지 : ");
        arrival = new JLabel("•도착지 : ");



        nameT = new JTextField(20);
        sortT = new JTextField(20);
        quantityT = new JTextField(20);
        priceT = new JTextField(20);
        userT = new JTextField(20);
        phoneNumT = new JTextField(20);
        departureT = new JTextField(20);
        arrivalT = new JTextField(20);


        accuse = new JButton("신고");
        cancel = new JButton("취소");


        name.setBounds(20, 120, 400, 25);
        sort.setBounds(20, 160, 400, 25);
        quantity.setBounds(20, 200, 400, 25);
        price.setBounds(20, 240, 400, 25);
        user.setBounds(20, 280, 400, 25);
        phoneNum.setBounds(20, 320, 400, 25);
        departure.setBounds(20, 360, 400, 25);
        arrival.setBounds(20, 400, 400, 25);



        nameT.setBounds(200, 120, 700, 25);
        sortT.setBounds(200, 160, 700, 25);
        quantityT.setBounds(200, 200, 700, 25);
        priceT.setBounds(200, 240, 700, 25);
        userT.setBounds(200, 280, 700, 25);
        phoneNumT.setBounds(200, 320, 700, 25);
        departureT.setBounds(200, 360, 700, 25);
        arrivalT.setBounds(200, 400, 700, 25);

        accuse.setBounds(620, 450, 100, 30);
        cancel.setBounds(780, 450, 100, 30);

        JPanel panel = new JPanel();
        panel.add(label);

        name.setFont(f);
        sort.setFont(f);
        quantity.setFont(f);
        price.setFont(f);
        user.setFont(f);
        phoneNum.setFont(f);
        departure.setFont(f);
        arrival.setFont(f);
        accuse.setFont(g);
        cancel.setFont(g);

        name.setForeground(Color.white);
        sort.setForeground(Color.white);
        quantity.setForeground(Color.white);
        price.setForeground(Color.white);
        user.setForeground(Color.white);
        phoneNum.setForeground(Color.white);
        departure.setForeground(Color.white);
        arrival.setForeground(Color.white);



        add(name);
        add(sort);
        add(quantity);
        add(price);
        add(user);
        add(phoneNum);
        add(departure);
        add(arrival);
        add(nameT);
        add(sortT);
        add(quantityT);
        add(priceT);
        add(userT);
        add(phoneNumT);
        add(departureT);
        add(arrivalT);


        add(accuse);
        add(cancel);
        add(panel);

        label.setIcon(new ImageIcon(img));

        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        accuse.addActionListener(e -> {


            JOptionPane.showMessageDialog(null,"수입신고가 완료되었습니다.");

            //todo 이제 이걸 파일로 쏴서 객체화 시키고 어드민에서 바로 불러오도록한다.
            //todo 그리고 유저화면에 신고 결과 확인을 넣어서 이름, 전화번호로 확인이 가능하도록 처리한다.
            
            dispose();

            new User();

        });

        cancel.addActionListener(e -> {

            dispose();

            new User();


        });


    }
}
