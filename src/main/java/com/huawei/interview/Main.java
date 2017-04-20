package com.huawei.interview;

import java.util.*;

/**
 * Created by dengrongguan on 2017/3/10.
 */
public class Main {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int tmp = sc.nextInt();
//        int result = 0;
//        int multiple = 1;
//        while(tmp > 0){
//            int a = tmp%10;
//            result = result + multiple*a;
//            multiple*=7;
//            tmp = tmp/10;
//        }
//        System.out.println(result);
//        System.out.println(tmp);

        // -----2-----
//        Scanner sc = new Scanner(System.in);
//        String tmp = sc.next();
//        StringBuffer sb = new StringBuffer(tmp);
//        if(tmp.length() == 2||tmp.length() == 5 || tmp.length() == 8 || tmp.length() == 11 || tmp.length() == 14){
//            if(tmp.length() == 2){
//                if(tmp.charAt(0) == tmp.charAt(1)){
//                    System.out.println("yes");
//                }else{
//                    System.out.println("no");
//                }
//            }else if(tmp.length() == 5){
//                for(int i = 0;i<tmp.length()-1;i++){
//                    int f = Integer.parseInt(String.valueOf(tmp.charAt(i)));
//                    for(int j = i+1;j<tmp.length();j++){
//                        int l = Integer.parseInt(String.valueOf(tmp.charAt(j)));
//                        if(f == l){
//                            sb.replace(f,f,"");
//                            sb.replace(l,l,"");
//                        }
//                    }
//                }
//            }
//        }else{
//            System.out.println("no");
//        }
        // ----3-----
        Scanner sc = new Scanner(System.in);
        Map<String,List> map = new HashMap<String, List>();
        for(int i = 0;i<5;i++){
            String tmp = sc.nextLine();
            if(validIP(tmp)){
                String[] strs = tmp.split("\\.");
                int a = Integer.parseInt(strs[0]);
                if(a<=127){
                    //A
                    insertIP(map,tmp,"A");
                }else if(a<=191){
                    //B
                    insertIP(map,tmp,"B");
                }else if(a<=223){
                    //C
                    insertIP(map,tmp,"C");
                }else if(a<=239){
                    //D
                    insertIP(map,tmp,"D");
                }else if(a<=247){
                    //E
                    insertIP(map,tmp,"E");
                }else{
                    continue;
                }
            }
        }
        out(map,"A");
        out(map,"B");
        out(map,"C");
        out(map,"D");
        out(map,"E");
    }

    public static int compareIP(String ip1,String ip2){
        String[] ip1s = ip1.split("\\.");
        String[] ip2s = ip2.split("\\.");
        for(int i = 0;i<4;i++){
            int a1 = Integer.parseInt(ip1s[i]);
            int a2 = Integer.parseInt(ip2s[i]);
            if(a1 < a2){
                return -1;
            }else if(a1 > a2){
                return 1;
            }
        }
        return 0;
    }

    public static boolean validIP(String ip){
        String[] ips = ip.split("\\.");
        for(int i=0;i<4;i++){
            int a = Integer.parseInt(ips[i]);
            if(a > 255){
                return false;
            }
        }
        return true;
    }

    public static int findInsertPosition(String ip,List<String> ips){
        int i;
        for(i = 0;i<ips.size();i++){
            String tmp = ips.get(i);
            if(compareIP(ip,tmp) <= 0){
                return i;
            }
        }
        return i;
    }

    public static void insertIP(Map<String,List> map,String ip,String c){
        List<String> as = map.get(c);
        if(as == null){
            as = new LinkedList<String>();
        }
        int p = findInsertPosition(ip,as);
        as.add(p,ip);
        map.put(c,as);
    }

    public static void out(Map<String,List> map,String c){
        List<String> list = map.get(c);
        if(list != null){
            System.out.print(c+"：[");
            for(int i = 0;i<list.size();i++){
                if(i != 0){
                    System.out.print("，"+list.get(i));
                }else{
                    System.out.print(list.get(i));
                }
            }
            System.out.println("]");
        }
    }
//    public static boolean judgeThree(StringBuffer sb){
//    }
}
