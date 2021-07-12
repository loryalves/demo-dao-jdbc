package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST 1: Department findById ====");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n==== TEST 2: Department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3: Department insert ====");
        Department newDepartment = new Department(null, "Cosmectics");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n==== TEST 4: Department update ====");
        department = departmentDao.findById(5);
        department.setName("Foods");
        departmentDao.update(department);
        System.out.println("Department Updated!");

        System.out.println("\n==== TEST 5: Department delete ====");
        System.out.print("Digite o código do departamento que deseja excluir: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Departamento deletado com sucesso!");

        sc.close();
    }
}
