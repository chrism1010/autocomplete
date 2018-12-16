import junit.framework.TestCase;

/**
 * NodeTest class
 * @author chrismunoz
 * @version 2018.12.7
 */
public class NodeTest extends TestCase {
    /**
     * Fields
     */
    private Node n1;
    private Node n2;
    
    /**
     * Set up
     */
    public void setUp() {
        n1 = new Node("Test", 1);
        n2 = new Node();
    }
    
    /**
     * Test method
     */
    public void testGetTerm() {
        assertEquals("Test", n1.getTerm().getTerm());
        assertEquals(1, n1.getTerm().getWeight());
        n2.getTerm();
    }
    
    /**
     * Test method
     */
    public void testSetTerm() {
        n1.setTerm(new Term("Tester", 2));
        assertEquals("Tester", n1.getTerm().getTerm());
        assertEquals(2, n1.getTerm().getWeight());
    }
    
    /**
     * Test method
     */
    public void testGetWords() {
        assertEquals(0, n1.getWords());
    }
    
    /**
     * Test method
     */
    public void testSetWords() {
        n1.setWords(1);
        assertEquals(1, n1.getWords());
    }
    
    /**
     * Test method
     */
    public void testGetPrefixes() {
        assertEquals(0, n1.getPrefixes());
    }
    
    /**
     * Test method
     */
    public void testSetPrefixes() {
        n1.setPrefixes(1);
        assertEquals(1, n1.getPrefixes());
    }
    
    /**
     * Test method
     */
    public void testGetChildren() {
        assertNull(n1.getReferences()[0]);
    }
    
    /**
     * Test method
     */
    public void testSetChildren() {
        Node[] t = new Node[26];
        n1.setReferences(t);
        assertEquals(t, n1.getReferences());
    }
    
    
    
    
}
