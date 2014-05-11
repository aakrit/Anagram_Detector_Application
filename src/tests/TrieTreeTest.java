package tests;

import com.aakrit.TrieNode;
import com.aakrit.TrieTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrieTreeTest {
    public TrieTree tree;
    public char[] str1, str2, str3;
    @Before
    public void setUp() throws Exception {
        tree = new TrieTree();
        str1 = "abcdef".toCharArray();
        str2 = "ghij".toCharArray();
        str3 = "fedcba".toCharArray();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddWord() throws Exception {
        tree.addWord(str1);
        tree.addWord(str2);
        tree.addWord(str3);
    }

    @Test
    public void testCheckIfWordIsAnagram() throws Exception {
        tree.addWord(str1);
        assertEquals(false, tree.checkIfWordIsAnagram(str1));
        tree.addWord(str2);
        tree.addWord(str3);
        assertEquals(true, tree.checkIfWordIsAnagram(str3));
        assertEquals(false, tree.checkIfWordIsAnagram(str2));

    }
}
