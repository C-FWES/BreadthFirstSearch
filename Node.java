package Tree;

public class Node {
    private int value = 0;
    private int frequency = 0;
    private Node left = null;
    private Node right = null;

    public Node(int v) {// constructor
        value = v;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }



}


