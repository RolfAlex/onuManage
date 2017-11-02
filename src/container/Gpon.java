package container;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gpon {

    public String conf;
 public  String getGpOnuList( String file,  int onufirst, int onulast) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        for (int i = onufirst; i <= onulast; i++) {
            while ((line = br.readLine()) != null && onufirst<= onulast) {

                conf = "onu "+onufirst+" type GPON_ONE sn "+ line + "\n";
                       
                sb.append(conf);
                onufirst++;
            }

        }
        br.close();
        return sb.toString();
    }

    public String getGpon(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            conf = "interface gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "tcont 1 name T-INET profile UP-500MB\n"
                    + "gemport " + first + " name G-INET unicast tcont 1 dir both\n"
                    + "gemport " + first + " traffic-limit downstream DOWN-500MB\n"
                    + "switchport mode hybrid vport " + first + "\n"
                    + "switchport vlan " + vlBegin++ + "  tag vport " + first + "\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();

    }

    public String getGponmgm(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {

            conf = "pon-onu-mng gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "flow " + first + " switch switch_0/1\n"
                    + "flow mode " + first + " tag-filter vid-filter untag-filter discard\n"
                    + "flow " + first + " priority 0 vid " + vlBegin + "\n"
                    + "gemport " + first + " flow " + first + "\n"
                    + "vlan-filter-mode ethuni eth_0/1 tag-filter vid-filter untag-filter transparent\n"
                    + "vlan-filter ethuni eth_0/1 priority 0 vid " + vlBegin + "\n"
                    + "onu-vlan ethuni eth_0/1 up-mode overwrite up-prio 0 up-vid " + vlBegin++ + " down-mode untag\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();
    }

    
     public String getGponUNO(int plata, int sfp, int first, int vlBegin, String mac) {
            conf = "onu "+first+" type GPON_ONE sn "+ mac + "\n"
                    + "exit \n"
                    +"interface gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "tcont 1 name T-INET profile UP-500MB\n"
                    + "gemport " + first + " name G-INET unicast tcont 1 dir both\n"
                    + "gemport " + first + " traffic-limit downstream DOWN-500MB\n"
                    + "switchport mode hybrid vport " + first + "\n"
                    + "switchport vlan " + vlBegin + "  tag vport " + first + "\n"
                    + "!\n";
        
        return conf;

    }

    public  String getGponmgmUNO(int plata, int sfp, int first, int vlBegin) {

            conf = "pon-onu-mng gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "flow " + first + " switch switch_0/1\n"
                    + "flow mode " + first + " tag-filter vid-filter untag-filter discard\n"
                    + "flow " + first + " priority 0 vid " + vlBegin + "\n"
                    + "gemport " + first + " flow " + first + "\n"
                    + "vlan-filter-mode ethuni eth_0/1 tag-filter vid-filter untag-filter transparent\n"
                    + "vlan-filter ethuni eth_0/1 priority 0 vid " + vlBegin + "\n"
                    + "onu-vlan ethuni eth_0/1 up-mode overwrite up-prio 0 up-vid " + vlBegin + " down-mode untag\n"
                    + "!\n";
        
        return conf;
    }
   
   
}
    