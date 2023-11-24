import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        System.out.println("          Welcome to 'SeaBattle'! Enjoy your game!");
        System.out.print("Warrior, enter your name: ");
        String playerName = sc.nextLine();

        int[][] battleField = randomShips();
         for (int i=0; i<7; i++) {
             for (int j=0; j<7; j++) {
                 System.out.print(battleField[i][j]+" ");
             }
             System.out.println();
         }

    }
    public static int[][] randomShips () {
        Random ran = new Random();
        int[][] mat = new int [7][7];
        int sh21 = 0;
        int sh22 = 0;
        int sh1 = 0;
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
        while (sh21==0) {
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
            else if (i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {
                    mat[i][j] = 2;
                    mat[i + 1][j] = 2;
                    sh21++;
                }
                else
                {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh21++;
                }
            } else if (i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh21++;
            }
//            else if (ras == 0 && i == 0 && j == 1 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j - 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 1][j - 1] == 0) {
//                mat[i][j] = 2;
//                mat[i][j - 1] = 2;
//            } else if (ras == 1 && i == 0 && j == 1 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j - 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 1][j - 1] == 0 && mat[i + 2][j] == 0 && mat[i + 2][j + 1] == 0 && mat[i + 2][j - 1] == 0) {
//                mat[i][j] = 2;
//                mat[i + 1][j] = 2;
//            } else if (ras == 2 && i == 0 && j == 1 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j - 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 1][j - 1] == 0 && mat[i][j + 2] == 0 && mat[i + 1][j + 2] == 0) {
//                mat[i][j] = 2;
//                mat[i][j + 1] = 2;
//            } else if (ras == 0 && i == 1 && j == 0 && mat[i - 1][j] == 0 && mat[i][j] == 0 && mat[i + 1][j] == 0 && mat[i - 1][j + 1] == 0 && mat[i][j + 1] == 0 && mat[i + 1][j + 1] == 0) {
//                mat[i][j] = 2;
//                mat[i - 1][j] = 2;
//            } else if (ras == 1 && i == 1 && j == 0 && mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0 && mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0) {
//                mat[i][j] = 2;
//                mat[1][1] = 2;
//            } else if (ras == 2 && i == 1 && j == 0 && mat[0][0] == 0 && mat[0][1] == 0 && mat[1][0] == 0 && mat[1][1] == 0 && mat[2][0] == 0 && mat[2][1] == 0 && mat[3][0] == 0 && mat[3][1] == 0) {
//                mat[i][j] = 2;
//                mat[2][0] = 2;
//            } else if (ras == 0 && i == 0 && j == 5 && mat[0][4] == 0 && mat[0][5] == 0 && mat[0][6] == 0 && mat[1][4] == 0 && mat[1][5] == 0 && mat[1][6] == 0) {
//                mat[i][j] = 2;
//                mat[0][6] = 2;
//            } else if (ras == 1 && i == 0 && j == 5 && mat[0][4] == 0 && mat[0][5] == 0 && mat[0][6] == 0 && mat[1][4] == 0 && mat[1][5] == 0 && mat[1][6] == 0 && mat[0][3] == 0 && mat[1][3] == 0) {
//                mat[i][j] = 2;
//                mat[0][4] = 2;
//            } else if (ras == 2 && i == 0 && j == 5 && mat[0][4] == 0 && mat[0][5] == 0 && mat[0][6] == 0 && mat[1][4] == 0 && mat[1][5] == 0 && mat[1][6] == 0 && mat[2][4] == 0 && mat[2][5] == 0 && mat[2][6] == 0) {
//                mat[i][j] = 2;
//                mat[1][5] = 2;
//            }
        }
//        while (mat[i][j]!=0 || mat[i][j-1]!=0 || mat[i][j+1]!=0 || mat[i-1][j]!=0 || mat[i-1][j-1]!=0 || mat[i-1][j+1]!=0 || mat[i+1][j-1]!=0 || mat[i+1][j]!=0 || mat[i+1][j+1]!=0) {
//            i = ran.nextInt(5)+1;
//            j = ran.nextInt(5)+1;
//        }
//        mat[i][j] = 2;
//        ras = ran.nextInt(4);
//
//        if (ras==0 && (mat[i][j-2]==0 || mat[i-1][j]==0 || mat[i-1][j-1]==0 || mat[i-1][j-2]==0 || mat[i+1][j-1]==0 || mat[i+1][j]==0 || mat[i+1][j-2]==0)) {
//
//        }
        return mat;
    }
}