๐ฏ CS02 ์์ ๋ฐ์ดํฐ๊ตฌ์กฐ
=

---

# LinkedList ๊ฐ๋

- ArrayList ์ ํจ๊ป List๋ฅผ ๋ง๋๋ ๋ ๊ฐ์ง ๋ฐฉ๋ฒ ์ค ํ๋.

- 'Linked' = ์ฐ๊ฒฐ

- ๋ฐ์ดํฐ ๊ตฌ์กฐ์์ ๊ฐ์ฅ ์ค์ํ ๋ถํ์ '๋ฉ๋ชจ๋ฆฌ' ์ด๋ค.
  - ๋ฉ๋ชจ๋ฆฌ๋ฅผ ํจ์จ์ ์ผ๋ก ์ฌ์ฉํ๋ ๊ฒ์ด ์ค์ํ ์ญํ ์ด๋ค.

- ๋ฉ๋ชจ๋ฆฌ์์ ์ฃผ์๊ฐ ๊ฐ๋ฆฌํค๋ ์์น์ ๋ฐ์ดํฐ๊ฐ ์ ์ฅ๋๋ค.
  - ๊ฐ๊ฐ์ ์ฃผ์์ ์ ๊ทผํ  ๋ ๊ฑธ๋ฆฌ๋ ์๊ฐ์ด **๋์ผํ๋ค.** (Random Access Memory = RAM)

- ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ฌ์ฉํ๋ ๋ฐฉ์์ ์ฐจ์ด
  - ArrayList : ๊ฐ์ element๋ค์ด ๋ฉ๋ชจ๋ฆฌ ์์ ์ฐ์์ ์ผ๋ก arrayํํ๋ก ๋ถ์ด์๋ค.
  - LinkedList : ๊ฐ๊ฐ์ element๋ค์ด ํฉ์ด์ ธ ์์ผ๋ ์๋ก **์ฐ๊ฒฐ๋์ด ์๋ค**.

---

# LinkedList ๊ตฌ์กฐ

- **Node = Data field : Link field**

- field๋ ๋ณ์๋ก ์ดํดํ๋ฉด ๋๋ค. **Link field์ ๋ค์ ๋ธ๋๊ฐ ๋ฌด์์ธ๊ฐ๊ฐ ์ ์ฅ๋์ด ์๋ค.**

- C์ธ์ด์์๋ ๊ตฌ์กฐ์ฒด๋ฅผ ์ด์ฉํ๊ณ  ๊ฐ์ฒด์งํฅ ์ธ์ด์์๋ ๊ฐ์ฒด๋ฅผ ์ด์ฉํด์ Node๋ฅผ ํํ

- LinkedList๋ฅผ ์ด์ฉํ๊ธฐ ์ํด์๋ ์ฒซ ๋ฒ์งธ ๋ธ๋๊ฐ ๋ฌด์์ธ์ง๋ฅผ ์ ์ ์์ด์ผ ํ๋ค. (Head)

- **์ฒซ๋ฒ์งธ ๋ธ๋**๊ฐ ๋ฌด์์ธ์ง ์๋ฏธํ๋ ์ ๋ณด๋ฅผ **Head field**์ ์ ์ฅํ๋ค.

---

# ๋ฐ์ดํฐ ์ถ๊ฐ์ ์ ๊ฑฐ

## insert

### ์ฒซ๋ฒ์งธ์ ์ถ๊ฐ

- ๋ธ๋ ์์ ๋ค์ ๋ธ๋๋ฅผ ์๋ฏธํ๋ next๋ผ๋ ๋ณ์๊ฐ ์กด์ฌํ๋ค.
```java
Node temp = new Node(input);
temp.next = head;
head = temp;
```

### ์ค๊ฐ์ ์ถ๊ฐ

