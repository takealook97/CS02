import java.util.HashSet;
import java.util.Random;

public class Node {
    static HashSet<String> idVerification = new HashSet<>();
    String id;
    String title;
    int time;
    Node next;

    public Node(String title, Node next) {
        this.title = title;
        id = makeId();
        time = makeTime();
        this.next = next;
    }

    public Node(String id, String title, int time, Node next) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.next = next;
    }

    void print() {//형식 출력
        System.out.println(title + "(" + id + "):" + time + "초");
    }

    String makeId() {//랜덤으로 8자리 알파벳 아이디 생성
        Random rd = new Random();
        String newId = "";
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append((char) (rd.nextInt(26) + 'a'));
            }
            if (!idVerification.contains(sb.toString())) {//중복방지
                idVerification.add(sb.toString());
                newId = sb.toString();
                break;
            }
        }
        return newId;
    }

    int makeTime() {//랜덤으로 1~15초 생성
        Random rd = new Random();
        return rd.nextInt(15) + 1;
    }

    Node copy() {//저장
        return new Node(id, title, time, null);
    }
}
