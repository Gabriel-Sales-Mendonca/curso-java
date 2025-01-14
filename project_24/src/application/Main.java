package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Test 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> seller2 = sellerDao.findByDepartment(department);

        for (Seller obj : seller2) {
            System.out.println(obj);
        }

        System.out.println("=== Test 3: seller findAll ===");
        List<Seller> allSellers = sellerDao.findAll();

        for (Seller obj : allSellers) {
            System.out.println(obj);
        }

        System.out.println("=== Test 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);

        System.out.println("Update completed");

        System.out.println("=== Test 6: seller delete ===");
        System.out.print("Enter ID for delete test: ");
        int id = sc.nextInt();
        sc.nextLine();

        sellerDao.deleteById(id);

        System.out.println("Delete completed");

        sc.close();
    }
}