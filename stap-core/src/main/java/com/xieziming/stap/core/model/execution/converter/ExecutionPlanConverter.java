package com.xieziming.stap.core.model.execution.converter;

import com.xieziming.stap.core.model.execution.dao.ExecutionLogDao;
import com.xieziming.stap.core.model.execution.dao.ExecutionPlanDao;
import com.xieziming.stap.core.model.execution.dao.ExecutionPlanMetaDao;
import com.xieziming.stap.core.model.execution.dto.ExecutionPlanDto;
import com.xieziming.stap.core.model.execution.pojo.ExecutionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suny on 7/21/16.
 */
@Component
public class ExecutionPlanConverter {
    @Autowired
    private ExecutionPlanMetaConverter executionPlanMetaConverter;
    @Autowired
    private ExecutionPlanMetaDao executionPlanMetaDao;
    @Autowired
    private ExecutionLogConverter executionLogConverter;
    @Autowired
    private ExecutionLogDao executionLogDao;
    @Autowired
    private ExecutionPlanDao executionPlanDao;

    public List<ExecutionPlanDto> convertAll(List<ExecutionPlan> executionPlanList) {
        List<ExecutionPlanDto> executionPlanDtoList = new ArrayList<ExecutionPlanDto>();
        for (ExecutionPlan executionPlan : executionPlanList){
            executionPlanDtoList.add(convert(executionPlan));
        }
        return executionPlanDtoList;
    }

    public ExecutionPlanDto convert(ExecutionPlan executionPlan) {
        ExecutionPlanDto executionPlanDto = new ExecutionPlanDto();
        executionPlanDto.setId(executionPlan.getId());
        executionPlanDto.setName(executionPlan.getName());
        executionPlanDto.setDescription(executionPlan.getDescription());
        executionPlanDto.setStatus(executionPlan.getStatus());
        executionPlanDto.setLastUpdate(executionPlan.getLastUpdate());
        executionPlanDto.setExecutionPlanMetaDtoList(executionPlanMetaConverter.convertAll(executionPlanMetaDao.findAllByExecutionPlanId(executionPlan.getId())));
        executionPlanDto.setExecutionLogDtoList(executionLogConverter.convertAll(executionLogDao.findAllByExecutionPlanId(executionPlan.getId())));
        return executionPlanDto;
    }
}
