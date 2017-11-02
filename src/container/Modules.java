/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.xml.transform.Source;

/**
 *
 * @author alex
 */
public class Modules {

    public String getConfEpon(String ip, String log, String pass) throws FileNotFoundException, IOException, InterruptedException {
        String fil = new File("onu.txt").getAbsolutePath();
        File f = new File(fil);
        StringBuilder sb = new StringBuilder();
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("display ont autofind all\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
            raf.write(command.getBytes());
            raf.write("\n".getBytes());

        }

        return sb.toString();

    }

    public String registrOnuEp(String ip, String log, String pass, String board, String sfp, StringBuilder sb) throws FileNotFoundException, IOException, InterruptedException {

        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("interface epon 0/" + board + "\n");
        s_in.print(sb.toString());
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");

        }
        return sb.toString();
    }

    public String registrOnuGp(String ip, String log, String pass, String board, String sfp, StringBuilder sb) throws FileNotFoundException, IOException, InterruptedException {

        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("interface gpon 0/" + board + "\n");
        s_in.print(sb.toString());
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");

        }
        return sb.toString();
    }

    public static HashMap<String, String> getParamOnu(String macc) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        HashMap<String, String> tmpHashMap = new HashMap<String, String>();
        String file = new File("onu.txt").getCanonicalPath();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String w = "";
        String sfptmp = "";
        String boardtmp = "";
        String mactmp = "";
        String sfp = "null";
        String board = "null";
        String mac = "null";
        while ((w = br.readLine()) != null) {
            String[] ar = w.split(" ");
            if (ar.length > 10 && ar[3].equalsIgnoreCase("F/S/P")) {
                String[] f = ar[19].split("/");
                System.out.println(Arrays.toString(f));
                sfptmp = f[f.length - 1];
                boardtmp = f[f.length - 2];
            }
            if (ar.length > 10 && ar[3].equalsIgnoreCase("ONT") && ar[4].equalsIgnoreCase("MAC")) {
                mactmp = ar[ar.length - 1];
                String e = mactmp.substring(10, 14);
                if (e.equalsIgnoreCase(macc)) {
                    mac = mactmp;
                    sfp = sfptmp;
                    board = boardtmp;
                    break;
                }
            }
            if (ar.length > 10 && ar[3].equalsIgnoreCase("Ont") && ar[4].equalsIgnoreCase("SN")) {
                mactmp = ar[ar.length - 1];
                String e = mactmp.substring(12, 16);
                if (e.equalsIgnoreCase(macc)) {
                    mac = mactmp;
                    sfp = sfptmp;
                    board = boardtmp;
                    break;
                }
            }

        }
        tmpHashMap.put("mac", mac);
        tmpHashMap.put("sfp", sfp);
        tmpHashMap.put("plata", board);

        return tmpHashMap;
    }

    //comands
    public String disOntInfo(String ip, String log, String pass, String board, String sfp, String onu, String flag) throws IOException, InterruptedException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        if (flag.equalsIgnoreCase("Gpon")) {
            s_in.print("interface gpon 0/" + board + "\n");
        }
        if (flag.equalsIgnoreCase("Epon")) {
            s_in.print("interface epon 0/" + board + "\n");
        }
        s_in.print("display ont info " + sfp + " " + onu + "\n");
        s_in.print("\u0020");

        s_in.flush();

        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");

        }

        return sb.toString();

    }

    public static String disOntInfoAll(String ip, String log, String pass, String board, String sfp) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("display  ont info 0 " + board + " " + sfp + " all\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();
        int i = 0;
        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String disOntOptic(String ip, String log, String pass, String board, String sfp, String onu, String flag) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        if (flag.equalsIgnoreCase("Gpon")) {
            s_in.print("interface gpon 0/" + board + "\n");
        }
        if (flag.equalsIgnoreCase("Epon")) {
            s_in.print("interface epon 0/" + board + "\n");
        }
        s_in.print("display ont optical-info " + sfp + " " + onu + "\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public String getOnuOpticInfo(String ip, String log, String pass, String board, String sfp, String onu, String flag) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        if (flag.equalsIgnoreCase("Gpon")) {
            s_in.print("interface gpon 0/" + board + "\n");
        }
        if (flag.equalsIgnoreCase("Epon")) {
            s_in.print("interface epon 0/" + board + "\n");
        }
        s_in.print("display ont optical-info " + sfp + " " + onu + "\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            String[] ar = command.split("  ");
//            System.out.println(Arrays.toString(ar));
            if (ar.length > 1 && ar[1].equalsIgnoreCase("Rx optical power(dBm)")) {
                sb.append(ar[ar.length - 1].replace(":", "") + " dBm");
//            sb.append("\n");

            }
        }
        return sb.toString();

    }

    public String disCurConfOnt(String ip, String log, String pass, String board, String sfp, String onu) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("display current-configuration ont 0/" + board + "/" + sfp + " " + onu + "\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("return") && !command.equalsIgnoreCase(" No configuration data")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public String disCurConfServ(String ip, String log, String pass, String servPort) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("display  current-configuration service-port " + servPort + "\n");
        s_in.print("\u0020");

        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("return") && !command.equalsIgnoreCase(" No configuration data")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String delOnu(String ip, String log, String pass, String board, String sfp, String onu, String servPort, String flag) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.print("config\n");
        s_in.flush();
        s_in.print("undo  service-port " + servPort + "\n");
        if (flag.equalsIgnoreCase("Gpon")) {
            s_in.print("interface gpon 0/" + board + "\n");
        }
        if (flag.equalsIgnoreCase("Epon")) {
            s_in.print("interface epon 0/" + board + "\n");
        }
        s_in.print("ont delete " + sfp + " " + onu + "\n");

        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");

        s_in.print("\n");
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("return") && !command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public String saveOlt(String ip, String log, String pass) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("save\n\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.flush();
        Thread.sleep(4000);
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }

    public void logg(String log) throws FileNotFoundException, IOException {
        File f = new File("sys.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        String com = "";
        raf.write(log.getBytes());
    }

    public String readLog(String d) throws IOException {
        RandomAccessFile file = new RandomAccessFile(d, "r");
        String res = "";
        int b = file.read();
        // побитово читаем символы и плюсуем их в строку
        while (b != -1) {
            res = res + (char) b;
            b = file.read();
        }
        file.close();
        return res;
    }

    
    public String getMac(String ip, String log, String pass, String servisePort) throws InterruptedException, IOException {

        StringBuilder sb = new StringBuilder();
        Socket s = new Socket(ip, 23);
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";

        try {
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print(pass + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("display  mac-address service-port " + servisePort + "\n\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\n");
        s_in.flush();
        Thread.sleep(4000);
        s_in.print("@\n");
        s_in.print("\n");
        s_in.flush();

        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            command = br.readLine();
            sb.append(command);
            sb.append("\n");
        }
        return sb.toString();

    }
    public Object[][] getTable(String ip, String log, String pass, String board, String sfp) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";
        try {
            Socket s = new Socket(ip, 23);
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        s_in.print(pass + "\n");
        s_in.flush();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("display  ont info 0 " + board + " " + sfp + " all\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");

        s_in.print("\n");
        s_in.print("2@\n");
        s_in.print("\n");
        s_in.flush();
        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            try {
                command = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] tmp = command.split(" ");
            int tt = tmp.length;
            if (tt > 60) {
                sb2 = new StringBuilder();
                String[] tmp2 = Arrays.copyOfRange(tmp, 47, tmp.length);
                for (String ss : tmp2) {
                    sb2.append(" ");
                    sb2.append(ss);
                }
                command = sb2.toString();
            }
            sb.append(command);
            sb.append("\n");
        }
        String[] er = sb.toString().split("  -----------------------------------------------------------------------------");
        String x = er[2];
        while (x.contains("  ")) {
            String replace2 = x.replace("  ", " ");
            String replace = replace2.replace(" 0/ ", "0/");
            x = replace;
        }
        String[] cou = x.split("\n");
        Object[][] finall = new Object[cou.length][10];
        for (int j = 1; j < cou.length; j++) {
            String[] tm = cou[j].split(" ");
            for (int k = 0; k < tm.length; k++) {
                finall[j][k] = tm[k];
            }
        }
        return finall;
    }

    public String getOnlineOnu(String ip, String log, String pass, String board, String sfp) {
        String onu = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";
        try {
            Socket s = new Socket(ip, 23);
            s_out = s.getOutputStream();
            s_in = new PrintWriter(s_out, true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        } catch (Exception e) {
        }
        s_in.print(log + "\n"); //diptan@utg
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        s_in.print(pass + "\n");
        s_in.flush();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("display  ont info 0 " + board + " " + sfp + " all\n");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");
        s_in.print("\u0020");

        s_in.print("\n");
        
        s_in.print("2@\n");
        s_in.print("\n");
        s_in.flush();
        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            try {
                command = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] tmp = command.split(" ");
            int tt = tmp.length;
            if (tt > 60) {
                sb2 = new StringBuilder();
                String[] tmp2 = Arrays.copyOfRange(tmp, 47, tmp.length);
                for (String ss : tmp2) {
                    sb2.append(" ");
                    sb2.append(ss);
                }
                command = sb2.toString();
            }
            sb.append(command);
            sb.append("\n");
        }
        String[] er = sb.toString().split("  -----------------------------------------------------------------------------");
        onu = er[5];

        return onu;

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(disOntOptic("10.0.167.7", "diptan@utg", "master", "0", "1", "2", "gpon"));
//        System.out.println(delOnuGp("10.0.167.7", "diptan@utg", "master", "0", "0", "2", "103"));
//System.out.println(disOntInfoAll("10.0.167.7", "diptan@utg", "master", "0", "1"));
    }

}
//       String mace = "jrfnejrnjrnf";
//           System.out.println(e);
//        
//        System.out.println(disOntInfo("10.0.240.7", "diptan@utg", "master", "0", "15", "0", "gPON"));
//System.out.println(disOntOptic("10.0.240.7", "diptan@utg", "master", "1", "1", "6", "Epon"));
//System.out.println(disCurConfOnt("10.0.240.7", "diptan@utg", "master", "0", "1", "6"));
//        System.out.println(disCurConfServ("10.0.240.7", "diptan@utg", "master", "2154"));
//System.out.println(getParamOnu("ECDF").get("mac"));
//        System.out.println(getConfEpon("10.0.162.7", "diptan@utg", "master"));
//        System.out.println(getParamOnuGp("3183").get("mac"));
//        System.out.println(saveOlt("10.0.240.7", "diptan@utg", "master"));
//            disOntInfo("10.0.240.7", "diptan@utg", "master", "rjfrwj");
//File d;
//        d = new File("/home/alex/NetBeansProjects/JavaApplication1/sys.txt");
//logg("jvnekvnjernvknrjvn \n jfnekrvnerjnvernvjo");
//        System.out.println(readLog(d));

