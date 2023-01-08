import java.util.HashSet;
import java.util.Random;

public class Node {
    String title;
    String id;
    int time;
    Node next;
    HashSet<String> idVerification = new HashSet<>();

    public Node(String title, Node next) {
        this.title = title;
        id = makeId();
        time = makeTime();
        this.next = next;
    }

    public Node(String title, String id, int time, Node next) {
        this.title = title;
        this.id = id;
        this.time = time;
        this.next = next;
    }

    String makeId() {
        Random rd = new Random();
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                int alphabet = rd.nextInt(26) + 'a';
                sb.append((char) alphabet);
            }
            if (!idVerification.contains(sb.toString())) {
                idVerification.add(sb.toString());
                return sb.toString();
            }
        }
    }

    int makeTime() {
        Random rd = new Random();
        return rd.nextInt(15) + 1;
    }

    void print() {//형식 출력
        System.out.println(title + "(" + id + "):" + time + "초");
    }
}
