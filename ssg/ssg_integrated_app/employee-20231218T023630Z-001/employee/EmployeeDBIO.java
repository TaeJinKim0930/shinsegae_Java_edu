package employee;

import java.sql.*;
import java.util.ArrayList;

import student.Student;

import lib.ObjectDBIO;

public abstract class EmployeeDBIO extends ObjectDBIO implements EmployeeIO {

	public boolean insertStaff(Staff emp) {
		String strSql = "insert into EMPLOYEE values('" + emp.getENo() + "','" + emp.getName() + "'," + emp.getYear() + "," + 
		emp.getMonth() + "," + emp.getDate() + ",'" + emp.getRole() + "', null )";
		
		super.execute(strSql);
		return true;
	}
	
	public boolean insertSecretary(Secretary emp) {
		return insertStaff(emp);
	}
	
	public boolean insertManager(Manager emp) {
		ArrayList<Employee> resArray = searchEmployee(emp.getSecNo());
		if(resArray.isEmpty())
			return false;
		
		String strSql = "insert into EMPLOYEE values('" + emp.getENo() + "','" + emp.getName() + "'," + emp.getYear() + "," + 
		emp.getMonth() + "," + emp.getDate() + ",'" + emp.getRole() + "','" + emp.getSecNo() + "')";
		
		super.execute(strSql);
		return true;
	}
	
	public ArrayList<Employee> getEmployeeList(String strUserID) {
		ArrayList<Employee> resArray = new ArrayList<Employee>();
		String strSql = "select * from EMPLOYEE where (role != 'Manager') or (secno = '" + strUserID + "')";
		ResultSet rs = null;
		
		try {
			rs = super.execute(strSql, rs);
			while(rs.next()) {
				Employee emp = null;
				if(rs.getString("role").equals("Staff")) {
					emp = new Staff(rs.getString("eno"), rs.getString("name"), rs.getInt("enteryear"), 
							rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				else if(rs.getString("role").equals("Secretary")) {
					emp = new Secretary(rs.getString("eno"), rs.getString("name"), rs.getInt("enteryear"), 
							rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				else if(rs.getString("role").equals("Manager")) {
					emp = new Manager(rs.getString("eno"), rs.getString("secno"), rs.getString("name"), 
							rs.getInt("enteryear"), rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				resArray.add(emp);
			}
			rs.close();
			super.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resArray;
	}
	
	public ArrayList<Employee> searchEmployee(String strENo) {
		ArrayList<Employee> resArray = new ArrayList<Employee>();
		String strSql = "select * from EMPLOYEE where eno = '" + strENo + "'";
		ResultSet rs = null;
		
		try {
			rs = super.execute(strSql, rs);
			while(rs.next()) {
				Employee emp = null;
				if(rs.getString("role").equals("Staff")) {
					emp = new Staff(rs.getString("eno"), rs.getString("name"), rs.getInt("enteryear"), 
							rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				else if(rs.getString("role").equals("Secretary")) {
					emp = new Secretary(rs.getString("eno"), rs.getString("name"), rs.getInt("enteryear"), 
							rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				else if(rs.getString("role").equals("Manager")) {
					emp = new Manager(rs.getString("eno"), rs.getString("secno"), rs.getString("name"), 
							rs.getInt("enteryear"), rs.getInt("entermonth"), rs.getInt("enterday"));
				}
				resArray.add(emp);
			}
			rs.close();
			super.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resArray;
	}
}
