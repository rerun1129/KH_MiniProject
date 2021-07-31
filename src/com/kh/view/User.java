package com.kh.view;

import com.kh.controller.ExportUser;
import com.kh.controller.ImportUser;
import com.kh.controller.Inquiry;

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

public class User extends JFrame implements ActionListener {

    BufferedImage img = null;
    private Image screenImage;
    private Graphics screenGrapic;

    private ImageIcon outReportImage = new ImageIcon("images/outReport.png");
    private ImageIcon inReportImage = new ImageIcon("images/inReport.png");
    private ImageIcon quitImage = new ImageIcon("images/quit.png");
    private ImageIcon accuseinquiryImage = new ImageIcon("images/신고조회.png");
    private ImageIcon outReportImage2 = new ImageIcon("images/outReport2.png");
    private ImageIcon inReportImage2 = new ImageIcon("images/inReport2.png");
    private ImageIcon quitImage2 = new ImageIcon("images/quit2.png");
    private ImageIcon accuseinquiryImage2 = new ImageIcon("images/신고조회2.png");


    private JButton quitButton = new JButton(quitImage);
    private JButton outReportButton = new JButton(outReportImage);
    private JButton inReportButton = new JButton(inReportImage);
    private JButton accuseinquiryButton = new JButton(accuseinquiryImage);

    public User() {
        JPanel pan = new JPanel();
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

        // introBackground = new
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

        add(accuseinquiryButton);
        accuseinquiryButton.setBounds(400, 260, 150, 75);
        accuseinquiryButton.setBorderPainted(false);
        accuseinquiryButton.setContentAreaFilled(false);
        accuseinquiryButton.setFocusPainted(false);

        accuseinquiryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                accuseinquiryButton.setIcon(accuseinquiryImage2);
                accuseinquiryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                accuseinquiryButton.setIcon(accuseinquiryImage);


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
