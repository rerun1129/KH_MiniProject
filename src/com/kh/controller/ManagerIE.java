package com.kh.controller;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;

import com.kh.model.dao.LimitList;
import com.kh.view.Admin;

public class ManagerIE extends JFrame implements ActionListener {


    private final JLabel exLimit, imLimit, exNot, imNot;
    private final JTextField exLimitT, imLimitT, exNotT, imNotT;
    private final JButton addBtn1, addBtn2, addBtn3, addBtn4, delBtn1, delBtn2, delBtn3, delBtn4;
    private final ImageIcon quitImage = new ImageIcon("images/quit.png");
    private final ImageIcon quitImage2 = new ImageIcon("images/quit2.png");

    private final JButton quitButton = new JButton(quitImage);


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
            exLimitT.setText("");
        });


        addBtn2 = new JButton("추가");
        addBtn2.addActionListener(e -> {
            ll.IL(imLimitT.getText());
            imLimitT.setText("");
        });


        addBtn3 = new JButton("추가");
        addBtn3.addActionListener(e -> {
            ll.EI(exNotT.getText());
            exNotT.setText("");
        });


        addBtn4 = new JButton("추가");
        addBtn4.addActionListener(e -> {
            ll.II(imNotT.getText());
            imNotT.setText("");
        });


        delBtn1 = new JButton("삭제");
        delBtn1.addActionListener(e -> {
            ll.ELD(exLimitT.getText());
            exLimitT.setText("");
        });


        delBtn2 = new JButton("삭제");
        delBtn2.addActionListener(e -> {
            ll.ILD(imLimitT.getText());
            imLimitT.setText("");
        });


        delBtn3 = new JButton("삭제");
        delBtn3.addActionListener(e -> {
            ll.EID(exNotT.getText());
            exNotT.setText("");
        });


        delBtn4 = new JButton("삭제");
        delBtn4.addActionListener(e -> {
            ll.IID(imNotT.getText());
            imNotT.setText("");
        });


        exLimit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                elInquiry();

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                exLimit.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
        });


        exNot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eIInquiry();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

                exNot.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
        });

        imLimit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                iLInquiry();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imLimit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });


        imNot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                iIInquiry();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                imNot.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });




        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitImage2);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new Admin();
            }

        });


        exLimit.setBounds(20, 160, 220, 25);
        imLimit.setBounds(20, 220, 220, 25);
        exNot.setBounds(20, 280, 220, 25);
        imNot.setBounds(20, 340, 220, 25);


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


    public void elInquiry() {

        File file = new File("src/com/kh/dat/exportLimit.dat");
        int i = 0;
        String line;
        int len = 100;
        String[] lines = new String[len];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }
            UIManager.put("OptionPane.messageFont", new Font("맑은 고딕",Font.BOLD,15));
            UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕",Font.BOLD,12));
            JOptionPane.showMessageDialog(null, lines, "수출제한목록", JOptionPane.PLAIN_MESSAGE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void eIInquiry() {

        File file = new File("src/com/kh/dat/exportInhibit.dat");
        int i = 0;
        String line;
        int len = 100;
        String[] lines = new String[len];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }

            UIManager.put("OptionPane.messageFont", new Font("맑은 고딕",Font.BOLD,15));
            UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕",Font.BOLD,12));
            JOptionPane.showMessageDialog(null, lines, "수출금지목록", JOptionPane.PLAIN_MESSAGE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iLInquiry() {

        File file = new File("src/com/kh/dat/importLimit.dat");
        int i = 0;
        String line;
        int len = 100;
        String[] lines = new String[len];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }

            UIManager.put("OptionPane.messageFont", new Font("맑은 고딕",Font.BOLD,15));
            UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕",Font.BOLD,12));
            JOptionPane.showMessageDialog(null, lines, "수입제한목록", JOptionPane.PLAIN_MESSAGE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void iIInquiry() {

        File file = new File("src/com/kh/dat/importInhibit.dat");
        int i = 0;
        String line;
        int len = 100;
        String[] lines = new String[len];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }

            UIManager.put("OptionPane.messageFont", new Font("맑은 고딕",Font.BOLD,15));
            UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕",Font.BOLD,12));
            JOptionPane.showMessageDialog(null, lines, "수입제한목록", JOptionPane.PLAIN_MESSAGE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}