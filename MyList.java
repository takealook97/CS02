public class MyList {
    Node head;
    int totalLength;
    int totalTime;

    void add(Node newNode) {
        if (head == null) {//아무 것도 없는 상태일때
            head = newNode;//추가될 노드가 앞으로의 헤드 노드
            totalLength = 1;//길이는 1로 지정
        } else {//다른 노드가 있는 상태일 때 마지막에 추가해야한다
            Node lastNode = getLastNode();//getLastNode 메서드를 통해 찾은 마지막 노드
            lastNode.next = newNode;//마지막 노드의 다음 = 추가할 노드
            totalLength++;//길이는 +1
        }
        totalTime += newNode.time;
    }

    void insert(Node newNode, int position) {
        if (position == 0) {//맨 앞에 삽입할 경우
            Node temp = head;//기존의 헤드노드를 temp 변수에 저장
            head = newNode;//헤드노드에는 새로 추가될 노드 지정
            head.next = temp;
        } else if (position >= totalLength) {//맨 뒤에 삽입할 경우(or 사이즈보다 큰 위치에 삽입명령이 올 경우)
            Node lastNode = getLastNode();//getLastNode 메서드를 통해 찾은 마지막 노드
            lastNode.next = newNode;//lastNode의 next에 새로 추가될 노드를 넣는다.
        } else {//중간에 삽입할 경우
            Node curNode = head;//기존의 헤드노드를 curNode 변수에 저장
            int count = 1;
            while (position != count++) {//position만큼 반복하여 삽입 위치까지 이동
                curNode = curNode.next;
            }
            Node temp = curNode.next;//temp 변수에 curNode.next 저장
            curNode.next = newNode;
            newNode.next = temp;//curNode - newNode - temp 형식으로 삽입
        }
        totalLength++;
        totalTime += newNode.time;
    }

    void delete(Node node) {
        if (head.id.equals(node.id)) {//헤드노드가 지울 노드일 경우
            head = head.next;//헤드노드의 next로 헤드를 넘겨주고
        } else {
            Node prevNode = head;//prevNode 변수에 head
            Node curNode = head.next;//curNode 변수에 head.next
            while (curNode != null) {//노드가 null이기 전까지 (=맨 끝까지)
                if (!curNode.id.equals(node.id)) {//curNode가 입력된 노드와 다르다면 다음노드로 이동
                    prevNode = curNode;
                    curNode = curNode.next;//prevNode - prevNode.next(=curNode) - curNode 세 개의 연결
                } else {//curNode와 입력된 노드가 같다면
                    prevNode.next = curNode.next;//이전노드의 next = 지울노드의 next로 연결
                    break;
                }
            }
        }
        totalLength--;//길이 -1
        totalTime -= node.time;
    }

    void render() {
        System.out.println("영상클립: " + totalLength + "개");
        System.out.println("전체길이: " + totalTime + "sec");
    }

    void print() {//출력형식
        Node curNode = head;
        System.out.print("|---");
        while (curNode != null) {//끝까지 반복
            System.out.print("[" + curNode.id + "," + curNode.time + "sec" + "]---");
            curNode = curNode.next;
        }
        System.out.println("[end]");
    }

    void printError() {
        System.out.println("node not found");
    }

    Node getLastNode() {
        Node curNode = head;//헤드노드를 찾고
        while (curNode.next != null) {//next가 비어있는 맨 끝 노드까지 진입
            curNode = curNode.next;
        }
        return curNode;//마지막 노드 리턴
    }
}
