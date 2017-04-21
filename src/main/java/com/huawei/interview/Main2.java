package com.huawei.interview;

import java.util.*;

/**
 * Created by dengrongguan on 2017/4/20.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String tasks = scanner.nextLine();
        String[] taskArray = tasks.split("\\|");
        Map<Integer,Integer> taskTimeMap = new HashMap<Integer, Integer>();
        Map<Integer,Task> taskIdMap = new HashMap<Integer, Task>();
        List<Task> waitingTasks = new ArrayList<Task>();
        for(int i = 0;i<taskArray.length;i++){
//            System.out.println(taskArray[i]);
            String task = taskArray[i].substring(1,taskArray[i].length()-1);
            String[] taskInfo = task.split("\\.");
            Task task1 = new Task();
            task1.id = Integer.parseInt(taskInfo[0]);
            task1.priority = Integer.parseInt(taskInfo[1]);
            task1.startTime = Integer.parseInt(taskInfo[2]);
            task1.leftTime = Integer.parseInt(taskInfo[3]);
            taskTimeMap.put(task1.startTime,task1.id);
            taskIdMap.put(task1.id,task1);
        }

        int nowId = 0;
        int nowTime = 0;
        int nowPriority = -1;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<200;i++){
            //在有任务切换时输出之前的任务id和运行时间
            if(taskTimeMap.containsKey(i)){
                int taskId = taskTimeMap.get(i);
                Task task = taskIdMap.get(taskId);
                if(task.priority > nowPriority && task.id != nowId){
                    int time = i - nowTime;
                    stringBuffer.append(nowId+"."+time+"|");
                    if(taskIdMap.containsKey(nowId)){
                        Task task1 = taskIdMap.get(nowId);
                        if(task1.leftTime > 0){
                            waitingTasks.add(task1);
                        }
                    }
                    nowId = task.id;
                    nowTime = i;
                    nowPriority = task.priority;

                }else{
                    waitingTasks.add(task);
                }
            }
            if(taskIdMap.containsKey(nowId)){
                Task task = taskIdMap.get(nowId);
                if(task.leftTime == 0){
                    //从等待池里选一个优先级最高的
                    if(waitingTasks.size() == 0){
                        int time = i - nowTime;
                        stringBuffer.append(nowId+"."+time+"|");
                        nowId = 0;
                        nowTime = i;
                        nowPriority = -1;
                    }else{
                        Task tmpTask = waitingTasks.get(0);
                        for(int j = 1;j<waitingTasks.size();j++){
                            Task task1 = waitingTasks.get(j);
                            if(task1.priority > tmpTask.priority && task1.leftTime>0){
                                tmpTask = task1;
                            }
                        }
                        waitingTasks.remove(tmpTask);
                        int time = i - nowTime;
                        stringBuffer.append(nowId+"."+time+"|");
                        nowId = tmpTask.id;
                        nowTime = i;
                        nowPriority = tmpTask.priority;
                        tmpTask.leftTime --;
                        taskIdMap.put(nowId,tmpTask);
                    }
                }else{
                    task.leftTime --;
                    taskIdMap.put(nowId,task);
                }
            }
        }
        int time = 200 - nowTime;
        if(time > 0){
            stringBuffer.append(nowId+"."+time);
        }else {
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        System.out.println(stringBuffer.toString());
    }
    static class Task{
        int id;
        int priority;
        int startTime;
        int leftTime;
    }
}
