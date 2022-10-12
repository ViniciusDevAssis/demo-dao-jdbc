package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		List<Department> list = depDao.findAll();
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = depDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: seller findAll ====");
		list = depDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department newDep = new Department(null, "Tools");
		depDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: departement update ====");
		dep = depDao.findById(7);
		dep.setNome("Utilities");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
	}

}
