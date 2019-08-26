package subject;


import java.util.Date;

public class Ip地址无效化_1108 {
    /*
        给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。

    所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

     
    示例 1：

    输入：address = "1.1.1.1"
    输出："1[.]1[.]1[.]1"
    示例 2：

    输入：address = "255.100.50.0"
    输出："255[.]100[.]50[.]0"

     */
    public static void main(String[] args) {
        String address = "255.100.50.0";
        long l = System.currentTimeMillis();
        for (int i = 0; i <1000000 ; i++) {
            String s = myDefangIPaddr(address);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    public static String myDefangIPaddr(String address) {
        String restStr = "";
        String[] split = address.split("\\.");
        for (int i = 0; i < split.length; i++) {
            if (i < split.length - 1) {
                restStr += split[i] + "[.]";
            } else {
                restStr += split[i];
            }
        }

        return restStr;
    }

    public static String defangIPaddr(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append('[');
                s.append('.');
                s.append(']');
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();
    }

}