- ์ถ๊ฐํ๊ณ ์ ํ๋ element ์๋ค์ ๋ ํผ๋ฐ์ค๊ฐ์ ์ฐพ์์ ์์ temp1 ๋ค๋ temp2 ๋ผ๋ ๋ณ์์ ๋ด๋๋ค.

- ์ ๋ธ๋์ next๋ฅผ ์๋ก์ด ๋ธ๋์ ์ฐ๊ฒฐ, ์๋ก์ด ๋ธ๋์ next๋ฅผ ๋ท ๋ธ๋์ ์ฐ๊ฒฐ

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

- ์ญ์ ๋ฅผ ํ๊ธฐ ์์ ์ญ์ ํ  ๋ธ๋์ ์์ next๋ฅผ ์ญ์ ํ  ๋ธ๋์ ๋ค๋ก ์ง์ ํ๋ค.

```java
Node cur = head;
while (--k != 0){
    cur = cur.next;}
Node tobedeleted = cur.next; //์ญ์ ํ๊ณ ์ ํ๋ ๋ธ๋
cur.next = cur.next.next;
delete tobedeleted;
```
- ArrayList์ผ ๊ฒฝ์ฐ ์ญ์ ํ์ ์ ์๊ธฐ๋ ๋จ์ 

  - ArrayList์๋ค๋ฉด ์ญ์  ํ ๋น์๋ฆฌ ๋ฐ์

  - ๋ฆฌ์คํธ์์๋ ๋น์๋ฆฌ๋ฅผ ํ์ฉํ์ง ์๊ธฐ ๋๋ฌธ์ ์ญ์  ํ ๋ค์ ๋ธ๋๋ฅผ ํ ์นธ์ฉ ๋ชจ๋ ๋น๊ฒจ์ฃผ์ด์ผํ๋ค (๋จ์ )

---

## List์์ ๋ฐ์ดํฐ๋ฅผ ์กฐํํ๋ ๋ฐฉ๋ฒ(๋ช ๋ฒ์งธ index์ ์กด์ฌํ๋ ๋ฐ์ดํฐ๋ฅผ ํ์ธํ๋ ๋ฐฉ๋ฒ)

- LinkedList

  - Head๋ฅผ ํตํด์ ์ฒซ๋ฒ์งธ ๋ธ๋๋ก ์ ๊ทผํด์ ๊ฐ์ด ๋ง๋์ง ํ์ธ ํ next, next...(ํ์ธ) ๋ฐ๋ณตํ์ฌ ์ฐพ๋๋ค.(๋๋ฆฌ๋ค)

  - ์ถ๊ฐ/์ญ์  (๋น ๋ฅด๋ค)
  
  - ํฌ์ธํฐ(์ฐธ์กฐ๊ฐ)๋ก ๊ฐ๊ฐ์ ๋ธ๋๊ฐ ์ฐ๊ฒฐ๋์ด ์๊ธฐ ๋๋ฌธ์ ๋ฉ๋ชจ๋ฆฌ๊ฐ ํ์ฉํ๋ ํ์์ ๋ธ๋๋ฅผ ๋ฌดํ์  ํ๋ ๊ฐ๋ฅ (List์ ํฌ๊ธฐ๊ฐ ํ์ ์ ์ด์ง ์๋ค)

- ArrayList

  - Array์์ฒด๊ฐ ๊ฐ์ง๊ณ  ์๋ index๋ก ๋ฐ๋ก ์ง์  ์ ๊ทผ (์๋๊ฐ ๋งค์ฐ ๋น ๋ฅด๋ค)

  - ์ถ๊ฐ/์ญ์  (๋๋ฆฌ๋ค)

  - ๋ฐฐ์ด ๊ตฌ์กฐ๋ฅผ ์ฌ์ฉํ๊ณ  ์๊ธฐ ๋๋ฌธ์ Array๊ฐ ๊ฐ์ง๊ณ  ์๋ ํฌ๊ธฐ๋ฅผ ๋์ด๊ฐ๋ฉด ์๋ฌ๊ฐ ๋ฐ์ํ๋ค.

