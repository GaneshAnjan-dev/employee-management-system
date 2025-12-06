package ems;

import java.io.*;
import java.util.*;

public class EmployeeService {
	private List<Employee> employees = new ArrayList<>();
	private static final String FILE_NAME = "employees.txt";

	public EmployeeService() {
		loadFromFile();
	}

	// Add Employee
	public void addEmployee(Employee emp) {
		employees.add(emp);
		saveToFile();
	}

	// View All Employees (Sorted by ID)
	public List<Employee> viewAll() {
		Collections.sort(employees);
		return employees;
	}

	// Search Employee by ID
	public Employee searchById(int id) {
		for (Employee emp : employees) {
			if (emp.getId() == id)
				return emp;
		}
		return null;
	}

	// Update Employee Details
	public boolean updateEmployee(int id, String name, String dept, double salary) {
		Employee emp = searchById(id);
		if (emp != null) {
			emp.setName(name);
			emp.setDept(dept);
			emp.setSalary(salary);
			saveToFile();
			return true;
		}
		return false;
	}

	// Delete Employee
	public boolean deleteEmployee(int id) {
		Employee emp = searchById(id);
		if (emp != null) {
			employees.remove(emp);
			saveToFile();
			return true;
		}
		return false;
	}

	// Save to File (Permanent Storage)
	private void saveToFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (Employee emp : employees) {
				bw.write(emp.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}

	// Load Data on Startup
	private void loadFromFile() {
		File file = new File(FILE_NAME);
		if (!file.exists())
			return;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				String dept = data[2];
				double salary = Double.parseDouble(data[3]);

				employees.add(new Employee(id, name, dept, salary));
			}
		} catch (IOException e) {
			System.out.println("Error loading file: " + e.getMessage());
		}
	}
}
