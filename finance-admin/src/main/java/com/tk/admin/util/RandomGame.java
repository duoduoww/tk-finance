package com.tk.admin.util;

import java.util.Scanner;

/**
 * @program: tk-finance
 * @description: 随机数游戏
 * @author: kzc
 * @create: 2020-07-25 12:53
 **/
public class RandomGame {

    public static void main(String[] args) {
        int number = (int)(Math.random()*100);
        Scanner input=new Scanner(System.in);
        System.out.println("我心里有一个0~99的之间的整数 请猜猜是什么?");
        int n=input.nextInt();
        guess(number,n,0,input);

    }

    private static void guess(int number, int n , int a ,Scanner input){
        if(number == n ){
            a++;
            System.out.println("猜对了");
            String msg = a ==  1 ? "你太聪明了！ " : a <6 ? "不错，再接再厉！ ":"要努力啊！ ";
            System.out.println(msg);
        }else if(n > number) {
            a++;
            System.out.println("大了一点  再猜？");
            n=input.nextInt();
            guess(number,n,a,input);
        } else {
            a++;
            System.out.println("小了一点  再猜？");
            n=input.nextInt();
            guess(number,n,a,input);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("我心里有一个0~99的之间的整数 请猜猜是什么?");
        int a = 0;
        int number = (int)(Math.random()*100);
        while (true) {
            int result = sc.nextInt();
            if (result < number) {
                a++;
                System.out.println("小了一点  再猜？");
            } else if (result > number) {
                a++;
                System.out.println("大了一点  再猜？");
            } else {
                a++;
                System.out.println("猜对了");
                break;
            }
        }
        String msg = a ==  1 ? "你太聪明了！ " : a <6 ? "不错，再接再厉！ ":"要努力啊！ ";
        System.out.println(msg);
    }
}
