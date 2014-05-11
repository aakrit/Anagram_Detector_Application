package com.aakrit;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: aakritprasad
 * Date: 4/20/14
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */

//The following class is responsible for
public class TrieTree
{
    private TrieNode root;

    public TrieTree(){
        root = new TrieNode('\0',false);//initialize with null character
    }
    //add a word
    public void addWord(char[] wordCharacters){
        TrieNode next = root;
        int i = 0;
        for(; i < wordCharacters.length-1; i++){
            TrieNode t = new TrieNode(wordCharacters[i], false);
            next.addChildNode(t);
            next = next.getChildNode(wordCharacters[i]);//get the reference to the Node we just created
        }
        //now add the last character
        TrieNode t = new TrieNode(wordCharacters[i], true);
        next.addChildNode(t);
    }
    //only works if anagram is in sorted order by characters
    public boolean checkIfWordIsAnagram(char[] wordCharacters){
        TrieNode next = root;
        int i = 0;
        //for each character except last
        for(; i < wordCharacters.length-1; i++){
            if(!next.findChildNode(wordCharacters[i])) return false;//character missing, not an anagram
            next = next.getChildNode(wordCharacters[i]);
        }
        //check for last character in the word
        if(next.findChildNode(wordCharacters[i]) &&
                next.getChildNode(wordCharacters[i]).isEndWord()) return true;
        return false;
    }
    public TrieNode getRoot(){
        return root;
    }

}
