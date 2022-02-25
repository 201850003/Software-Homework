package com.example.demo.mapper;

import com.example.demo.dao.TaskMapper;
import com.example.demo.model.po.TaskPO;
import com.example.demo.util.RandomUtil;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;

    static Integer id;
    static String title = RandomUtil.getRandomtitle();
    static Integer isCompleted = RandomUtil.getRandomIsCompleted();

    @Test
    @Order(Integer.MIN_VALUE)
    void insert() {
        TaskPO taskPO = new TaskPO();
        taskPO.setTitle(title);
        taskPO.setIsCompleted(isCompleted);
        assertEquals(1, taskMapper.insert(taskPO));
        id = taskPO.getId();
    }

    @Test
    void findByUid() {
        TaskPO taskPO = taskMapper.findById(id);
        assertNotNull(taskPO);
        assertEquals(title, taskPO.getTitle());
        assertEquals(isCompleted, taskPO.getIsCompleted());
    }

    @Test
    void getTaskList() {
        List<TaskPO> taskList = taskMapper.getTaskList();
        assertNotNull(taskList);
        assertNotEquals(0, taskList.size());
    }

    @Test
    @Order(Integer.MAX_VALUE - 1)
    void update() {
        isCompleted = isCompleted==0?1:0;
        assertEquals(1, taskMapper.updateById(id, isCompleted));
        assertEquals(isCompleted, taskMapper.findById(id).getIsCompleted());
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void delete() {
        assertEquals(1, taskMapper.deleteById(id));
        assertNull(taskMapper.findById(id));
    }

}
