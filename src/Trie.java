import java.util.HashMap;

class Node {
    Character c;
    HashMap<Character, Node> children = new HashMap<Character, Node>();
    boolean isLeaf;

    public Node() {

    }

    public Node(Character c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node{" +
            "c=" + c +
            ", children=" + children +
            ", isLeaf=" + isLeaf +
            '}';
    }
}

public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }


    public void insert(String word) {
        HashMap<Character, Node> children = root.children;

        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {

            Character c = arr[i];
            Node t;

            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new Node(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }

    }


    public boolean search(String word) {
        Node n = searchKey(word);


        if (n != null) {
            return true;
        } else
            return false;

    }


    private Node searchKey(String key) {
        HashMap<Character, Node> children = root.children;
        Node n = null;

        char[] arr = key.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (children.containsKey(c)) {
                n = children.get(c);
                children = n.children;
            } else {
                return null;
            }

        }

        if (n.isLeaf)
            return n;
        else
            return null;

    }


}
