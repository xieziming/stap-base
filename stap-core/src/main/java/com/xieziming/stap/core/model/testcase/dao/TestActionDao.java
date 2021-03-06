package com.xieziming.stap.core.model.testcase.dao;

import com.xieziming.stap.core.model.testcase.pojo.TestAction;
import com.xieziming.stap.db.StapDbTables;
import com.xieziming.stap.db.StapDbUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Suny on 5/10/16.
 */
@Component
public class TestActionDao {

    public void add(TestAction testAction) {
        String sql = "INSERT INTO "+StapDbTables.TEST_ACTION+" SET Name =?, Handler=?, Remark=?";
        StapDbUtil.getJdbcTemplate().update(sql, new Object[]{testAction.getName(), testAction.getHandler(), testAction.getRemark()});
    }

    public void update(TestAction testAction) {
        String sql = "UPDATE "+StapDbTables.TEST_ACTION+" SET Name =?, Handler=?, Remark=? WHERE Id=?";
        StapDbUtil.getJdbcTemplate().update(sql, new Object[]{testAction.getName(), testAction.getHandler(), testAction.getRemark(), testAction.getId()});
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM "+StapDbTables.TEST_ACTION+" WHERE Id=?";
        StapDbUtil.getJdbcTemplate().update(sql, new Object[]{id});
    }

    public List<TestAction> findAll(){
        String sql = "SELECT * FROM " + StapDbTables.TEST_ACTION;
        return  StapDbUtil.getJdbcTemplate().query(sql, new Object[0], testActionRowMapper);
    }

    public TestAction findById(int id) {
        String sql = "SELECT * FROM " + StapDbTables.TEST_ACTION + " WHERE Id=?";
        return  StapDbUtil.getJdbcTemplate().queryForObject(sql, new Object[]{id}, testActionRowMapper);
    }

    public TestAction findByName(String name) {
        String sql = "SELECT * FROM " + StapDbTables.TEST_ACTION + " WHERE Name=?";
        return  StapDbUtil.getJdbcTemplate().queryForObject(sql, new Object[]{name}, testActionRowMapper);
    }


    RowMapper<TestAction> testActionRowMapper = new RowMapper<TestAction>() {
        public TestAction mapRow(ResultSet resultSet, int i) throws SQLException {
            TestAction testAction = new TestAction();
            testAction.setId(resultSet.getInt("Id"));
            testAction.setName(resultSet.getString("Name"));
            testAction.setHandler(resultSet.getString("Handler"));
            testAction.setRemark(resultSet.getString("Remark"));
            testAction.setLastUpdate(resultSet.getTimestamp("Last_Update"));
            return testAction;
        }
    };
}
