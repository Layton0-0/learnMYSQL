package mc.ys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class EmpDAO {
	public void testInsert() throws SQLException {
		String sql = "insert into emp(emp_name, emp_age, emp_hiredate, dept_code) "
				+ "values('kim',23,'2022-01-20 14:01:20','ABCDE');";
		// 커넥션 요청
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		// 쿼리와 결과가 통과하는 통로 만들기
		Statement stmt = null;
		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if(affectedCount > 0) {
			System.out.println("삽입 작업 완료");
		} else {
			System.out.println("삽입 작업 실패");
		}
		// 쿼리를 DB로 보내기 / 쿼리 결과 받기
		// 결과 처리하기
		// TODO Auto-generated catch block

		// 연결 종료하기 (가장 늦게 연결한 것부터 닫아야 함.)
		stmt.close();
		con.close();
	}
	
	public void testInsertV2() throws SQLException{
		String sql = "insert into emp(emp_name, emp_age, emp_hiredate, dept_code) values(?, ?, ?, ?);";
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "Jeong");
		pstmt.setInt(2, 28);
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		pstmt.setTimestamp(3, stamp);
		pstmt.setString(4, "ABCDE");
		
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount > 0) {
			System.out.println("정상 삽입 완료");
		} else {
			System.out.println("삽입실패");
		}
		
		cm.closeConnection(con, pstmt, null);
		
	}

	public void testConnection() {
		// mysql에 접속하여 커넥션 객체가 만들어져서 전달되는지 확인하는 코드
		// 커넥션 객체는 ConnectionManager 클래스의 getConnection메소드를 호출하여 전달받는다.
		// ConnectionManager 클래스의 패키지는 실행클래스와 동일하다.
		Connection con = new ConnectionManager().getConnection();

		if (con != null) {
			System.out.println("연결되었습니다.");
		} else {
			System.out.println("연결되지 않았습니다.");
		}

	}

	public void testQuery() {
		String sql = "select * from usertbl";
		// 커넥션 요청
		Connection con = new ConnectionManager().getConnection();
		// 쿼리와 결과가 통과하는 통로 만들기
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			// 쿼리를 DB로 보내기 / 쿼리 결과 받기
			rs = stmt.executeQuery(sql);
			// 결과 처리하기
			while (rs.next()) {
				System.out.printf("%s %s %s %n", rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결 종료하기 (가장 늦게 연결한 것부터 닫아야 함.)
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void testQuery2() {
		String sql = "select emp_name, emp_age, emp_hiredate from emp;";
		// 커넥션 요청
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		// 쿼리와 결과가 통과하는 통로 만들기
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			// 쿼리를 DB로 보내기 / 쿼리 결과 받기
			rs = stmt.executeQuery(sql);
			// 결과 처리하기
			while (rs.next()) {
				System.out.printf("%s %s %s %n", rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결 종료하기 (가장 늦게 연결한 것부터 닫아야 함.)
			cm.closeConnection(con, stmt, rs);
		}

	}
	
	public void testQuery3() {
		String sql = "select * from emp;";
		// 커넥션 요청
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		// 쿼리와 결과가 통과하는 통로 만들기
		Statement stmt = null;
		ResultSet rs = null;
		//ArrayList<EmpVO>를 사용하여 레코드를 EmpVO인스턴스를 생성하여 저장하는 코드 작성하시오.
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO vo = null;
		try {
			stmt = con.createStatement();
			// 쿼리를 DB로 보내기 / 쿼리 결과 받기
			rs = stmt.executeQuery(sql);
			// 결과 처리하기
			while (rs.next()) {
				System.out.printf("%s %s %s %n", rs.getString(1), rs.getString(2), rs.getString(3));
				int empCode = rs.getInt("emp_code");
				String empName = rs.getString("emp_name");
				int empAge = rs.getInt("emp_age");
				Timestamp empHiredate = rs.getTimestamp("emp_hiredate");
				int empSalary = rs.getInt("emp_salary");
				String deptCode = rs.getString("dept_code");
				vo = new EmpVO(empCode, empName, empAge, empHiredate, empSalary, deptCode);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 연결 종료하기 (가장 늦게 연결한 것부터 닫아야 함.)
			cm.closeConnection(con, stmt, rs);
		}

	}
}
