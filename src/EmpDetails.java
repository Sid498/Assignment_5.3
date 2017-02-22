import java.util.Scanner;

abstract class Employee {
	int EmpId, Total_leaves = 30;
	String EmpName;
	double total_Salary;
	Scanner sc = new Scanner(System.in);

	abstract void calculate_balance_leaves();

	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);

	abstract void calculate_salary();
}

class PermanentEmp extends Employee {
	int paid_leave, sick_leave, casual_leave;
	double basic, hra, pf;

	void print_leave_details() {
		System.out.println("Enter Paid Leave of Permanent employee ");
		paid_leave = sc.nextInt();
		System.out.println("Enter Sick Leave of Permanent employee ");
		sick_leave = sc.nextInt();
		System.out.println("Enter Casual Leave of Permanent employee ");
		casual_leave = sc.nextInt();
		System.out.println("Paid Leave of employee " + paid_leave + "\n" + "Sick Leave of employee " + sick_leave + "\n"
				+ "Casual Leave of employee " + casual_leave);
	}

	void calculate_balance_leaves() {
		int balance_leaves = Total_leaves - (paid_leave + sick_leave + casual_leave);
		System.out.println("balance leaves of Permanent employee " + balance_leaves);
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		no_of_leaves = paid_leave + sick_leave + casual_leave;
		System.out.println("Number of Leaves is " + no_of_leaves);

		return false;
	}

	void calculate_salary() {
		System.out.println("Please enter salary of Permanent employee ");
		basic=sc.nextDouble();
		pf = basic * 12 / 100;
		hra = basic * 50 / 100;
		total_Salary = basic + hra - pf;
		System.out.println("Permant Emp Salary " + total_Salary);
	}

}

class TemporaryEmp extends Employee {
	int paid_leave, sick_leave, casual_leave;
	double basic, hra, pf;

	void calculate_balance_leaves() {
		System.out.println("Enter Paid Leave of Temporary employee ");
		paid_leave = sc.nextInt();
		System.out.println("Enter Sick Leave of Temporary employee ");
		sick_leave = sc.nextInt();
		System.out.println("Enter Casual Leave of Temporary employee ");
		casual_leave = sc.nextInt();
		int balance_leaves = Total_leaves - (paid_leave + sick_leave + casual_leave);
		System.out.println("balance leaves Temporary of employee " + balance_leaves);
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		return false;
	}

	void calculate_salary() {
		System.out.println("Please enter salary of Temporary employee ");
		basic=sc.nextDouble();
		pf = basic * 12 / 100;
		hra = basic * 50 / 100;
		total_Salary = basic + hra - pf;
		System.out.println("Temporary Emp salary " + total_Salary);
	}

}

public class EmpDetails {

	public static void main(String[] args) {
		char c;
		System.out.println("Press P for Permanent Employee ");
		System.out.println("Press T for Permanent Employee ");
		Scanner sc=new Scanner(System.in);
		c=sc.nextLine().toUpperCase().charAt(0);
		switch(c){
		case 'P':
		
		PermanentEmp pe=new PermanentEmp();
		pe.calculate_salary();
		pe.print_leave_details();
		pe.calculate_balance_leaves();
		
		case 'T':
		TemporaryEmp te = new TemporaryEmp();
		te.calculate_salary();
		te.calculate_balance_leaves();
		}
	}

}
