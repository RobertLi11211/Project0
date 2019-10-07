/*
 * package com.revature.dao;
 * 
 * import java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException; import java.io.ObjectInputStream; import
 * java.io.ObjectOutputStream; import java.util.List;
 * 
 * public class EmployeeListDAOSerialization implements EmployeeListDAO {
 * 
 * @Override public void createEmployeeList(List<String> c) { String fileName =
 * "employeeList.dat"; try (FileOutputStream fos = new
 * FileOutputStream(fileName); ObjectOutputStream oos = new
 * ObjectOutputStream(fos);) { oos.writeObject(c);
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * @Override public List<String> readEmployeeList() { String fileName =
 * "employeeList.dat"; List<String> ret = null; try (FileInputStream fis = new
 * FileInputStream(fileName); ObjectInputStream ois = new
 * ObjectInputStream(fis);) { ret = (List<String>) ois.readObject(); } catch
 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * return ret; }
 * 
 * }
 */