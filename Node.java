import java.util.HashSet;
import java.util.Random;

public class Node {

    String title;
    String id;
    int time;
    Node next;
    HashSet<String> idVerify = new HashSet<>();

    public Node(String title, Node next) {
        this.title = title;
        id = makeId();
        time = makeTime();
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
            if (!idVerify.contains(sb.toString())) {
                idVerify.add(sb.toString());
                return sb.toString();
            }
        }
    }

    int makeTime() {
        Random rd = new Random();
        return rd.nextInt(15) + 1;
    }

    void print() {
        System.out.println(title + "(" + id + "):" + time + "초");
    }
}
