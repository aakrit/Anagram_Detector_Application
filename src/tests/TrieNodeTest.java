package tests;

import com.aakrit.TrieNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TrieNodeTest {
    private TrieNode testNode1, testNode2, testNode3, testNode4;
    @Before
    public void setUp() throws Exception {
        testNode1 = new TrieNode('c',false);
        testNode2 = new TrieNode('a', false);
        testNode3 = new TrieNode('r', true);
        testNode4 = new TrieNode('s', true);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetChildNodes() throws Exception {

    }

    @Test
    public void testAddChildNode() throws Exception {
        testNode1.addChildNode(testNode2);
        testNode2.addChildNode(testNode3);
        testNode3.addChildNode(testNode4);
    }

    @Test
    public void testFindChildNode() throws Exception {
        testNode1.addChildNode(testNode2);
        assertEquals(true, testNode1.findChildNode('a'));
    }

    @Test
    public void testGetChildNode() throws Exception {
        testNode1.addChildNode(testNode2);
        ArrayList<TrieNode> tn = testNode1.getChildNodes();

        assertEquals(testNode2, tn.get(0));
    }

    @Test
    public void testIsEndWord() throws Exception {
        assertEquals(true, testNode3.isEndWord());
        assertEquals(true, testNode4.isEndWord());
        assertEquals(false, testNode1.isEndWord());
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals('c',testNode1.getValue(),0);
        assertEquals('a',testNode2.getValue(),0);
        assertEquals('r', testNode3.getValue(), 0);
        assertEquals('s',testNode4.getValue(),0);


    }
//    @Test(expected = Exception.class)
//    public void testGetValue2() throws Exception {
//        assertEquals('d',testNode1.getValue(),0);
//        assertEquals('s',testNode2.getValue(),0);
//        assertEquals('r',testNode3.getValue(),0);
//
//    }
}
