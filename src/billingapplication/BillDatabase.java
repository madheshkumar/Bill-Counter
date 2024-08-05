package billingapplication;

import java.sql.*;

public class BillDatabase {

    private Statement stmt;
    private Statement stmt2;
    private ResultSet rs;

    Connection con;

    //initialize database
    BillDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Madhesh@17");
            if (con != null) {
                System.out.println("Connected to the database");
                stmt = con.createStatement();
                stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmt.execute("CREATE DATABASE IF NOT EXISTS billCounter");
                stmt.execute("USE billcounter");
                createTables();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    //create tables
    private void createTables() throws SQLException {
        try {
            stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS `billcounter`.`customer` ( `id` INT NOT NULL AUTO_INCREMENT,"
                    + "  `cust_name` VARCHAR(100) NOT NULL,"
                    + "  `phone_no` VARCHAR(45) NOT NULL,"
                    + "  PRIMARY KEY (`id`),"
                    + "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");
            stmt.execute("CREATE TABLE IF NOT EXISTS `billcounter`.`menu` (`id` INT NOT NULL AUTO_INCREMENT, "
                    + " `mealname` VARCHAR(100) NOT NULL, "
                    + " `mealtype` VARCHAR(100) NOT NULL, "
                    + " `price` INT NOT NULL, "
                    + " PRIMARY KEY (`id`), "
                    + " UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");

            stmt.execute("CREATE TABLE IF NOT EXISTS `billcounter`.`bill` ("
                    + " `id` INT NOT NULL AUTO_INCREMENT,"
                    + " `cid` INT NOT NULL,"
                    + " `table_no` VARCHAR(45) NOT NULL,"
                    + " `total_price` INT NOT NULL,"
                    + " `date` DATE NOT NULL,"
                    + " PRIMARY KEY (`id`),"
                    + " UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,"
                    + " INDEX `custid_idx` (`cid` ASC) VISIBLE,"
                    + " CONSTRAINT `custid`"
                    + " FOREIGN KEY (`cid`)"
                    + " REFERENCES `billcounter`.`customer` (`id`)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE);");

            stmt.execute("CREATE TABLE IF NOT EXISTS`billcounter`.`order` ("
                    + " `id` INT NOT NULL AUTO_INCREMENT,"
                    + " `billid` INT NOT NULL,"
                    + " `mealid` INT NOT NULL,"
                    + " `quantity` INT NOT NULL,"
                    + " PRIMARY KEY (`id`),"
                    + " UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,"
                    + " INDEX `billid_idx` (`billid` ASC) VISIBLE,"
                    + " INDEX `mealid_idx` (`mealid` ASC) VISIBLE,"
                    + " CONSTRAINT `billid`"
                    + " FOREIGN KEY (`billid`)"
                    + " REFERENCES `billcounter`.`bill` (`id`)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE,"
                    + " CONSTRAINT `mealid`"
                    + " FOREIGN KEY (`mealid`)"
                    + " REFERENCES `billcounter`.`menu` (`id`)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE);");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //insert customer
    public void insertCustomer(String name, String phone) {
        try {
            stmt.execute("INSERT INTO `billcounter`.`customer` (`cust_name`, `phone_no`) VALUES ('" + name + "', '" + phone + "');");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //insert menu
    public void insertMenu(String mealname, String mealtype, int price) {
        try {
            stmt.execute("INSERT INTO `billcounter`.`menu` (`mealname`, `mealtype`, `price`) VALUES ('" + mealname + "', '" + mealtype + "', '" + price + "');");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //insert bill  
    public void insertBill(int cid, String table_no, int total_price, String date) {
        try {
            stmt.execute("INSERT INTO `billcounter`.`bill` (`cid`, `table_no`, `total_price`, `date`) VALUES ('" + cid + "', '" + table_no + "', '" + total_price + "', '" + date + "');");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getLastBill() {
        try {
            rs = stmt.executeQuery("SELECT id FROM `billcounter`.`bill` ORDER BY id DESC LIMIT 1;");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //insert order
    public void insertOrder(int billid, int mealid, int quantity) {
        try {
            stmt.execute("INSERT INTO `billcounter`.`order` (`billid`, `mealid`, `quantity`) VALUES ('" + billid + "', '" + mealid + "', '" + quantity + "');");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //get customer id
    public int getCustomerId(String name, String phone) {
        try {
            rs = stmt.executeQuery("SELECT id FROM `billcounter`.`customer` WHERE cust_name = '" + name + "' AND phone_no = '" + phone + "';");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //get menu id
    public int getMealId(String mealname) {
        try {
            rs = stmt.executeQuery("SELECT id FROM `billcounter`.`menu` WHERE mealname = '" + mealname + "';");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //get bill id
    public int getBillId(int cid, String date) {
        try {
            rs = stmt.executeQuery("SELECT id FROM `billcounter`.`bill` WHERE cid = '" + cid + "' AND date = '" + date + "';");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //meal price
    public int getMealPrice(String mealname) {
        try {
            rs = stmt.executeQuery("SELECT price FROM `billcounter`.`menu` WHERE mealname = '" + mealname + "';");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //get all menu 
    public String[] getMenu() {
        try {
            rs = stmt2.executeQuery("SELECT mealname FROM `billcounter`.`menu`;");
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            if (rowCount == 0) {
                return new String[]{};
            }
            String[] menu = new String[rowCount];
            int i = 0;
            while (rs.next()) {
                menu[i] = rs.getString(1);
                i++;
            }
            return menu;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getVegMenu() {
        try {
            int i = 0;
            rs = stmt2.executeQuery("SELECT mealname FROM billcounter.menu where mealtype = 'veg';");
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            if (rowCount == 0) {
                return new String[]{};
            }
            String[] menu = new String[rowCount];
            while (rs.next()) {
                menu[i] = rs.getString(1);
                i++;
            }
            return menu;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getNonVegMenu() {
        try {
            int i = 0;
            rs = stmt2.executeQuery("SELECT mealname FROM `billcounter`.`menu` where mealtype = 'non-veg';");
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            if (rowCount == 0) {
                return new String[]{};
            }
            String[] menu = new String[rowCount];
            while (rs.next()) {
                menu[i] = rs.getString(1);
                i++;
            }
            return menu;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    //get total revenue
    public int getTotalRevenue() {
        try {
            rs = stmt.executeQuery("SELECT SUM(total_price) FROM `billcounter`.`bill`;");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //get total customers
    public int getTotalCustomers() {
        try {
            rs = stmt.executeQuery("SELECT COUNT(id) FROM `billcounter`.`customer`;");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    //get Bills
    public String[][] getBills() {
        try {
            rs = stmt2.executeQuery("SELECT * FROM `billcounter`.`bill`;");
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            if (rowCount == 0) {
                return new String[][]{};
            }
            String[][] bills = new String[rowCount][5];
            int i = 0;
            while (rs.next()) {
                bills[i][0] = rs.getString(1);
                bills[i][1] = rs.getString(2);
                bills[i][2] = rs.getString(3);
                bills[i][3] = rs.getString(4);
                bills[i][4] = rs.getString(5);
                i++;
            }
            return bills;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    //get Customers
    public String[][] getCustomers() {
        try {
            rs = stmt2.executeQuery(
                    "select c.id,c.cust_name,c.phone_no, count(o.id) "
                    + "from billcounter.customer c join billcounter.bill b "
                    + " on c.id = b.cid join billcounter.order o "
                    + " on b.id = o.billid group by c.id;");
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            if (rowCount == 0) {
                return new String[][]{};
            }
            String[][] customers = new String[rowCount][4];
            int i = 0;
            while (rs.next()) {
                customers[i][0] = rs.getString(1);
                customers[i][1] = rs.getString(2);
                customers[i][2] = rs.getString(3);
                customers[i][3] = rs.getString(4);
                i++;
            }
            return customers;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    String getCustomerName(String cid) {
        try {
            rs = stmt.executeQuery("SELECT cust_name FROM `billcounter`.`customer` WHERE id = '" + cid + "';");
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
