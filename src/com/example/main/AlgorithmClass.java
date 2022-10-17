package com.example.main;

import java.util.Random;

public class AlgorithmClass {

    public static void main(String[] args) {
//        reverseNumber();
//        calcNumberLength();
        getRedPack();
    }

    /**
     * 抢红包的简单场景算法
     */
    public static void getRedPack() {

        //红包金额数组定义
        int[] redPackArr = {2, 100, 1000, 8000, 10000};
        int[] randomRedPackArr = new int[redPackArr.length];

        //第一种写法：先把红包池打乱（即把红包金额数组打乱）
        System.out.println("======打乱后的红包池，顺序取======");

        for (int i = 0; i < redPackArr.length;) {
            //生成随机索引
            int randomIndex = new Random().nextInt(redPackArr.length);
            //得到随机索引下的值
            int randomValue = redPackArr[randomIndex];
            //判断是否重复
            if(!checkRepeat(randomRedPackArr,randomValue)){
                randomRedPackArr[i] = randomValue;
                i++;
            }
        }

        //打乱后，顺序取值
        for (int i : randomRedPackArr) {
            System.out.println(i + " 的红包已被抢走！");
        }

        System.out.println();

        //第二种写法：不打乱红包池，而是在取值的时候随机取
        System.out.println("======原有的红包池，随机取======");

        int[] loadedRedPackArr = new int[redPackArr.length];

        int loopCount = 0;

        for (int i = 0; i < redPackArr.length; ) {
            int random = new Random().nextInt(redPackArr.length);
            int loadedElement = redPackArr[random];
            if(!checkRepeat(loadedRedPackArr,loadedElement)){
                System.out.println(loadedElement + " 的红包已被抢走！");
                loadedRedPackArr[i] = loadedElement;
                i++;
            }
            loopCount++;
        }
    }

    /**
     * 检查数组中是否有重复项元素
     * @param arr
     * @param element
     * @return
     */
    private static boolean checkRepeat(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算数字的长度
     */
    public static void calcNumberLength() {
        int number = 123456;
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        System.out.println(count);
    }

    /**
     * 数字反转算法
     */
    public static void reverseNumber() {
        int number = 1992;

        System.out.println("======翻转前的数字======");
        System.out.println(number);

        //1. 由于Java对于基础数据类型没有遍历的API，所以这里需要将
        //基础数据类型转为引用数据类型（String）。
        String numberStr = String.valueOf(number);

        //2. 定义一个新的数组，用于填充数据
        int[] arr = new int[numberStr.length()];

        //3. 遍历字符串，将每个字符强转为数字，并依次填入到新的数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }

        System.out.println("======翻转前的数组======");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");

        //4. 翻转数组
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println("======翻转后的数组======");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");

        int newNumber = 0;

        //5. 拼接新的数组
        for (int i = 0; i < arr.length; i++) {
            newNumber = newNumber * 10 + arr[i];
        }

        System.out.println("======打印翻转后的数字======");
        System.out.println(newNumber);
    }
}
