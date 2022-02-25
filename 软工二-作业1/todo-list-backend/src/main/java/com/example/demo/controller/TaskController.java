package com.example.demo.controller;

import com.example.demo.model.vo.TaskVO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/all")
    public List<TaskVO> getTodoList() {
        return taskService.list();
    }

    @PostMapping(value = "/add")
    public String addTask(@RequestParam("title") String title) {
        taskService.add(title);
        return "添加成功！";
    }

    @DeleteMapping(value = "/task/{id}")
    public String deleteTask(@PathVariable("id") Integer id) {
        taskService.delete(id);
        return "删除成功！";
    }

    @PutMapping(value = "/task/{id}")
    public String updateTask(@PathVariable("id") Integer id, @RequestParam("isCompleted") Integer isCompleted) {
        taskService.update(id, isCompleted);
        return "更新成功！";
    }
}
