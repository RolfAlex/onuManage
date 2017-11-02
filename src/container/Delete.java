/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

/**
 *
 * @author alex
 */
public class Delete {

    public String cou;

    public String remove(int first, int last) {
        StringBuilder sb = new StringBuilder();
        for (int j = first; j <= last; j++) {
            cou = "no onu " + first + "\n";
            first++;
            sb.append(cou);
        }
        return sb.toString();
    }

    public String counter(int first, int last) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            cou = first + "\n";
            first++;
            sb.append(cou);
        }
        return sb.toString();
    }
     public String servport(int f, int last) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = f; i <= last; i++) {
            cou = "undo service-port " + i + "\n";
            sb.append(cou);
        }
        return sb.toString();
    }

    public String onudel(int sfp, int onu_f, int onu_l) {
        StringBuilder sb = new StringBuilder();
        for (int i = onu_f; i <= onu_l; i++) {
            cou = "ont delete " + sfp + " " + onu_f + "\n";

            onu_f++;
            sb.append(cou);
        }
        return sb.toString();
    }

}
