package com.cz;


class Byteland {

    int peopleNum;

    int[][] rel;



    void initRel(){

        rel = new int[peopleNum][peopleNum];

        for(int i=0; i < peopleNum; i++){

            for(int j=0; j < peopleNum; j++){

                rel[i][j] = 0;

            }

        }

    }




    void matrixRel(){

        for(int i=0; i < peopleNum; i++){

            for(int j=0; j < peopleNum; j++){

                if(rel[i][j] == 1)

                    rel[j][i] = 1;

            }

        }

    }



    void reverse(){

        for(int i=0; i < peopleNum; i++){

            for(int j=0; j < peopleNum; j++){

                if(rel[i][j] == 1)

                    rel[i][j] = 0;

                else

                    rel[i][j] = 1;

            }

        }

    }

}





public class TribeGuard{

    static int[] x; //当前解

    static int n;//图的定点数

    static int cn;//当前顶点数

    static int bestn;//当前最大顶点数

    static int[] bestx;//当前最优解

    static int[][] a;

    public static int maxClique(int[] v){



        x = new int[n];

        cn = 0;

        bestn = 0;

        bestx = v;

        backtrack(0);

        return bestn;

    }

    public static void backtrack(int i){

        if(i > n-1){



            for(int j=0; j < n; j++){

                bestx[j]=x[j];

                System.out.print(bestx[j]+" ");

            }

            System.out.println();

            bestn=cn;

            return;

        }


        int ok = 1;

        for(int j=0;j < i; j++)

            if(x[j] == 1 && a[i][j] == 0){



                ok = 0;

                break;

            }

        if (ok == 1){



            x[i] = 1;

            cn++;

            backtrack(i+1);

            cn--;

        }

        if (cn+n-i > bestn){



            x[i] = 0;

            backtrack(i+1);

        }

    }

    public static void main(String[] args){

        Byteland b =new Byteland();

        b.peopleNum = 7;

        b.initRel();



        b.rel[0][1] = 1;

        b.rel[0][2] = 1;

        b.rel[0][3] = 1;

        b.rel[0][4] = 1;

        b.rel[1][2] = 1;

        b.rel[1][3] = 1;

        b.rel[2][3] = 1;

        b.rel[2][4] = 1;

        b.rel[3][4] = 1;

        b.rel[4][5] = 1;

        b.matrixRel();



        b.reverse();



        n = b.peopleNum;

        a = b.rel;



        int[] v = new int[n];



        System.out.println("可选分配方式：\n");

        int maxPeopleNum = maxClique(v);

        System.out.println("最优分配方式：\n");

        for(int i=0; i < bestx.length; i++){

            System.out.print(bestx[i]+" ");

        }

        System.out.println("\n卫队最大人数："  + bestn);

    }

}