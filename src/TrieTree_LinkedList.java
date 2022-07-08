import java.util.ArrayList;

public class TrieTree_LinkedList {

    private TrieNode_LinkedList root;
    private int depth=0;
    public TrieTree_LinkedList() {
        root = new TrieNode_LinkedList(' ');
    }
    
    public void AddString(String word) {
        TrieNode_LinkedList current = root;
        for (char ch : word.toCharArray()) {
        	TrieNode_LinkedList child = current.checkNode(ch); 
            if (child != null) {
                current = child;
            } else {
                current.getChildList().add(new TrieNode_LinkedList(ch));
                current = current.checkNode(ch);
                depth++;
            }
            current.setCount(current.getCount()+1);
        }
        current.setLeaf(true);
    }
 
    public boolean isDefined(String word) {
    	TrieNode_LinkedList current = root;
        for (char ch : word.toCharArray()) {
            if (current.checkNode(ch) == null) {
                return false;
            } else {
                current = current.checkNode(ch);
            }
        }
        if (current.isLeaf() == true) {
            return true;
        }
        return false;
    }


    public boolean remove(String word) {
        if (isDefined(word) == false) {
            return false;
        }
        TrieNode_LinkedList current = root;
        for (char ch : word.toCharArray()) {
        	TrieNode_LinkedList child = current.checkNode(ch);
            if (child.getCount() == 1) {
                current.getChildList().remove(child); 
                return true;
            } else {
            	child.setCount(current.getCount()-1);
                current = child;
            }
        }
        current.setLeaf(false);
        return true;
    }

    public ArrayList<String> createArray() {
        // set up a recursion call.
        ArrayList<String> result = new ArrayList<>();
        char[] charstack = new char[depth];
        getWords(root, charstack, 0, result);
        return result;
    }

    private void getWords(TrieNode_LinkedList node, char[] charstack, int stackdepth, ArrayList<String> result) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            result.add(new String(charstack, 0, stackdepth));
        }
        for (TrieNode_LinkedList kid : node.getChildNodes()) {
            charstack[stackdepth] = kid.getSign();
            getWords(kid, charstack, stackdepth + 1, result);
        }
    }
    
    public String[] Trie2Array()
    {
    	 ArrayList<String> result = createArray();
    	 String[] array = new String[result.size()];
    	 array = result.toArray(array);
    	 return array;
    }
}