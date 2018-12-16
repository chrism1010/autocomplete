import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * AutoCompleteTest class
 * @author chrismunoz
 * @version 2018.12.1
 */
public class AutoCompleteTest extends TestCase {
    /**
     * Fields
     */
    private Autocomplete a1;
    private Autocomplete a2;
    
    /**
     * Set up
     */
    public void setUp() {
        a1 = new Autocomplete(); 
        a2 = new Autocomplete();
        a1.addWord("test", 3);
        a1.addWord("testing", 6);
        a1.addWord("cat", 3);
        a1.addWord("cop", 3);
        a1.addWord("cattle", 6);
        a1.addWord("apple", 5);
        a1.addWord("ape", 3);
    }
    /**
     * Test method
     */
    public void testGetSubTrie() {
        assertEquals(a1.getSubTrie("te").getTerm().getTerm(), "");
        assertEquals(a1.getSubTrie("cat").getTerm().getTerm(), "cat");
        assertNull(a1.getSubTrie("cate"));
        assertNull(a1.getSubTrie("A"));
        assertNull(a1.getSubTrie("c~"));
        assertEquals(a1.getSubTrie("").getTerm().getTerm(), "");
    }
    
    /**
     * Test method
     */
    public void testCountPrefixes() {
        assertEquals(2, a1.countPrefixes("t"));
        assertEquals(2, a1.countPrefixes("te"));
        assertEquals(2, a1.countPrefixes("tes"));
        assertEquals(2, a1.countPrefixes("test"));
        assertEquals(1, a1.countPrefixes("testi"));
        assertEquals(1, a1.countPrefixes("testing"));
        assertEquals(7, a1.countPrefixes(""));
        assertEquals(0, a1.countPrefixes("~"));
        assertEquals(0, a1.countPrefixes("ABC"));
        assertEquals(0, a1.countPrefixes("testti"));
        //assertEquals(0, a1.countPrefixes(""));
    }
    
    /**
     * Test method
     */
    public void testGetSuggestions() {
        assertEquals(2, a1.getSuggestions("t").size());
        assertEquals(7, a1.getSuggestions("").size());    
        assertEquals(1, a1.getSuggestions("co").size()); 
        ArrayList<Term> empty = new ArrayList<Term>();
        assertEquals(empty.toString(), a1.getSuggestions("cate").toString());
        assertEquals(empty.toString(), a1.getSuggestions("c~").toString());
        assertEquals(empty.toString(), a1.getSuggestions("A").toString());
        
    }
    
    /**
     * Test method
     */
    public void testGetPrefixes() {
        assertEquals(3, a1.getSubTrie("c").getPrefixes());
        assertEquals(2, a1.getSubTrie("tes").getPrefixes());
        assertEquals(1, a1.getSubTrie("testi").getPrefixes());
        assertEquals(2, a1.getSubTrie("test").getPrefixes());
        
    }
    
    /**
     * Test method
     */
    public void testAddWord() {
        a2.addWord("test", 11);
        a2.addWord("ABC", 0);
        a2.addWord("~~~", 0);
        assertNull(a2.getSubTrie("~"));
        
    }
}
