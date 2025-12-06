package ems;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private String dept;
	private double salary;

	public Employee(int id, String name, String dept, double salary) {
		this.setId(id);
		this.setName(name);
		this.setDept(dept);
		this.setSalary(salary);
	}

	// Getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// For Sorting by ID by default
	@Override
	public int compareTo(Employee e) {

		return this.id - e.id;
	}

	// toString() for printing employee details
	@Override
	public String toString() {
		return id + "," + name + "," + dept + "," + salary;
	}

}
