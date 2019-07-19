package com.hexaware.canteenmanagement.model;
import java.util.Objects;
public class Employee {
    private int empId;
    private String empName;
    private int walletBalance;
    private String role;
    private String contactNo;
    public Employee(final int empId, final String empName, final int walletBalance, final String role, final String contactNo) {
        this.empId = empId;
        this.empName = empName;
        this.walletBalance = walletBalance;
        this.role = role;
        this.contactNo = contactNo;
    }
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    Employee emp = (Employee) obj;
        if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
            && Objects.equals(walletBalance, emp.walletBalance) && Objects.equals(role, emp.role)
            && Objects.equals(contactNo, emp.contactNo)) {
        return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
      return Objects.hash(empId, empName, walletBalance, role, contactNo);
  }
  public int getEmpId() {
      return this.empId;
  }
  public String getEmpName() {
      return this.empName;
  }
  public int getWalletBalance() {
      return this.walletBalance;
  }
  public String getRole() {
      return this.role;
  }
  public String getContactNo() {
      return this.contactNo;
  }
  public void setEmpId(final int empId) {
      this.empId = empId;
  }
  public void setEmpName(final String empName) {
      this.empName = empName;
  }
  public void setWalletBalance(final int walletBalance) {
      this.walletBalance = walletBalance;
  }
  public void setRole(final String role) {
      this.role = role;
  }
  public void setContactNo(final String contactNo) {
      this.contactNo = contactNo;
  }
}