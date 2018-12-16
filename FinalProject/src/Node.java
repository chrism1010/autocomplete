/**
 * Node class
 * @author chrismunoz
 * @version 2018.11.30
 */
public class Node {
    /**
     * Fields
     */
    private Term term;
    private int words;
    private int prefixes;
    private Node[] references = new Node[26];
    
    /**
     * Constructor no argument
     */
    public Node() {
        for (int i = 0; i < references.length; i++) {
            references[i] = null;
        }
        this.term = new Term("", 0);
        this.words = 0;
        this.prefixes = 0;        
    }
    
    /**
     * Constructor arguments
     * @param term string 
     * @param weight weight
     */
    public Node(String term, long weight) {
        for (int i = 0; i < references.length; i++) {
            references[i] = null;
        }
        this.term = new Term(term, weight);
        this.words = 0;
        this.prefixes = 0;
    }
    
    /**
     * @return term
     */
    public Term getTerm() {
        return term;
    }
    
    /**
     * @param term term
     */
    public void setTerm(Term term) {
        this.term = term;
    }
    
    /**
     * @return words
     */
    public int getWords() {
        return words;
    }
    
    /**
     * @param words words
     */
    public void setWords(int words) {
        this.words = words;
    }
    
    /**
     * @return prefixes
     */
    public int getPrefixes() {
        return prefixes;
    }
    
    /**
     * @param prefixes prefixes
     */
    public void setPrefixes(int prefixes) {
        this.prefixes = prefixes;
    }
    
    /**
     * @return references
     */
    public Node[] getReferences() {
        return references;
    }
    
    /**
     * @param references references
     */
    public void setReferences(Node[] references) {
        this.references = references;
    }

    
}
