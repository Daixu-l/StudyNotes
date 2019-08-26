package subject;

public class 宝石与石头_771 {
    /*
    给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

    J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

    示例 1:

    输入: J = "aA", S = "aAAbbbb"
    输出: 3
    示例 2:

    输入: J = "z", S = "ZZ"
    输出: 0

     */
    public static void main(String[] args) {
        String gemstone ="z";
        String stone ="ZZ";
        int i = numJewelsInStones(gemstone, stone);
        System.out.println(i);
    }
    public static  int  myNumJewelsInStones(String gemstone, String stone) {
        byte[] gemstones = gemstone.getBytes();
        byte[] stones = stone.getBytes();
        int temp = 0;
        for (int i = 0; i <gemstones.length ; i++) {
            byte gemstone1 = gemstones[i];
            for (int j = 0; j <stones.length ; j++) {
                if (gemstone1 == stones[j] ){
                    temp++;
                }
            }

        }
        return temp;
    }

    //看不懂
    public static int numJewelsInStones(String J, String S) {
        if (S == null || S.isEmpty()) return 0;
        if (J == null || J.isEmpty()) return 0;

        byte[] arr = new byte[58];
        int count = 0;
        for (char ch : J.toCharArray()) {
            arr[ch - 65] = 1;
        }
        for (char ch : S.toCharArray()) {
            if(arr[ch -65] == 1) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones2(String J, String S) {
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            String temp = S.substring(i, i + 1);
            if (J.indexOf(temp) != -1) {
                num++;
            }
        }
        return num;
    }


}
