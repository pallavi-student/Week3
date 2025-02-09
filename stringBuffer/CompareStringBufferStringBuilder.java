package com.week3.day4.stringBuffer;

import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class CompareStringBufferStringBuilder {
    public static void main(String[] args) {
      StringBuffer sb=new StringBuffer();
      StringBuilder sb1=new StringBuilder();
      long start=nanoTime();
      for(int i=0;i<100000;i++){
          sb.append("hello");
      }
      long end=nanoTime();
      long timeTakenByStringbuffer=end-start;
      //reinitialising the start and end variables
      start=0;end=0;
      //Now calculating time for StringBuilder
      start=nanoTime();
        for(int i=0;i<100000;i++){
            sb1.append("hello");
        }
        end=nanoTime();
        long timeTakenByStringbuilder=end-start;

        out.println("Time taken by StringBuffer "+timeTakenByStringbuffer+ " ns");
        out.println("Time taken by StringBuilder "+timeTakenByStringbuilder+ " ns");
    }
}
