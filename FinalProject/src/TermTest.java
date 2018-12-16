import junit.framework.TestCase;

/**
 * TermTest class
 * @author chrismunoz
 * @version 2018.12.7
 */
public class TermTest extends TestCase {
    /**
     * Fields
     */
    private Term t1;
    private Term t2;
    private Term t3;
    private Term t4;
    private Term t5;
    
    /**
     * Set up
     */
    public void setUp() {
        t1 = new Term("apple", 1);
        t2 = new Term("applepie", 2);
        t3 = new Term("cake", 3);
        t4 = new Term("dairy", 4);
        t5 = new Term("apple", 1);
    }
    
    /**
     * Test constructor
     */
    public void testTerm() {
        Exception thrown = null;
        try
        {
            new Term("", -1);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        Exception thrown1 = null;
        try
        {
            new Term(null, 1);
        }
        catch (Exception exception)
        {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof IllegalArgumentException);
        
        Exception thrown2 = null;
        try
        {
            new Term(null, -1);
        }
        catch (Exception exception)
        {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IllegalArgumentException);
    }
    
    /**
     * Test method
     */
    public void testByReverseWeightOrder() {
        assertEquals(-1, Term.byReverseWeightOrder().compare(t2, t1));
        assertEquals(1, Term.byReverseWeightOrder().compare(t1, t2));
        assertEquals(-2, Term.byReverseWeightOrder().compare(t4, t2));
       
    }
    
    /**
     * Test method
     */
    public void testByPrefixOrder() {
        Exception thrown = null;
        try
        {
            Term.byPrefixOrder(-1);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(0, Term.byPrefixOrder(4).compare(t1, t2));
        assertEquals(-2, Term.byPrefixOrder(1).compare(t1, t3));
        assertEquals(3, Term.byPrefixOrder(1).compare(t4, t5));
        assertEquals(0, Term.byPrefixOrder(4).compare(t1, t5));
        
    }
    
    /**
     * Test Method
     */
    public void testCompareTo() {
        assertEquals(0, t1.compareTo(t5));
        assertEquals(-3, t1.compareTo(t2));
        assertEquals(3, t2.compareTo(t1));
        assertEquals(-2, t1.compareTo(t3));
        assertEquals(2, t3.compareTo(t2));
        assertEquals(2, t3.compareTo(t1));
        assertEquals(3, t4.compareTo(t1));
    }
    
    /**
     * Test method
     * 
     */
    public void testGetTerm() {
        assertEquals("apple", t1.getTerm());
    }
    
    /**
     * Test method
     */
    public void testSetTerm() {
        t3.setTerm("crackers");
        assertEquals("crackers", t3.getTerm());
    }
    
    /**
     * Test method
     */
    public void testGetWeight() {
        assertEquals(2, t2.getWeight());
    }
    
    /**
     * Test method
     */
    public void testSetWeight() {
        t4.setWeight(40);
        assertEquals(40, t4.getWeight());
    }
    
    /**
     * Test method
     */
    public void testToString() {
        assertEquals("1\tapple", t1.toString());
    }
}
