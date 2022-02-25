package com.example.demo.dao;

import com.example.demo.model.po.TaskPO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    // Mybatis 注解方式
//    @Select("select * from task")
//    List<TaskPO> getTaskList();
//
//    @Insert("insert into task(title, is_completed) values(#{title}, #{isCompleted})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    int insert(TaskPO taskPO);
//
//    @Delete("delete from task where id = #{id}")
//    int deleteById(Integer id);
//
//    @Update("update task set is_completed=#{isCompleted} where id = #{id}")
//    int updateById(Integer id, Integer isCompleted);

    //Mybatis xml配置文件方式
    List<TaskPO> getTaskList();

    int insert(TaskPO taskPO);

    TaskPO findById(Integer id);

    int deleteById(Integer id);

    int updateById(Integer id, Integer isCompleted);
}
