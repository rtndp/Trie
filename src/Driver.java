/**
 * Created by rmangalvedhekar on 4/9/17.
 */
public class Driver {

    public static void main(String args[]) {
        System.out.println("Hello World!");

        Trie trie = new Trie();

        trie.insert("Word");

        trie.search("Word");
    }
}
