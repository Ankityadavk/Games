public class test {
    public static void main(String[] args) {
        int a = 2048;
        String s = String.valueOf(a);
        int arr[][] = new int[4][4];
        arr[1][2] = 10;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.println(")))))))))))))");
    }

}
