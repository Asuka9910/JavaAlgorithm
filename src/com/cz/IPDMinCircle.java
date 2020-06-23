package com.cz;

import java.util.Arrays;
import java.util.Scanner;

class S2 implements Comparable<S2> {	//С�����꼰������
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
class S22 {//��վ����
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
class verify1{	//�����Լ���
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
        System.out.println("��������֤����");
        if(flagVer==n) {
            System.out.println("��վ���ܹ��������е���");
        }else {
            System.out.println("��վ�㲻�ܸ������е��죬�����㷨");
        }
    }
}

public class IPDMinCircle {
    private static int n; // ����
    private int m; // ��վ��
    public S22 C[] = new S22[n]; // ��վ����
    private double c; // ��վ������
    private static int d; // ��վ�뾶
    private int X1;
    private int Y1;
    private int tempX;
    private int tempY;
    private double tempD; // С���;�Բ�ĵľ���
    public static int flag;
    public IPDMinCircle(S2 S[],int n,int d) {
        X1 = S[0].getX();
        Y1 = S[0].getY();
        c = X1 + Math.sqrt(d * d - Y1 * Y1);
        C[0] = new S22(c,0);
        for (int j = 0; j < n; j++) {
            tempX = S[j].getX();
            tempY = S[j].getY();
            tempD = Math.sqrt((tempY * tempY + Math.pow((tempX - c), 2))); // ��һԲ��λ�ã��жϸõ������Ƿ�����һԲ��
            if ((tempD <= d)) { // �µ������ھ�Բ�ڣ����õ�λ�ھ�Բ�ڻ�Բ������λ��
                // ������Բ��������Բ
                continue;
            } else if ((tempD > d)) { // �µ������ھ�Բ�⣬���õ�λ�ھ�Բ�ĵ��ұ�����Բ��
                // ������Բ��������Բ
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
        System.out.println("������С������");
        n = in.nextInt();
        System.out.println("������ ��վ�뾶��");
        d = in.nextInt();
        S2 S[] = new S2[n];
        System.out.println("������С�����꣺");
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
            Arrays.sort(S, 0, n); // ��n������Arrays.sort(d)��Ĭ����ȫ��
//			for (int i = 0; i < n; i++) { //debug
//				System.out.println(S[i].getX()+" "+S[i].getY());
//			}
            new IPDMinCircle(S,n,d);
        }
    }
}


