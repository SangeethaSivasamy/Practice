package com.subrat.string;

/**
 * Print string snake string
 */


public class StringSinusoidal {

    public static String snakeString(String s){

        StringBuilder sb = new StringBuilder(s.length());

        if(s.length() == 0){
            return sb.toString();
        }

        int length = s.length();
        for (int i = 1; i < length; i = i+4){
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < length; i = i+2){
            sb.append(s.charAt(i));
        }

        for (int i = 3; i < length; i = i+4){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String str = new String("Hello World!");
        String result = snakeString(str);
        System.out.println(result.equals("e lHloWrdlo!"));
    }

}