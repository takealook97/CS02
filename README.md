🎯 CS02 영상 데이터구조
=

---

# LinkedList 개념

- ArrayList 와 함께 List를 만드는 두 가지 방법 중 하나.

- 'Linked' = 연결

- 데이터 구조에서 가장 중요한 부품은 '메모리' 이다.
  - 메모리를 효율적으로 사용하는 것이 중요한 역할이다.

- 메모리에서 주소가 가리키는 위치에 데이터가 저장된다.
  - 각각의 주소에 접근할 때 걸리는 시간이 **동일하다.** (Random Access Memory = RAM)

- 메모리를 사용하는 방식의 차이
  - ArrayList : 같은 element들이 메모리 상에 연속적으로 array형태로 붙어있다.
  - LinkedList : 각각의 element들이 흩어져 있으나 서로 **연결되어 있다**.

---

# LinkedList 구조

- **Node = Data field : Link field**

- field는 변수로 이해하면 된다. **Link field에 다음 노드가 무엇인가가 저장되어 있다.**

- C언어에서는 구조체를 이용하고 객체지향 언어에서는 객체를 이용해서 Node를 표현

- LinkedList를 이용하기 위해서는 첫 번째 노드가 무엇인지를 알 수 있어야 한다. (Head)

- **첫번째 노드**가 무엇인지 의미하는 정보를 **Head field**에 저장한다.

---

# 데이터 추가와 제거

## insert

### 첫번째에 추가

- 노드 안에 다음 노드를 의미하는 next라는 변수가 존재한다.
```java
Node temp = new Node(input);
temp.next = head;
head = temp;
```

### 중간에 추가

- 추가하고자 하는 element 앞뒤의 레퍼런스값을 찾아서 앞은 temp1 뒤는 temp2 라는 변수에 담는다.

- 앞 노드의 next를 새로운 노드에 연결, 새로운 노드의 next를 뒷 노드에 연결

```java
Node temp1 = head;
while (--k != 0){
    temp1 = temp1.next;}
Node temp2 = temp1.next;
Node newNode = new Node(input);
temp1.next = newNode;
newNode.next = temp2;
```

## delete

- 삭제를 하기 앞서 삭제할 노드의 앞의 next를 삭제할 노드의 뒤로 지정한다.

```java
Node cur = head;
while (--k != 0){
    cur = cur.next;}
Node tobedeleted = cur.next; //삭제하고자 하는 노드
cur.next = cur.next.next;
delete tobedeleted;
```
- ArrayList일 경우 삭제했을 시 생기는 단점

  - ArrayList였다면 삭제 후 빈자리 발생

  - 리스트에서는 빈자리를 허용하지 않기 때문에 삭제 한 뒤의 노드를 한 칸씩 모두 당겨주어야한다 (단점)

---

## List에서 데이터를 조회하는 방법(몇 번째 index의 존재하는 데이터를 확인하는 방법)

- LinkedList

  - Head를 통해서 첫번째 노드로 접근해서 값이 맞는지 확인 후 next, next...(확인) 반복하여 찾는다.(느리다)

  - 추가/삭제 (빠르다)
  
  - 포인터(참조값)로 각각의 노드가 연결되어 있기 때문에 메모리가 허용하는 한에서 노드를 무한정 확대 가능 (List의 크기가 확정적이지 않다)

- ArrayList

  - Array자체가 가지고 있는 index로 바로 직접 접근 (속도가 매우 빠르다)

  - 추가/삭제 (느리다)

  - 배열 구조를 사용하고 있기 때문에 Array가 가지고 있는 크기를 넘어가면 에러가 발생한다.

- 장단점을 조합해서 -> 필요에 따라 만들어보자

---

# Mission 1. 참조, 연속배열, 데이터구조
## Main 클래스
```java
public class Main {
    public static void main(String[] args) {
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
    }
}
```
- 제목 1~13을 titles 배열에 넣어준다.
- Node클래스의 newNode 참조변수를 생성하고 헤드노드는 비워둔다.
- 해시맵의 key에 생성된 아이디를, value에 새로운 노드를 넣는다.
- 반복문을 통해 node클래스의 print() 메서드의 형식대로 출력한다.

## Node 클래스
```java
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
```
- 필드 : title, id, time, next(다음노드)
- 메서드 : makeId, makeTime, print
- 생성자(매개변수 title, next)를 통해 title, makeId, makeTime, next (인스턴스 초기화)
- makeId 메서드
  - Random 객체 생성
  - 8자리의 무작위 알파벳을 StringBuilder를 통해 입력
  - idVerification(HashSet)에 저장되어 있지 않은 아이디라면 저장
  - idVerification(HashSet)에 저장된 아이디라면 다시 생성
- makeTime 메서드
  - Random 객체 생성
  - 1~15 사이의 랜덤 정수 리턴
- print 메서드
  - 리스트 형식대로 출력
---