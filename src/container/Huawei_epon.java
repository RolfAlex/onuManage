/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Huawei_epon {
    public   String conf;
    
    public  String huaEpon1( String file, int sfp, int onufirst, int onulast, int lineprofile_id, int superVlan) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        for (int i = onufirst; i <= onulast; i++) {
            while ((line = br.readLine()) != null && onufirst<= onulast) {

                conf = "ont add " + sfp + " " + onufirst + " mac-auth "+ line.toUpperCase() +" oam ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                        + "\n"
                        + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + superVlan
                        + "\n";
                sb.append(conf);
                onufirst++;
            }

        }
        br.close();
        return sb.toString();
    }
    public  String huaEpon2(int servPort, int superVlan, int plata, int sfp, int onuFirst, int onulast, int vlan){
        StringBuilder sb = new StringBuilder();
        for (int i = onuFirst; i <= onulast; i++) {
            conf = "service-port "+ servPort +" vlan "+ superVlan +" epon 0/"+ plata +"/"+ sfp +" ont "+ onuFirst +" multi-service user-vlan "+ superVlan +" tag-transform translate-and-add inner-vlan "+ vlan +" inner-priority 0\n"
                    +"\n";
            sb.append(conf);
            onuFirst++;
            servPort++;
            vlan++;
        }
        return sb.toString();
    }
     
    
    public  String huaEpon1UNO( String file, int sfp, int onufirst,  int lineprofile_id, int superVlan,  String mac) {
        StringBuilder sb = new StringBuilder();
        
                conf = "ont add " + sfp + " " + onufirst + " mac-auth "+ mac +" oam ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                        + "\n"
                        + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + superVlan
                        + "\n";
                sb.append(conf);
            

        
        return sb.toString();
    }
    public  String huaEpon2UNO(int servPort, int superVlan, int plata, int sfp, int onuFirst, int vlan){
        StringBuilder sb = new StringBuilder();
            conf = "service-port "+ servPort +" vlan "+ superVlan +" epon 0/"+ plata +"/"+ sfp +" ont "+ onuFirst +" multi-service user-vlan "+ superVlan +" tag-transform translate-and-add inner-vlan "+ vlan +" inner-priority 0\n"
                    +"\n";
            sb.append(conf);
       
        
        return sb.toString();
    }


    
    
   public  String huaEponGeneral1( String file, int sfp, int onufirst, int onulast, int lineprofile_id, int vlan) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        for (int i = onufirst; i <= onulast; i++) {
            while ((line = br.readLine()) != null && onufirst<= onulast) {

                conf = "ont add " + sfp + " " + onufirst + " mac-auth "+ line.toUpperCase() +" oam ont-lineprofile-id " + lineprofile_id + " ont-srvprofile-id " + lineprofile_id + "\n"
                        + "\n"
                        + "ont port native-vlan " + sfp + " " + onufirst + " eth 1 vlan " + vlan
                        + "\n";
                sb.append(conf);
                onufirst++;
            }

        }
        br.close();
        return sb.toString();
    }
    public  String huaEponGeneral2(int servPort,  int plata, int sfp, int onuFirst, int onulast, int vlan){
        StringBuilder sb = new StringBuilder();
        for (int i = onuFirst; i <= onulast; i++) {
            conf = "service-port "+ servPort +" vlan "+ vlan +" epon 0/"+ plata +"/"+ sfp +" ont "+ onuFirst +" multi-service user-vlan "+ vlan +" tag-transform translate\n"
                    +"\n";
            sb.append(conf);
            onuFirst++;
            servPort++;
        }
        return sb.toString();
    }
   
}