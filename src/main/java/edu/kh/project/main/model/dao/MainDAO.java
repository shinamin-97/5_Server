package edu.kh.project.main.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class MainDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MainDAO() {
		try {
			String filePath = MainDAO.class.getResource("/edu/kh/project/sql/main-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 게시판 종류 조회 DAO
	 * @param conn
	 * @return boardTypeMap
	 * @throws Exception
	 */
	public Map<Integer, String> selectBoardType(Connection conn) throws Exception {
		Map<Integer, String> boardTypeMap = new HashMap<>();
		
		try {
			
			String sql = prop.getProperty("selectBoardType");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				boardTypeMap.put(rs.getInt(1), rs.getString(2));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return boardTypeMap;
	}
	
	
	
	

}
