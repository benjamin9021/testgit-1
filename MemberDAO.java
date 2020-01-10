import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {
	private static final String DRIVE = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "lwy";
	private static final String PASS = "1234";
	
	public MemberDAO() {
		try {
			Class.forName(DRIVE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set name = ?, did = ?, birth = ? where id = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getDid());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();
			System.out.println("회원정보가 수정되었습니다.");
			
		} catch (Exception e) {
			System.out.println("회원정보 수정에 실패하였습니다.");
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
