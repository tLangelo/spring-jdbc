package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  DepartmentRepository implements CRUDInterface<Department> {
    private Connection conn;

    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Department> getAllEntities() {
        ArrayList<Department> departments = new ArrayList<>();
        String query;

        try{
            conn = DatabaseConnectionManager.getConnection();

            Statement stmt = conn.createStatement();
            query = "select * from departments";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int deptNum = rs.getInt("department_number");
                String deptName = rs.getString("department_name");
                String location = rs.getString("location");


                departments.add(new Department(deptNum,deptName,location));
            }

            return departments;

        }catch(SQLException e){
            System.out.println("in departmentRepo - method:getAllEntities()");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Department> getEntitiesByIDs(int id) {
        return null;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
