import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JFrame implements ActionListener {
    String piece_names[]={
            "empty.png",//1
            "white_pawn.png",//2
            "white_rook.png",//3
            "white_knight.png",//4
            "white_bishop.png",//5
            "white_queen.png",//6
            "white_king.png",//7
            "black_king.png",//8
            "black_queen.png",//9
            "black_bishop.png",//10
            "black_knight.png",//11
            "black_rook.png",//12
            "black_pawn.png",//13
            "empty_black.png",//14
            "white_pawn_black.png",//15,
            "white_rook_black.png",//16
            "white_knight_black.png",//17
            "white_bishop_black.png",//18
            "white_queen_black.png",//19
            "white_king_black.png",//20
            "black_king_black.png",//21
            "black_queen_black.png",//22
            "black_bishop_black.png",//23
            "black_knight_black.png",//24
            "black_rook_black.png",//25
            "black_pawn_black.png",//26
            "empty_attack.png",//1
            "white_pawn_attack.png",//2
            "white_rook_attack.png",//3
            "white_knight_attack.png",//4
            "white_bishop_attack.png",//5
            "white_queen_attack.png",//6
            "white_king_attack.png",//7
            "black_king_attack.png",//8
            "black_queen_attack.png",//9
            "black_bishop_attack.png",//10
            "black_knight_attack.png",//11
            "black_rook_attack.png",//12
            "black_pawn_attack.png",//13
            "empty_black_attack.png",//14
            "white_pawn_black_attack.png",//15,
            "white_rook_black_attack.png",//16
            "white_knight_black_attack.png",//17
            "white_bishop_black_attack.png",//18
            "white_queen_black_attack.png",//19
            "white_king_black_attack.png",//20
            "black_king_black_attack.png",//21
            "black_queen_black_attack.png",//22
            "black_bishop_black_attack.png",//23
            "black_knight_black_attack.png",//24
            "black_rook_black_attack.png",//25
            "black_pawn_black_attack.png"//26
    };
    int turn=1;
    JButton tiles[]=new JButton[64];
    int tile_values[]=new int[64];
    ImageIcon piece_art[]=new ImageIcon[52];
    boolean choosing=true;
    boolean moving=false;
    Useful_funcs fun = new Useful_funcs();
    Moves moves = new Moves();
    public void redraw(){
        ImageIcon a;
        for (int i=0;i<64;i++){
            a=piece_art[fun.value_to_piece_art(tile_values,i,this.valid_moves_bitboard)];
            tiles[i].setIcon(a);
        }
    }

    long valid_moves_bitboard=0;
    long en_passant_bitboard=0;
    int chosen_piece=32;
    boolean is_en_passant=false;
    boolean piece_can_castle[]={true,true,true,true,true,true,true};
    boolean team_can_castle[]=new boolean[3];
    public void check_piece_can_castle(){
        int squares_check[]={60,56,63,7,0,4};
        int values_check[]={6,2,2,-2,-2,-6};
        for (int k=0;k<6;k++){
            if (this.tile_values[squares_check[k]]!=values_check[k]){
                this.piece_can_castle[k+1]=false;
            }
        }
    }
    Board() {
        fun.find_image_file_path();
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String image_file_path=fun.find_image_file_path();
        for (int i=0;i<52;i++){
            piece_art[i]=new ImageIcon(image_file_path+piece_names[i]);
        }
        for (int i = 0; i < 64; i++) {
            tiles[i] = new JButton();
            tiles[i].setIcon(fun.png_arr_read(piece_art, tile_values[i]));
            tiles[i].addActionListener(this);
            tile_values[i] = 0;
            tiles[i].setVisible(true);
            this.add(tiles[i]);
        }
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        for (int i = 0; i < 8; i++) {//pawns
            tile_values[i + 8] = -1;
            tile_values[i + 48] = 1;
        }
        tile_values[0] = tile_values[7] = -2;//rook
        tile_values[56] = tile_values[63] = 2;
        tile_values[1] = tile_values[6] = -3;//knight
        tile_values[57] = tile_values[62] = 3;
        tile_values[2] = tile_values[5] = -4;//bishop
        tile_values[58] = tile_values[61] = 4;
        tile_values[3] = -5;//queen
        tile_values[59] = 5;
        tile_values[4] = -6;//king
        tile_values[60] = 6;

        redraw();
    }
    public void promote(){
        for (int i=0;i<8;i++){
            if (this.tile_values[i]==1){
                this.tile_values[i]=5;
            }
            if (this.tile_values[i+56]==-1){
                this.tile_values[i+56]=-5;
            }
        }
    }
    public int check_has_won(){
        boolean white_king_found=false;
        boolean black_king_found=false;
        for (int i=0;i<64;i++){
            if (tile_values[i]==6){
                white_king_found=true;
            }
            if (tile_values[i]==-6){
                black_king_found=true;
            }
        }
        int out=0;
        if (!white_king_found){
            out=-1;
        }
        if (!black_king_found){
            out=1;
        }
        return out;
    }
    void win_sequence(){
        String image_file_path=fun.find_image_file_path();
        ImageIcon white_wins_image=new ImageIcon(image_file_path+"white_wins.png");
        ImageIcon black_wins_image=new ImageIcon(image_file_path+"black_wins.png");
        JLabel winner_label=new JLabel();
        for (int i=0;i<64;i++){
            tiles[i].setVisible(false);
        }
        if (check_has_won()==1){
            winner_label.setIcon(white_wins_image);
        }else{
            winner_label.setIcon(black_wins_image);
        }
        this.setLayout(null);
        winner_label.setBounds(200,200,800,500);
        this.add(winner_label);
        this.getContentPane().setBackground(new Color(89,40,36));
    }
    int x_cord;
    int y_cord;
    int y_from;
    int y_change;
    @Override
    public void actionPerformed(ActionEvent e){
        for (int i=0;i<64;i++) {
            if (e.getSource() == tiles[i]) {
                if (choosing) {
                    if (tile_values[i] * turn > 0) {
                        for (int j=1;j<4;j++){
                            team_can_castle[j-1]=fun.bool_arr_read(piece_can_castle,j*turn);
                        }
                        chosen_piece = i;
                        this.choosing = false;
                        this.moving = true;
                        this.valid_moves_bitboard = moves.find_valid_moves(tile_values, i, en_passant_bitboard, team_can_castle);
                        redraw();
                    }
                    //System.out.println("chosen");
                } else if (moving) {
                    if ((fun.expo(2, i) & valid_moves_bitboard) != 0) {
                        x_cord=i%8;
                        y_cord=i/8;
                        this.moving = false;
                        this.choosing = true;
                        this.is_en_passant=false;
                        if (tile_values[chosen_piece]*tile_values[chosen_piece]==1){
                            if ((fun.expo(2, i) & en_passant_bitboard) != 0){
                                this.is_en_passant=true;
                            }
                        }
                        if (this.is_en_passant){
                            tile_values[fun.cords_to_num(x_cord,y_cord+turn)]=0;
                        }
                        this.en_passant_bitboard=0;
                        if (tile_values[chosen_piece]*tile_values[chosen_piece]==1){
                            y_from=chosen_piece/8;
                            y_change=y_from-y_cord;
                            if (y_change<0){
                                y_change=-y_change;
                            }
                            if (y_change==2){
                                this.en_passant_bitboard=this.en_passant_bitboard+fun.expo(2,fun.cords_to_num(x_cord,y_cord+turn));
                            }
                        }
                        if (tile_values[chosen_piece]*tile_values[chosen_piece]==36){
                            if (fun.abs(((chosen_piece%8)-x_cord))>1){
                                if (i%8==2){
                                    this.tile_values[fun.cords_to_num(3,moves.file_team_king(turn))]=2*turn;
                                    this.tile_values[fun.cords_to_num(0,moves.file_team_king(turn))]=0;
                                }
                                if (i%8==6){
                                    this.tile_values[fun.cords_to_num(5,moves.file_team_king(turn))]=2*turn;
                                    this.tile_values[fun.cords_to_num(7,moves.file_team_king(turn))]=0;
                                }
                            }
                        }
                        this.tile_values[i] = this.tile_values[chosen_piece];
                        this.tile_values[chosen_piece] = 0;
                        this.turn = -this.turn;
                        this.valid_moves_bitboard=0;
                        promote();
                    }else{
                        this.moving = false;
                        this.choosing = true;
                        this.valid_moves_bitboard=0;
                    }
                    check_piece_can_castle();
                    redraw();
                }
            }
        }
        if (check_has_won()!=0){
            this.moving=false;
            this.choosing=false;
            win_sequence();
        }
    }
}
