package tests;

import com.aakrit.TrieTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class AnagramTest {
    public TrieTree characterTree;

    @Before
    public void setUp() throws Exception {
        characterTree = new TrieTree();

    }
    @Test
    public void addCharacter() throws Exception{

        String[] testWords = new String[]{"aan", "naa", "mike", "ekim", "running", "ok", "ko", "meik"};
        for(String s: testWords){
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            characterTree.addWord(characters);
        }
//        assertEquals(true, characterTree.checkIfWordIsAnagram("naa".toCharArray()));
        assertEquals(false, characterTree.checkIfWordIsAnagram("runnin".toCharArray()));
        char[] c = "ok".toCharArray();
        assertEquals(false, characterTree.checkIfWordIsAnagram(c));
    }

    @After
    public void tearDown() throws Exception {

    }
}
