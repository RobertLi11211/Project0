/*
 * package com.revature.dao;
 * 
 * import java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException; import java.io.ObjectInputStream; import
 * java.io.ObjectOutputStream;
 * 
 * import com.revature.pojos.Car; import com.revature.pojos.Customer; import
 * com.revature.pojos.Employee;
 * 
 * public class EmployeeDAOSerialization implements EmployeeDAO {
 * 
 * @Override public void createEmployee(Employee e) { String fileName; if
 * (e.getUsername() != null) { fileName = e.getUsername() + "Employee.dat"; }
 * else { fileName = "MysteryPerson.dat"; } try (FileOutputStream fos = new
 * FileOutputStream(fileName); ObjectOutputStream oos = new
 * ObjectOutputStream(fos);) { oos.writeObject(e);
 * 
 * } catch (IOException ex) { ex.printStackTrace(); }
 * 
 * }
 * 
 * @Override public Employee readEmployee(String username) { String fileName =
 * username + "Employee.dat"; Employee ret = null; try (FileInputStream fis =
 * new FileInputStream(fileName); ObjectInputStream ois = new
 * ObjectInputStream(fis);) { ret = (Employee) ois.readObject(); } catch
 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * return ret; }
 * 
 * }
 */