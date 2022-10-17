package com.example.main;

public class TestClass {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(arr);

        int[] arrNew = arr;

        arrNew[0] = 4;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arrNew[i] + ",");
        }
    }
}
