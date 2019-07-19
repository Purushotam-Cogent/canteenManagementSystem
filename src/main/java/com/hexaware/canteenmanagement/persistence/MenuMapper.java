package com.hexaware.canteenmanagement.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.canteenmanagement.model.Menu;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class MenuMapper implements ResultSetMapper<Menu> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped employee object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
    public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
      return new Menu(rs.getInt("food_id"), rs.getString("food_name"), rs.getInt("quantity"),
                    rs.getInt("price"));
    }
  }