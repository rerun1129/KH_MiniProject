package com.kh.controller;

import com.kh.view.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ExportAdmin extends JFrame {


    private JLabel taskNum, name, sort, quantity, price, user, phoneNum, departure, arrival;
    private JTextField taskNumT, nameT, sortT, quantityT, priceT, userT, phoneNumT, departureT, arrivalT;
    private JButton accept, cancel;
    private String[] lines = new String[100];
    private String[] lineArr;
    private String strWhy;

    public ExportAdmin() {

        super("수출허가");


        setLayout(null);
        setResizable(false);

        Image img = new ImageIcon("images/수출허가.png").getImage().getScaledInstance(960, 640, 0);
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


        accept = new JButton("신고처리");
        cancel = new JButton("불허");

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
        taskNum.setFont(f);
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
        taskNum.setForeground(Color.white);


        taskNumT.setEditable(false);
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
        add(taskNum);
        add(taskNumT);


        add(accept);
        add(cancel);
        add(panel);


        panel.setBounds(0, 0, 960, 550);

        setSize(960, 550);

        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        accept.addActionListener(e -> {
            int i = 0;
            try (BufferedReader br = new BufferedReader(new FileReader("src/com/kh/dat/exportLimit.dat"));
                 BufferedReader br1 = new BufferedReader(new FileReader("src/com/kh/dat/exportInhibit.dat"))) {
                String str1;
                String str2;

                while ((str1 = br.readLine()) != null && (str2 = br1.readLine()) != null) {
                    if (str1.equals(sortT.getText())) {
                        JOptionPane.showMessageDialog(null, "수출제한 물품입니다.");
                        i = 1;
                    }
                    if (str2.equals(sortT.getText())) {
                        JOptionPane.showMessageDialog(null, "수출금지 물품입니다.");
                        i = 2;
                    }
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "수출신고를 허가합니다.");
                }
            } catch (IOException fileNotFoundException) {
                JOptionPane.showMessageDialog(null, "문제가 생겼습니다.");
            }


            File file = new File("src/com/kh/dat/exportConfirm.dat");
            File file1 = new File("src/com/kh/dat/exportInfo.dat");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                 BufferedReader br = new BufferedReader(new FileReader(file1))) {

                String str;
                while ((str = br.readLine()) != null) {
                    String[] split = str.split("/");
                    if (split[0].equals(taskNumT.getText())) {
                        bw.write(str);
                        break;
                    }
                }

                switch (i) {
                    case 1:
                        bw.write("/수출제한");
                        break;
                    case 2:
                        bw.write("/수출금지");
                        break;
                    case 0:
                        bw.write("/수출허가");
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

        });

        cancel.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "불허 처리했습니다.");

            strWhy = JOptionPane.showInputDialog(null, " 불허사유를 적어주세요.", "신고 불허", JOptionPane.QUESTION_MESSAGE);

            File file = new File("src/com/kh/dat/exportConfirm.dat");
            File file1 = new File("src/com/kh/dat/exportInfo.dat");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                 BufferedReader br = new BufferedReader(new FileReader(file1))) {

                String str;
                while ((str = br.readLine()) != null) {
                    String[] split = str.split("/");
                    if (split[0].equals(taskNumT.getText())) {
                        bw.write(str + "/(불허사유)" + strWhy);
                        break;
                    }
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

        });

        fileIn();

    }


    public void fileIn() {


        File file = new File("src/com/kh/dat/exportInfo.dat");
        File file1 = new File("src/com/kh/dat/exportConfirm.dat");

        int i = 0;
        String line;
        String [] lineArrC = new String[10];
        String [] linesC = new String[100];



        try(BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedReader br1 = new BufferedReader(new FileReader(file1))) {

            while ((line = br.readLine()) != null) {
                lines[i] = line;
                lineArr = lines[i].split("/");
                i++;
            }

            while ((line = br1.readLine())!=null){
                linesC[i] = line;
                lineArrC = linesC[i].split("/");
                i++;
            }

            int temp1 = Integer.parseInt(lineArr[0]);
            int temp2 = Integer.parseInt(lineArrC[0]);

            if(temp1==temp2){
                JOptionPane.showMessageDialog(null, "처리할 업무가 없습니다.");
                dispose();
                new Admin();
            }

            if(temp1 > temp2){

                lineArr = lines[temp2].split("/");
                int temp = Integer.parseInt(lineArr[0]);
                String fin = String.valueOf(temp);
                taskNumT.setText(fin);
                nameT.setText(lineArr[1]);
                sortT.setText(lineArr[2]);
                quantityT.setText(lineArr[3]);
                priceT.setText(lineArr[4]);
                userT.setText(lineArr[5]);
                phoneNumT.setText(lineArr[6]);
                departureT.setText(lineArr[7]);
                arrivalT.setText(lineArr[8]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}