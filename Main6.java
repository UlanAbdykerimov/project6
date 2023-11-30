import java.util.Scanner;
import java.util.Random;

public class Main6
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int[][] battleField = randomShips();
        int hits = 0;
        int x = 0; int y = 0;
        int sh3 = 0;
        int attemts = 1;

        System.out.println("          Welcome to 'SeaBattle'! Enjoy your game!");
        System.out.print("Warrior, enter your name: ");
        String playerName = sc.nextLine();
        System.out.println("Be ready warrior, the battle is started!");

        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                System.out.print(battleField[i][j] + " ");
            }
            System.out.println();
        }
        while (hits<12) {
            System.out.print("Attempt #" + attemts + "!       Captain " + playerName + ", enter the coordinates of enemy ship: ");
            x = sc.nextInt(); y = sc.nextInt();
            x = x-1;
            y = y-1;
            int xm1 = x-1;
            int xp1 = x+1;
            int ym1 = y-1;
            int yp1 = y+1;
            int xm2 = x-2;
            int xp2 = x+2;
            int ym2 = y-2;
            int yp2 = y+2;
            if (battleField[x][y]==0) {
                battleField[x][y]=4;
            }
            else if (battleField[x][y]==1) {
                battleField[x][y]=5;
                if (xm1>=0 && ym1>=0) battleField[xm1][ym1]=4;
                if (xm1>=0) battleField[xm1][y]=4;
                if (xm1>=0 && yp1<=6) battleField[xm1][yp1]=4;
                if (ym1>=0) battleField[x][ym1]=4;
                if (yp1<=6) battleField[x][yp1]=4;
                if (xp1<=6 && ym1>=0) battleField[xp1][ym1]=4;
                if (xp1<=6) battleField[xp1][y]=4;
                if (xp1<=6 && yp1<=6) battleField[xp1][yp1]=4;
                hits++;
            }
            else if (battleField[x][y]==2) {
                battleField[x][y]=6;
                hits++;
                if (ym1>=0) {
                    if (battleField[x][ym1]==6) {
                        if (ym2>=0) {
                            if (xm1>=0) battleField[xm1][ym2]=4;
                            battleField[x][ym2]=4;
                            if (xp1<=6) battleField[xp1][ym2]=4;
                        }
                        if (xm1>=0) battleField[xm1][ym1]=4;
                        if (xp1<=6) battleField[xp1][ym1]=4;
                        if (xm1>=0) battleField[xm1][y]=4;
                        if (xp1<=6) battleField[xp1][y]=4;
                        if (yp1<=6 && xm1>=0) battleField[xm1][yp1]=4;
                        if (yp1<=6) battleField[x][yp1]=4;
                        if (yp1<=6 && xp1<=6) battleField[xp1][yp1]=4;
                        battleField[x][y]=8;
                        battleField[x][ym1]=8;
                    }
                }
                if (xm1>=0) {
                    if (battleField[xm1][y]==6) {
                        if (xm2>=0) {
                            if (ym1>=0) battleField[xm2][ym1]=4;
                            battleField[xm2][y]=4;
                            if (yp1<=6) battleField[xm2][yp1]=4;
                        }
                        if (ym1>=0) battleField[xm1][ym1]=4;
                        if (yp1<=6) battleField[xm1][yp1]=4;
                        if (ym1>=0) battleField[x][ym1]=4;
                        if (yp1<=6) battleField[x][yp1]=4;
                        if (ym1>=0 && xp1<=6) battleField[xp1][ym1]=4;
                        if (xp1<=6) battleField[xp1][y]=4;
                        if (yp1<=6 && xp1<=6) battleField[xp1][yp1]=4;
                        battleField[x][y]=8;
                        battleField[xm1][y]=8;
                    }
                }
                if (yp1<=6) {
                    if (battleField[x][yp1]==6) {
                        if (yp2<=6) {
                            if (xm1>=0) battleField[xm1][yp2]=4;
                            battleField[x][yp2]=4;
                            if (xp1<=6) battleField[xp1][yp2]=4;
                        }
                        if (xm1>=0 && ym1>=0) battleField[xm1][ym1]=4;
                        if (ym1>=0) battleField[x][ym1]=4;
                        if (xm1>=0) battleField[xm1][y]=4;
                        if (xp1<=6 && ym1>=0) battleField[xp1][ym1]=4;
                        if (xp1<=6) battleField[xp1][y]=4;
                        if (xm1>=0) battleField[xm1][yp1]=4;
                        if (xp1<=6) battleField[xp1][yp1]=4;
                        battleField[x][y]=8;
                        battleField[x][yp1]=8;
                    }
                }
                if (xp1<=6) {
                    if (battleField[xp1][y]==6) {
                        if (xp2<=6) {
                            if (ym1>=0) battleField[xp2][ym1]=4;
                            battleField[xp2][y]=4;
                            if (yp1<=6) battleField[xp2][yp1]=4;
                        }
                        if (xm1>=0 && ym1>=0) battleField[xm1][ym1]=4;
                        if (xm1>=0) battleField[xm1][y]=4;
                        if (xm1>=0 && yp1<=6) battleField[xm1][yp1]=4;
                        if (ym1>=0) battleField[x][ym1]=4;
                        if (yp1<=6) battleField[x][yp1]=4;
                        if (ym1>=0) battleField[xp1][ym1]=4;
                        if (yp1<=6) battleField[xp1][yp1]=4;
                        battleField[x][y]=8;
                        battleField[xp1][y]=8;
                    }
                }
            }
            int x31 = 0; int y31 = 0;
            int x32 = 0; int y32 = 0;
            int x33 = 0; int y33 = 0;
            if (battleField[x][y]==3) {
                System.out.println(x31 + ' ' + y31 + " " + x32 + " " + y32 + " " + x33 + " " + y33);
                sh3++;
                if (sh3==1) {
                    x31=x;
                    y31=y;
                }
                if (sh3==2) {
                    x32=x;
                    y32=y;
                }
                battleField[x][y]=7;
                hits++;
                if (sh3==3) {
                    x33=x;
                    y33=y;
                    battleField[x31][y31]=9;
                    battleField[x32][y32]=9;
                    battleField[x33][y33]=9;
                    System.out.println(x31 + ' ' + y31 + " " + x32 + " " + y32 + " " + x33 + " " + y33);
                    if ((x31-1)>=0) {
                        if ((y31-1)>=0) battleField[x31-1][y31-1]=4;
                        if (battleField[x31-1][y31] != 9) battleField[x31-1][y31]=4;
                        if ((y31+1)<=6) battleField[x31-1][y31+1]=4;
                    }
                    if ((y31-1)>=0 && battleField[x31][y31-1] != 9) battleField[x31][y31-1]=4;
                    if ((y31+1)<=6 && battleField[x31][y31+1] != 9) battleField[x31][y31+1]=4;
                    if ((x31+1)>=0) {
                        if ((y31-1)>=0) battleField[x31+1][y31-1]=4;
                        if (battleField[x31+1][y31]!=9) battleField[x31+1][y31]=4;
                        if ((y31+1)<=6) battleField[x31+1][y31+1]=4;
                    }
                    if ((x32-1)>=0) {
                        if ((y32-1)>=0) battleField[x32-1][y32-1]=4;
                        if (battleField[x32-1][y32]!=9) battleField[x32-1][y32]=4;
                        if ((y32+1)<=6) battleField[x32-1][y32+1]=4;
                    }
                    if ((y32-1)>=0) battleField[x32][y32-1]=4;
                    if ((y32+1)<=6) battleField[x32][y32+1]=4;
                    if ((x32+1)>=0) {
                        if ((y32-1)>=0) battleField[x32+1][y32-1]=4;
                        if (battleField[x32+1][y32]!=9) battleField[x32+1][y32]=4;
                        if ((y32+1)<=6) battleField[x32+1][y32+1]=4;
                    }
                    if ((x33-1)>=0) {
                        if ((y33-1)>=0) battleField[x33-1][y33-1]=4;
                        if (battleField[x33-1][y33]!=9) battleField[x33-1][y33]=4;
                        if ((y33+1)<=6) battleField[x33-1][y33+1]=4;
                    }
                    if ((y33-1)>=0 && battleField[x33][y33-1] != 9) battleField[x33][y33-1]=4;
                    if ((y33+1)<=6 && battleField[x33][y33+1] != 9) battleField[x33][y33+1]=4;
                    if ((x33+1)>=0) {
                        if ((y33-1)>=0 && (x33+1)<=6) battleField[x33+1][y33-1]=4;
                        if (battleField[x33+1][y33]!=9) battleField[x33+1][y33]=4;
                        if ((y33+1)<=6) battleField[x33+1][y33+1]=4;
                    }
                }
            }
            System.out.println("  ------------------------------------");
            for (int i = 0; i < 7; i++) {
                int z = i + 1;
                System.out.print(z + " ");
                for (int j = 0; j < 7; j++) {
                    if (battleField[i][j]>=0 && battleField[i][j]<4) System.out.print("|    ");
                    else if (battleField[i][j]==4) System.out.print("| () ");
                    else if (battleField[i][j]==6 || battleField[i][j]==7) System.out.print("| ++ ");
                    else if (battleField[i][j]==5 || battleField[i][j]==8 || battleField[i][j]==9) System.out.print("| ** ");
                }
                System.out.println("|");
                System.out.println("  ------------------------------------");
            }
            System.out.println("    A    B    C    D    E    F    G  ");
            attemts++;
        }
    }
    public static int[][] randomShips () {
        Random ran = new Random();
        int[][] mat = new int [7][7];
        int sh21 = 0;
        int sh11 = 0;
        int i = ran.nextInt(7);
        int j = ran.nextInt(7);
        int ras = ran.nextInt(2);
        if (i==6 && j==6) {
            if (ras==0) j--;
            else i--;
        }
        else if (i==6 && j==0) {
            if (ras==0) j++;
            else i--;
        }
        else if (i==0 && j==0) {
            if (ras==0) j++;
            else i++;
        }
        else if (i==0 && j==6) {
            if (ras==0) j--;
            else i++;
        }
        if (j==0 || j==6) {
            mat[i-1][j] = 3;
            mat[i][j] = 3;
            mat[i+1][j] = 3;
        }
        else if (i==0 || i==6) {
            mat[i][j-1] = 3;
            mat[i][j] = 3;
            mat[i][j+1] = 3;
        }
        else {
            if (ras==0) {
                mat[i-1][j] = 3;
                mat[i][j] = 3;
                mat[i+1][j] = 3;
            }
            else {
                mat[i][j-1] = 3;
                mat[i][j] = 3;
                mat[i][j+1] = 3;
            }
        }
        while (sh21==0 || sh21==1) {  //placing first ship 2x1
            i = ran.nextInt(7);
            j = ran.nextInt(7);

            ras = ran.nextInt(2);
            if (ras == 0 && i == 6 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i][j - 2] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j - 1] == 0 && mat[i - 1][j - 2] == 0) {
                mat[i][j] = 2;
                mat[i][j - 1] = 2;
                sh21++;
            } else if (i == 6 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j - 1] == 0 && mat[i - 2][j] == 0 && mat[i - 2][j - 1] == 0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh21++;
            } else if (ras == 0 && i == 6 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j + 1] == 0 && mat[i - 2][j] == 0 && mat[i - 2][j + 1] == 0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh21++;
            } else if (i == 6 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j + 2] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j + 1] == 0 && mat[i - 1][j + 2] == 0) {
                mat[i][j] = 2;
                mat[i][j + 1] = 2;
                sh21++;
            } else if (ras == 0 && i == 0 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 2][j] == 0 && mat[i + 2][j + 1] == 0) {
                mat[i][j] = 2;
                mat[i + 1][j] = 2;
                sh21++;
            } else if (i == 0 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j + 2] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 1][j + 2] == 0) {
                mat[i][j] = 2;
                mat[i][j + 1] = 2;
                sh21++;
            } else if (ras == 0 && i == 0 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j - 1] == 0 && mat[i + 2][j] == 0 && mat[i + 2][j - 1] == 0) {
                mat[i][j] = 2;
                mat[i + 1][j] = 2;
                sh21++;
            } else if (i == 0 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i][j - 2] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j - 1] == 0 && mat[i + 1][j - 2] == 0) {
                mat[i][j] = 2;
                mat[i][j - 1] = 2;
                sh21++;
            }
            else if (i==0) i++;
            else if (i==6) i--;
            else if (j==0) j++;
            else if (j==6) j--;
            ras = ran.nextInt(4);
            if (i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) { //corner 5;5
                    mat[i][j] = 2;
                    mat[i + 1][j] = 2;
                    sh21++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
            } if (ras==2 && i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh21++;
            }
            if (i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
            }
            if (i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {  //corner 5;1
                    mat[i][j] = 2;
                    mat[i + 1][j] = 2;
                    sh21++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
                }
            }
            if (ras==2 && i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                mat[i][j]=2;
                mat[i-1][j]=2;
                sh21++;
            }
            if (i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                mat[i][j]=2;
                mat[i][j+1]=2;
                sh21++;
            }
            if (i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {   //corner 1;1
                    mat[i][j] = 2;
                    mat[i - 1][j] = 2;
                    sh21++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
                }
            }
            if (ras == 2 && i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                mat[i][j]=2;
                mat[i][j+1]=2;
                sh21++;
            }
            if (i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                mat[i][j]=2;
                mat[i+1][j]=2;
                sh21++;
            }
            if (i == 1 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {  //corner 1;5
                    mat[i][j] = 2;
                    mat[i - 1][j] = 2;
                    sh21++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
            }
            if (ras==2 && i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                mat[i][j]=2;
                mat[i][j-1]=2;
                sh21++;
            }
            if (i == 1 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                mat[i][j]=2;
                mat[i+1][j]=2;
                sh21++;
            }
            if (i==1 && j>1 && j<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;  // i==1
                    mat[i][j-1] = 2;
                    sh21++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i-1][j] = 2;
                    sh21++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh21++;
                }
            }
            if (i==5 && j>1 && j<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;  // i==5
                    mat[i][j-1] = 2;
                    sh21++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh21++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
                else if (mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i-1][j] = 2;
                    sh21++;
                }
            }
            if (j==1 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // j==1
                    mat[i-1][j] = 2;
                    sh21++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh21++;
                }
            }
            if (j==5 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // j==5
                    mat[i-1][j] = 2;
                    sh21++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
                else if (ras==2 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh21++;
                }
            }
            if (j>1 && j<5 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // center
                    mat[i-1][j] = 2;
                    sh21++;
                }
                else if (ras==1 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
                else if (ras==2 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh21++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh21++;
                }
            }
        }
        while (sh11>=0 && sh11<4) {
            i = ran.nextInt(7);
            j = ran.nextInt(7);

            if (i==0 && j==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i==0 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i==6 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i==6 && j==0 && mat[i][j]==0 && mat[i-1][j+1]==0 && mat[i][j+1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i==0 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i==6 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (j==0 && i>0 && i<6 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (j==6 && i>0 && i<6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j-1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
            else if (i>0 && i<6 && j>0 && j<6 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh11++;
            }
        }
        return mat;
    }
}