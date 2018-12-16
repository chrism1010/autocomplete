import java.util.Comparator;

/**
 * Term class
 * @author chrismunoz
 * @version 2018.11.29
 */
public class Term implements Comparable<Term> {
    /**
     * Fields
     */
    private String term;
    private long weight;
    
    /**
     * Constructor
     * @param term term 
     * @param weight weight
     */
    public Term(String term, long weight) {
        if (term == null || weight < 0) {
            throw new IllegalArgumentException("***");
        }
        this.term = term;
        this.weight = weight;
    }
    
    /**
     * Compares the two terms in descending order by weight.
     * @return < 0 or > 0 or 0
     */
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                return (int) ((o1.weight - o2.weight) * -1);
                
            }
        };
        
    }
    
    /**
     * Compares the two terms in lexicographic order 
     * but using only the first r characters of each term.
     * @param r first r characters
     * @return < 0 or > 0 or 0
     */
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("***");
        }
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                String a = o1.term.substring(0, r);
                String b = o2.term.substring(0, r);
                return a.compareTo(b);
            }
        };
        
    }
    
    @Override
    public int compareTo(Term that) {
        if (this.term.length() > that.term.length()) {
            for (int i = 0; i < that.term.length(); i++) {
                if (term.charAt(i) 
                        - that.term.charAt(i) != 0) {
                    return term.charAt(i) - that.term.charAt(i);
                }
            }
        }
        else if (this.term.length() < that.term.length()) {
            for (int i = 0; i < term.length(); i++) {
                if (term.charAt(i) 
                        - that.term.charAt(i) != 0) {
                    return term.charAt(i) - that.term.charAt(i);
                }
            }
        } 
        else {
            for (int i = 0; i < that.term.length(); i++) {
                if (term.charAt(i) 
                        - that.term.charAt(i) != 0) {
                    return term.charAt(i) - that.term.charAt(i);
                }
            }
        }
        if (term.length() > that.term.length()) {
            return term.length() - that.term.length();
        }
        else if (term.length() < that.term.length()) {
            return term.length() - that.term.length();
        }
        return 0;
    }
    
    /**
     * Returns a string representation of this term 
     * in the following format:
     * the weight, followed by a tab character, 
     * followed by the term (no space).
     * @return weight, tab, term
     */
    public String toString() {
        return this.weight + "\t" + this.term;
        
    }
    
    /**
     * Get term
     * @return term
     */
    public String getTerm() {
        return term;
    }
    
    /**
     * Set term
     * @param term term
     */
    public void setTerm(String term) {
        this.term = term;
    }
    
    /**
     * Get weight
     * @return weight
     */
    public long getWeight() {
        return weight;
    }
    
    /**
     * Set weight
     * @param weight weight
     */
    public void setWeight(long weight) {
        this.weight = weight;
    }

}
