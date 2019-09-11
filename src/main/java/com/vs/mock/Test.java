package com.vs.mock;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {4,5,7,3,2,1};
//        for(int outer = array.length -1; outer >=1;outer--){
//            for(int inner = 0;inner < outer;inner++){
//                if(array[inner] >  array[inner+1]){
//                    int temp = array[inner];
//                    array[inner] = array[inner+1];
//                    array[inner+1] = temp;
//                }
//            }
//        }
        System.out.println(Arrays.toString(array));

        for(int outer = 0 ;outer < array.length -1;outer++){
            int key = outer;
            for(int inner = outer+1;inner < array.length;inner++){
                if(array[inner] <  array[key]){
                    key = inner;
                }
            }
            if(outer != key){
                int temp = array[key];
                array[key] = array[outer];
                array[outer] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
