import java.util.*;
public class TrieNode {
    private char c;
    private Map<Character, TrieNode> children = new TreeMap<>();
    private boolean isLeaf;

    public TrieNode() {
}

    public TrieNode(char c){
        this.c = c;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    
    public boolean isEmpty(TrieNode node)
    {
    	return children.isEmpty();
    }

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
	public TrieNode[] getChildNodes() {
        if (children == null) {
            return null;
        }
        TrieNode[] result = children.values().toArray(new TrieNode[children.size()]);
        return result;
    }
    
}