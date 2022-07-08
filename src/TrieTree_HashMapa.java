import java.util.*;
public class TrieTree_HashMapa {
	
	private TrieNode root;
	int depth;
	
	 public TrieTree_HashMapa() {
	        root = new TrieNode();
	        depth = 0;
	    }
	 
	 public void AddString(String word) {
	        Map<Character, TrieNode> children = root.getChildren();
	        for(int i = 0; i < word.length(); i++) {
	            char c = word.charAt(i);
	            TrieNode node;
	            if(children.containsKey(c)) {
	                node = children.get(c);
	            } else { 
	                node = new TrieNode(c);
	                children.put(c, node);
	                depth++;
	            }
	            children = node.getChildren();

	            if(i == word.length() - 1) {
	                node.setLeaf(true);
	            }
	        }
	    }
	 
	 public void DeleteAll()
	 {
		 root = new TrieNode();
	 }
	 public boolean DelString(String word) {
		    return delete(root, word, 0);
		}

	 private boolean delete(TrieNode current, String word, int index) {
		    if (index == word.length()) {
		        if (!current.isLeaf()) {
		            return false;
		        }
		        current.setLeaf(false);
		        return current.getChildren().isEmpty();
		    }
		    char ch = word.charAt(index);
		    TrieNode node = current.getChildren().get(ch);
		    if (node == null) {
		        return false;
		    }
		    boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isLeaf();

		    if (shouldDeleteCurrentNode) {
		        current.getChildren().remove(ch);
		        return current.getChildren().isEmpty();
		    }
		    return false;
		}
	 public boolean isDefined(String word) {
	        Map<Character, TrieNode> children = root.getChildren();

	        TrieNode node = null;
	        for(int i = 0; i < word.length(); i++) {
	            char c = word.charAt(i);
	            if(children.containsKey(c)) {
	                node = children.get(c);
	                children = node.getChildren();
	            } else { 
	                node = null;
	                break;
	            }
	        }

	        if(node != null && node.isLeaf()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	 public ArrayList<String> createArray() {
	        // set up a recursion call.
	        ArrayList<String> result = new ArrayList<>();
	        char[] charstack = new char[depth];
	        getWords(root, charstack, 0, result);
	        return result;
	    }

	    private void getWords(TrieNode node, char[] charstack, int stackdepth, ArrayList<String> result) { 
	        if (node == null) {
	            return;
	        }
	        if (node.isLeaf()) {
	            result.add(new String(charstack, 0, stackdepth));
	        }
	        for (TrieNode kid : node.getChildNodes()) {
	            charstack[stackdepth] = kid.getC();
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
