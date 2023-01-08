public class PrintedList {
    Node head;
    int totalLength;
    int totalTime;

    void add(Node newNode) {
        if (head == null) {//아무 것도 없는 상태일때
            head = newNode;//추가될 노드가 앞으로의 헤드 노드
            totalLength = 1;//길이는 1로 저장
        } else {//다른 노드가 있는 상태일 때 마지막에 추가해야한다
            Node tailNode = getTailNode();//getTailNode 메서드를 통해 찾은 마지막 노드
            tailNode.next = newNode;//마지막 노드의 다음 = 추가할 노드
            totalLength++;//길이는 +1
        }
        totalTime += newNode.time;
    }

    void delete(Node node) {
        if (head.id.equals(node.id)) {//헤드노드가 지울 노드일 경우
            head = head.next;//헤드노드의 next로 헤드를 넘겨준다
        } else {//헤드노드가 아닌 다른 노드가 지울 노드일 경우
            Node prevNode = head;//prevNode 변수에 head 저장
            Node curNode = head.next;//curNode 변수에 head.next 저장
            while (curNode != null) {//노드가 null이기 전까지 (=맨 끝까지)
                if (!curNode.id.equals(node.id)) {//curNode가 입력된 노드와 다르다면 다음노드로 이동
                    prevNode = curNode;//prev, cur 둘 다 한 칸씩 이동
                    curNode = curNode.next;//prevNode - prevNode.next(=curNode) - curNode.next 세 개의 연결구조
                } else {//curNode와 입력된 노드가 같다면
                    prevNode.next = curNode.next;//이전노드의 next = 지울노드의 next로 연결
                    totalLength--;
                    totalTime -= node.time;
                    break;
                }
            }
        }
    }

    void insert(Node newNode, int position) {//처음,중간,끝 세 경우로 나누기
        if (position == 0) {//맨 앞에 삽입할 경우
            Node temp = head;//기존의 헤드노드를 temp 변수에 저장
            head = newNode;//헤드노드에는 새로 추가될 노드 지정
            head.next = temp;//헤드의 next에 기존의 헤드노드였던 temp 연결
        } else if (position >= totalLength) {//맨 뒤에 삽입할 경우(or 사이즈보다 큰 위치에 삽입명령이 올 경우)
            Node tailNode = getTailNode();//getTailNode 메서드를 통해 찾은 마지막 노드
            tailNode.next = newNode;
        } else {//중간에 삽입할 경우
            Node curNode = head;
            int count = 1;
            while (position != count) {//position만큼 반복하여 삽입 위치까지 이동
                curNode.next = curNode;
                count++;
            }
            Node temp = curNode.next;//temp 변수에 curNode.next 저장
            curNode.next = newNode;
            newNode.next = temp;//curNode - newNode - temp 형식으로 삽입
        }
        totalLength++;
        totalTime += newNode.time;
    }

    void render() {
        System.out.println("영상클립: " + totalLength + "개");
        System.out.println("전체길이: " + totalTime + "sec");
    }

    Node getTailNode() {
        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        return curNode;
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

    void error() {
        System.out.println("node not found");
    }
}
