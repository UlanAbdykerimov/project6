import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main6
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int[][] battleField = randomShips();
        int hits = 0;
        int sh3 = 0;
        int attemtps = 1;
        int ship1 = 0;
        int ship2 = 0;
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr3 = new ArrayList<String>();

        int x31 = 0; int y31 = 0;
        int x32 = 0; int y32 = 0;
        int x33 = 0; int y33 = 0;


        System.out.println("          Welcome to 'SeaBattle'! Enjoy your game!");
        System.out.print("Warrior, enter your name: ");
        String playerName = sc.nextLine();
        System.out.println("Be ready warrior, the battle is started!");

        while (hits<11) {
            System.out.println("   ------------------------------------");
            for (int i = 0; i < 7; i++) {
                int z = i + 1;
                System.out.print(z + "  ");
                for (int j = 0; j < 7; j++) {
                    if (battleField[i][j] >= 0 && battleField[i][j] < 4) System.out.print("|    ");
                    else if (battleField[i][j] == 4) System.out.print("|" + blue + " () " + reset);
                    else if (battleField[i][j] == 6 || battleField[i][j] == 7)
                        System.out.print("|" + yellow + " ++ " + reset);
                    else if (battleField[i][j] == 5 || battleField[i][j] == 8 || battleField[i][j] == 9)
                        System.out.print("|" + redBack + "    " + reset);
                }
                System.out.println("|");
                System.out.println("   ------------------------------------");
            }
            System.out.println("     A    B    C    D    E    F    G  ");
            System.out.print("Attempt #" + attemtps + "!       Captain " + playerName + ", enter the coordinates of enemy ship: ");
            String xy = sc.nextLine();
            char xChar = xy.charAt(0);
            char yChar = xy.charAt(2);
            int yChar2 = yChar;
            int xChar2 = xChar;
            int y = 0;
            if (xChar2>90) y = xChar2-96;
            else y = xChar2-64;
            int x = yChar2-48;
            x = x - 1;
            y = y - 1;

            if (x<0 || x>6 || y<0 || y>6) System.out.println("Captain " + playerName + ", size of the enemy base is only 7x7! So, enter right coordinates!");
            else if (battleField[x][y]==4) System.out.println("Captain " + playerName + ", according to existing intelligence information, there are no enemy ships at these coordinates, so enter other coordinates to save ammunition!");
            else if (battleField[x][y]>4 && battleField[x][y]<10) System.out.println("Captain " + playerName + ", these coordinates have already been hit, enter other coordinates!");
            else {
                int xm1 = x - 1;
                int xp1 = x + 1;
                int ym1 = y - 1;
                int yp1 = y + 1;
                int xm2 = x - 2;
                int xp2 = x + 2;
                int ym2 = y - 2;
                int yp2 = y + 2;
                if (battleField[x][y] == 0) {
                    battleField[x][y] = 4;
                } else if (battleField[x][y] == 1) {
                    battleField[x][y] = 5;
                    if (xm1 >= 0 && ym1 >= 0) battleField[xm1][ym1] = 4;
                    if (xm1 >= 0) battleField[xm1][y] = 4;
                    if (xm1 >= 0 && yp1 <= 6) battleField[xm1][yp1] = 4;
                    if (ym1 >= 0) battleField[x][ym1] = 4;
                    if (yp1 <= 6) battleField[x][yp1] = 4;
                    if (xp1 <= 6 && ym1 >= 0) battleField[xp1][ym1] = 4;
                    if (xp1 <= 6) battleField[xp1][y] = 4;
                    if (xp1 <= 6 && yp1 <= 6) battleField[xp1][yp1] = 4;
                    hits++;
                    ship1++;
                    if (ship1 == 1) System.out.println("Keep it up! You sank the fist 1x1 enemy ship!");
                    if (ship1 == 2) System.out.println("Keep it up! You sank the second 1x1 enemy ship!");
                    if (ship1 == 3) System.out.println("Keep it up! You sank the third 1x1 enemy ship!");
                    if (ship1 == 4)
                        System.out.println("Great job, captain " + playerName + "! You sank all 1x1 enemy ships!");
                } else if (battleField[x][y] == 2) {
                    battleField[x][y] = 6;
                    hits++;
                    if (ym1 >= 0) {
                        if (battleField[x][ym1] == 6) {
                            if (ym2 >= 0) {
                                if (xm1 >= 0) battleField[xm1][ym2] = 4;
                                battleField[x][ym2] = 4;
                                if (xp1 <= 6) battleField[xp1][ym2] = 4;
                            }
                            if (xm1 >= 0) battleField[xm1][ym1] = 4;
                            if (xp1 <= 6) battleField[xp1][ym1] = 4;
                            if (xm1 >= 0) battleField[xm1][y] = 4;
                            if (xp1 <= 6) battleField[xp1][y] = 4;
                            if (yp1 <= 6 && xm1 >= 0) battleField[xm1][yp1] = 4;
                            if (yp1 <= 6) battleField[x][yp1] = 4;
                            if (yp1 <= 6 && xp1 <= 6) battleField[xp1][yp1] = 4;
                            battleField[x][y] = 8;
                            battleField[x][ym1] = 8;
                            ship2++;
                            if (ship2 == 1) System.out.println("Keep it up! You sank the first 2x1 enemy ship!");
                            if (ship2 == 2)
                                System.out.println("Great job, captain " + playerName + "! You sank all 2x1 enemy ships!");
                        }
                    }
                    if (xm1 >= 0) {
                        if (battleField[xm1][y] == 6) {
                            if (xm2 >= 0) {
                                if (ym1 >= 0) battleField[xm2][ym1] = 4;
                                battleField[xm2][y] = 4;
                                if (yp1 <= 6) battleField[xm2][yp1] = 4;
                            }
                            if (ym1 >= 0) battleField[xm1][ym1] = 4;
                            if (yp1 <= 6) battleField[xm1][yp1] = 4;
                            if (ym1 >= 0) battleField[x][ym1] = 4;
                            if (yp1 <= 6) battleField[x][yp1] = 4;
                            if (ym1 >= 0 && xp1 <= 6) battleField[xp1][ym1] = 4;
                            if (xp1 <= 6) battleField[xp1][y] = 4;
                            if (yp1 <= 6 && xp1 <= 6) battleField[xp1][yp1] = 4;
                            battleField[x][y] = 8;
                            battleField[xm1][y] = 8;
                            ship2++;
                            if (ship2 == 1) System.out.println("Keep it up! You sank the first 2x1 enemy ship!");
                            if (ship2 == 2)
                                System.out.println("Great job, captain " + playerName + "! You sank all 2x1 enemy ships!");
                        }
                    }
                    if (yp1 <= 6) {
                        if (battleField[x][yp1] == 6) {
                            if (yp2 <= 6) {
                                if (xm1 >= 0) battleField[xm1][yp2] = 4;
                                battleField[x][yp2] = 4;
                                if (xp1 <= 6) battleField[xp1][yp2] = 4;
                            }
                            if (xm1 >= 0 && ym1 >= 0) battleField[xm1][ym1] = 4;
                            if (ym1 >= 0) battleField[x][ym1] = 4;
                            if (xm1 >= 0) battleField[xm1][y] = 4;
                            if (xp1 <= 6 && ym1 >= 0) battleField[xp1][ym1] = 4;
                            if (xp1 <= 6) battleField[xp1][y] = 4;
                            if (xm1 >= 0) battleField[xm1][yp1] = 4;
                            if (xp1 <= 6) battleField[xp1][yp1] = 4;
                            battleField[x][y] = 8;
                            battleField[x][yp1] = 8;
                            ship2++;
                            if (ship2 == 1) System.out.println("Keep it up! You sank the first 2x1 enemy ship!");
                            if (ship2 == 2)
                                System.out.println("Great job, captain " + playerName + "! You sank all 2x1 enemy ships!");
                        }
                    }
                    if (xp1 <= 6) {
                        if (battleField[xp1][y] == 6) {
                            if (xp2 <= 6) {
                                if (ym1 >= 0) battleField[xp2][ym1] = 4;
                                battleField[xp2][y] = 4;
                                if (yp1 <= 6) battleField[xp2][yp1] = 4;
                            }
                            if (xm1 >= 0 && ym1 >= 0) battleField[xm1][ym1] = 4;
                            if (xm1 >= 0) battleField[xm1][y] = 4;
                            if (xm1 >= 0 && yp1 <= 6) battleField[xm1][yp1] = 4;
                            if (ym1 >= 0) battleField[x][ym1] = 4;
                            if (yp1 <= 6) battleField[x][yp1] = 4;
                            if (ym1 >= 0) battleField[xp1][ym1] = 4;
                            if (yp1 <= 6) battleField[xp1][yp1] = 4;
                            battleField[x][y] = 8;
                            battleField[xp1][y] = 8;
                            ship2++;
                            if (ship2 == 1) System.out.println("Keep it up! You sank the first 2x1 enemy ship!");
                            if (ship2 == 2)
                                System.out.println("Great job, captain " + playerName + "! You sank all 2x1 enemy ships!");
                        }
                    }
                }
                if (battleField[x][y] == 3) {
                    sh3++;
                    if (sh3 == 1) {
                        x31 = x;
                        y31 = y;
                    }
                    if (sh3 == 2) {
                        x32 = x;
                        y32 = y;
                    }
                    battleField[x][y] = 7;
                    hits++;
                    if (sh3 == 3) {
                        x33 = x;
                        y33 = y;
                        System.out.println("Awesome, captain " + playerName + "! You sank the largest enemy ship!");
                        battleField[x31][y31] = 9;
                        battleField[x32][y32] = 9;
                        battleField[x33][y33] = 9;
                        if ((x31 - 1) >= 0) {
                            if ((y31 - 1) >= 0) battleField[x31 - 1][y31 - 1] = 4;
                            if (battleField[x31 - 1][y31] != 9) battleField[x31 - 1][y31] = 4;
                            if ((y31 + 1) <= 6) battleField[x31 - 1][y31 + 1] = 4;
                        }
                        if ((y31 - 1) >= 0 && battleField[x31][y31 - 1] != 9) battleField[x31][y31 - 1] = 4;
                        if ((y31 + 1) <= 6 && battleField[x31][y31 + 1] != 9) battleField[x31][y31 + 1] = 4;
                        if ((x31 + 1) <= 6) {
                            if ((y31 - 1) >= 0) battleField[x31 + 1][y31 - 1] = 4;
                            if (battleField[x31 + 1][y31] != 9) battleField[x31 + 1][y31] = 4;
                            if ((y31 + 1) <= 6) battleField[x31 + 1][y31 + 1] = 4;
                        }
                        if ((x32 - 1) >= 0) {
                            if ((y32 - 1) >= 0) battleField[x32 - 1][y32 - 1] = 4;
                            if (battleField[x32 - 1][y32] != 9) battleField[x32 - 1][y32] = 4;
                            if ((y32 + 1) <= 6) battleField[x32 - 1][y32 + 1] = 4;
                        }
                        if ((y32 - 1) >= 0 && battleField[x32][y32 - 1] != 9) battleField[x32][y32 - 1] = 4;
                        if ((y32 + 1) <= 6 && battleField[x32][y32 + 1] != 9) battleField[x32][y32 + 1] = 4;
                        if ((x32 + 1) <= 6) {
                            if ((y32 - 1) >= 0) battleField[x32 + 1][y32 - 1] = 4;
                            if (battleField[x32 + 1][y32] != 9) battleField[x32 + 1][y32] = 4;
                            if ((y32 + 1) <= 6) battleField[x32 + 1][y32 + 1] = 4;
                        }
                        if ((x33 - 1) >= 0) {
                            if ((y33 - 1) >= 0) battleField[x33 - 1][y33 - 1] = 4;
                            if (battleField[x33 - 1][y33] != 9) battleField[x33 - 1][y33] = 4;
                            if ((y33 + 1) <= 6) battleField[x33 - 1][y33 + 1] = 4;
                        }
                        if ((y33 - 1) >= 0 && battleField[x33][y33 - 1] != 9) battleField[x33][y33 - 1] = 4;
                        if ((y33 + 1) <= 6 && battleField[x33][y33 + 1] != 9) battleField[x33][y33 + 1] = 4;
                        if ((x33 + 1) <= 6) {
                            if ((y33 - 1) >= 0 && (x33 + 1) <= 6) battleField[x33 + 1][y33 - 1] = 4;
                            if (battleField[x33 + 1][y33] != 9) battleField[x33 + 1][y33] = 4;
                            if ((y33 + 1) <= 6) battleField[x33 + 1][y33 + 1] = 4;
                        }
                    }
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                attemtps++;
                if (hits==11) {
                    System.out.println("   ------------------------------------");
                    for (int i = 0; i < 7; i++) {
                        int z = i + 1;
                        System.out.print(z + "  ");
                        for (int j = 0; j < 7; j++) {
                            if (battleField[i][j] >= 0 && battleField[i][j] < 4) System.out.print("|    ");
                            else if (battleField[i][j] == 4) System.out.print("|" + blue + " () " + reset);
                            else if (battleField[i][j] == 6 || battleField[i][j] == 7)
                                System.out.print("|" + yellow + " ++ " + reset);
                            else if (battleField[i][j] == 5 || battleField[i][j] == 8 || battleField[i][j] == 9)
                                System.out.print("|" + redBack + "    " + reset);
                        }
                        System.out.println("|");
                        System.out.println("   ------------------------------------");
                    }
                    System.out.println("     A    B    C    D    E    F    G  ");
                    System.out.println("Wonderful, captain " + playerName + "! Thanks to your clear leadership we won the battle in " + attemtps + " attempts!");
                    System.out.println("We have a lot of other enemies. The crew of our ship are strongly wishing to continue the war with your leading, captain " + playerName + "! Do you want to continue to lead our ship? ");
                    System.out.print("Your answer, cap: ");
                    try (FileWriter f = new FileWriter("toplist.txt", true);
                         BufferedWriter b = new BufferedWriter(f);
                         PrintWriter p = new PrintWriter(b);) {


                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm");
                        String formattedDate = myDateObj.format(myFormatObj);

                        p.println(playerName);
                        p.println(attemtps);
                        p.println(formattedDate);

                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    BufferedReader reader;

                            try {
                                reader = new BufferedReader(new FileReader("toplist.txt"));
                                String line = reader.readLine();
                                arr1.add(line);
                                line = reader.readLine();


                                int o = 0;
                                while (line != null) {
                                    int number = Integer.parseInt(line);
                                    arr2.add(number);
                                    line = reader.readLine();
                                    arr3.add(line);
                                    line = reader.readLine();
                                    arr1.add(line);
// read next line
                                    line = reader.readLine();
                                    o++;
                                }

                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    int change2 = 0;
                    String change1 = " ";
                    String change3 = " ";
                    for (int w=0; w<arr2.size(); w++) {
                        for (int e=0; e<arr2.size(); e++) {
                            if (arr2.get(w)<arr2.get(e)) {
                                change2 = arr2.get(w);
                                arr2.set(w, arr2.get(e));
                                arr2.set(e, change2);
                                change1 = arr1.get(w);
                                arr1.set(w, arr1.get(e));
                                arr1.set(e, change1);
                                change3 = arr3.get(w);
                                arr3.set(w, arr3.get(e));
                                arr3.set(e, change3);
                            }
                        }
                    }
                    for (int w=0; w<arr2.size(); w++) {
                        for (int e=0; e<arr2.size(); e++) {
                            if (Objects.equals(arr1.get(w), arr1.get(e)) && w!=e) {
                                if (arr2.get(w)<=arr2.get(e)) {
                                    arr1.remove(e);
                                    arr2.remove(e);
                                    arr3.remove(e);
                                }
                                else {
                                    change2 = arr2.get(w);
                                    arr2.set(w, arr2.get(e));
                                    arr2.set(e, change2);
                                    change1 = arr1.get(w);
                                    arr1.set(w, arr1.get(e));
                                    arr1.set(e, change1);
                                    change3 = arr3.get(w);
                                    arr3.set(w, arr3.get(e));
                                    arr3.set(e, change3);
                                    arr1.remove(e);
                                    arr2.remove(e);
                                    arr3.remove(e);
                                }
                            }
                        }
                    }
                    Scanner sca = new Scanner(System.in);
                    String capAnswer = sca.nextLine();
                    String yes1 = "YES";
                    String yes2 = "Yes";
                    String yes3 = "yes";
                    String no1 = "NO";
                    String no2 = "No";
                    String no3 = "no";
                    if (capAnswer.equals(yes1) || capAnswer.equals(yes2) || capAnswer.equals(yes3)) {
                        hits = 0;
                        attemtps=0;
                        System.out.println("The new battle is starting! GOOOOOO!!!");
                        battleField = randomShips();
                        sh3=0;
                    }
                    else if (capAnswer.equals(no1) || capAnswer.equals(no2) || capAnswer.equals(no3)) {
                        System.out.println();
                        if (arr1.size() > 10) System.out.println("Top 10 best players ever: ");
                        else
                            System.out.println("                           Top " + arr2.size() + " best players ever: ");
                        System.out.println();
                        if (arr1.size() > 10) {
                            for (int w = 0; w < 10; w++) {
                                int e = w + 1;
                                System.out.println(e + ": " + arr1.get(w) + " - " + arr2.get(w) + "  (" + arr3.get(w) + ")");
                            }
                        } else {
                            for (int w = 0; w < arr2.size(); w++) {
                                int e = w + 1;
                                System.out.println(e + ": " + arr1.get(w) + " - " + arr2.get(w) + "  (" + arr3.get(w) + ")");
                            }
                        }
                    }
                }
            }

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
    public static final String reset = "\u001B[0m";
    public static final String redBack = "\u001B[41m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";

}