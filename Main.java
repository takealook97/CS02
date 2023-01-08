import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] titles = {"제목01", "제목02", "제목03", "제목04", "제목05", "제목06",
                "제목07", "제목08", "제목09", "제목10", "제목11", "제목12", "제목13"};
        LinkedHashMap<String, Node> movieList = new LinkedHashMap<>();
        System.out.println("---영상클립 생성---");
        for (int i = 0; i < 13; i++) {
            Node newNode = new Node(titles[i], null);
            movieList.put(newNode.id, newNode);
            newNode.print();
        }
        //-----------------------------------------------------------------------------
        PrintedList list = new PrintedList();//PrintedList 객체생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        while (true) {
            System.out.print("> ");
            String order[] = br.readLine().split(" ");//스페이스바를 기준으로 입력을 input배열에 넣어줌
            switch (order[0]) {//order[0] = 명령 / order[1] = id / order[3] = insert 위치
                case "add":
                    if (movieList.containsKey(order[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        list.add(movieList.get(order[1]));//list에 add
                        list.print();//출력
                    } else {//id가 해시맵(출력된아이디)에 없는 key값일 경우
                        list.error();//에러
                    }
                    break;
                case "delete":
                    if (movieList.containsKey(order[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        int prevTotalLength = list.totalLength;//prevTotalLength에 기존의 영상길이 저장
                        list.delete(movieList.get(order[1]));//list에서 delete
                        if (prevTotalLength != list.totalLength) {//영상길이가 줄어들었다면
                            list.print();
                        } else {//해시맵(출력된아이디)에 있지만 list에 없는 id를 지우라는 명령일 때
                            list.error();
                        }//영상길이가 줄어들 지 않았을 것이므로 에러 출력
                    } else {//id가 해시맵(출력된아이디)에 없는 key값일 경우
                        list.error();//에러
                    }
                    break;
                case "insert":
                    if (movieList.containsKey(order[1])) {//id가 해시맵(출력된아이디)에 있는 key값일 경우
                        list.insert(movieList.get(order[1]), Integer.parseInt(order[2]));//입력 위치에 insert
                        list.print();
                    } else list.error();
                    break;
                case "render":
                    list.render();
                    break;
                default:
                    System.out.println("command is wrong");
            }
        }
    }
}