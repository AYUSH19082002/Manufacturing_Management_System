package manufacturing_management_system;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection con;

    private static void productManagement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Product Management:");
        System.out.println("1. Add a new product");
        System.out.println("2. View product details");
        System.out.println("3. Update product information");
        System.out.println("4. Delete a product");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                viewProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
            	deleteProduct();
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
        sc.close();
    }

    private static void addProduct() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter product id: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter product description: ");
            String desc = sc.nextLine();

            System.out.print("Enter unit price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity in stock: ");
            int qty = sc.nextInt();

            String query = "INSERT INTO product (product_id, name, descrip, unit_price, qty) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, desc);
            st.setDouble(4, price);
            st.setInt(5, qty);

            int x = st.executeUpdate();
            if (x > 0) {
                System.out.println("A new product was inserted successfully!");
            } else {
                System.out.println("Failed to insert the product. Please try again.");
            }

            st.close(); // Close the PreparedStatement

        } catch (Exception e) {
            System.out.println("Error adding product: " + e);
        }
        sc.close();
    }

    private static void viewProduct()
    {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter the product_id");
    	int id=sc.nextInt();
    	
    	String query="SELECT * FROM product WHERE product_id= ?";
    	try {
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			
			if (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Description: " + rs.getString("descrip"));
                System.out.println("Unit Price: " + rs.getDouble("unit_price"));
                System.out.println("Quantity in Stock: " + rs.getInt("qty"));
            } else {
                System.out.println("Product not found.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sc.close();
    }
    
    private static void updateProduct() 
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the product_id");
    	int id=sc.nextInt();
    	 System.out.print("Enter new product name: ");
         String name = sc.next();
         System.out.print("Enter new product description: ");
         String description = sc.next();
         System.out.print("Enter new unit price: ");
         double unitPrice = sc.nextDouble();
         System.out.print("Enter new quantity in stock: ");
         int quantity = sc.nextInt();
         
         String query = "UPDATE Product SET name = ?, descrip = ?, unit_price = ?, qty = ? WHERE product_id = ?";
    	try {
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, name);
            st.setString(2, description);
            st.setDouble(3, unitPrice);
            st.setInt(4, quantity);
            st.setInt(5, id);
            st.executeUpdate();
            System.out.println("Product updated successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sc.close();
    }
    
    private static void deleteProduct()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        String query = "DELETE FROM Product WHERE product_id = ?";
        
        try {
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Product deleted successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sc.close();
    }
    
    private static void supplierManagement() {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("\nSupplier Management:");
        System.out.println("1. Add a new supplier");
        System.out.println("2. View supplier details");
        System.out.println("3. Update supplier information");
        System.out.println("4. Delete a supplier");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        
        switch (choice) {
        case 1:
            addSupplier();
            break;
        case 2:
            viewSupplier();
            break;
        case 3:
            updateSupplier();
            break;
        case 4:
            deleteSupplier();
            break;
        default:
            System.out.println("Invalid option, please try again.");
    }
        sc.close();
    }
    
    private static void addSupplier() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter supplier id: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter supplier name: ");
            String name = sc.nextLine();

            System.out.print("Enter supplier email: ");
            String email = sc.nextLine();

            System.out.print("Enter supplier phone number: ");
            String phone = sc.nextLine();

            System.out.print("Enter supplier address: ");
            String address = sc.nextLine();

            String query = "INSERT INTO supplier (supplier_id, name, email, ph_no, addr) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, address);

            int x = st.executeUpdate();
            if (x > 0) {
                System.out.println("Supplier added successfully!");
            } else {
                System.out.println("Failed to add the supplier. Please try again.");
            }

            st.close(); // Close the PreparedStatement

        } catch (SQLException e) {
            System.out.println("Error adding supplier: " + e);
        }
        sc.close();
    }
    
    private static void viewSupplier()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter supplier ID: ");
        int id = sc.nextInt();

        String query = "SELECT * FROM Supplier WHERE supplier_id = ?";
        try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

            if (rs.next()) {
                System.out.println("Supplier ID: " + rs.getInt("supplier_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone Number: " + rs.getString("ph_no"));
                System.out.println("Address: " + rs.getString("addr"));
            } else {
                System.out.println("Supplier not found.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sc.close();
    }
    
    
    private static void updateSupplier()
    {
    	Scanner sc=new Scanner(System.in);
    	 System.out.print("Enter supplier ID: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new supplier name: ");
         String name = sc.next();
         System.out.print("Enter new supplier email: ");
         String email = sc.next();
         System.out.print("Enter new supplier phone number: ");
         String phone = sc.next();
         System.out.print("Enter new supplier address: ");
         String address = sc.next();
         
         String query = "UPDATE Supplier SET name = ?, email = ?, ph_no = ?, addr = ? WHERE supplier_id = ?";
         try {
			PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, name);
	        st.setString(2, email);
	        st.setString(3, phone);
	        st.setString(4, address);
	        st.setInt(5, id);
	        st.executeUpdate();
	        System.out.println("Supplier updated successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         sc.close();
    }
    
    
    private static void deleteSupplier(){
    	Scanner sc=new Scanner(System.in);
        System.out.print("Enter supplier ID: ");
        int id = sc.nextInt();

        String query = "DELETE FROM Supplier WHERE supplier_id = ?";
        try {
        	PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Supplier deleted successfully.");
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sc.close();
    }
    
    
    private static void productionOrder()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("\nProduction Order Management:");
        System.out.println("1. Create a new production order");
        System.out.println("2. View production order details");
        System.out.println("3. Update production order information");
        System.out.println("4. Cancel a production order");
        System.out.print("Choose an option: ");
        
        int ch=sc.nextInt();
        
        switch(ch) {
        case 1:
        	createProOrder();
        	break;
        case 2:
        	viewProOder();
        	break;
        case 3:
        	updateProOder();
        	break;
        case 4:
        	cancelProOrder();
        }
        sc.close();
        
    }
    
    private static void createProOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order_id:");
        int o_id = sc.nextInt();
        System.out.println("Enter the product_id:");
        int p_id = sc.nextInt();
        System.out.println("Enter the supplier_id:");
        int s_id = sc.nextInt();
        System.out.print("Enter order date (YYYY-MM-DD): ");
        String orderDate = sc.next();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = sc.next();
        System.out.print("Enter status (open/closed): ");
        String status = sc.next();

        String query = "INSERT INTO produc_order (order_id, product_id, supplier_id, order_date, due_date, status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, o_id);
            st.setInt(2, p_id);
            st.setInt(3, s_id);
            st.setDate(4, java.sql.Date.valueOf(orderDate));
            st.setDate(5, java.sql.Date.valueOf(dueDate));
            st.setString(6, status);

            st.executeUpdate();
            int x=st.executeUpdate();
            if (x > 0) {
                System.out.println("Production order created successfully!");
            } else {
                System.out.println("Failed to create the production order. Please try again.");
            }

            st.close(); // Close the PreparedStatement
        } catch (SQLException e) {
            System.out.println("Error creating production order: " + e);
        }
        sc.close();
    }

    
    private static void viewProOder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter production order id: ");
        int id = sc.nextInt();

        String query = "SELECT * FROM produc_order WHERE order_id = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                System.out.println("Production Order ID: " + rs.getInt("order_id"));
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Supplier ID: " + rs.getInt("supplier_id"));
                System.out.println("Order Date: " + rs.getDate("order_date"));
                System.out.println("Due Date: " + rs.getDate("due_date"));
                System.out.println("Status: " + rs.getString("status"));
            } else {
                System.out.println("Production order not found.");
            }
            rs.close(); // Close the ResultSet
            st.close(); // Close the PreparedStatement
        } catch (SQLException e) {
            System.out.println("Error retrieving production order: " + e);
        }
        sc.close();
    }

    
    private static void updateProOder()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter production_order id: ");
        int o_id = sc.nextInt();
        System.out.print("Enter new product ID: ");
        int p_id = sc.nextInt();
        System.out.print("Enter new supplier ID: ");
        int s_id = sc.nextInt();
        System.out.print("Enter new order date (YYYY-MM-DD): ");
        String orderDate = sc.next();
        System.out.print("Enter new due date (YYYY-MM-DD): ");
        String dueDate = sc.next();
        System.out.print("Enter new status (open/closed): ");
        String status = sc.next();

        String query = "UPDATE produc_order SET product_id = ?, supplier_id = ?, order_date = ?, due_date = ?, status = ? WHERE order_id = ?";
        
        try {
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, p_id);
			st.setInt(2, s_id);
			st.setDate(3, java.sql.Date.valueOf(orderDate));
            st.setDate(4, java.sql.Date.valueOf(dueDate));
            st.setString(5, status);
            st.setInt(6, o_id);
            
            int x=st.executeUpdate();
            if(x>=0)
            {
            	System.out.println("Updated Successfully");
            }
            else {
            	System.out.println("Failed to update");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sc.close();
    }
    
    
    private static void cancelProOrder()
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter production_order id to cancel: ");
        int o_id = sc.nextInt();
        String query = "UPDATE produc_order SET status = 'cancelled' WHERE order_id = ?";
        try {
			PreparedStatement st=con.prepareStatement(query);
			st.setInt(1, o_id);
			int x=st.executeUpdate();
			if(x>=0)
			{
				System.out.println("Order Cancelled");
			}
			else {
				System.out.println("Failed to cancel the order");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sc.close();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/manufacturing";
            String uname ="root";
            String pass = "1234";

            con = DriverManager.getConnection(url, uname, pass);
            System.out.println("Connection Established");

            boolean exit = false;

            while (!exit) {
            	 System.out.println("\nMenu:");
                 System.out.println("1. Product Management");
                 System.out.println("2. Supplier Management");
                 System.out.println("3. Production Order Management");
                 System.out.println("4. Exit");
                 System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        productManagement();
                        break;

                    case 2:
                        supplierManagement();
                        break;
                    case 3:
                    	productionOrder();
                    	break;
                    case 4:
                    	System.out.println("Exiting...");
                        sc.close();
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                        exit = true;
                        break;
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e);
        } catch (Exception e) {
            System.out.println("Connection error: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (Exception e) {
                System.out.println("Error closing connection: " + e);
            }
            sc.close(); // Closing Scanner
        }
    }
}
