package com.hexaware.canteenmanagement.util;
import java.util.Scanner;
import com.hexaware.canteenmanagement.factory.MenuFactory;
import com.hexaware.canteenmanagement.factory.EmployeeFactory;
import com.hexaware.canteenmanagement.factory.OrderFactory;
import com.hexaware.canteenmanagement.model.Menu;
import com.hexaware.canteenmanagement.model.Employee;
class CliMain {
    private Scanner option = new Scanner(System.in, "UTF-8");
    private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Order Food");
    System.out.println("3. View All Orders (Admin)");
    mainMenuDetails();
    }
    private void mainMenuDetails() {
        try {
          System.out.println("Enter your choice:");
          int menuOption = option.nextInt();
          switch (menuOption) {
            case 1:
              showFullMenu();
              break;
            case 2:
               orderFood();
               break;
            case 3:
               viewAllOrders();
               break;
            case 4:
              // halt since normal exit throws a stacktrace due to jdbc threads not responding
              Runtime.getRuntime().halt(0);
            default:
              System.out.println("Choose either 1, 2, 3, 4 or 5");
          }
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("enter a valid value");
        }
        option.nextLine();
        mainMenu();
    }
    private void showFullMenu() {
        Menu[] menu = MenuFactory.showMenu();
        System.out.println("Food Id  Food Name  Quantity Price");
        for(Menu m : menu) {
            System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getQuantity() + "\t" + m.getPrice());
        }
    }
    private void orderFood() {
      System.out.println("Enter Your employee Id");
      int empId = option.nextInt();
      Employee emp = EmployeeFactory.employeeDetail(empId);
      if (emp == null) {
        System.out.println("Invalid Employee Id");
      }
      else {
        System.out.println(OrderFactory.orderFood(empId));
      }
    }
    private void viewAllOrders() {
      System.out.println("Enter Your employee Id");
      int empId = option.nextInt();
      Employee emp = EmployeeFactory.employeeDetail(empId);
      if (emp == null) {
        System.out.println("Invalid Employee Id");
      }
      else if (!emp.getRole().equals("admin")) {
        System.out.println("Sorry! Only admin can view orders");
      }
      else {
        System.out.println(OrderFactory.viewOrders());
      }
    }
    public static void main(final String[] ar) {
        final CliMain mainObj = new CliMain();
        mainObj.mainMenu();
      }            
}
