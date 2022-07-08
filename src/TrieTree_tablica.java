public class TrieTree_tablica {
	
	private TrieNode_tablica root;
	int ind = 0;
	int depth;
	 public TrieTree_tablica() {
	        root = new TrieNode_tablica();
	        depth=0;
	    }
	 	 
	 public int getDepth() {
		return depth;
	}
	public TrieNode_tablica getRoot() {
		return root;
	 }

	public void AddString(String word) {
		    TrieNode_tablica node = root;
		        
		    for (char c : word.toCharArray()) {
		    	int tmp = code_index(c);
		        if (node.getChildren()[tmp] == null) {
		            node.getChildren()[tmp] = new TrieNode_tablica();
		            depth++;
		        }
		        node = node.getChildren()[tmp];
		    }
		    node.setLeaf(true);
		}
	public boolean isDefined(String key)
    {
        TrieNode_tablica node = root;
 
        for (int i = 0; i < key.length(); i++) {
            int index = code_index(key.charAt(i));
            if (node.getChildren()[index] == null)
                return false;
 
            node = node.getChildren()[index];
        }
 
        return (node != null && node.isLeaf());
    }
	
	public TrieNode_tablica remove(TrieNode_tablica node, String key, int depth)
    {
        if (root == null)
            return null;
        if (depth == key.length()) {
            if (node.isLeaf())
                node.setLeaf(false);
            if (node.isEmpty()) {
                node = null;;
            }
            return node;
        }
        int index = code_index(key.charAt(depth));
        node.getChildren()[index] =remove(node.getChildren()[index], key, depth + 1);
        if (node.isEmpty() && node.isLeaf() == false){
            node = null;
        }
        return node;
    }
	
	public boolean DelString(String word) {
	    TrieNode_tablica node = remove(root, word, 0);
	    if(node == null)
	    {
	    	return true;
	    }
	    else
	    	return false;
	}
	 
	    
	    public int code_index(char c)
	    {
	    	if(c>='a' && c <='z')
	    		return c - 'a';
	    	else if(c >= '0' && c<='9')
	    		return c - 22;
	    	switch(c)
	    		{
	    		case '¹':
	    			return 36;
	    		case 'ê':
	    			return 37;
	    		case 'ó':
	    			return 38;
	    		case 'æ':
	    			return 39;
	    		case '³':
	    			return 40;
	    		case 'ñ':
	    			return 41;
	    		case 'œ':
	    			return 42;
	    		case '¿':
	    			return 43;
	    		case 'Ÿ':
	    			return 44;
	    		case '_':
	    			return 45;
	    		}
	    	return 0;
	    }
	    
	    public char decode_index(int c)
	    {
	    	if(c>=0 && c <=25)
	    		return (char)(c + 'a');
	    	else if(c >= 26 && c<=35)
	    		return (char)(c + 22);
	    	switch(c)
	    		{
	    		case 36:
	    			return '¹';
	    		case 37:
	    			return 'ê';
	    		case 38:
	    			return 'ó';
	    		case 39:
	    			return 'æ';
	    		case 40:
	    			return '³';
	    		case 41:
	    			return 'ñ';
	    		case 42:
	    			return 'œ';
	    		case 43:
	    			return '¿';
	    		case 44:
	    			return 'Ÿ';
	    		case 45:
	    			return '_';
	    		}
	    	return 0;
	    
	    }
	    /*public String[] Trie2Array()
	    {
	    	 String [] StringArray;
	    	 String word = "";
	    	 word = createWord(root, word);
	    	 StringArray = word.split("\\s+");
	    	 return StringArray;
	    }
	    
	    private String createWord(TrieNode_tablica node, String word)
	    {
	    	if(node.isEmpty() == false)
	    	{
	    		String tmp = "";
	    		for(int i=0; i<node.getChildren().length; i++)
	    		{
	    			if(node.getChildren()[i] != null)
	    				tmp +=createWord(node.getChildren()[i], word+node.getC(i)) + " ";
	    		}
	    		word = tmp;
	    	}
	    	return word;
	    }*/
}
