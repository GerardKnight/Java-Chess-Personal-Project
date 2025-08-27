public class Moves {
    Useful_funcs fun = new Useful_funcs();
    public long knight_valid_moves(int board_state[],int pos){
        int pos_x=pos%8;
        int pos_y=pos/8;
        int positions_to_test_x[]= {
                pos_x+1,
                pos_x+1,
                pos_x-1,
                pos_x-1,
                pos_x+2,
                pos_x+2,
                pos_x-2,
                pos_x-2
        };
        int positions_to_test_y[]= {
                pos_y+2,
                pos_y-2,
                pos_y+2,
                pos_y-2,
                pos_y+1,
                pos_y-1,
                pos_y+1,
                pos_y-1,
        };
        int position_to_test;
        int x_to_test;
        int y_to_test;
        long oot=0;
        for (int i=0;i<8;i++){
            x_to_test=positions_to_test_x[i];
            y_to_test=positions_to_test_y[i];
            if (0<=x_to_test&&x_to_test<=7){
                if (0<=y_to_test&&y_to_test<=7){
                    position_to_test=fun.cords_to_num(x_to_test,y_to_test);
                    if ((board_state[position_to_test]*board_state[pos])<=0){
                        oot=oot+fun.expo(2,position_to_test);
                    }
                }
            }
        }
        return oot;
    }

    public long rook_valid_moves(int board_state[], int pos){
        long oot=0;
        int team=board_state[pos];
        int pos_x=pos%8;
        int pos_y=pos/8;
        boolean abu;
        int moved;
        int pos_test;
        int pos_test_x;
        int pos_test_y;
        abu=true;
        moved=1;
        while (abu){
            pos_test=fun.cords_to_num(pos_x+moved,pos_y);
            pos_test_x=pos_x+moved;
            pos_test_y=pos_y;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test=fun.cords_to_num(pos_x-moved,pos_y);
            pos_test_x=pos_x-moved;
            pos_test_y=pos_y;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test=fun.cords_to_num(pos_x,pos_y+moved);
            pos_test_x=pos_x;
            pos_test_y=pos_y+moved;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test=fun.cords_to_num(pos_x,pos_y-moved);
            pos_test_x=pos_x;
            pos_test_y=pos_y-moved;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        return oot;
    }
    public long bishop_valid_moves(int board_state[], int pos){
        long oot=0;
        int team=board_state[pos];
        int pos_x=pos%8;
        int pos_y=pos/8;
        boolean abu;
        int moved;
        int pos_test;
        int pos_test_x;
        int pos_test_y;
        abu=true;
        moved=1;
        while (abu){
            pos_test_x=pos_x+moved;
            pos_test_y=pos_y+moved;
            pos_test=pos_test_x+pos_test_y*8;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test_x=pos_x+moved;
            pos_test_y=pos_y-moved;
            pos_test=pos_test_x+pos_test_y*8;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test_x=pos_x-moved;
            pos_test_y=pos_y+moved;
            pos_test=pos_test_x+pos_test_y*8;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        abu=true;
        moved=1;
        while (abu){
            pos_test_x=pos_x-moved;
            pos_test_y=pos_y-moved;
            pos_test=pos_test_x+pos_test_y*8;
            if (0<=pos_test_x&&pos_test_x<=7&&0<=pos_test_y&&pos_test_y<=7){
                if (board_state[pos_test]*team>0){
                    abu=false;
                }else if(board_state[pos_test]*team==0){
                    oot=oot+fun.expo(2,pos_test);
                    moved++;
                }else{
                    oot=oot+fun.expo(2,pos_test);
                    abu=false;
                }
            }else{
                abu=false;
            }
        }
        return oot;
    }
    public long queen_valid_moves(int board_state[], int pos){
        long oot=0;
        oot=oot+rook_valid_moves(board_state,pos);
        oot=oot+bishop_valid_moves(board_state,pos);
        return oot;
    }
    public int file_team_king(int team){
        int oot=0;
        if (team==1){
            oot=7;
        }else{
            oot=0;
        }
        return oot;
    }
    public long king_valid_moves(int board_state[], int pos, boolean team_can_castle[]){
        int team=board_state[pos]/6;
        int pos_x=pos%8;
        int pos_y=pos/8;
        int positions_to_test_x[]= {
                pos_x+1,
                pos_x+1,
                pos_x+1,
                pos_x,
                pos_x,
                pos_x-1,
                pos_x-1,
                pos_x-1,
        };
        int positions_to_test_y[]= {
                pos_y+1,
                pos_y,
                pos_y-1,
                pos_y+1,
                (pos_y-1),
                (pos_y+1),
                pos_y,
                (pos_y-1),
        };
        int position_to_test;
        int x_to_test;
        int y_to_test;
        long oot=0;
        int castle_check_x[]={1,2,3,5,6};
        for (int i=0;i<8;i++){
            x_to_test=positions_to_test_x[i];
            y_to_test=positions_to_test_y[i];
            if (0<=x_to_test&&x_to_test<=7){
                if (0<=y_to_test&&y_to_test<=7){
                    position_to_test=fun.cords_to_num(x_to_test,y_to_test);
                    if ((board_state[position_to_test]*board_state[pos])<=0){
                        oot=oot+fun.expo(2,position_to_test);
                    }
                }
            }
        }
        boolean can_castle[]={team_can_castle[1],team_can_castle[2]};
        if (team_can_castle[0]) {
            if (team_can_castle[1]) {
                for (int i = 0; i < 3; i++) {
                    if (board_state[fun.cords_to_num(castle_check_x[i], file_team_king(team))] != 0) {
                        can_castle[0] = false;
                    }
                }
                for (int i = 3; i < 5; i++) {
                    if (board_state[fun.cords_to_num(castle_check_x[i], file_team_king(team))] != 0) {
                        can_castle[1] = false;
                    }
                }
            }
            if (can_castle[0]) {
                oot = oot + fun.expo(2, fun.cords_to_num(2, file_team_king(team)));
            }
            if (can_castle[1]) {
                oot = oot + fun.expo(2, fun.cords_to_num(6, file_team_king(team)));
            }
        }
        return oot;
    }
    public int file_team_pawn(int team){
        int oot=0;
        if (team==1){
            oot=6;
        }else{
            oot=1;
        }
        return oot;
    }
    public long pawn_valid_moves(int board_state[], int pos, long en_passant_bitboard){
        long oot=0;
        int pos_x=pos%8;
        int pos_y=pos/8;
        int team=board_state[pos];
        int[] check_en_passant=new int[2];
        if (pos_y>0&&board_state[fun.cords_to_num(pos_x,pos_y-team)]==0) {
            oot = oot + fun.expo(2, fun.cords_to_num(pos_x, pos_y - team));
            if (pos_y == file_team_pawn(team)) {
                if (board_state[fun.cords_to_num(pos_x, pos_y - 2*team)] == 0) {
                    oot = oot + fun.expo(2, fun.cords_to_num(pos_x, pos_y - 2*team));
                }
            }
        }
        if ((pos_x>0)){
            if (board_state[fun.cords_to_num(pos_x-1,pos_y-team)]*team<0){
                oot=oot+fun.expo(2, fun.cords_to_num(pos_x-1, pos_y - team));
            }
        }
        if (pos_x<7){
            if (board_state[fun.cords_to_num(pos_x+1,pos_y-team)]*team<0){
                oot=oot+fun.expo(2, fun.cords_to_num(pos_x+1, pos_y - team));
            }
        }
        check_en_passant[0]=fun.cords_to_num(pos_x+1,pos_y-team);
        check_en_passant[1]=fun.cords_to_num(pos_x-1,pos_y-team);
        if ((fun.expo(2,check_en_passant[0]) & en_passant_bitboard) != 0){
            oot=oot+en_passant_bitboard;
        }
        if ((fun.expo(2,check_en_passant[1]) & en_passant_bitboard) != 0){
            oot=oot+en_passant_bitboard;
        }
        return oot;
    }
    public long find_valid_moves(int board_state[], int pos, long en_passant_bitboard, boolean team_can_castle[]){
        long oot=0;
        int piece=board_state[pos];
        if (piece<0){
            piece=-piece;
        }
        switch (piece){
            case 1:
                oot = pawn_valid_moves(board_state, pos, en_passant_bitboard);
                break;
            case 2:
                oot = rook_valid_moves(board_state, pos);
                break;
            case 3:
                oot = knight_valid_moves(board_state, pos);
                break;
            case 4:
                oot = bishop_valid_moves(board_state, pos);
                break;
            case 5:
                oot= queen_valid_moves(board_state, pos);
                break;
            case 6:
                oot= king_valid_moves(board_state, pos, team_can_castle);
                break;
        }
        return oot;
    }
}