- ์ฅ๋จ์ ์ ์กฐํฉํด์ -> ํ์์ ๋ฐ๋ผ ๋ง๋ค์ด๋ณด์

---

# Mission 1. ์ฐธ์กฐ, ์ฐ์๋ฐฐ์ด, ๋ฐ์ดํฐ๊ตฌ์กฐ
## Main ํด๋์ค
```java
public class Main {
  public static void main(String[] args) {
    String[] titles = {"์ ๋ชฉ01", "์ ๋ชฉ02", "์ ๋ชฉ03", "์ ๋ชฉ04", "์ ๋ชฉ05", "์ ๋ชฉ06",
            "์ ๋ชฉ07", "์ ๋ชฉ08", "์ ๋ชฉ09", "์ ๋ชฉ10", "์ ๋ชฉ11", "์ ๋ชฉ12", "์ ๋ชฉ13"};
    LinkedHashMap<String, Node> movieList = new LinkedHashMap<>();
    System.out.println("---์์ํด๋ฆฝ ์์ฑ---");
    for (int i = 0; i < 13; i++) {
      Node newNode = new Node(titles[i], null);
      movieList.put(newNode.id, newNode);
      newNode.print();
        }
    }
}
```
- ์ ๋ชฉ 1~13์ titles ๋ฐฐ์ด์ ๋ฃ์ด์ค๋ค.
- Nodeํด๋์ค์ newNode ์ฐธ์กฐ๋ณ์๋ฅผ ์์ฑํ๊ณ  ํค๋๋ธ๋๋ ๋น์๋๋ค.
- ํด์๋งต์ key์ ์์ฑ๋ ์์ด๋๋ฅผ, value์ ์๋ก์ด ๋ธ๋๋ฅผ ๋ฃ๋๋ค.
- ๋ฐ๋ณต๋ฌธ์ ํตํด nodeํด๋์ค์ print() ๋ฉ์๋์ ํ์๋๋ก ์ถ๋ ฅํ๋ค.

## Node ํด๋์ค
```java
public class Node {

  String title;
  String id;
  int time;
  Node next;
  static HashSet<String> idVerify = new HashSet<>();

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
    System.out.println(title + "(" + id + "):" + time + "์ด");
  }
}
```
- ํ๋ : title, id, time, next(๋ค์๋ธ๋)
- ๋ฉ์๋ : makeId, makeTime, print
- ์์ฑ์(๋งค๊ฐ๋ณ์ title, next)๋ฅผ ํตํด title, makeId, makeTime, next ์ธ์คํด์ค ์ด๊ธฐํ
- makeId ๋ฉ์๋
  - Random ๊ฐ์ฒด ์์ฑ
  - 8์๋ฆฌ์ ๋ฌด์์ ์ํ๋ฒณ์ StringBuilder๋ฅผ ํตํด ์๋ ฅ
  - Hashset์ ๋์ผํ key๊ฐ์ ๊ฐ์ง ์ ์๊ธฐ ๋๋ฌธ์ ์ค๋ณต์ ๊ฑฐ์ ์ ๋ฆฌํ๋ค.
  - idVerify(HashSet)์ ์ ์ฅ๋์ด ์์ง ์์ ์์ด๋๋ผ๋ฉด ์ ์ฅ
  - idVerify(HashSet)์ ์ ์ฅ๋ ์์ด๋๋ผ๋ฉด ๋ค์ ์์ฑ
- makeTime ๋ฉ์๋
  - Random ๊ฐ์ฒด ์์ฑ
  - 1~15 ์ฌ์ด์ ๋๋ค ์ ์ ๋ฆฌํด
- print ๋ฉ์๋
  - ๋ฆฌ์คํธ ํ์๋๋ก ์ถ๋ ฅ
