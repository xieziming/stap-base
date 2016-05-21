package com.xieziming.stap.core.execution;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xieziming.stap.core.util.JsonDateSerializer;

import java.util.Date;
import java.util.List;

/**
 * Created by Suny on 5/8/16.
 */
public class ExecutionPlan {
    private Integer id;
    private String name;
    private String remark;
    private String status;
    private List<ExecutionPlanMeta> executionPlanMetaList;
    private List<ExecutionPlanLog> executionPlanLogList;
    private List<Execution> executionList;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ExecutionPlanMeta> getExecutionPlanMetaList() {
        return executionPlanMetaList;
    }

    public void setExecutionPlanMetaList(List<ExecutionPlanMeta> executionPlanMetaList) {
        this.executionPlanMetaList = executionPlanMetaList;
    }

    public List<ExecutionPlanLog> getExecutionPlanLogList() {
        return executionPlanLogList;
    }

    public void setExecutionPlanLogList(List<ExecutionPlanLog> executionPlanLogList) {
        this.executionPlanLogList = executionPlanLogList;
    }

    public List<Execution> getExecutionList() {
        return executionList;
    }

    public void setExecutionList(List<Execution> executionList) {
        this.executionList = executionList;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
