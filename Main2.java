package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main2 {
    static int getIndex(char c){
        if('A'<=c&&c<='Z') return c-'A';
        else return c-'a'+26;
    }
    static boolean isOk(boolean[] arr,int idx){
        for(int j=idx-26;j<=idx+26;j+=26){
            if(0<=j&&j<52){
                if(!arr[j]) return false;
            }
        }
        return true;
    }

    static int solution(String S){
        System.out.println("들어온 문자열 : "+S);
        int answer=Integer.MAX_VALUE;
        boolean v[]=new boolean[52];
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            int idx=getIndex(c);
            v[idx]=true;
        }
        boolean check[]=new boolean[52];
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            int idx=getIndex(c);
            if(isOk(v,idx)){
                list.add(c);
                check[idx]=true;
                for(int j=i+1;j<S.length();j++){
                    c=S.charAt(j);
                    idx=getIndex(c);

                    if(isOk(v,idx)){
                        list.add(c);
                        check[idx]=true;
                    }else break;

                    boolean flag=true;
                    for(char ch:list){
                        if(!isOk(check,getIndex(ch))){
                            flag=false;
                            break;
                        }
                    }
                    if(flag) answer=Math.min(answer,list.size());
                }

                Arrays.fill(check,false);
                list.clear();
            }
        }
        if(answer==Integer.MAX_VALUE) return -1;
        else return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("aAaaaaaaaBbCc")); //답 2
        System.out.println(solution("azABaabza")); //
        System.out.println(solution("AcZCbaBz"));
        System.out.println(solution("aaACA"));
        System.out.println(solution("aBabA"));
        System.out.println(solution("aAAaCA"));
        System.out.println(solution("AbaaaaaaaaaaaaaaaaaaaaaaaB"));
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz"));
    }
}
