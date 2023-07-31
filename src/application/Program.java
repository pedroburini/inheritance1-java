package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("enter the number of employees: ");
		int n = sc.nextInt();
		
		int i = 0;
		for (i=0; i<n; i++) {
			System.out.println("employee #" + (i + 1) + " data: ");
			System.out.print("outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("hours: ");
			int hours = sc.nextInt();
			System.out.print("value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (outsourced == 'y') {
				System.out.print("additional charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("payments: ");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}
}
