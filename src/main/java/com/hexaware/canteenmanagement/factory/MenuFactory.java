package com.hexaware.canteenmanagement.factory;

import com.hexaware.canteenmanagement.persistence.MenuDAO;
import com.hexaware.canteenmanagement.persistence.DbConnection;
import java.util.List;
import com.hexaware.canteenmanagement.model.Menu;

public class MenuFactory {
    private static MenuDAO dao() {
        DbConnection db = new DbConnection();
        return db.getConnect().onDemand(MenuDAO.class);
      }
    public static Menu[] showMenu() {
        List<Menu> menu= dao().show();
        return menu.toArray(new Menu[menu.size()]);
    }
    public static Menu showFoodItem(final int foodId) {
        Menu menu = dao().findByFoodId(foodId);
        return menu;
    }
}