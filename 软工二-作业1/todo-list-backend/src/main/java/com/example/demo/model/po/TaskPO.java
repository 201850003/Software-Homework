package com.example.demo.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskPO {
    /**
     * 任务id
     */
    private Integer id;

    /**
     * 任务名称
     */
    private String title;

    /**
     * 任务是否完成
     */
    private Integer isCompleted;

}