---
# Mission 2. ๋ธ๋ ์ถ๊ฐ, ์ฐ๊ฒฐ๋ฆฌ์คํธ, ๋ธ๋ ํ์, ๋ธ๋ ์ญ์ 
## PrintedList ํด๋์ค
### ํ๋
```java
public class PrintedList {
    Node head;
    int totalLength;
    int totalTime;
```
- ํค๋ ๋ธ๋์ ์ด ๊ธธ์ด, ์ด ์๊ฐ ํ๋ ์์ฑ
- 
### getTailNode ๋ฉ์๋
```java
Node getTailNode() {
    Node curNode = head;
    while (curNode.next != null) {
        curNode = curNode.next;
    }
    return curNode;
}
```
- curNode ๋ณ์์ ํค๋๋ฅผ ์ง์ 
- curNode๋ฅผ next๋ก ์ง์ ํ๋ฉด์ next๊ฐ null์ผ๋๊น์ง ๋ฐ๋ณต(๋งจ ๋๊น์ง)
- ๋ฆฌํดํ curNode๋ ๋ง์ง๋ง ๋ธ๋๋ฅผ ๊ฐ๋ฆฌํค๊ฒ ๋๋ค.

### add ๋ฉ์๋
```java
    void add(Node addNode) {
        if (head == null) {
            head = addNode;
            totalLength = 1;
        } else {
            Node tailNode = getTailNode();
            tailNode.next = addNode;
            totalLength++;
        }
        totalTime += addNode.time;
    }
```
- ํค๋ ๋ธ๋๊ฐ ๋น์ด์์ ๊ฒฝ์ฐ์ ๋น์ด์์ง ์์ ๊ฒฝ์ฐ 2๊ฐ์ง ์กด์ฌ
- ๋น์ด์์ ๊ฒฝ์ฐ ํค๋๋ธ๋์ ์ถ๊ฐํ  ๋ธ๋๋ฅผ ์ง์ ํด์ค
- ๋น์ด์์ง ์์ ๊ฒฝ์ฐ getTailNode๋ฉ์๋๋ฅผ ํตํด ๊ตฌํ ๋ง์ง๋ง ๋ธ๋์ next์ ์ถ๊ฐํ  ๋ธ๋๋ฅผ ์ง์ ํด์ค๋ค.

### delete ๋ฉ์๋
```java
    void delete(Node delNode) {
        if (head.id.equals(delNode.id)) {
            head = head.next;
            totalLength--;
            totalTime -= node.time;
        } else {
            Node prevNode = head;
            Node curNode = head.next;
            while (curNode != null) {
                if (!curNode.id.equals(delNode.id)) {
                    prevNode = curNode;
                    curNode = curNode.next;
                } else {
                    prevNode.next = curNode.next;
                    totalLength--;
                    totalTime -= node.time;
                    break;
                }
            }
        }
        totalLength--;
        totalTime -= delNode.time;
    }
```
- ํค๋ ๋ธ๋๋ฅผ ์ญ์ ํ  ๊ฒฝ์ฐ์ ํค๋๋ธ๋๊ฐ ์๋ ๋ค๋ฅธ ๋ธ๋๋ฅผ ์ญ์ ํ  ๊ฒฝ์ฐ 2๊ฐ์ง ์กด์ฌ
- ํค๋ ๋ธ๋๋ฅผ ์ญ์ ํ  ๊ฒฝ์ฐ ํค๋๋ฅผ ํค๋์ next๋ก ๋๊ฒจ์ฃผ๊ธฐ๋ง ํ๋ฉด ๋๋ค.
- ๋ค๋ฅธ ๋ธ๋๋ฅผ ์ญ์ ํ  ๊ฒฝ์ฐ ๋ฐ๋ณต๋ฌธ์ ํตํด ์ญ์ ํ  ๋ธ๋๊น์ง ์ ๊ทผ์ ํ ๋ค prevNode.next๋ฅผ curNode.next๋ก ์ฐ๊ฒฐ
  - prevNode - curNode(prevNode.next) - curNode.next ๊ตฌ์กฐ์์ ์ค๊ฐ์ ์์ ๊ณ  prevNode์ curNode๋ฅผ ์ฐ๊ฒฐํ๋ ๊ตฌ์กฐ

