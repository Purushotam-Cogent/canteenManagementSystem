package com.hexaware.canteenmanagement.persistence;

import java.util.List;

import com.hexaware.canteenmanagement.model.Order;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface OrderDAO {
    @SqlUpdate("insert into orders(food_id, order_time, quantity, cancellation_time, emp_id, final_amnt, estimated_time, order_status) values(:foodId, :dateTime, :quan, null, :empId, :amnt, null, 'Pending')")
    void newOrder(@Bind("foodId") int foodID, @Bind("empId") int empId, @Bind("dateTime") String dateTime,
                  @Bind("amnt") int amnt, @Bind("quan") int quan);

    @SqlUpdate("update employee set wallet_balance = :newBal where emp_id = :empId")
    void updateEmp(@Bind("empId") int empId, @Bind("newBal") int newBal);

    @SqlQuery("select * from orders")
    @Mapper(OrderMapper.class)
    List<Order> view();

    @SqlQuery("select * from orders where order_id = :oid")
    @Mapper(OrderMapper.class)
    Order viewById(@Bind("oid") int oid);
    
    @SqlUpdate("update orders set cancellation_time = :cancelTime, estimated_time = :estTime where order_id = :oid")
    void updateOrder(@Bind("oid") int oid, @Bind("cancelTime") String cancelTime, @Bind("estTime") String estTime);


}