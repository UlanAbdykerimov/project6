import java.util.Scanner;
import java.util.Random;

public class Main6
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
        int sh11 = 0;
        int sh12 = 0;
        int sh13 = 0;
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
        while (sh21==0) {  //placing first ship 2x1
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
        while (sh22==0) {  //placing second ship 2x1
            i = ran.nextInt(7);
            j = ran.nextInt(7);

            ras = ran.nextInt(2);
            if (ras == 0 && i == 6 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i][j - 2] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j - 1] == 0 && mat[i - 1][j - 2] == 0) {
                mat[i][j] = 2;
                mat[i][j - 1] = 2;
                sh22++;
            } else if (i == 6 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j - 1] == 0 && mat[i - 2][j] == 0 && mat[i - 2][j - 1] == 0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh22++;
            } else if (ras == 0 && i == 6 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j + 1] == 0 && mat[i - 2][j] == 0 && mat[i - 2][j + 1] == 0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh22++;
            } else if (i == 6 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j + 2] == 0 && mat[i - 1][j] == 0 && mat[i - 1][j + 1] == 0 && mat[i - 1][j + 2] == 0) {
                mat[i][j] = 2;
                mat[i][j + 1] = 2;
                sh22++;
            } else if (ras == 0 && i == 0 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 2][j] == 0 && mat[i + 2][j + 1] == 0) {
                mat[i][j] = 2;
                mat[i + 1][j] = 2;
                sh22++;
            } else if (i == 0 && j == 0 && mat[i][j] == 0 && mat[i][j + 1] == 0 && mat[i][j + 2] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j + 1] == 0 && mat[i + 1][j + 2] == 0) {
                mat[i][j] = 2;
                mat[i][j + 1] = 2;
                sh22++;
            } else if (ras == 0 && i == 0 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j - 1] == 0 && mat[i + 2][j] == 0 && mat[i + 2][j - 1] == 0) {
                mat[i][j] = 2;
                mat[i + 1][j] = 2;
                sh22++;
            } else if (i == 0 && j == 6 && mat[i][j] == 0 && mat[i][j - 1] == 0 && mat[i][j - 2] == 0 && mat[i + 1][j] == 0 && mat[i + 1][j - 1] == 0 && mat[i + 1][j - 2] == 0) {
                mat[i][j] = 2;
                mat[i][j - 1] = 2;
                sh22++;
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
                    sh22++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
            } if (ras==2 && i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                mat[i][j] = 2;
                mat[i - 1][j] = 2;
                sh22++;
            }
            if (i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                mat[i][j] = 2;
                mat[i][j-1] = 2;
                sh22++;
            }
            if (i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {  //corner 5;1
                    mat[i][j] = 2;
                    mat[i + 1][j] = 2;
                    sh22++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh22++;
                }
            }
            if (ras==2 && i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                mat[i][j]=2;
                mat[i-1][j]=2;
                sh22++;
            }
            if (i == 5 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                mat[i][j]=2;
                mat[i][j+1]=2;
                sh22++;
            }
            if (i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {   //corner 1;1
                    mat[i][j] = 2;
                    mat[i - 1][j] = 2;
                    sh22++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh22++;
                }
            }
            if (ras == 2 && i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                mat[i][j]=2;
                mat[i][j+1]=2;
                sh22++;
            }
            if (i == 1 && j == 1 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                mat[i][j]=2;
                mat[i+1][j]=2;
                sh22++;
            }
            if (i == 1 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0) {  //corner 1;5
                    mat[i][j] = 2;
                    mat[i - 1][j] = 2;
                    sh22++;
                }
                else if (ras==1)
                {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
            }
            if (ras==2 && i == 5 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                mat[i][j]=2;
                mat[i][j-1]=2;
                sh22++;
            }
            if (i == 1 && j == 5 && mat[i][j] == 0 && mat[i-1][j - 1] == 0 && mat[i-1][j] == 0 && mat[i-1][j+1] == 0 && mat[i][j - 1] == 0 && mat[i][j+1] == 0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0 && mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                mat[i][j]=2;
                mat[i+1][j]=2;
                sh22++;
            }
            if (i==1 && j>1 && j<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;  // i==1
                    mat[i][j-1] = 2;
                    sh22++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i-1][j] = 2;
                    sh22++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh22++;
                }
            }
            if (i==5 && j>1 && j<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;  // i==5
                    mat[i][j-1] = 2;
                    sh22++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh22++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
                else if (mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i-1][j] = 2;
                    sh22++;
                }
            }
            if (j==1 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // j==1
                    mat[i-1][j] = 2;
                    sh22++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh22++;
                }
                else if (ras==2 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh22++;
                }
            }
            if (j==5 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // j==5
                    mat[i-1][j] = 2;
                    sh22++;
                }
                else if (ras==1) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
                else if (ras==2 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh22++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh22++;
                }
            }
            if (j>1 && j<5 && i>1 && i<5 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                if (ras==0 && mat[i-2][j-1]==0 && mat[i-2][j]==0 && mat[i-2][j+1]==0) {
                    mat[i][j] = 2;  // center
                    mat[i-1][j] = 2;
                    sh22++;
                }
                else if (ras==1 && mat[i-1][j+2]==0 && mat[i][j+2]==0 && mat[i+1][j+2]==0) {
                    mat[i][j] = 2;
                    mat[i][j+1] = 2;
                    sh22++;
                }
                else if (ras==2 && mat[i-1][j-2]==0 && mat[i][j-2]==0 && mat[i+1][j-2]==0) {
                    mat[i][j] = 2;
                    mat[i][j-1] = 2;
                    sh22++;
                }
                else if (mat[i+2][j-1]==0 && mat[i+2][j]==0 && mat[i+2][j+1]==0) {
                    mat[i][j] = 2;
                    mat[i+1][j] = 2;
                    sh22++;
                }
            }
        }
        while (sh11==0) {
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
        while (sh12==0) {
            i = ran.nextInt(7);
            j = ran.nextInt(7);

            if (i==0 && j==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i==0 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i==6 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i==6 && j==0 && mat[i][j]==0 && mat[i-1][j+1]==0 && mat[i][j+1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i==0 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i==6 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (j==0 && i>0 && i<6 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (j==6 && i>0 && i<6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j-1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
            else if (i>0 && i<6 && j>0 && j<6 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh12++;
            }
        }
        while (sh13==0) {
            i = ran.nextInt(7);
            j = ran.nextInt(7);

            if (i==0 && j==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i==0 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i==6 && j==6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i==6 && j==0 && mat[i][j]==0 && mat[i-1][j+1]==0 && mat[i][j+1]==0 && mat[i-1][j]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i==0 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i==6 && j>0 && j<6 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (j==0 && i>0 && i<6 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (j==6 && i>0 && i<6 && mat[i][j]==0 && mat[i][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j-1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
            else if (i>0 && i<6 && j>0 && j<6 && mat[i-1][j-1]==0 && mat[i-1][j]==0 && mat[i-1][j+1]==0 && mat[i][j-1]==0 && mat[i][j]==0 && mat[i][j+1]==0 && mat[i+1][j-1]==0 && mat[i+1][j]==0 && mat[i+1][j+1]==0) {
                mat[i][j] = 1;
                sh13++;
            }
        }
        return mat;
    }
}