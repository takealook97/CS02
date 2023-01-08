import java.util.HashSet;
import java.util.Random;

public class Node {

    String title;
    String id;
    int time;
    Node next;
    static HashSet<String> idVerify = new HashSet<>();//static 으로 Set에 아이디 스택

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

    Node copy() {
        return new Node(title, id, time, null);
    }

}
