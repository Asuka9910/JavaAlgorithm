package com.cz;

public class test {
    /**
     * @param args
     */
    final static int board_size = 4;
    static int tial = 1;
    static int [][]board = new int [board_size][board_size];
    static void chessBoard(int tr,int tc,int dr,int dc,int size) {
        if(size == 1)
            return;
        int s = size/2 ;
//System.out.println(s);
        int t = tial++;

        if(dr<tr+s && dc<tc+s) {//���ⷽ�������Ͻ�������
            chessBoard(tr,tc,dr,dc,s);
        } else {//���ⷽ���ڴˣ����������½Ƿ���Ϊ���ⷽ��
            board[tr+s-1][tc+s-1] = t;
            chessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }

        if(dr<tr+s && dc>=tc+s) {//���ⷽ�������Ͻ�������
            chessBoard(tr,tc+s,dr,dc,s);
        } else {//���ⷽ���ڴˣ����������½Ƿ���Ϊ���ⷽ��
            board[tr+s-1][tc+s] = t;
            chessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }

        if(dr>=tr+s && dc<tc+s) {//���ⷽ�������½�������
            chessBoard(tr+s,tc,dr,dc,s);
        } else {//���ⷽ���ڴˣ����������ϽǷ���Ϊ���ⷽ��
            board[tr+s][tc+s-1] = t;
            chessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }

        if(dr>=tr+s && dc>=tc+s) {//���ⷽ�������½�������
            chessBoard(tr+s,tc+s,dr,dc,s);
        } else {//���ⷽ���ڴˣ����������ϽǷ���Ϊ���ⷽ��
            board[tr+s][tc+s] = t;
            chessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        board[2][2] = 0;//���ⷽ���λ��
        chessBoard(0,0,2,2,board_size);

        for(int i=0;i<board_size;i++) {
            for(int j=0;j<board_size;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

} 