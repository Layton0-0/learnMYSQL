package mc.ys.jdbc;

import java.sql.SQLException;

public class DatabaseMain {

	public static void main(String[] args) {
		DatabaseMain dm = new DatabaseMain();
		dm.testCRUD();

	}
	
	public void testCRUD() {
		EmpDAO dao = new EmpDAO();
		try {
			dao.testInsertV2();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//dm.testQuery2();
	}


}
