package com.aakrit;

import sun.management.ManagementFactoryHelper;

import java.io.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: aakritprasad
 * Date: 4/20/14
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */

public class AnagramMain
{
    private TrieTree characterTree;
    private static BufferedReader fileReader;

    public AnagramMain(){
        characterTree = new TrieTree();
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String[] pidValue = ManagementFactoryHelper.getRuntimeMXBean().getName().split("@");
        System.out.println("Process ID: "+pidValue[0]);//for performance testing
        AnagramMain anagram = new AnagramMain();
        String filename = "/Users/aakritprasad/IdeaProjects/AnagramDetector/LargestWordFile";
        if(args.length == 1){
            filename = args[0];//pass the filename as 1st argument
        }
        try {
            fileReader = new BufferedReader(new FileReader(new File(filename)));
        } catch (FileNotFoundException e) {e.printStackTrace();}
        try{
            while(fileReader.ready()){
                String nextWord = fileReader.readLine();
                if(nextWord == null) continue;
                String[] checkWorkInput = nextWord.split(" ");
                if(checkWorkInput.length != 1 || nextWord.equals("")){
//                    System.err.println("No words/Multiple Words per Line, skipping this line");
                    continue;
                }
                nextWord.toLowerCase();//assuming our assumption does not hold and we get pass Capitals
                char[] characters = nextWord.toCharArray();
                Arrays.sort(characters);//Sort for inserting into Trie such that element is found fast
                if(anagram.characterTree.checkIfWordIsAnagram(characters))
                    System.out.println("TRUE");
                else {
                    System.out.println("FALSE");
                    anagram.characterTree.addWord(characters);
                }
            }
        }catch (IOException e){e.printStackTrace();}

        long finishTime = System.currentTimeMillis();
        float time = (float)(finishTime - startTime) / 1000;
        System.out.print("\nComputation complete in: ");
        System.out.printf("%.5f", time);
        System.out.print(" seconds");

    }
}
