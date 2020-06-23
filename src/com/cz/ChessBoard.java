package com.cz;
import java.util.Scanner;

public class ChessBoard {
    static int title = 1;
    int[][] board = new int[4][4];

    public void chessboard(int nr, int nl, int sr, int sl, int size) {
        if(size == 1)
            return;
        int s = size / 2;
        int t = title ++ ;

        if (sr < nr + s && sl < nl + s) {                    //����������������Ͻ�����
            chessboard(nr, nl, sr, sl, s);
        } else {                                             //�������Ӳ������Ͻ�
            board[nr + s - 1][nl + s - 1] = t;               //�����Ͻ����̵����½���Ϊ�������Ӳ���t���Ƹ���
            chessboard(nr, nl, nr + s - 1, nl + s - 1, s);
        }
        if (sr < nr + s && sl >= nl + s) {                    //����������������Ͻ�����
            chessboard(nr , nl + s, sr, sl, s);
        } else {
            board[nr + s - 1][nl + s] = t;                   //�����Ͻ����̵����½���Ϊ�������Ӳ���t���Ƹ���
            chessboard(nr, nl + s, nr + s - 1, nl + s, s);
        }
        if (sr >= nr + s && sl < nl + s) {                     //����������������½�����
            chessboard(nr + s, nl, sr, sl, s);
        } else {
            board[nr + s][nl + s - 1] = t;                    //�����½����̵����Ͻ���Ϊ�������Ӳ���t���Ƹ���
            chessboard(nr + s, nl, nr + s, nl + s - 1, s);
        }
        if (sr >= nr + s && sl >=nl + s) {
            chessboard(nr + s, nl + s, sr, sl, s);
        } else {
            board[nr + s][nl + s] = t;
            chessboard(nr + s, nl + s, nr + s, nl + s, s);
        }
    }

    public static void main(String[] args) {
        ChessBoard c = new ChessBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("���������̴�С��");
        int size = sc.nextInt();
        System.out.println("��������������λ�ã�");
        int sr = sc.nextInt()-1;
        int sl = sc.nextInt()-1;

        c.chessboard(0, 0, sr, sl, size);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(c.board[i][j] + " ");
            }
            System.out.println();

        }
    }
}
