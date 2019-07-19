package com.hexaware.canteenmanagement.model;
import java.util.Objects;

public class Order {
    private int orderId;
    private int foodId;
    private String orderTime;
    private String cancellationTime;
    private int empId;
    private int finalAmnt;
    private String estimatedTime;
    private String status;
    private int quantity;
    public Order(final int orderId, final int foodId, final String orderTime, final String cancellationTime,
                final int empId, final int finalAmnt, final String estimatedTime, final String status,
                final int quantity) {
                    this.orderId = orderId;
                    this.foodId = foodId;
                    this.orderTime = orderTime;
                    this.cancellationTime = cancellationTime;
                    this.empId = empId;
                    this.finalAmnt = finalAmnt;
                    this.estimatedTime = estimatedTime;
                    this.status = status;
                    this.quantity = quantity;
                }
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
            if (Objects.equals(orderId, order.orderId) && Objects.equals(foodId, order.foodId)
                && Objects.equals(orderTime, order.orderTime) && Objects.equals(cancellationTime, order.cancellationTime)
                && Objects.equals(empId, order.empId) && Objects.equals(finalAmnt, order.finalAmnt)
                && Objects.equals(estimatedTime, order.estimatedTime) && Objects.equals(status, order.status)) {
            return true;
        }
        return false;
      }
    @Override
    public final int hashCode() {
        return Objects.hash(orderId, foodId, orderTime, cancellationTime, empId, finalAmnt, estimatedTime, status);
      }
      public int getOrderId() {
        return this.orderId;
    }
    public int getFoodId() {
        return this.foodId;
    }
    public String getOrderTime() {
        return this.orderTime;
    }
    public String getCancellationTime() {
        return this.cancellationTime;
    }
    public int getEmpId() {
        return this.empId;
    }
    public int getFinalAmnt() {
        return this.finalAmnt;
    }
    public String getEstimatedTime() {
        return this.estimatedTime;
    }
    public String getStatus() {
        return this.status;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setOrderId(final int orderId) {
        this.orderId = orderId;
    }
    public void setFoodId(final int foodId) {
        this.foodId = foodId;
    }
    public void setOrderTime(final String orderTime) {
        this.orderTime = orderTime;
    }
    public void setCancellationTime(final String cancellationTime) {
        this.cancellationTime = cancellationTime;
    }
    public void setEmpId(final int empId) {
        this.empId = empId;
    }
    public void setFinalAmnt(final int finalAmnt) {
        this.finalAmnt = finalAmnt;
    }
    public void setEstimatedTime(final String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    public void setStatus(final String status) {
        this.status = status;
    }
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}