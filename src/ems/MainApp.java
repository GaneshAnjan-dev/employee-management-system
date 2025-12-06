package ems;

import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== Employee Management System =====");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Search Employee by ID");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Department: ");
				String dept = sc.nextLine();
				System.out.print("Enter Salary: ");
				double salary = sc.nextDouble();

				service.addEmployee(new Employee(id, name, dept, salary));
				System.out.println("Employee Added Successfully!");
				break;

			case 2:
				List<Employee> list = service.viewAll();
				System.out.println("\n--- Employee List ---");
				for (Employee e : list) {
					System.out.println(e);
				}
				break;

			case 3:
				System.out.print("Enter Employee ID: ");
				int searchId = sc.nextInt();
				Employee emp = service.searchById(searchId);
				if (emp != null)
					System.out.println("Employee Found: " + emp);
				else
					System.out.println("Employee Not Found!");
				break;

			case 4:
				System.out.print("Enter Employee ID: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Name: ");
				String newName = sc.nextLine();
				System.out.print("Enter New Dept: ");
				String newDept = sc.nextLine();
				System.out.print("Enter New Salary: ");
				double newSalary = sc.nextDouble();

				if (service.updateEmployee(updateId, newName, newDept, newSalary))
					System.out.println("Updated Successfully!");
				else
					System.out.println("Employee Not Found!");
				break;

			case 5:
				System.out.print("Enter Employee ID: ");
				int deleteId = sc.nextInt();
				if (service.deleteEmployee(deleteId))
					System.out.println("Deleted Successfully!");
				else
					System.out.println("Employee Not Found!");
				break;

			case 6:
				System.out.println("Thank you! Exiting...");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice! Try Again.");
			}
		}
	}
}
