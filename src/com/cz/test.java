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

        if(dr<tr+s && dc<tc+s) {//特殊方格在左上角棋盘中
            chessBoard(tr,tc,dr,dc,s);
        } else {//特殊方格不在此，则设置右下角方格为特殊方格
            board[tr+s-1][tc+s-1] = t;
            chessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }

        if(dr<tr+s && dc>=tc+s) {//特殊方格在右上角棋盘中
            chessBoard(tr,tc+s,dr,dc,s);
        } else {//特殊方格不在此，则设置左下角方格为特殊方格
            board[tr+s-1][tc+s] = t;
            chessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }

        if(dr>=tr+s && dc<tc+s) {//特殊方格在左下角棋盘中
            chessBoard(tr+s,tc,dr,dc,s);
        } else {//特殊方格不在此，则设置右上角方格为特殊方格
            board[tr+s][tc+s-1] = t;
            chessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }

        if(dr>=tr+s && dc>=tc+s) {//特殊方格在右下角棋盘中
            chessBoard(tr+s,tc+s,dr,dc,s);
        } else {//特殊方格不在此，则设置左上角方格为特殊方格
            board[tr+s][tc+s] = t;
            chessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        board[2][2] = 0;//特殊方格的位置
        chessBoard(0,0,2,2,board_size);

        for(int i=0;i<board_size;i++) {
            for(int j=0;j<board_size;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

} 