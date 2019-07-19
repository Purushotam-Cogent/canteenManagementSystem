package com.hexaware.canteenmanagement.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.canteenmanagement.model.Order;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class OrderMapper implements ResultSetMapper<Order> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped employee object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
    public final Order map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
      return new Order(rs.getInt("order_id"), rs.getInt("food_id"), rs.getString("order_time"),
                    rs.getString("cancellation_time"),rs.getInt("emp_id"),rs.getInt("final_amnt"),
                    rs.getString("estimated_time"),rs.getString("order_status"), rs.getInt("quantity"));
    }
  }