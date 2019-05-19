package com.gwz.demo.service.impl.user;

import com.gwz.demo.model.Task;
import com.jfinal.aop.Inject;

public class TaskService {
    public static  final  TaskService taskService=new TaskService();
    @Inject
    Task taskdao;
    public Boolean addTask(Task task){
        return task.save();
    }
}
