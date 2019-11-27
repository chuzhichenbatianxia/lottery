package com.chuyu.lottery.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class IndexUtil {

    public static void main(String[] args) {
        getFieldMoneyCountByParam();
    }


    /**
     * 随机彩票
     */
    public static void getFieldMoneyCountByParam() {
        for (int i = 0; i < 5; i++) {
            lottery("2");
        }

    }


    public static Integer[] sort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public  static List<Integer>  lottery(String lotteryTYpe){

        List<Integer> front = new ArrayList<>();
        List<Integer> after = new ArrayList<>();

        List<Integer> lottery = new ArrayList<>();
        int temp =0;
        //1是双色球，2是大乐透
        if ("1".equals(lotteryTYpe)){
            for (int i = 1; i <= 33; i++) {
                front.add(i);
            }
            for (int i = 1; i <= 16; i++) {
                after.add(i);
            }
            temp = 6;
        }else {
            for (int i = 1; i <= 35; i++) {
                front.add(i);
            }
            for (int i = 1; i <= 12; i++) {
                after.add(i);
            }
            temp = 5;
        }


        for (int i = 0; i < 7 ; i++) {
            if (i < temp){
                int radom = new Random().nextInt(front.size());
                int num = front.get(radom);
                lottery.add(i,num);
                front.remove(radom);
            } else {
                int radom = new Random().nextInt(after.size());
                int num = after.get(radom);
                lottery.add(i,num);
                after.remove(radom);
            }

        }

//        System.out.println(lottery);
        //排序彩票

        front.clear();
        after.clear();

        List<Integer> lotterySort = new ArrayList<>();

        for (int i = 0; i < lottery.size(); i++) {

            if (i < temp){
                front.add(lottery.get(i));
            }else {
                after.add(lottery.get(i));
            }
        }

        Integer[] a = new Integer[front.size()];
        Integer[] b = new Integer[after.size()];
        front.toArray(a);
        after.toArray(b);
        a = sort(a);
        b = sort(b);

        lotterySort.addAll(Arrays.asList(a));
        lotterySort.addAll(Arrays.asList(b));
        System.out.println(lotterySort);
        return lotterySort;
    }
}