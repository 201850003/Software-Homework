package com.example.demo.model.vo;

import com.example.demo.model.po.TaskPO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class TaskVO {

    private Integer id;

    private String title;

    private Integer isCompleted;

    public TaskVO(TaskPO po) {
        BeanUtils.copyProperties(po, this);
    }
}
