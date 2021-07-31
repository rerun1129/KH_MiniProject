package com.kh.view;

import com.kh.controller.ExportUser;
import com.kh.controller.ImportUser;
import com.kh.controller.Inquiry;

import java.awt.Cursor;
import java.awt.Graphics;
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

public class User extends JFrame implements ActionListener {

    BufferedImage img = null;

    private final ImageIcon outReportImage = new ImageIcon("images/outReport.png");
    private final ImageIcon inReportImage = new ImageIcon("images/inReport.png");
    private final ImageIcon quitImage = new ImageIcon("images/quit.png");
    private final ImageIcon accuseInquiryImage = new ImageIcon("images/신고조회.png");
    private final ImageIcon outReportImage2 = new ImageIcon("images/outReport2.png");
    private final ImageIcon inReportImage2 = new ImageIcon("images/inReport2.png");
    private final ImageIcon quitImage2 = new ImageIcon("images/quit2.png");
    private final ImageIcon accuseInquiryImage2 = new ImageIcon("images/신고조회2.png");


    private final JButton quitButton = new JButton(quitImage);
    private final JButton outReportButton = new JButton(outReportImage);
    private final JButton inReportButton = new JButton(inReportImage);
    private final JButton accuseInquiryButton = new JButton(accuseInquiryImage);

    public User() {
        setTitle("수출입관리 (이용자용)");

        JLayeredPane lp = new JLayeredPane();
        lp.setSize(960, 540);
        lp.setLayout(null);
        try {
            img = ImageIO.read(new File("C:\\Users\\KYS\\Documents\\GitHub\\KH_MiniProject\\images\\introBackground2.png"));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            System.exit(0);

        }

        myPanel p = new myPanel();
        p.setSize(960, 540);
        lp.add(p);

        setLayout(null);

        setSize(960, 540);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        // setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        // ImageIcon(Main.class.getResource("images/introBackground.jpg")).getImage();

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

        add(outReportButton);
        outReportButton.setBounds(400, 100, 150, 75);
        outReportButton.setBorderPainted(false);
        outReportButton.setContentAreaFilled(false);
        outReportButton.setFocusPainted(false);

        outReportButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                outReportButton.setIcon(outReportImage2);
                outReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                outReportButton.setIcon(outReportImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ExportUser();
            }

        });

        add(inReportButton);
        inReportButton.setBounds(400, 180, 150, 75);
        inReportButton.setBorderPainted(false);
        inReportButton.setContentAreaFilled(false);
        inReportButton.setFocusPainted(false);

        inReportButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                inReportButton.setIcon(inReportImage2);
                inReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                inReportButton.setIcon(inReportImage);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new ImportUser();
            }

        });

        add(accuseInquiryButton);
        accuseInquiryButton.setBounds(400, 260, 150, 75);
        accuseInquiryButton.setBorderPainted(false);
        accuseInquiryButton.setContentAreaFilled(false);
        accuseInquiryButton.setFocusPainted(false);

        accuseInquiryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                accuseInquiryButton.setIcon(accuseInquiryImage2);
                accuseInquiryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                accuseInquiryButton.setIcon(accuseInquiryImage);


            }
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();

                new Inquiry();
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
