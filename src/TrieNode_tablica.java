public class TrieNode_tablica {
	private final int size = 45;
	private int index;
	private boolean isLeaf;
    private TrieNode_tablica children[] = new TrieNode_tablica[size];
    public TrieNode_tablica()
    {

        for (int i = 0; i < size; i++)
            children[i] = null;
        index = -1;
        isLeaf = false;
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public TrieNode_tablica[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode_tablica[] children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty()
	{
		for(int i=0; i<size; i++)
		{
			if(children[i] != null)
				return false;
		}
		return true;
	}
    
	public void remove(int tmp)
	{
		children[tmp] = null;
	}
	
	public char getC(int i)
	{
		return decode_index(i);
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

}
