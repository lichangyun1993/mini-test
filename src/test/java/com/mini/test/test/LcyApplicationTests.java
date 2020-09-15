package com.mini.test.test;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;
import java.util.regex.Pattern;

@SpringBootTest
class LcyApplicationTests {
    private static final String PATTERN = "^\\d[0-9]{0}+(,+\\d[0-9]{0})?";
    private static String[] lettersArray;

    static {
        lettersArray = new String[]{"", "", "a,b,c", "d,e,f", "g,h,i", "j,k,l",
                "m,n,o", "p,q,r,s", "t,u,v", "w,x,y,z"};
    }

    @Test
    void contextLoads() {
    }

    @Test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input 0-9 numbers! Two numbers are separated by ','!Input 'q'  quit the system!");
        while (sc.hasNext()) {
            String next = sc.next();
            if ("q".equals(next.toLowerCase())) {
                break;
            }

            if (Pattern.matches(PATTERN, next)) {
                //正则过滤所有格式,如需可分步判断返回具体错误格式
                System.out.println("get all letters = " + getLetters(next));
            } else {
                System.out.println("Please enter the correct format!");
            }

        }
        System.out.println("quit the system!");
        sc.close();
        lettersArray = null;

    }

    private static String getLetters(String array) {
        String[] split = array.split(",");
        String firstArray = split[0];
        String secondArray = null;
        if (split.length > 1) {
            secondArray = split[1];
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (StringUtils.isBlank(secondArray)) {
            String first = lettersArray[Integer.parseInt(firstArray)];
            String[] firstArraySplit = first.split(",");
            for (String s : firstArraySplit) {
                stringBuilder.append(s).append(" ");
            }

        } else {
            String first = lettersArray[Integer.parseInt(firstArray)];
            String second = lettersArray[Integer.parseInt(secondArray)];
            String[] firstArraySplit = first.split(",");
            String[] secondArraySplit = second.split(",");

            for (String s : firstArraySplit) {
                for (String s1 : secondArraySplit) {
                    stringBuilder.append(s).append(s1).append(" ");
                }
            }
        }

        return stringBuilder.toString();
    }
}
