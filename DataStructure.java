import java.util.Scanner;

public class DataStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] title = {"제목01", "제목02", "제목03", "제목04", "제목05", "제목06",
                "제목07", "제목08", "제목09", "제목10", "제목11", "제목12", "제목13"};
        String[] id = new String[13];
        int[] time = new int[13];
        for (int i = 0; i < 13; i++) {
            id[i] = "";
            for (int j = 0; j < 8; j++) {
                int num = (int) (Math.random() * 26 + 97);
                id[i] += String.valueOf((char) num);
            }
            time[i] = (int) (Math.random() * 16 + 1);
        }
        for (int i = 0; i < 13; i++) {
            System.out.println(title[i] + "(" + id[i] + "):" + time[i] + "초");
        }
    }
}