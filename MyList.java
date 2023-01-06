public class MyList {

    Node head;//헤드노드

    int size;//영상길이

    int totalTime;//영상시간

    void add(Node newNode) {//add
        if (head == null) {//헤드노드가 비었을때
            head = newNode;
            size = 1;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
            size++;
        }
        totalTime += newNode.time;
    }

    void insert(Node newNode, int position) {//insert
        if(position == 0) {//삽입 위치가 맨 앞일 경우
            Node temp = head;
            head = newNode;
            head.next = temp;
        } else if(position >= size) {//삽입 위치가 사이즈 이상일 경우
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        else {//삽입 위치가 출력된 노드의 뒤일 경우
            Node curNode = head;
            int count = 1;
            while (position != count++) {
                curNode = curNode.next;
            }
            Node temp = curNode.next;
            curNode.next = newNode;
            newNode.next = temp;
        }
        totalTime += newNode.time;
        size++;
    }

    void delete(Node node) {//delete
        if(head.id.equals(node.id)) {//delete 할 노드가 존재할 경우
            head = head.next;
            totalTime -= node.time;
            size--;
            return;
        }
        Node prevNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if(curNode.id.equals(node.id)) {
                prevNode.next = curNode.next;
                size--;
                totalTime -= node.time;
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
    }

    void print() {//프로그램 출력 형식
        Node curNode = head;
        System.out.print("|---");
        while (curNode != null) {
            System.out.print("[" + curNode.id + "," + curNode.time + "sec" + "]---");
            curNode = curNode.next;
        }
        System.out.println("[end]");
    }

    void printError() {//없는 노드를 호출했을때
        System.out.println("node not found");
    }

    Node getLastNode() {//마지막 노드 값
        Node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        return curNode;
    }
}