package com.subrat.java8ExerciseFilesandPDF;

import java.util.StringJoiner;


public class Bits {

    public static void main(String[] args) {

        // StringJoiner
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.add("one").add("two");
        
        
        System.out.println(sj.toString());
    }
}
