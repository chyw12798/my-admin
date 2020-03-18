package com.myproject.admin;

/**
 * @ClassName DemoTests
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/16 17:45
 * @Version 1.0
 */
public class DemoTests {
    public static void main(String[] args) {

        System.out.println(demo2(1234554321));

    }

    public static boolean demo(int x){
        // 123321
        String num = String.valueOf(x);
        System.out.println(num);
        int len = num.length();
        for (int i = 0;i<len/2;i++) {
            System.out.println(num.charAt(i) + "============" + num.charAt(len - i -1));
            if (num.charAt(i) != num.charAt(len - i -1)) {
                return false;
            }
        }
        return true;
    }
    public static boolean demo2(int x) {
        String num = String.valueOf(x);
        String num1 = num.substring(0,num.length()/2);
        int num2 = 0;
        if (String.valueOf(x).length()%2 == 0) {
            num2 = Integer.parseInt(num.substring(num.length() / 2, num.length()));
        } else {
            num2 = Integer.parseInt(num.substring(num.length() / 2 +1, num.length()));
        }
        // TODO 将num2的内容进行翻转
        String num3 = String.valueOf(reserve(num2));
        System.out.println(num1 +"==="+ num3);
        if (num1.equals(num3)){
            return true;
        }
        return false;
    }

    public static int reserve(int x) {
        // 1234
        int num = 0;
        while (x%10>0) {
            // TODO 需考虑溢出，好比x=12345678,首位以1开头，输出的结果就是同等长度首位为8开头的整数了
//            num = num*10;
            int prop = x%10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE && prop > 7)) {
                return 0;
            }
            num = num * 10 + prop;
            System.out.println(num);
            x = x / 10;
        }
        return num;
    }
    public void luoma(String str){
        // MCMXCIV
        // TODO 将str包含的特殊规则进行转换
        int res = 0;
        int len = str.length();
        for (int i = 0;i<len; i++) {
            res = Integer.valueOf(str.charAt(i));
        }


    }
}
