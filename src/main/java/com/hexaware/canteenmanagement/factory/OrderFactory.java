package com.hexaware.canteenmanagement.factory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import com.hexaware.canteenmanagement.persistence.OrderDAO;
import com.hexaware.canteenmanagement.persistence.DbConnection;
import com.hexaware.canteenmanagement.model.Menu;
import com.hexaware.canteenmanagement.model.Order;
import com.hexaware.canteenmanagement.model.Employee;

public class OrderFactory {
    private static OrderDAO dao() {
        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(OrderDAO.class);
      }
      public static Order[] viewAll() {
        List<Order> order= dao().view();
        return order.toArray(new Order[order.size()]);
    }
    public static Order viewOrderById(final int oid) {
        Order o = dao().viewById(oid);
        return o;
    }
    public static String orderFood(final int empId) {
        String returnResult = "";
        Scanner option1 = new Scanner(System.in, "UTF-8");
        Employee emp = EmployeeFactory.employeeDetail(empId);
        Menu[] menu = MenuFactory.showMenu();
        System.out.println("Food Id  Food Name  Quantity Price");
        for(Menu m : menu) {
            System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getQuantity() + "\t" + m.getPrice());
        }
        System.out.println("Your available balance: "+ emp.getWalletBalance());
        System.out.println("Enter the food ID you want to order");
        int foodId = option1.nextInt();
        Menu men = MenuFactory.showFoodItem(foodId);
        System.out.println("Enter the quantity you want to order");
        int quan = option1.nextInt();
        if(men.getPrice() * quan > emp.getWalletBalance()) {
            returnResult = "Insufficient Wallet Balance";
        }
        else{
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            String dateTime = df.format(dateobj);
            dao().newOrder(foodId, empId, dateTime, men.getPrice() * quan, quan);
            int newBal = emp.getWalletBalance() - men.getPrice() * quan;
            System.out.println(newBal);
            dao().updateEmp(empId, newBal);
            returnResult = "Successully placed";
        }
        return returnResult;
    }
    public static String viewOrders() {
        String returnResult = "";
        Scanner option2 = new Scanner(System.in, "UTF-8");
        Order[] ord = OrderFactory.viewAll();
        System.out.println("Order Id  Food Id  Order Time  Cancellation Time  Emp ID  Amount  estimated Time  Order status  Quantity");
        for(Order o : ord) {
            System.out.println(o.getOrderId() + "\t" + o.getFoodId() + "\t" +o.getOrderTime() + "\t" + o.getCancellationTime()
                            + "\t" + o.getEmpId()+ "\t " + o.getFinalAmnt() + "\t" + o.getEstimatedTime()
                            + "\t" + o.getStatus() + "\t" + o.getQuantity());
        }
        System.out.println("Enter the order id you want to change");
        int oid = option2.nextInt();
        Order order = OrderFactory.viewOrderById(oid);
        System.out.println("Enter the new cancellation time");
        String cancelTime = option2.nextLine();
        // option2.nextLine();
        System.out.println("Enter the new estimated time");
        String estTime = option2.nextLine();
        dao().updateOrder(oid, cancelTime, estTime);
        returnResult = "Successfully Updated";
        return returnResult;
    }
}