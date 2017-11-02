/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Huawei_gpon {   
    public  String conf;

    public  String huaGpon1( String file, int sfp, int onufirst, int onulast, int lineprofile_id, int superVlan) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
            for (int i = onufirst; i <= onulast; i++) {
                while ((line = br.readLine()) != null && onufirst<= onulast) {
                    conf = "ont add " + sfp + " " + onufirst + " sn-auth " +'"'+ line.toUpperCase() +'"'+ " omci ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                            + "\n"
                            + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + superVlan + " priority 0"
                            + "\n";
                    sb.append(conf);
                    onufirst++;
                }

        }
        br.close();
        return sb.toString();
    }
    public  String huaGpon2(int servPort, int superVlan, int plata, int sfp, int onuFirst, int onulast, int vlan){
        StringBuilder sb = new StringBuilder();
        for (int i = onuFirst; i <= onulast; i++) {
            conf = "service-port "+ servPort +" vlan "+ superVlan +" gpon 0/"+plata+"/"+ sfp +" ont "+ onuFirst +" gemport 1 multi-service user-vlan "+ superVlan +" tag-transform translate-and-add inner-vlan "+ vlan +" inner-priority 0\n"
                    +"\n";
        sb.append(conf);
            onuFirst++;
            servPort++;
            vlan++;
        }
        return sb.toString();
    }
    
    public  String huaGpon1UNO( String file, int sfp, int onufirst,  int lineprofile_id, int superVlan, String mac) {
        StringBuilder sb = new StringBuilder();
       
                    conf = "ont add " + sfp + " " + onufirst + " sn-auth " +'"'+ mac +'"'+ " omci ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                            + "\n"
                            + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + superVlan + " priority 0"
                            + "\n";
                    sb.append(conf);
        return sb.toString();
    }
    public  String huaGpon2UNO(int servPort, int superVlan, int plata, int sfp, int onuFirst,  int vlan){
        StringBuilder sb = new StringBuilder();
            conf = "service-port "+ servPort +" vlan "+ superVlan +" gpon 0/"+plata+"/"+ sfp +" ont "+ onuFirst +" gemport 1 multi-service user-vlan "+ superVlan +" tag-transform translate-and-add inner-vlan "+ vlan +" inner-priority 0\n"
                    +"\n";
        sb.append(conf);
        
        
        return sb.toString();
    }
    
    
    public  String huaGponGeneral1( String file, int sfp, int onufirst, int onulast, int lineprofile_id, int vlan ) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
            for (int i = onufirst; i <= onulast; i++) {
                while ((line = br.readLine()) != null && onufirst<= onulast) {
                    conf = "ont add " + sfp + " " + onufirst + " sn-auth " +'"'+ line.toUpperCase() +'"'+ " omci ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                            + "\n"
                            + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + vlan + " priority 0"
                            + "\n";
                    sb.append(conf);
                    onufirst++;
                }

        }
        br.close();
        return sb.toString();
    }
    public  String huaGponGeneral2(int servPort,  int plata, int sfp, int onuFirst, int onulast, int vlan){
        StringBuilder sb = new StringBuilder();
        for (int i = onuFirst; i <= onulast; i++) {
            conf = "service-port "+ servPort +" vlan "+ vlan +" gpon 0/"+plata+"/"+ sfp +" ont "+ onuFirst +" gemport 1 multi-service user-vlan "+ vlan +" tag-transform translate\n"
                    +"\n";
        sb.append(conf);
            onuFirst++;
            servPort++;
        }
        return sb.toString();
    }

    


}

