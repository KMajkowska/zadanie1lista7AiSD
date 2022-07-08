import java.util.*;
public class TrieNode_LinkedList {

    
	private char sign;
    private boolean isLeaf;
    private int count;
    private LinkedList<TrieNode_LinkedList> childList;
    public TrieNode_LinkedList(char c) {
        childList = new LinkedList<>();
        isLeaf = false;
        sign = c;
        count = 0;
    }

    public TrieNode_LinkedList checkNode(char c) {
        if (childList != null) {
            for (TrieNode_LinkedList eachChild : childList) {
                if (eachChild.getSign() == c) {
                    return eachChild;
                }
            }
        }
        return null;
    }

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf =isLeaf;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LinkedList<TrieNode_LinkedList> getChildList() {
		return childList;
	}

	public void setChildList(LinkedList<TrieNode_LinkedList> childList) {
		this.childList = childList;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}
	
	public TrieNode_LinkedList[] getChildNodes() {
        if (childList == null) {
            return null;
        }
        TrieNode_LinkedList[] result = getChildList().toArray(new TrieNode_LinkedList[childList.size()]);
        return result;
    }
	

}