package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface<Employee>{
    private Connection conn;
    private PreparedStatement update;


    @Override
    public boolean create(Employee employee) {

            try {
                conn = DatabaseConnectionManager.getConnection();

                update = conn.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?)");
                update.setInt(1, employee.getEID());
                update.setString(2, employee.getName());
                update.setString(3, employee.getJob());
                update.setInt(4, employee.getManager());
                update.setString(5, employee.getHireDate());
                update.setInt(6, employee.getSalary());
                update.setInt(7, employee.getCommission());
                update.setInt(8, employee.getDepartmentNumber());
                update.executeUpdate();
                System.out.println(employee.getName() + " has been added");
                return true;
            } catch (SQLException e) {
                System.out.println("in employeeRepo - method:create()");
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        String query;
        Employee emp = null;

        try{
            conn = DatabaseConnectionManager.getConnection();

            Statement stmt = conn.createStatement();
            query = "select * from employees where id = '" + id + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int EID = rs.getInt("id");
                String name = rs.getString("employee_name");
                String job = rs.getString("job");
                int manager = rs.getInt("manager");
                String hireDate = rs.getString("hiredate");
                int salary = rs.getInt("salary");
                int commission = rs.getInt("commission");
                int deptNum = rs.getInt("department_number");

                emp = new Employee(EID,name,job,manager,hireDate,salary,commission,deptNum);

            }
            return emp;

        }catch(SQLException e){
            System.out.println("in employeeRepo - method:getSingleEntityById()");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
        ArrayList<Employee> employees = new ArrayList<>();
        String query;

        try{
            conn = DatabaseConnectionManager.getConnection();

            Statement stmt = conn.createStatement();
            query = "select * from employees";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int EID = rs.getInt("id");
                String name = rs.getString("employee_name");
                String job = rs.getString("job");
                int manager = rs.getInt("manager");
                String hireDate = rs.getString("hiredate");
                int salary = rs.getInt("salary");
                int commission = rs.getInt("commission");
                int deptNum = rs.getInt("department_number");


                employees.add(new Employee(EID,name,job,manager,hireDate,salary,commission,deptNum));
            }
            return employees;

        }catch(SQLException e){
            System.out.println("in employeeRepo - method:getAllEntities()");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> getEntitiesByIDs(int id) {
        ArrayList<Employee> employees = new ArrayList<>();
        String query;

        try{
            conn = DatabaseConnectionManager.getConnection();

            Statement stmt = conn.createStatement();
            query = "select * from employees where department_number = '" + id + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int EID = rs.getInt("id");
                String name = rs.getString("employee_name");
                String job = rs.getString("job");
                int manager = rs.getInt("manager");
                String hireDate = rs.getString("hiredate");
                int salary = rs.getInt("salary");
                int commission = rs.getInt("commission");
                int deptNum = rs.getInt("department_number");


                employees.add(new Employee(EID,name,job,manager,hireDate,salary,commission,deptNum));
            }
            return employees;

        }catch(SQLException e){
            System.out.println("in employeeRepo - method:getEntitiesByDep()");

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }


}
