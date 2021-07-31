package com.kh.controller;


import com.kh.view.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ImportAdmin extends JFrame {


    private JLabel name, sort, quantity, price, user, phoneNum, departure, arrival, imLimit, imNot;
    private JTextField nameT, sortT, quantityT, priceT, userT, phoneNumT, departureT, arrivalT;
    private JButton accept, cancel;

    private String[] lines = new String[100];
    private String[] lineArr;
    int number;


    public ImportAdmin() {

        super("수입허가");
        setLayout(null);
        setResizable(false);


        Image img = new ImageIcon("images/수입허가.png").getImage().getScaledInstance(960, 640, 0);
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

        cancel = new JButton();


        accept = new JButton("신고처리");
        cancel = new JButton("불허");

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

        accept.setBounds(620, 450, 100, 30);
        cancel.setBounds(780, 450, 100, 30);


        JPanel panel = new JPanel();
        label.setIcon(new ImageIcon(img));
        panel.add(label);

        name.setFont(f);
        sort.setFont(f);
        quantity.setFont(f);
        price.setFont(f);
        user.setFont(f);
        phoneNum.setFont(f);
        departure.setFont(f);
        arrival.setFont(f);
        accept.setFont(g);
        cancel.setFont(g);


        name.setForeground(Color.white);
        sort.setForeground(Color.white);
        quantity.setForeground(Color.white);
        price.setForeground(Color.white);
        user.setForeground(Color.white);
        phoneNum.setForeground(Color.white);
        departure.setForeground(Color.white);
        arrival.setForeground(Color.white);

        nameT.setEditable(false);
        sortT.setEditable(false);
        quantityT.setEditable(false);
        priceT.setEditable(false);
        userT.setEditable(false);
        phoneNumT.setEditable(false);
        departureT.setEditable(false);
        arrivalT.setEditable(false);


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


        add(accept);
        add(cancel);
        add(panel);

        fileIn();

        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                try (BufferedReader br = new BufferedReader(new FileReader("src/com/kh/dat/importLimit.dat"));
                     BufferedReader br1 = new BufferedReader(new FileReader("src/com/kh/dat/importInhibit.dat"))) {
                    String str1;
                    String str2;

                    while ((str1 = br.readLine()) != null && (str2 = br1.readLine()) != null) {
                        if (str1.equals(sortT.getText())) {
                            JOptionPane.showMessageDialog(null, "수입제한 물품입니다.");
                            i = 1;
                            break;
                        }
                        if (str2.equals(sortT.getText())) {
                            JOptionPane.showMessageDialog(null, "수입금지 물품입니다.");
                            i = 2;
                            break;
                        }
                    }
                    if(i==0){
                        JOptionPane.showMessageDialog(null, "수입신고를 허가합니다.");
                    }
                } catch (IOException fileNotFoundException) {
                    JOptionPane.showMessageDialog(null, "문제가 생겼습니다.");
                }


                File file = new File("src/com/kh/dat/importConfirm.dat");
                File file1 = new File("src/com/kh/dat/importInfo.dat");

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                     BufferedReader br = new BufferedReader(new FileReader(file1))) {

                    String str;
                    int j = 0;
                    int[] spInt = new int[100];
                          while ((str = br.readLine()) != null){
                              String[] split = str.split("/");
                              spInt[j] = Integer.parseInt(split[0]);
                              if (spInt[j] == number){
                                  bw.write(str);
                                  break;
                              }
                          }

                    switch (i) {
                        case 1:
                            bw.write("/수입제한");
                            break;
                        case 2:
                            bw.write("/수입금지");
                            break;
                        case 0:
                            bw.write("/수입허가");
                            break;
                        default:
                    }
                    bw.write("\r\n");
                    bw.flush();

                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "파일이 없습니다.");
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "문제가 생겼습니다.");
                }

                dispose();

                new Admin();

            }
        });

        cancel.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "취소했습니다.");


            dispose();

            new Admin();

        });
    }

    public void fileIn() {

        File file = new File("src/com/kh/dat/importInfo.dat");
        int i = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;

                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            number = Integer.parseInt(JOptionPane.showInputDialog("처리할 신고 번호를 입력하세요."));

            lineArr = lines[number - 1].split("/");

            nameT.setText(lineArr[1]);
            sortT.setText(lineArr[2]);
            quantityT.setText(lineArr[3]);
            priceT.setText(lineArr[4]);
            userT.setText(lineArr[5]);
            phoneNumT.setText(lineArr[6]);
            departureT.setText(lineArr[7]);
            arrivalT.setText(lineArr[8]);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "잘못된 번호입니다.");
            System.exit(0);

        }
    }

}

