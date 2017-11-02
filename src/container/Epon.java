package container;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Epon {

    public String conf;
    public  String getEpOnuList( String file,  int onufirst, int onulast) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        for (int i = onufirst; i <= onulast; i++) {
            while ((line = br.readLine()) != null && onufirst<= onulast) {

                conf = "onu "+onufirst+ " type EPON_ONE mac "+ line+" ip-cfg static \n";
                       
                sb.append(conf);
                onufirst++;
            }

        }
        br.close();
        return sb.toString();
    }
    
    public String getEpon(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            conf = "interface epon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "admin enable\n"
                    + "ems-autocfg-request disable\n"
                    + "encrypt direction downstream  enable  vport 1\n"
                    + "switchport mode hybrid vport 1\n"
                    + "switchport vlan " + vlBegin++ + " tag vport 1\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();
    }

    public String getEponMg(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            conf = "pon-onu-mng epon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "auto-config\n"
                    + "compatibility enable mode CTC\n"
                    + "vlan port eth_0/1 mode tag vlan " + vlBegin++ + " priority 0\n"
                    + "interface-loopdetect eth_0/1 activate\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();
    }
public String getEponUNO(int plata, int sfp, int first,  int vlBegin, String mac) {
            conf =  "onu "+first+" type EPON_ONE mac "+mac+" ip-cfg static \n"
                    + "exit \n"
                    + "interface epon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "admin enable\n"
                    + "ems-autocfg-request disable\n"
                    + "encrypt direction downstream  enable  vport 1\n"
                    + "switchport mode hybrid vport 1\n"
                    + "switchport vlan " + vlBegin++ + " tag vport 1\n"
                    + "!\n";
       
        return conf;
    }

    public String getEponMgUNO(int plata, int sfp, int first,  int vlBegin) {
            conf = "pon-onu-mng epon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "auto-config\n"
                    + "compatibility enable mode CTC\n"
                    + "vlan port eth_0/1 mode tag vlan " + vlBegin + " priority 0\n"
                    + "interface-loopdetect eth_0/1 activate\n"
                    + "!\n";
          
        
        return conf;
    }
}
