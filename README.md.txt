MANUFACTURING_MANAGEMENT SYSTEM



This readme file provides an overview of the manufacturing management system code.

Purpose

This code manages a manufacturing system's products, suppliers, and production orders. It allows users to:

->Add, view, update, and delete products
->Add, view, update, and delete suppliers
->Create, view, update, and cancel production orders

Features

Product Management:
->Add new products with details like ID, name, description, unit price, and quantity
->View existing products by ID
->Update product information
->Delete products
->Supplier Management:
->Add new suppliers with details like ID, name, email, phone number, and address
->View existing suppliers by ID
->Update supplier information
->Delete suppliers
Production Order Management:
->Create new production orders with details like ID, product ID, supplier ID, order date, due date, and status
->View existing production orders by ID
->Update production order information
->Cancel production orders

Dependencies

The code depends on the following:

Java Database Connectivity (JDBC) driver (com.mysql.cj.jdbc.Driver)
MySQL database connection
Database Configuration

The code expects a MySQL database named "manufacturing" to be available. You'll need to modify the connection details (URL, username, and password) in the main function to connect to your specific database instance.

Running the Code

Ensure you have the JDBC driver included in your project's classpath.
Configure the database connection details in the main function.
Compile and run the Main class.
Example Usage

Start the program.
Select a menu option:
Option 1: Product Management
Option 1: Add a new product
Option 2: View product details (by ID)
Option 3: Update product information
Option 4: Delete a product
Option 2: Supplier Management (similar options as product management)
Option 3: Production Order Management (similar options as product management)
Option 4: Exit