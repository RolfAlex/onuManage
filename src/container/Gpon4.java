package container;

public class Gpon4 {

    public String conf;

    public String getGpon4(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            conf = "interface gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "name ONU-" + sfp + ":" + first + "\n"
                    + "description ONU-" + sfp + ":" + first + "\n"
                    + "tcont 1 name T-INET profile UP-500MB\n"
                    + "gemport " + first + " name G-INET unicast tcont 1 dir both\n"
                    + "gemport " + first + " traffic-limit downstream DOWN-500MB\n"
                    + "switchport mode hybrid vport " + first + "\n"
                    + "switchport vlan " + vlBegin++ + "  tag vport " + first + "\n"
                    + "dhcp-option82 enable vport " + first + "\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();
    }

    public String getGponmgm4(int plata, int sfp, int first, int last, int vlBegin) {
        StringBuilder sb = new StringBuilder();
        for (int i = first; i <= last; i++) {
            conf = "pon-onu-mng gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                    + "flow " + first + " switch switch_0/1\n"
                    + "flow mode " + first + " tag-filter vid-filter untag-filter discard\n"
                    + "gemport " + first + " flow " + first + "\n"
                    + "switchport-bind switch_0/1 iphost 1\n"
                    + "ip-host 1 dhcp-enable true ping-response true traceroute-response true\n"
                    + "vlan-filter-mode iphost 1 tag-filter vid-filter untag-filter discard\n"
                    + "vlan-filter iphost 1 priority 0 vid " + vlBegin++ + "\n"
                    + "dhcp-ip ethuni eth_0/1 from-onu\n"
                    + "dhcp-ip ethuni eth_0/2 from-onu\n"
                    + "dhcp-ip ethuni eth_0/3 from-onu\n"
                    + "dhcp-ip ethuni eth_0/4 from-onu\n"
                    + "!\n";
            first++;
            sb.append(conf);
        }
        return sb.toString();
    }

    public String getGpon4UNO(int plata, int sfp, int first, int vlBegin, String mac) {

        conf = "onu " + first + " type GPON_FOUR_WIFI sn " + mac + "\n"
                + "exit \n"
                + "interface gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                + "name ONU-" + sfp + ":" + first + "\n"
                + "description ONU-" + sfp + ":" + first + "\n"
                + "tcont 1 name T-INET profile UP-500MB\n"
                + "gemport " + first + " name G-INET unicast tcont 1 dir both\n"
                + "gemport " + first + " traffic-limit downstream DOWN-500MB\n"
                + "switchport mode hybrid vport " + first + "\n"
                + "switchport vlan " + vlBegin++ + "  tag vport " + first + "\n"
                + "dhcp-option82 enable vport " + first + "\n"
                + "!\n";
        return conf;
    }

    public String getGponmgm4UNO(int plata, int sfp, int first, int vlBegin) {
        conf = "pon-onu-mng gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                + "flow " + first + " switch switch_0/1\n"
                + "flow mode " + first + " tag-filter vid-filter untag-filter discard\n"
                + "gemport " + first + " flow " + first + "\n"
                + "switchport-bind switch_0/1 iphost 1\n"
                + "ip-host 1 dhcp-enable true ping-response true traceroute-response true\n"
                + "vlan-filter-mode iphost 1 tag-filter vid-filter untag-filter discard\n"
                + "vlan-filter iphost 1 priority 0 vid " + vlBegin + "\n"
                + "dhcp-ip ethuni eth_0/1 from-onu\n"
                + "dhcp-ip ethuni eth_0/2 from-onu\n"
                + "dhcp-ip ethuni eth_0/3 from-onu\n"
                + "dhcp-ip ethuni eth_0/4 from-onu\n"
                + "!\n";

        return conf;
    }

    public String getZTE4UNO(int plata, int sfp, int first, int vlBegin, String mac) {

        conf = "onu " + first + " type GPON_FOUR_WIFI sn " + mac + "\n"
                + "exit \n"
                + "interface gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                + "description ONU-" + sfp + ":" + first + "\n"
                + "tcont 1 name T-INET profile UP-500MB\n"
                + "gemport 1 name G-INET unicast tcont 1 dir both\n"
                + "gemport 1 traffic-limit downstream DOWN-500MB \n"
                + "switchport mode hybrid vport 1\n"
                + "switchport vlan " + vlBegin + "  tag vport 1\n"
                + "dhcp-option82 enable vport 1 \n"
                + "!\n";
        return conf;
    }

    public String getZTEmgm4UNO(int plata, int sfp, int first, int vlBegin) {
        conf = "pon-onu-mng gpon-onu_1/" + plata + "/" + sfp + ":" + first + "\n"
                + "flow mode 1 tag-filter vid-filter untag-filter discard\n"
                + "flow 1 priority 0 vid " + vlBegin + "\n"
                + "gemport 1 flow 1\n"
                + "switchport-bind switch_0/1 iphost 1\n"
                + "ip-host 1 dhcp-enable true ping-response true traceroute-response true\n"
                + "vlan-filter-mode iphost 1 tag-filter vid-filter untag-filter discard\n"
                + "vlan-filter iphost 1 priority 0 vid " + vlBegin + "\n"
                + "dhcp-ip ethuni eth_0/1 from-onu\n"
                + "dhcp-ip ethuni eth_0/2 from-onu\n"
                + "dhcp-ip ethuni eth_0/3 from-onu\n"
                + "dhcp-ip ethuni eth_0/4 from-onu\n"
                + "!";

        return conf;
    }
}
