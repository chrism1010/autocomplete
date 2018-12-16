import java.util.ArrayList;
import java.util.List;

/**
 * Autocomplete class
 * @author chrismunoz
 * @version 2018.11.29
 */
public class Autocomplete {
    /**
     * Fields
     */
    private Node root;
    
    /**
     * Constructor no arguments
     */
    public Autocomplete() {
        root = new Node("", 0);
    }
    
    /**
     * Big O - O(N)
     * @param word word
     * @param weight weight
     */
    public void addWord(String word, long weight) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int childIndex = c - 97;
            if (childIndex < 0 || childIndex > 25) {
                return;
            }
        }
        addWord(word, weight, root, 0, root.getReferences());
    }
    
    /**
     * @param word word
     * @param weight weight
     * @param n root
     * @param index index of word
     * @param children node array of n
     */
    private void addWord(String word, long weight, Node n, 
            int index, Node[] children) {    
        if (index == word.length()) {
            return;
        }
        boolean newVertex = false;
        char c = word.charAt(index);
        int childIndex = c - 97;
        
        if (children[childIndex] == null) {
            newVertex = true;
        }  
        
        if (newVertex) {
            if (index == word.length() - 1) {
                Node child = new Node(word, weight);
                child.setWords(child.getWords() + 1);
                child.setPrefixes(child.getPrefixes() + 1);
                children[childIndex] = child;
                addWord(word, weight, child, index + 1, child.getReferences());
            } 
            else {
                Node child = new Node();
                children[childIndex] = child;
                child.setPrefixes(child.getPrefixes() + 1);
                //System.out.print(childIndex + ", ");
                addWord(word, weight, child, index + 1, child.getReferences());
            }
            
        } 
        else {
            Node child = children[childIndex];
            child.setPrefixes(child.getPrefixes() + 1);
            //System.out.print("path(" + childIndex + "), ");
            addWord(word, weight, child, index + 1, child.getReferences());
        }

    }
    
    /**
     * Big O - O(N)
     * @param prefix prefix
     * @return root of sub trie
     */
    public Node getSubTrie(String prefix) {
        return getSubTrie(prefix, 0, root, root.getReferences());
        
    }
    
    /**
     * @param prefix prefix
     * @param index index
     * @param n root
     * @param children children of n
     * @return root of sub trie
     */
    private Node getSubTrie(String prefix, int index, Node n, Node[] children) {
        if (index == prefix.length()) {
            return n;
        } 
        char c = prefix.charAt(index);
        int childIndex = c - 97;
        if (childIndex < 0 || childIndex > 25) {
            return null;
        }
        if (children[childIndex] == null) {
            return null;
        }
        //System.out.print(n.getTerm().getQuery() + ", ");
        return getSubTrie(prefix, index + 1, children[childIndex],
                children[childIndex].getReferences());
        
    }
    
    /**
     *  @param prefix prefix 
     *  @return number of words that follow prefix
     */
    public int countPrefixes(String prefix) {
        if (this.getSubTrie(prefix) == null) {
            return 0;
        }
        return countPrefixes(prefix, this.getSubTrie(prefix),
                this.getSubTrie(prefix).getReferences());
    }
    
    /**
     * @param prefix prefix
     * @param n root
     * @param children children of n
     * @return number of words that follow prefix
     */
    private int countPrefixes(String prefix, Node n, Node[] children) {
        int total = 0;
        total += n.getWords();
        for (int i = 0; i < children.length; i++) {   
            if (children[i] != null) {
                total += countPrefixes(prefix, children[i], 
                        children[i].getReferences()); 
            }
        }
        return total;
    }
   
    /**
     * Big O - O(N^2 * Log base 26 (N))
     * @param prefix 
     * @return list of terms
     */
    public List<Term> getSuggestions(String prefix) {
        ArrayList<Term> terms = new ArrayList<Term>();
        ArrayList<Term> empty = new ArrayList<Term>();
        if (this.getSubTrie(prefix) == null) {
            //terms.clear();
            return empty;
        }
        return getSuggestions(prefix, this.getSubTrie(prefix),
                this.getSubTrie(prefix).getReferences(), terms);
    }
    
    /**
     * @param prefix prefix
     * @param n root
     * @param children children of n
     * @param list list
     * @return list of terms
     */
    private List<Term> getSuggestions(String prefix, Node n, 
            Node[] children, ArrayList<Term> list) {
        
        for (int i = 0; i < children.length; i++) {   
            if (children[i] != null) {
                for (int j = 0; j < children[i].getWords(); j++) { 
                    //System.out.print(children[i].getTerm().getQuery() + ", ");
                    list.add(children[i].getTerm());
                }
                getSuggestions(prefix, children[i], 
                        children[i].getReferences(), list);   
            } 
        }   
        return list; 
    }
}
