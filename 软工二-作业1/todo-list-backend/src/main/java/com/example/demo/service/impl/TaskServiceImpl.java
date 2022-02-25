package com.example.demo.service.impl;

import com.example.demo.dao.TaskMapper;
import com.example.demo.model.po.TaskPO;
import com.example.demo.model.vo.TaskVO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskVO> list() {
        List<TaskPO> taskPOs = taskMapper.getTaskList();
        List<TaskVO> taskList = new ArrayList<>();
        for (TaskPO taskPO : taskPOs) {
            taskList.add(new TaskVO(taskPO));
        }
        return taskList;
    }

    @Override
    public void add(String title) {
        TaskPO taskPO = TaskPO.builder().title(title).isCompleted(0).build();
        taskMapper.insert(taskPO);
    }

    @Override
    public void delete(Integer id) {
        taskMapper.deleteById(id);
    }

    @Override
    public void update(Integer id, Integer isCompleted) {
        taskMapper.updateById(id, isCompleted);
    }
}
