package com.kh.controller;


import com.kh.view.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class ImportUser extends JFrame {

    //Todo 2. 신고처리를 누르면 Admin DB로 넘어감


    private JLabel taskNum, name, sort, quantity, price, user, phoneNum, departure, arrival, imLimit, imNot;
    private JTextField taskNumT, nameT, sortT, quantityT, priceT, userT, phoneNumT, departureT, arrivalT;
    private JButton accuse, cancel;

    private String[] lines = new String[100];
    private String[] lineArr;


    public ImportUser() {

        super("수입신고");
        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수입신고.png").getImage().getScaledInstance(960, 640, 0);
        JLabel label = new JLabel();


        Font f = new Font("맑은 고딕", Font.BOLD, 20);
        Font g = new Font("맑은 고딕", Font.BOLD, 15);

        taskNum = new JLabel("•신고 번호 : ");
        name = new JLabel("•물품명 : ");
        sort = new JLabel("•종류 : ");
        quantity = new JLabel("•수량 : ");
        price = new JLabel("•단가 : ");
        user = new JLabel("•신고자 : ");
        phoneNum = new JLabel("•연락처 : ");
        departure = new JLabel("•출발지 : ");
        arrival = new JLabel("•도착지 : ");


        taskNumT = new JTextField(20);
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

        taskNum.setBounds(20, 80, 400, 25);
        name.setBounds(20, 120, 400, 25);
        sort.setBounds(20, 160, 400, 25);
        quantity.setBounds(20, 200, 400, 25);
        price.setBounds(20, 240, 400, 25);
        user.setBounds(20, 280, 400, 25);
        phoneNum.setBounds(20, 320, 400, 25);
        departure.setBounds(20, 360, 400, 25);
        arrival.setBounds(20, 400, 400, 25);


        taskNumT.setBounds(200, 80, 700, 25);
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
        taskNum.setFont(f);

        name.setForeground(Color.white);
        sort.setForeground(Color.white);
        quantity.setForeground(Color.white);
        price.setForeground(Color.white);
        user.setForeground(Color.white);
        phoneNum.setForeground(Color.white);
        departure.setForeground(Color.white);
        arrival.setForeground(Color.white);
        taskNum.setForeground(Color.white);
        taskNumT.setEditable(false);

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
        add(taskNum);
        add(taskNumT);

        add(accuse);
        add(cancel);
        add(panel);

        autoIncrement();

        label.setIcon(new ImageIcon(img));

        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        accuse.addActionListener(e -> {


            File file = new File("src/com/kh/dat/importInfo.dat");

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {

                if(nameT.getText().length() == 0 || sortT.getText().length() == 0 ||quantityT.getText().length() == 0 || priceT.getText().length() == 0|| userT.getText().length() == 0 ||phoneNumT.getText().length()==0||
                        departureT.getText().length()==0||arrivalT.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "각 항목이 공백이 없게 작성해주세요.");
                }else{
                    bw.write(taskNumT.getText() + "/");
                    bw.write(nameT.getText() + "/");
                    bw.write(sortT.getText() + "/");
                    bw.write(quantityT.getText() + "/");
                    bw.write(priceT.getText() + "/");
                    bw.write(userT.getText() + "/");
                    bw.write(phoneNumT.getText() + "/");
                    bw.write(departureT.getText() + "/");
                    bw.write(arrivalT.getText());
                    bw.write("\r\n");
                    bw.flush();
                    JOptionPane.showMessageDialog(null, "수입신고가 완료되었습니다.");

                    dispose();

                    new User();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });

        cancel.addActionListener(e -> {


            dispose();

            new User();


        });


    }
    public void autoIncrement() {

        File file = new File("src/com/kh/dat/importInfo.dat");
        int i = 0;
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }
            lineArr = lines[i-1].split("/");
            int temp = Integer.parseInt(lineArr[0])+1;
            String fin = String.valueOf(temp);
            taskNumT.setText(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}