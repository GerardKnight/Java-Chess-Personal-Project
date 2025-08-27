import java.io.File;
import javax.swing.*;

public class Useful_funcs {
    public static int int_arr_read(int arr[],int pos){
        if (pos<0){
            pos=pos+arr.length;
        }
        return arr[pos];
    }
    public static boolean bool_arr_read(boolean arr[],int pos){
        if (pos<0){
            pos=pos+arr.length;
        }
        return arr[pos];
    }
    public static String str_arr_read(String arr[],int pos){
        if (pos<0){
            pos=pos+arr.length;
        }
        return arr[pos];
    }
    public static ImageIcon png_arr_read(ImageIcon arr[], int pos){
        if (pos<0){
            pos=pos+arr.length;
        }
        return arr[pos];
    }
    public static int cords_to_num(int x, int y){
        return x+8*y;
    }
    public static int[] num_to_cords(int num){
        int oot[]={num%8,num/8};
        return oot;
    }
    public static long expo(long x,long y){
        long oot=1;
        for (int i=0;i<y;i++){
            oot=oot*x;
        }
        return oot;
    }
    public static int[] conc_arr_int(int arr_1[], int arr_2[]){
        int len_o_oot= arr_1.length+arr_2.length;
        int oot[]=new int[len_o_oot];
        for (int i=0;i< arr_1.length;i++){
            oot[i]=arr_1[i];
        }
        for (int i=0;i< arr_2.length;i++){
            oot[i+arr_1.length]=arr_2[i];
        }
        return oot;
    }
    public static void move_draw(long moves,int pos){
        int moves_arr[]=new int[64];
        for (int i=0;i<64;i++){
            if ((expo(2,i) & moves)!=0){
                moves_arr[i]=1;
            }
        }
        for (int y=0;y<8;y++){
            for (int x=0;x<8;x++){
                if (moves_arr[x+8*y]==1){
                    System.out.printf("x");
                }else{
                    System.out.printf(".");
                }
            }
            System.out.println();
        }
    }
    public static boolean square_is_whight(int pos){
        boolean oot=true;
        int pos_xy[]=num_to_cords(pos);
        if (((pos_xy[0]+pos_xy[1])%2)==0){
            oot=false;
        }
        return oot;
    }
    public static int value_to_piece_art(int board_state[], int pos,long bitboard){
        int lib[]={0,1,2,3,4,5,6,7,8,9,10,11,12};
        int oot=lib[int_arr_read(lib,board_state[pos])];
        if (square_is_whight(pos)){
            oot=oot+13;
        }
        if ((expo(2,pos) & bitboard)>0){
            oot=oot+26;
        }
        return oot;
    }
    int abs(int x){
        int oot=0;
        if (x<0){
            oot=-x;
        }else{
            oot=x;
        }
        return oot;
    }
    public void bool_arr_print(boolean to_print[]){
        int len=to_print.length;
        for (int i=0;i<len;i++){
            System.out.println(to_print[i]);
        }
    }
    public static String find_image_file_path(){
        File file=new File("images//empty.png");
        String out=file.getAbsolutePath();
        out=out.substring(0, out.length()-9);
        return out;
    }
}
