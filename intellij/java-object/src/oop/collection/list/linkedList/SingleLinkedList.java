package oop.collection.list.linkedList;

public class SingleLinkedList<T> {
    // 시작점을 넣을 수 있는 head 필드값을 만들어 줍니다
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    } // Node<T>

    public void addNode(T data) {
        // 만약에 시작점(head)이 없으면 새로운 시작점(head) 를 만들고
        if (head == null) {
            head = new Node<T>(data);
            // 시작점이 이미 있으면
        } else {
            // 현재위치를 시작점으로 포인트를 하시고
            Node<T> node = this.head;
            // 노드의 끝으로 내 위치를 바꾼다음에 (LinkedList 의 끝은 항상 Null 값 입니다)
            while (node.next != null) {
                node = node.next;
            }
            // 끝 노드의 다음 자리에 새로운 노드를 추가해 줍니다
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        // 만약에 시작점(head)이 없으면
        if (head != null) {
            // 시작점을 node 에 넣어주고
            Node<T> node = this.head;
            // 값을 출력
            System.out.println(node.data);
            // 노드의 끝(null)이 아니라면
            while (node.next != null) {
                // 내 위치를 다음으로 바꾼 후에
                node = node.next;
                // 그 값을 출력
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        // 만약에 시작점(head)이 없으면 return null. 찾을게 없으니 null 값으로 돌아옵니다
        if (this.head == null) {
            return null;
        } else {
            // 시작점을 node 에 넣어주시고
            Node<T> node = this.head;
            // node가 끝까지 갈때까지 돌리고 .length 개념
            while(node != null) {
                // 만약 내가 있는 위치의 data 가 유저가 찾고싶은 data 일 경우 return
                if (node.data == data) {
                    return node;
                    // 그 데이터가 아니라면 다음노드로 이동
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    /**
     * 1,2,3 에 5를 1과 2 사이에 넣고 싶습니다
     * [1 | next] - [2 | next] - [3 | next] - [ | null]
     *
     * [1 | next] - [5 | next] - [2 | next] - [3 | next] - [ | null]
     * @param data
     * @param isData
     */
    public void addNodeInside(T data, T isData) {
        // 내가 찾고자 하는 값의 위치를 찾고
        Node<T> searchedNode = this.search(isData);
        // 못찾았다면 그냥 addNode 로 넣고 --> 데이터가 있으면 맨 뒤에 아니라면 그냥 바로 그 위치에(맨앞)
        if (searchedNode == null) {
            this.addNode(data);
            // 찾았다면
        } else {
            // 찾은 노드의 위치의 다음 위치를 nextNode 에 넣습니다
            Node<T> nextNode = searchedNode.next;
            // 그럼 그 다음위치에 있는 나(head)는 유저가 넣고 싶어하는 새로운 data 값을 할당해주고
            searchedNode.next = new Node<T>(data);
            // 그 다다음위치에 위에서 찾은 nextNode 를 넣어줍니다 (1과 2 중간에 5를 삽입을 해야되기 때문에 2를 밀어주는 작업)
            searchedNode.next.next = nextNode;
        }
    }

    /**
     * 지우고자 하는 찾이 3 입니다!
     *
     * [1 | next] - [2 | next] - [3 | next] - [ | null]
     *
     * 내 시작점[1]의 다음 노드의 값이 존재하다면(null 값이 아니라면) 다음 노드의 값[2]이 유저가 찾는 값[3]인지 확인을 해주고
     * 아니라면 다음 노드[2]로 위치를 바꾸고 또 그 위치에서 다음의 노드[3]의 데이터랑 유저가 찾는 데이터[3]를 비교하고
     * 찾았을 경우 return true 못찾았을 경우 return false
     * @param isData
     * @return 찾으면 true/ 못찾으면 false
     */
    public boolean delNode(T isData) {
        // 만약에 시작점(head)이 없다면 return false;
        if (this.head == null) {
            return false;
            // 있다면
        } else {
            // 내 위치를 지금 head 로 해주고
            Node<T> node = this.head;
            // 지금 내가 있는 노드의 data 가 찾는 데이터면
            if (node.data == isData) {
                // 지금 위치의 노드를 다음 노드로 덮어 씌워줍니다
                this.head = this.head.next;
                return true;
                // 내가 지금 있는 위치의 값이 유저가 찾는 값이 아니라면
            } else {
                // node 의 끝까지(내 위치의 다음 노드가 null 이 아닐때까지) while 문을 돌면서 찾아줍니다
                while (node.next != null) {
                    // 내 노드의 다음 값이 유저가 찾는 데이터라면
                    if (node.next.data == isData) {
                        // 내 다음 값을 다다음 값으로 덮어 씌워줍니다
                        node.next = node.next.next;
                        return true;
                    }
                    // 그리고 내 위치를 다음으로 옮깁니다
                    node = node.next;
                }
                // 끝까지 다 돌았는데 못찾았으면 return false 를 합니다.
                return false;
            }
        }
    }

}// class
