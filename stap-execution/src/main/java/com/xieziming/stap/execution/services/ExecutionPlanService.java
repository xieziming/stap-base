package com.xieziming.stap.execution.services;

import com.xieziming.stap.core.execution.BasicExecutionPlan;
import com.xieziming.stap.core.execution.ExecutionPlan;
import com.xieziming.stap.dao.execution.ExecutionPlanDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Suny on 5/22/16.
 */
@Controller
public class ExecutionPlanService {
    private static Logger logger = LoggerFactory.getLogger(ExecutionPlanService.class);
    private final String UTF8 = ";charset=UTF-8";

    @Autowired
    private ExecutionPlanDao executionPlanDao;

    @RequestMapping(value = "execution_plans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+UTF8)
    @ResponseBody
    public List<BasicExecutionPlan> getExecutions() {
        return executionPlanDao.findAllBasic();
    }

    @RequestMapping(value = "execution_plan/{execution_plan_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE+UTF8)
    @ResponseBody
    public ExecutionPlan getExecutionPlan(@PathVariable("execution_plan_id") int executionPlanId) {
        return executionPlanDao.findById(executionPlanId);
    }
}