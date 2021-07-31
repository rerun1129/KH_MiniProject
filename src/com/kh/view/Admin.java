package com.kh.view;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.controller.*;

public class Admin extends JFrame implements ActionListener {

    BufferedImage img = null;
    private Image screenImage;
    private Graphics screenGrapic;

    private ImageIcon outAcsImage = new ImageIcon("images/outAcs.png");
    private ImageIcon inAcsImage = new ImageIcon("images/inAcs.png");
    private ImageIcon informationImage = new ImageIcon("images/information.png");
    private ImageIcon inOutSetImage = new ImageIcon("images/inOutSet.png");
    private ImageIcon quitImage = new ImageIcon("images/quit.png");
    private ImageIcon outAcsImage2 = new ImageIcon("images/outAcs2.png");
    private ImageIcon inAcsImage2 = new ImageIcon("images/inAcs2.png");
    private ImageIcon informationImage2 = new ImageIcon("images/information2.png");
    private ImageIcon inOutSetImage2 = new ImageIcon("images/inOutSet2.png");
    private ImageIcon quitImage2 = new ImageIcon("images/quit2.png");

    private JButton quitButton = new JButton(quitImage);
    private JButton outAcsButton = new JButton(outAcsImage);
    private JButton inAcsButton = new JButton(inAcsImage);
    private JButton inOutSetButton = new JButton(inOutSetImage);
    private JButton informationButton = new JButton(informationImage);


    public Admin() {

        // setUndecorated(true);
        setTitle("수출입관리 (관리자용)");

        JLayeredPane lp = new JLayeredPane();
        lp.setSize(960, 540);
        lp.setLayout(null);
        try {
            img = ImageIO.read(new File("C:\\Users\\KYS\\Documents\\GitHub\\KH_MiniProject\\images\\introBackground.png"));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            System.exit(0);

        }

        myPanel p = new myPanel();
        p.setSize(960, 540);
        lp.add(p);

        setLayout(null);

        setSize(960, 575);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // 나가기 버튼
        add(quitButton);
        quitButton.setBounds(400, 430, 150, 75);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);

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
                System.exit(0);
            }

        });

        // 수출허가 버튼
        add(outAcsButton);
        outAcsButton.setBounds(400, 50, 150, 75);
        outAcsButton.setBorderPainted(false);
        outAcsButton.setContentAreaFilled(false);
        outAcsButton.setFocusPainted(false);

        outAcsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                outAcsButton.setIcon(outAcsImage2);
                outAcsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }


            @Override
            public void mouseExited(MouseEvent e) {
                outAcsButton.setIcon(outAcsImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {

                dispose();

                new ExportAdmin();
            }

        });

        // 수입허가 버튼
        add(inAcsButton);
        inAcsButton.setBounds(400, 130, 150, 75);
        inAcsButton.setBorderPainted(false);
        inAcsButton.setContentAreaFilled(false);
        inAcsButton.setFocusPainted(false);

        inAcsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                inAcsButton.setIcon(inAcsImage2);
                inAcsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }


            @Override
            public void mouseExited(MouseEvent e) {
                inAcsButton.setIcon(inAcsImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ImportAdmin();
            }

        });

        // 정보조회 버튼
        add(informationButton);
        informationButton.setBounds(400, 210, 150, 75);
        informationButton.setBorderPainted(false);
        informationButton.setContentAreaFilled(false);
        informationButton.setFocusPainted(false);

        informationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                informationButton.setIcon(informationImage2);
                informationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }


            @Override
            public void mouseExited(MouseEvent e) {
                informationButton.setIcon(informationImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new InfoSearchHome();


            }

        });

        // 수출입관리 버튼
        add(inOutSetButton);
        inOutSetButton.setBounds(400, 280, 150, 75);
        inOutSetButton.setBorderPainted(false);
        inOutSetButton.setContentAreaFilled(false);
        inOutSetButton.setFocusPainted(false);

        inOutSetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                inOutSetButton.setIcon(inOutSetImage2);
                inOutSetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                inOutSetButton.setIcon(inOutSetImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ManagerIE();
            }

        });

        add(lp);

    }

    class myPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
