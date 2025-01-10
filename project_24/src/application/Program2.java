package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: seller insert ===");
        Department newDepartment = new Department(null, "Fruits");
        departmentDao.insert(newDepartment);
        System.out.println("Insert completed");

        System.out.println("=== Test 2: seller findById ===");
        Department department =  departmentDao.findById(5);
        System.out.println(department);

        System.out.println("=== Test 3: seller findAll ===");
        List<Department> list = departmentDao.findAll();

        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("=== Test 4: seller update ===");
        Department departmentUpdate = new Department(7, "Cakes");
        departmentDao.update(departmentUpdate);
        System.out.println("Update completed");

        System.out.println("=== Test 5: seller deleteById ===");
        System.out.print("Enter the ID of the department to be deleted: ");
        int id = sc.nextInt();
        sc.nextLine();
        departmentDao.deleteById(id);

        sc.close();
    }
}
