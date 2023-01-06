import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] titles = {"제목01", "제목02", "제목03", "제목04", "제목05", "제목06",
                "제목07", "제목08", "제목09", "제목10", "제목11", "제목12", "제목13"};
        LinkedHashMap<String, Node> videoMap = new LinkedHashMap<>();
        for (int i = 0; i < 13; i++) {
            Node newNode = new Node(titles[i], null);
            videoMap.put(newNode.id, newNode);
        }
        System.out.println("---영상클립---");
        for (Node node : videoMap.values()) {
            node.print();
        }
//------------------------------------------------------------------------------------
        MyList list = new MyList();
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "add": {
                    if (videoMap.containsKey(input[1])) {//생성된 id일 때
                        list.add(videoMap.get(input[1]).copy());
                        list.print();
                    } else {//생성되지 않은 id일 경우 에러
                        list.printError();
                    }
                    break;
                }
                case "insert": {
                    if (videoMap.containsKey(input[1])) {
                        list.insert(videoMap.get(input[1]).copy(), Integer.parseInt(input[2]));
                        list.print();
                    } else {
                        list.printError();
                    }
                    break;
                }
                case "delete": {
                    if (videoMap.containsKey(input[1])) {
                        int prevSize = list.size;
                        list.delete(videoMap.get(input[1]));
                        if (list.size != prevSize)
                            list.print();
                        else
                            list.printError();
                    } else {
                        list.printError();
                    }
                    break;
                }
                case "render": {
                    System.out.println("영상클립: " + list.size + "개");
                    System.out.println("전체길이: " + list.totalTime + "sec");
                    break;
                }
                default: {
                    System.out.println("잘못된 명령어입니다.");
                }
            }
        }
    }
}