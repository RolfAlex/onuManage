/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class OltLists {

    String path = new File("Report.txt").getAbsolutePath();
    File fileList = new File("Report.txt");

    public String[] getOltList() {
        File f = new File("oltList").getAbsoluteFile();
        File[] filename = f.listFiles();
        String[] array = new String[filename.length];
        for (int i = 0; i < filename.length; i++) {
            array[i] = filename[i].getName();

        }
        return array;

    }

    public void clearFile() throws IOException {
        File fileList = new File("onu.txt").getAbsoluteFile();

        FileWriter fstream1 = new FileWriter(fileList.getAbsoluteFile());// конструктор с одним параметром - для перезаписи
        BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
        out1.write(""); // очищаем, перезаписав поверх пустую строку
        out1.close(); // закрываем
    }

    public  HashMap<String, String> getParamOlt(String olt) {
        HashMap<String, String> hashh = new HashMap<String, String>();
        try {
            StringBuilder sb = new StringBuilder();
            File fr = new File("oltList/").getCanonicalFile();
            File[] ar = fr.listFiles();
            for (int i = 0; i < ar.length; i++) {
                if (ar[i].getName().equalsIgnoreCase(olt)) {
                    Path path = Paths.get(ar[i].getAbsolutePath());
                    Scanner scanner = new Scanner(path);
                    //читаем построчно
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        sb.append(line);
                        sb.append("\n");
                    }
                }
            }
            String[] s = sb.toString().split("\n");

            hashh.put("ip", s[1]);
            hashh.put("log",s[2]);
            hashh.put("pass", s[3]);
        } catch (IOException ex) {
            Logger.getLogger(OltLists.class.getName()).log(Level.SEVERE, null, ex);
        }

            return hashh;
        }
    public static void main(String[] args) {
        
    
    }
    
}