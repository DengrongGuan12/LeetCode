package com.huawei.interview;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line == null || line.equals("")){
            System.out.println(0);
        }
        String[] words = line.split(",");
        Set<String> wordSet = new HashSet<String>();
        for(String word: words){
            if(wordSet.contains(word)){
                continue;
            }
            wordSet.add(word);
        }
        Set<String> deletedWords = new HashSet<String>();
        Queue<String> tmpQ = new LinkedList<String>();
        Set<String> headWords = new HashSet<String>();
        for(String word: words){
            if(deletedWords.contains(word)){
                continue;
            }
            tmpQ.offer(word);
            headWords.add(word);
            while(!tmpQ.isEmpty()){
                int size = tmpQ.size();
                for(int i = 0; i < size; i++){
                    String tmpWord = tmpQ.poll();
                    Set<String> gWords = getGroupWords(tmpWord);
                    for(String gWord: gWords){
                        if(wordSet.contains(gWord) && !headWords.contains(gWord)){
                            wordSet.remove(gWord);
                            tmpQ.offer(gWord);
                            deletedWords.add(gWord);
                        }
                    }
                }
            }
        }
        System.out.println(wordSet.size());
    }

    public static Set<String> getGroupWords(String word){
        // 获取交换一次的所有字符串
        Set<String> res = new HashSet<String>();
        char[] cs = word.toCharArray();
        for(int i = 0; i < cs.length; i ++){
            for(int j = i + 1; j < cs.length; j++){
                if(cs[i] == cs[j]){
                    continue;
                }
                swap(cs, i, j);
                res.add(new String(cs));
                swap(cs, i, j);
            }
        }
        return res;
    }

    public static void swap(char[] cs, int i, int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }

}