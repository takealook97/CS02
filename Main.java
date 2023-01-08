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
        //----------------------------------------------------------------------------
        MyList list = new MyList();//MyList 객체생성
        while (true) {
            System.out.print("> ");
            String[] input = br.readLine().split(" ");//스페이스바를 기준으로 입력을 input배열에 넣어줌
            switch (input[0]) {//input[0] = 명령 / input [1] = id / input [3] = insert 위치
                case "add":
                    if (videoMap.containsKey(input[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        list.add(videoMap.get(input[1]));//list에 add
                        list.print();//출력
                    } else {//id가 해시맵(출력된아이디)에 없는 key값일 경우
                        list.printError();//에러
                    }
                    break;
                case "insert":
                    if (videoMap.containsKey(input[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        list.insert(videoMap.get(input[1]), Integer.parseInt(input[2]));//입력 위치에 insert
                        list.print();
                    } else {
                        list.printError();
                    }
                    break;
                case "delete":
                    if (videoMap.containsKey(input[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        int prevTotalLength = list.totalLength;//prevTotalLength에 기존의 영상길이 저장
                        list.delete(videoMap.get(input[1]));//list에서 delete
                        if (list.totalLength != prevTotalLength) {//영상길이가 줄어들었다면
                            list.print();
                        } else {//해시맵(출력된아이디)에 있지만 list에 없는 id를 지우라는 명령일 때
                            list.printError();//영상길이가 줄어들 지 않았을 것이므로 에러 출력
                        }
                    } else {//id가 해시맵(출력된아이디)에 없는 key값일 경우
                        list.printError();//에러
                    }
                    break;
                case "render":
                    list.render();
                    break;
                default: {//case에 있는 명령이 아닐 경우
                    System.out.println("잘못된 명령어입니다.");
                }
            }
        }
    }
}