### insert ๋ฉ์๋
```java    
    void insert(Node insNode, int position) {
        if (position == 0) {
            Node temp = head;
            head = insNode;
            head.next = temp;
        } else if (position >= totalLength) {
            Node tailNode = getTailNode();
            tailNode.next = insNode;
        } else {
            Node curNode = head;
            int count = 1;
            while (position != count) {
                curNode.next = curNode;
                count++;
            }
            Node temp = curNode.next;
            curNode.next = insNode;
            insNode.next = temp;
        }
        totalLength++;
        totalTime += insNode.time;
    }
```
- ๋งจ ์, ์ค๊ฐ, ๋งจ ๋ค์ ์ฝ์ ํ  ๊ฒฝ์ฐ 3๊ฐ์ง
- ๋งจ ์์ ์ฝ์ํ  ๊ฒฝ์ฐ ๊ธฐ์กด์ ํค๋๋ธ๋๋ฅผ temp ๋ณ์์ ์ ์ฅํ ๋ค, ํค๋ ๋ธ๋์ ์๋ก ์ถ๊ฐ๋  ๋ธ๋ ์ง์ 
- ํค๋์ next์ ๊ธฐ์กด์ ํค๋๋ธ๋์๋ temp๋ฅผ ์ฐ๊ฒฐํ๋ค.
- ๋งจ ๋ค์ ์ฝ์ํ  ๊ฒฝ์ฐ getTailNode ๋ฉ์๋๋ฅผ ํตํด ์ฐพ์ ๋ง์ง๋ง ๋ธ๋์ next์ ์ฝ์ํ  ๋ธ๋๋ฅผ ์ฐ๊ฒฐํ๋ค.
- ์ค๊ฐ์ ์ฝ์ํ  ๊ฒฝ์ฐ position ๋งํผ ๋ฐ๋ณตํ์ฌ ์ฝ์ ์์น๊น์ง ์ด๋ํ ๋ค
- temp ๋ณ์์ curNode.next๋ฅผ ์ ์ฅํด์ curNode - newNode - temp ๊ตฌ์กฐ๋ก ์ฝ์ํ๋ค.

### render ๋ฉ์๋
```java
    void render() {
        System.out.println("์์ํด๋ฆฝ: " + totalLength + "๊ฐ");
        System.out.println("์ ์ฒด๊ธธ์ด: " + totalTime + "sec");
    }
```

### print ๋ฉ์๋
```java
    void print() {//์ถ๋ ฅํ์
        Node curNode = head;
        System.out.print("|---");
        while (curNode != null) {
            System.out.print("[" + curNode.id + "," + curNode.time + "sec" + "]---");
            curNode = curNode.next;
        }
        System.out.println("[end]");
    }

    void error() {
        System.out.println("node not found");
    }
}
```

## Node ํด๋์ค ์ถ๊ฐ
```java
    public Node(String title, String id, int time, Node next) {
        this.title = title;
        this.id = id;
        this.time = time;
        this.next = next;
    }
    Node copy() {
        return new Node(title, id, time, null);
    }
```
- Mainํด๋์ค์ ํด์๋งต ์ฐธ์กฐ ์ 
  - ์ฐธ์กฐ์๋ฃํ์ ์ค์  ๋ฐ์ดํฐ ๊ฐ์ ํ ๋ฉ๋ชจ๋ฆฌ์ ์ ์ฅ
  - **์คํ๋ฉ๋ชจ๋ฆฌ์ ๋ณ์ ๊ณต๊ฐ์๋ ์ค์  ๋ณ์๊ฐ์ด ์ ์ฅ๋ ํ ๋ฉ๋ชจ๋ฆฌ์ ์์น๊ฐ์ ์ ์ฅํ๋ค.**
