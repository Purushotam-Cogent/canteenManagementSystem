package com.hexaware.canteenmanagement.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.canteenmanagement.model.Employee;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class EmployeeMapper implements ResultSetMapper<Employee> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped employee object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
    public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
      return new Employee(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getInt("wallet_balance"),
                    rs.getString("role"), rs.getString("contact_no"));
    }
  }