package com.example.demo.service;

import com.example.demo.model.po.TaskPO;
import com.example.demo.model.vo.TaskVO;

import java.util.List;

public interface TaskService {

    /**
     * 查看所有任务
     */
    List<TaskVO> list();

    /**
     * 添加一条新任务
     */
    void add(String title);

    /**
     * 删除一条任务
     */
    void delete(Integer id);

    /**
     * 更新一条任务的状态
     */
    void update(Integer id, Integer isCompleted);
}