- ์ฆ, ์ํฅ์ ์ฃผ๊ธฐ ๋๋ฌธ์ copy๋ฉ์๋๋ฅผ ์ฌ์ฉํ๋ค.
- copy ๋ฉ์๋๋ฅผ ์ฌ์ฉํ๊ธฐ ์ํด ์๋ก์ด ์์ฑ์๋ฅผ ๋ง๋ ๋ค.

## Main ํด๋์ค ์ถ๊ฐ
### ๋ช๋ น์ด ์๋ ฅ ํ
```java
    PrintedList list = new PrintedList();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println();
    System.out.println("order : [add id], [delete id], [insert id position-number], [render], [close]");
    out:
    while (true) {
      System.out.print("> ");
      String order[] = br.readLine().split(" ");
```
- ๋ฒํผ ๋ฆฌ๋๋ก ์๋ ฅ -> ์คํ์ด์ค๋ฐ๋ฅผ ๊ธฐ์ค์ผ๋ก order๋ฐฐ์ด ์์ฑ

### switch ๊ตฌ๋ฌธ์ ํตํ case ๋ถ๋ฆฌ
### add
```java        
      switch (order[0]) {
        case "add":
          if (movieList.containsKey(order[1])) {
            list.add(movieList.get(order[1]).copy());
            list.print();
          } else {
            list.error();
          }
          break;
```
- ๋ฆฌ์คํธ(ํด์๋งต)์ ์๋ ํค๊ฐ์ด๋ฉด copy๋ฉ์๋๋ฅผ ํตํด ์ถ๊ฐ ํ ์ถ๋ ฅ
- ์๋ ๊ฒฝ์ฐ ์๋ฌ ์ถ๋ ฅ
### delete
```java
        case "delete":
          if (movieList.containsKey(order[1])) {
            int prevTotalLength = list.totalLength;
            list.delete(movieList.get(order[1]));
            if (prevTotalLength != list.totalLength) {
              list.print();
            } else {
              list.error();
            }
          } else {
            list.error();
          }
          break;
```
- ๋ฆฌ์คํธ(ํด์๋งต)์ ์๋ ํค๊ฐ์ด๋ฉด
  - ์ด ๊ธธ์ด์ ๋ณํ๊ฐ ์๋์ง์ ๋ฐ๋ผ ์ญ์  ํ ์ถ๋ ฅ or ์๋ฌ์ถ๋ ฅ
- ์๋ ๊ฒฝ์ฐ ์๋ฌ์ถ๋ ฅ
### insert
```java
        case "insert":
          if (movieList.containsKey(order[1])) {
            list.insert(movieList.get(order[1]).copy(), Integer.parseInt(order[2]));
            list.print();
          } else list.error();
          break;
```
- ๋ฆฌ์คํธ(ํด์๋งต)์ ์๋ ํค๊ฐ์ด๋ฉด copy๋ฉ์๋๋ฅผ ํตํด ์ฝ์ ํ ์ถ๋ ฅ
- ์๋ ๊ฒฝ์ฐ ์๋ฌ ์ถ๋ ฅ
### render & close & default 
```java
        case "render":
          list.render();
          break;
        case "close":
          System.out.println("---end---");
          break out;
        default:
          System.out.println("command is wrong");
      }
    }
  }
}

```
- render์ผ ๊ฒฝ์ฐ render ๋ฉ์๋์ ๋ฐ๋ผ ์์ํด๋ฆฝ๊ณผ ์ ์ฒด์๊ฐ ์ถ๋ ฅ
- close์ผ ๊ฒฝ์ฐ ๋ ์ด๋ธ์ breakํจ์ผ๋ก์จ ์ข๋ฃ
- default์ผ ๊ฒฝ์ฐ ์์ ๋์ดํ case๊ฐ ์๋ ์ ์ถ๋ ฅ