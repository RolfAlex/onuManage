
import container.Form;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewClass extends JFrame {

    public static HashMap<String, String> getOltVal(String board, String sfp, String olt) throws IOException {
        HashMap<String, String> hash = new HashMap<String, String>();
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
        hash.put("ip", s[1]);
        hash.put("log", s[2]);
        hash.put("pass", s[3]);
        int a = s.length - 4;
        int b = 3;
        for (int i = 0; i <= a; i++) {
            String[] arr = s[b].split(" ");
            if (arr[0].equals(board)) {
                hash.put("plata", arr[0]);
                hash.put("type", arr[1]);
                hash.put("line", arr[2]);
                hash.put("SVLAN", arr[3]);
                break;
            }
            b++;
        }
        return hash;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String ip = "10.0.167.7";
        String log = "diptan@utg";
        String pass = "master";
        String board = "0";
        String sfp = "0";

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        OutputStream s_out = null;
        PrintWriter s_in = null;
        BufferedReader br = null;
        String command = "";
        Scanner in = new Scanner(System.in);

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
        int i = 0;
        while(true){
            System.out.println("halllll");
            s_in.print(in.nextLine());
            System.out.println("Halloooo");
            s_in.print("\u0020");
            s_in.print("\u0020");
            s_in.print("2@\n");
            s_in.flush();

        
        while (!command.equalsIgnoreCase("  % Unknown command, the error locates at '^'")) {
            try {
                command = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(command);
            command = "";
        }
        }
//            String[] tmp = command.split(" ");
//            int tt = tmp.length;
//            if (tt > 60) {
//                sb2 = new StringBuilder();
//                String[] tmp2 = Arrays.copyOfRange(tmp, 47, tmp.length);
//                for (String ss : tmp2) {
//                    sb2.append(" ");
//                    sb2.append(ss);
//                }
//                command = sb2.toString();
//            }
//
//            sb.append(command);
//            sb.append("\n");
//        }
//        String[] er = sb.toString().split("  -----------------------------------------------------------------------------");
//        String x = er[2];
//        String[] w = x.split(" ");
//        System.out.println(er[5]);
//        while (x.contains("  ")) {
//            String replace2 = x.replace("  ", " ");
//            String replace = replace2.replace(" 0/ ", "0/");
//
//            x = replace;
//        }
//            System.out.println(x);

//        String[] cou = x.split("\n");
//        System.out.println(Arrays.toString(cou));
//        Object[][] eeee = new Object[cou.length][9];
//        for (int j = 1; j < cou.length; j++) {
//            String[] tm = cou[j].split(" ");
//            for (int k = 0; k < tm.length; k++) {
//                eeee[j][k] = tm[k];
//            }
//
//        }
//        for (int ii = 0; ii < eeee.length; ii++) {
//            for (int jj = 0; jj < eeee.length; jj++) {
//                System.out.print(eeee[ii][jj]);
//            }
//            System.out.println();
//        }

    }
}
