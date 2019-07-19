package com.hexaware.canteenmanagement.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.canteenmanagement.model.Employee;

public interface EmployeeDAO {
    @SqlQuery("Select * from employee where emp_id = :empId")
    @Mapper(EmployeeMapper.class)
    Employee list(@Bind("empId") int empId);
}