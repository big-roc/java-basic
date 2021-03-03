package atguigu.senior;

import org.junit.jupiter.api.Test;

public class StringExer {

    @Test
    public void test02() {
        String s = "hello abc good";
    }

    public String myReverse(String s, int start, int end) throws Exception {
        if (s != null) {
            if (s.length() == 0) {
                return "";
            }
            if (start <= end || start < 0 || end > s.length()) {
                throw new Exception("起止位输入错误");
            }

            char[] middle = s.substring(start, end).toCharArray();

            return s.substring(0, start) + middle.toString() + s.substring(end, s.length());
        }
        return null;
    }


    @Test
    public void test01() {
        //模拟一个trim方法，去除字符串两端的空格
        //String str = " abc 123  ";
        //String str = null;
        String str = "  ";

        String newStr = myTrim02(str);
        System.out.println(newStr.length());
        System.out.println(newStr);
    }

    //方式2
    public String myTrim02(String str) {
        if (str != null) {
            int begin = 0;
            int end = str.length() - 1;

            while (begin < end && str.charAt(begin) == ' ') {
                begin++;
            }

            while (begin < end && str.charAt(end) == ' ') {
                end--;
            }

            if (str.charAt(begin) == ' ') {
                return "";
            }

            return str.substring(begin, end + 1);
        }
        return null;
    }

    //方式1
    public String myTrim01(String str) {
        if (str != null) {
            int begin = 0;
            int end = str.length();

            char[] chars = str.toCharArray();
            //起点
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    begin = i;
                    System.out.println(i);
                    break;
                }
            }

            //终点
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != ' ') {
                    end = i;
                    System.out.println(chars[i]);
                    break;
                }
            }

            return str.substring(begin, end + 1);
        }
        return null;
    }
}
