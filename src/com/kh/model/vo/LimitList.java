package com.kh.model.vo;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LimitList {


    public void EI(String exI) {
        try (FileWriter fw = new FileWriter("exportInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null){
                if(str.equals(exI)){
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }

            fw.write(exI);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null,"추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
    }


    public void II(String imI) {
        try (FileWriter fw = new FileWriter("exportInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null){
                if(str.equals(imI)){
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(imI);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null,"추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }

    }


    public void EL(String exL) {
        try (FileWriter fw = new FileWriter("exportInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null){
                if(str.equals(exL)){
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(exL);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null,"추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }

    }


    public void IL(String imL) {
        try (FileWriter fw = new FileWriter("exportInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null){
                if(str.equals(imL)){
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(imL);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null,"추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
    }

}
