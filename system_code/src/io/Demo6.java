package io;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 19:09
 */
public class Demo6 {
    private static ArrayList<Integer> intersection (ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <nums1.size(); i++){
           int tmp = nums1.get(i);
           for(int j = 0 ; j <nums2.size(); j++){

               if(list.contains(tmp)){
                   break;
               }
               if(tmp == nums2.get(j)){
                   list.add(tmp);
                   break;
               }
           }
        }
        return list;
    }
    public static void main(String[] args) {
//        ArrayList<Integer> nums1 = new ArrayList<>();
//        ArrayList<Integer> nums2 = new ArrayList<>();
//        nums1.add(2);
//        nums1.add(2);
//        nums1.add(2);
//        nums1.add(2);
//        nums1.add(1);
//
//        nums2.add(2);
//        nums2.add(2);
//        nums2.add(2);
//        nums2.add(2);
//        nums2.add(3);
//        nums2.add(3);
//        nums2.add(1);
//        nums2.add(3);
//        nums2.add(3);
//
//        System.out.println(intersection(nums1,nums2));
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        //int count = 0;
        ArrayList<Integer> nums1 = new ArrayList<>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();

            if(a>b){
                return;
            }
            while(b >= a){
                int tmp = b%a;
                if(tmp == 0){
                    nums1.add(tmp);
                }
                b--;
                System.out.println(nums1);

            }

        }
    }
}
