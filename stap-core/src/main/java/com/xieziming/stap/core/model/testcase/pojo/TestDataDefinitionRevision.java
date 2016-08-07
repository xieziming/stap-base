package com.xieziming.stap.core.model.testcase.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xieziming.stap.core.util.JsonDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Suny on 5/8/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDataDefinitionRevision {
    private Integer id;
    private Integer testDataDefinitionId;
    private String type;
    private String content;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date time;
}
