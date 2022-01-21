package mc.ys.jdbc;

import java.sql.Timestamp;

public class EmpVO {
	int empCode;
	String empName;
	int empAge;
	Timestamp empHiredate = System.currentTimeMillis();
	int empSalary = 3000;
	String deptCode;
	
	public EmpVO(int empCode, String empName, int empAge, Timestamp empHiredate, int empSalary, String deptCode) {
		this.empCode = empCode;
		this.empName = empName;
		this.empAge = empAge;
		this.empHiredate = empHiredate;
		this.empSalary = empSalary;
		this.deptCode = deptCode;
	}
	
	public EmpVO(int empCode, String empName, int empAge, String deptCode) {
		this.empCode = empCode;
		this.empName = empName;
		this.empAge = empAge;
		this.deptCode = deptCode;
	}

	public int getEmpCode() {
		return empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public String getEmpHiredate() {
		return empHiredate;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public String getDeptCode() {
		return deptCode;
	}
	
	
}
