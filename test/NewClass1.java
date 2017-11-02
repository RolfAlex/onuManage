
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class NewClass1 {
    public static void main(String[] args) throws IOException, InterruptedException {
          StringBuilder sb = new StringBuilder();
        Socket s = new Socket("10.0.167.7", 23);
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
        s_in.print("diptan@utg" + "\n"); //diptan@utg
        Thread.sleep(500);
        s_in.print("master" + "\n");
        s_in.flush();
        Thread.sleep(500);
        s_in.print("enable\n");
        s_in.flush();
        s_in.print("config\n");
        s_in.print("interface gpon 0/0\n");
        for (int i = 0; i < 10; i++) {
        s_in.print("display  ont optical-info 0 " + i +"\n");
        s_in.print("\u0020");
        }
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
        System.out.println(sb.toString());
    }
}