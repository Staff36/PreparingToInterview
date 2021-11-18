package linkedlists;

public class LinkedNodes {

    public Node<Integer> prepareNodes() {
        Node<Integer> previousNode = null;
        Node<Integer> firstNode = null;
        for (int i = 0; i < 10; i++) {
            Node<Integer> currentNode = new Node<>(i);
            if (previousNode != null) {
                previousNode.setNext(currentNode);
            } else {
                firstNode = currentNode;
            }
            previousNode = currentNode;
        }
        return firstNode;
    }

    public void loopNodes(Node node) {
        Node first = node;
        while (node.hasNext()) {
            node = node.getNext();
        }
        node.setNext(first);
    }

    public boolean isLoopedNodes(Node firstNode) {
        Node checkedNode = new Node(null);
        while (firstNode.hasNext()) {
            if (firstNode.getNext() == checkedNode) {
                return true;
            }
            Node tempNode = firstNode;
            firstNode = firstNode.getNext();
            tempNode.setNext(checkedNode);
        }
        return false;
    }

    public Node reverseList(Node currentNode) {
        Node nextNode;
        Node previousNode = null;
        while (currentNode.hasNext()) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        currentNode.setNext(previousNode);
        return currentNode;
    }

    public void displayList(Node node) {
        while (node != null){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
