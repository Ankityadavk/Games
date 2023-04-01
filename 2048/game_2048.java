import java.lang.Math;
import java.util.Scanner;

public class game_2048 {
    int arr[][] = new int[4][4];
    double p2 = 0.7;

    game_2048() {
        int a = (int) (Math.random() * 4);
        int b = (int) (Math.random() * 4);
        int e = (int) (Math.random() * 2) + 1;
        arr[a][b] = 2 * e;
    }

    public boolean move_up() {
        if (column_up(0) + column_up(1) + column_up(2) + column_up(3) != 0) {
            return true;
        }
        return false;
    }

    public boolean move_down() {
        if (column_down(0) + column_down(1) + column_down(2) + column_down(3) != 0) {
            return true;
        }
        return false;
    }

    public boolean move_left() {
        if (row_left(0) + row_left(1) + row_left(2) + row_left(3) != 0) {
            return true;
        }
        return false;
    }

    public boolean move_right() {
        if (row_right(0) + row_right(1) + row_right(2) + row_right(3) != 0) {
            return true;
        }
        return false;
    }

    public int row_left(int row) {
        int sol = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[row][i] == 0) {
                for (int j = i + 1; j < 4; j++) {
                    if (arr[row][j] != 0) {
                        arr[row][i] = arr[row][j];
                        arr[row][j] = 0;
                        sol++;
                        break;
                    }
                }
            }
        }

        if (arr[row][0] == arr[row][1] && arr[row][1] != 0) {
            arr[row][0] *= 2;
            if (arr[row][2] == arr[row][3]) {
                arr[row][1] = 2 * arr[row][2];
                arr[row][2] = 0;
                arr[row][3] = 0;
                return 1;
            } else {
                arr[row][1] = arr[row][2];
                arr[row][2] = arr[row][3];
                arr[row][3] = 0;
                return 1;
            }
        } else if (arr[row][1] == arr[row][2] && arr[row][2] != 0) {
            arr[row][1] *= 2;
            arr[row][2] = arr[row][3];
            arr[row][3] = 0;
            return 1;
        } else if (arr[row][2] == arr[row][3] && arr[row][3] != 0) {
            arr[row][2] *= 2;
            arr[row][3] = 0;
            return 1;
        }
        return sol;
    }

    public int column_up(int column) {
        int sol = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][column] == 0) {
                for (int j = i + 1; j < 4; j++) {
                    if (arr[j][column] != 0) {
                        arr[i][column] = arr[j][column];
                        arr[j][column] = 0;
                        sol++;
                        break;
                    }
                }
            }
        }

        if (arr[0][column] == arr[1][column] && arr[1][column] != 0) {
            arr[0][column] *= 2;
            if (arr[2][column] == arr[3][column]) {
                arr[1][column] = 2 * arr[2][column];
                arr[2][column] = 0;
                arr[3][column] = 0;
                return 1;
            } else {
                arr[1][column] = arr[2][column];
                arr[2][column] = arr[3][column];
                arr[3][column] = 0;
                return 1;
            }
        } else if (arr[1][column] == arr[2][column] && arr[1][column] != 0) {
            arr[1][column] *= 2;
            arr[2][column] = arr[3][column];
            arr[3][column] = 0;
            return 1;
        } else if (arr[2][column] == arr[3][column] && arr[2][column] != 0) {
            arr[2][column] *= 2;
            arr[3][column] = 0;
            return 1;
        }
        return sol;
    }

    public int column_down(int column) {
        int sol = 0;
        for (int i = 3; i >= 0; i--) {
            if (arr[i][column] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j][column] != 0) {
                        arr[i][column] = arr[j][column];
                        arr[j][column] = 0;
                        sol++;
                        break;
                    }
                }
            }
        }

        if (arr[3][column] == arr[2][column] && arr[3][column] != 0) {
            arr[3][column] *= 2;
            if (arr[1][column] == arr[0][column]) {
                arr[2][column] = 2 * arr[1][column];
                arr[1][column] = 0;
                arr[0][column] = 0;
                return 1;
            } else {
                arr[2][column] = arr[1][column];
                arr[1][column] = arr[0][column];
                arr[0][column] = 0;
                return 1;
            }
        } else if (arr[2][column] == arr[3][column] && arr[3][column] != 0) {
            arr[2][column] *= 2;
            arr[1][column] = arr[0][column];
            arr[0][column] = 0;
            return 1;
        } else if (arr[1][column] == arr[0][column] && arr[1][column] != 0) {
            arr[1][column] *= 2;
            arr[0][column] = 0;
            return 1;
        }
        return sol;
    }

    public boolean check() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int score() {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public int row_right(int row) {
        int sol = 0;
        for (int i = 3; i >= 0; i--) {
            if (arr[row][i] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[row][j] != 0) {
                        arr[row][i] = arr[row][j];
                        arr[row][j] = 0;
                        sol++;
                        break;
                    }
                }
            }
        }

        if (arr[row][3] == arr[row][2] && arr[row][2] != 0) {
            arr[row][3] *= 2;
            if (arr[row][1] == arr[row][0]) {
                arr[row][2] = 2 * arr[row][1];
                arr[row][1] = 0;
                arr[row][0] = 0;
                return 1;
            } else {
                arr[row][2] = arr[row][1];
                arr[row][1] = arr[row][0];
                arr[row][0] = 0;
                return 1;
            }
        } else if (arr[row][2] == arr[row][3] && arr[row][2] != 0) {
            arr[row][2] *= 2;
            arr[row][1] = arr[row][0];
            arr[row][0] = 0;
            return 1;
        } else if (arr[row][1] == arr[row][0] && arr[row][0] != 0) {
            arr[row][1] *= 2;
            arr[row][0] = 0;
            return 1;
        }
        return sol;
    }

    public int input() {
        int n;
        System.out.println("Enter 1 to move UP");
        System.out.println("Enter 2 to move DOWN");
        System.out.println("Enter 3 to move LEFT");
        System.out.println("Enter 4 to move RIGHT");
        System.out.println("Enter 0 to EXIT GAME");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        return n;
    }

    public boolean win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                inside(arr[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void inside(int a) {
        String s = String.valueOf(a);
        char array[] = new char[6];
        array[0] = ' ';
        array[5] = ' ';
        if (s.length() % 2 != 0) {
            if (s.length() == 1) {
                array[1] = ' ';
                array[2] = s.charAt(0);
                array[3] = ' ';
                array[4] = ' ';
            } else if (s.length() == 3) {
                array[1] = s.charAt(0);
                array[2] = s.charAt(1);
                array[3] = s.charAt(2);
                array[4] = ' ';
            }
        } else {
            if (s.length() == 2) {
                array[1] = ' ';
                array[2] = s.charAt(0);
                array[3] = s.charAt(1);
                array[4] = ' ';
            } else if (s.length() == 4) {
                array[1] = s.charAt(0);
                array[2] = s.charAt(1);
                array[3] = s.charAt(2);
                array[4] = s.charAt(3);
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public void num_generator() {
        int a = (int) (Math.random() * 4);
        int b = (int) (Math.random() * 4);
        while (arr[a][b] != 0) {
            a = (int) (Math.random() * 4);
            b = (int) (Math.random() * 4);
        }
        int val = (int) (Math.random() * 100);
        if (val < (p2 * 100)) {
            arr[a][b] = 2;
        } else {
            arr[a][b] = 4;
        }
    }

    public void play() {
        boolean flag = true;
        while (flag) {
            if (check()) {
                num_generator();
            } else {
                System.out.println("GAME OVER");
                System.out.println("Yor socre is " + score());
                return;
            }
            print();
            int a = input();
            switch (a) {
                case 0:
                    return;
                case 1:
                    if (move_up()) {
                        break;
                    } else {
                        System.out.println("Invalid move");
                        continue;
                    }
                case 2:
                    if (move_down()) {
                        break;
                    } else {
                        System.out.println("Invalid move");
                        continue;
                    }
                case 3:
                    if (move_left()) {
                        break;
                    } else {
                        System.out.println("Invalid move");
                        continue;
                    }
                case 4:
                    if (move_right()) {
                        break;
                    } else {
                        System.out.println("Invalid move");
                        continue;
                    }
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        game_2048 al = new game_2048();
        al.play();
        System.out.println("\n\nTHE END");
    }
    // public static void main(String[] args) {
    // game_2048 al = new game_2048();
    // al.arr[1][0] = 2;
    // al.arr[2][0] = 2;
    // al.print();
    // System.out.println(al.move_left());
    // al.print();
    // System.out.println("\n\nTHE END");
    // }
}
