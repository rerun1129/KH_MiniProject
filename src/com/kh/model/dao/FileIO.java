package com.kh.model.dao;

import com.kh.model.vo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    private ArrayList<Info> InfoList = new ArrayList<>();            //정보조회와 신고정보 저장
    private ArrayList<ExportAllowInfo> EAList = new ArrayList<>();   //수출허가정보
    private ArrayList<ImportAllowInfo> IAList = new ArrayList<>();   //수입허가정보

    public ArrayList<Info> getInfoList() {
        return InfoList;
    }

    public void setInfoList(ArrayList<Info> infoList) {
        InfoList = infoList;
    }


    public ArrayList<ExportAllowInfo> getEAList() {
        return EAList;
    }

    public void setEAList(ArrayList<ExportAllowInfo> EAList) {
        this.EAList = EAList;
    }

    public ArrayList<ImportAllowInfo> getIAList() {
        return IAList;
    }

    public void setIAList(ArrayList<ImportAllowInfo> IAList) {
        this.IAList = IAList;
    }





    public void importSave() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("import.dat", true))) {

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("파일이 없습니다.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void importLoad() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("import.dat"))) {

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }








    public void exportSave() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("export.dat", true))) {

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("파일이 없습니다.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void exportLoad() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("export.dat"))) {

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }








    public void importAllowSave() {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("importConfirm.dat", true)))) {
            out.writeObject(IAList);
            System.out.println("저장 완료");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("파일이 없습니다.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void importAllowLoad() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("importConfirm.dat")))) {
            ArrayList<ImportAllowInfo> loadIA = (ArrayList<ImportAllowInfo>)in.readObject();
            IAList.addAll(loadIA);
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }








    public void exportAllowSave() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("exportConfirm.dat", true))) {
            out.writeObject(EAList);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("파일이 없습니다.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void exportAllowLoad() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("exportConfirm.dat"))) {
            ArrayList<ExportAllowInfo> loadEA = (ArrayList<ExportAllowInfo>)in.readObject();
            EAList.addAll(loadEA);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }





    public void searchInfo(){



    }




}
