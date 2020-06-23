package com.cz;

import java.util.Arrays;
import java.util.Scanner;

class S2 implements Comparable<S2> {	//小岛坐标及左区间
    private int x;
    private int y;
    private double left;
    public S2(int x, int y, double left) {
        this.setX(x);
        this.setY(y);
        this.setLeft(left);
    }
    public int compareTo(S2 s) {
        return (int) (this.getLeft() - s.left);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getLeft() {
        return left;
    }
    public void setLeft(double left) {
        this.left = left;
    }
}
class S22 {//基站坐标
    private double x;
    private int y;
    public S22(double x, int y) {
        this.setX(x);
        this.setY(y);
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
class verify1{	//合理性检验
    private double tempC;
    private int tempX;
    private int tempY;
    private double tempD;
    private int flag;
    private int flagVer;
    public verify1(S2 S[],S22 C[],int d,int n,int m) {
        for(int i=0;i<n;i++) {
            tempX = S[i].getX();
            tempY = S[i].getY();
            flag = 0;
            for(int j=0;j<=m;j++) {
                tempC=C[j].getX();
                tempD=Math.sqrt((tempY * tempY + Math.pow((tempX - tempC), 2)));
                if(tempD>d) {
                    flag = 0;
                }else{
                    flag = 1;
                    break;
                }
            }
            flagVer = flag + flagVer;
        }
        System.out.println("合理性验证结束");
        if(flagVer==n) {
            System.out.println("基站点能够覆盖所有岛屿");
        }else {
            System.out.println("基站点不能覆盖所有岛屿，请检查算法");
        }
    }
}

public class IPDMinCircle {
    private static int n; // 岛数
    private int m; // 基站数
    public S22 C[] = new S22[n]; // 基站坐标
    private double c; // 基站横坐标
    private static int d; // 基站半径
    private int X1;
    private int Y1;
    private int tempX;
    private int tempY;
    private double tempD; // 小岛和旧圆心的距离
    public static int flag;
    public IPDMinCircle(S2 S[],int n,int d) {
        X1 = S[0].getX();
        Y1 = S[0].getY();
        c = X1 + Math.sqrt(d * d - Y1 * Y1);
        C[0] = new S22(c,0);
        for (int j = 0; j < n; j++) {
            tempX = S[j].getX();
            tempY = S[j].getY();
            tempD = Math.sqrt((tempY * tempY + Math.pow((tempX - c), 2))); // 上一圆心位置，判断该岛坐标是否在上一圆内
            if ((tempD <= d)) { // 新岛坐标在旧圆内，即该岛位于旧圆内或圆上任意位置
                // 保留旧圆，不作新圆
                continue;
            } else if ((tempD > d)) { // 新岛坐标在旧圆外，即该岛位于旧圆心的右边且在圆外
                // 保留旧圆，另作新圆
                c = tempX + Math.sqrt(d * d - tempY * tempY);
                m = m + 1;
                C[m] = new S22(c,0);
            }
        }
        System.out.println(m+1);
        for (int i = 0; i <= m; i++) {
            System.out.println(C[i].getX() + " " + C[i].getY());
        }
        new verify1(S,C,d,n,m);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入小岛数：");
        n = in.nextInt();
        System.out.println("请输入 基站半径：");
        d = in.nextInt();
        S2 S[] = new S2[n];
        System.out.println("请输入小岛坐标：");
        for (int i = 0; i < n; i++) {
            int k1 = in.nextInt();
            int k2 = in.nextInt();
            double tleft = Math.sqrt(d * d - k2 * k2) + k1 - d;
            S[i] = new S2(k1, k2, tleft);
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(S[i].getY()) > d) {
                flag = -1;
                System.out.println(flag);
            } else {
                flag = 1;
            }
        }
        if (flag > 0) {
            Arrays.sort(S, 0, n); // 排n个数，Arrays.sort(d)则默认排全部
//			for (int i = 0; i < n; i++) { //debug
//				System.out.println(S[i].getX()+" "+S[i].getY());
//			}
            new IPDMinCircle(S,n,d);
        }
    }
}


