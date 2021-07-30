package com.kh.model.vo;


import javax.swing.*;
import java.io.*;

public class LimitList {


    public void EI(String exI) {
        try (FileWriter fw = new FileWriter("exportInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (exI.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (str.equals(exI)) {
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }

            }
            fw.write(exI);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null, "추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
    }


    public void II(String imI) {
        try (FileWriter fw = new FileWriter("importInhibit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("importInhibit.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (imI.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (str.equals(imI)) {
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(imI);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null, "추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }

    }


    public void EL(String exL) {
        try (FileWriter fw = new FileWriter("exportLimit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("exportLimit.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (exL.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (str.equals(exL)) {
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(exL);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null, "추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }

    }


    public void IL(String imL) {
        try (FileWriter fw = new FileWriter("importLimit.txt", true);
             BufferedReader br = new BufferedReader(new FileReader("importLimit.txt"))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (imL.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (str.equals(imL)) {
                    JOptionPane.showMessageDialog(null, "중복되는 물품이 있습니다.");
                    return;
                }
            }
            fw.write(imL);
            fw.write("\r\n");
            JOptionPane.showMessageDialog(null, "추가 완료!");
        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
    }


    public void ELD(String exL) {

        File inventory = new File("exportLimit.txt");
        File temp = new File("deletedAfter.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
             BufferedReader br = new BufferedReader(new FileReader(inventory))) {
            String line;
            int lineCount = 0;
            int lineCount2 = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                if (exL.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (!line.equals(exL)) {
                    bw.write(line + System.getProperty("line.separator"));
                    lineCount2++;
                }
            }
            if (lineCount != lineCount2) {
                JOptionPane.showMessageDialog(null, exL + " 삭제 완료.");
            } else if (lineCount == lineCount2) {
                JOptionPane.showMessageDialog(null, "삭제할 물품명이 존재하지 않습니다.");
            }

        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
        inventory.delete();
        temp.renameTo(inventory);
    }

    public void EID(String exI) {

        File inventory = new File("exportInhibit.txt");
        File temp = new File("deletedAfter.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
             BufferedReader br = new BufferedReader(new FileReader(inventory))) {
            String line;
            int lineCount = 0;
            int lineCount2 = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                if (exI.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (!line.equals(exI)) {
                    bw.write(line + System.getProperty("line.separator"));
                    lineCount2++;
                }
            }
            if (lineCount != lineCount2) {
                JOptionPane.showMessageDialog(null, exI + " 삭제 완료.");
            } else if (lineCount == lineCount2) {
                JOptionPane.showMessageDialog(null, "삭제할 물품명이 존재하지 않습니다.");
            }

        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
        inventory.delete();
        temp.renameTo(inventory);
    }

    public void IID(String imI) {
        File inventory = new File("importInhibit.txt");
        File temp = new File("deletedAfter.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
             BufferedReader br = new BufferedReader(new FileReader(inventory))) {
            String line;
            int lineCount = 0;
            int lineCount2 = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                if (imI.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (!line.equals(imI)) {
                    bw.write(line + System.getProperty("line.separator"));
                    lineCount2++;
                }
            }
            if (lineCount != lineCount2) {
                JOptionPane.showMessageDialog(null, imI + " 삭제 완료.");
            } else if (lineCount == lineCount2) {
                JOptionPane.showMessageDialog(null, "삭제할 물품명이 존재하지 않습니다.");
            }

        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
        inventory.delete();
        temp.renameTo(inventory);
    }

    public void ILD(String imL) {
        File inventory = new File("importLimit.txt");
        File temp = new File("deletedAfter.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
             BufferedReader br = new BufferedReader(new FileReader(inventory))) {
            String line;
            int lineCount = 0;
            int lineCount2 = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                if (imL.length() == 0) {
                    JOptionPane.showMessageDialog(null, "공백은 입력할수 없습니다.");
                    return;
                }
                if (!line.equals(imL)) {
                    bw.write(line + System.getProperty("line.separator"));
                    lineCount2++;
                }
            }
            if (lineCount != lineCount2) {
                JOptionPane.showMessageDialog(null, imL + " 삭제 완료.");
            } else if (lineCount == lineCount2) {
                JOptionPane.showMessageDialog(null, "삭제할 물품명이 존재하지 않습니다.");
            }

        } catch (IOException e) {
            System.out.println("문제가 생겼습니다.");
        }
        inventory.delete();
        temp.renameTo(inventory);
    }
}

