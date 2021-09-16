package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//push_front X: 정수 X를 덱의 앞에 넣는다.
//push_back X: 정수 X를 덱의 뒤에 넣는다.
//pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 덱에 들어있는 정수의 개수를 출력한다.
//empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = nextInt(br);
        Deque de = new Deque();
        while (cnt-- > 0) {
            String[] data = nextStringArr(br, " ");
            switch (data[0]) {
                case "push_front":
                    de.pushFront(data[1]);
                    break;
                case "push_back":
                    de.pushBack(data[1]);
                    break;
                case "pop_front":
                    pln(de.popFront());
                    break;
                case "pop_back":
                    pln(de.popBack());
                    break;
                case "size":
                    pln(de.size);
                    break;
                case "empty":
                    pln(de.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    pln(de.front());
                    break;
                case "back":
                    pln(de.back());
                    break;

            }

        }

    }

    public static int nextInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] nextIntArr(BufferedReader br, String token) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), token);
        int[] retVal = new int[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            retVal[i++] = Integer.parseInt(st.nextToken());
        }
        return retVal;
    }

    public static String[] nextStringArr(BufferedReader br, String token) throws IOException {
        return br.readLine().split(token);
    }

    public static void pln(Object o) {
        System.out.println(o);
    }

    static class Deque {
        public Node firstNode;
        public Node lastNode;
        public int size;

        public void pushFront(Object o) {
            if (size == 0) {
                Node node = new Node(null, null, o);
                this.firstNode = node;
                this.lastNode = node;
                size++;
            } else {
                Node node = new Node(null, this.firstNode, o);
                this.firstNode.pre = node;
                this.firstNode = node;
                size++;
            }

        }

        public void pushBack(Object o) {
            if (size == 0) {
                Node node = new Node(null, null, o);
                this.firstNode = node;
                this.lastNode = node;
                size++;
            } else {
                Node node = new Node(this.lastNode, null, o);
                this.lastNode.post = node;
                this.lastNode = node;
                size++;
            }
        }

        public Object popFront() {
            if (size == 0) {
                return -1;
            } else {
                Object retVal = this.firstNode.data;
                if (size == 1) {
                    this.firstNode = null;
                    this.lastNode = null;
                } else {
                    Node nextFront = this.firstNode.post;
                    nextFront.pre = null;
                    this.firstNode = nextFront;
                }
                size--;
                return retVal;
            }
        }

        public Object popBack() {
            if (size == 0) {
                return -1;
            } else {
                Object retVal = this.lastNode.data;
                if (size == 1) {
                    this.firstNode = null;
                    this.lastNode = null;
                } else {
                    Node nextBack = this.lastNode.pre;
                    nextBack.post = null;
                    this.lastNode = nextBack;
                }
                size--;
                return retVal;
            }
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        public Object front() {
            if (this.firstNode != null) {
                return firstNode.data;
            } else {
                return -1;
            }
        }

        public Object back() {
            if (this.lastNode != null) {
                return lastNode.data;
            } else {
                return -1;
            }
        }
    }
    static class Node {
        public Node pre;
        public Node post;
        public Object data;

        public Node(Node pre, Node post, Object data) {
            this.pre = pre;
            this.post = post;
            this.data = data;
        }

    }
}
