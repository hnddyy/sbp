package com.example.sbp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sbp.domain.User;
import com.example.sbp.mapper.UserMapper;

@SpringBootTest
class SbpApplicationTests {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void testUserMapper() throws Exception {
		User user = mapper.getLoginInfo("test1");
		System.out.println("User >>" + user);
		assertEquals("김일",user.getUserName());
		
		String userName = mapper.getUserName("test2");
		assertEquals("김이", userName);
	}
	
	@Ignore @Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);
		
		try (Connection conn = ds.getConnection()){
			System.out.println("Coooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);
			
			assertEquals(100, getLong(conn, "select 100"));
			assertTrue(0 < getLong(conn, "select count(*) from USER"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Test
	void contextLoads() {
	}

}
