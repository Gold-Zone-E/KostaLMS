package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import jdbc.UserRowMapper;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vo.WoosongVO;

//create table woosong(
//num number primary key,
//writer varchar2(20),
//password varchar2(20),
//sub varchar2(100),
//content varchar2(200),
//wfile blob);
//commit;
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate JdbcTemplate;
	//DataSource dataSource;

	@Override
	public void insertData(WoosongVO vo, HttpServletRequest request) {		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into woosong ");
		sql.append("values(woosong_seq.nextVal,?,?,?,?,?)");
				
		MultipartFile file = vo.getWfile();

		HttpSession session = request.getSession();
		String r_path = session.getServletContext().getRealPath("/");
		String img_path = "img\\";
		
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		String oriFn = file.getOriginalFilename();
		path.append(oriFn);

		File f = new File(path.toString());
		try {
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//ModelAndView mav = new ModelAndView("success2");
		//mav.addObject("imgName", oriFn);
		//return mav;
		
		JdbcTemplate.update(
				sql.toString(),
				new Object[] { 
					vo.getWriter(), 
					vo.getPassword(), 
					vo.getSub(),
					vo.getContent(), 
					oriFn
		});
	}

	@Override
	public List<WoosongVO> getUserList() {
		List userList = new ArrayList();
		String sql = "select * from woosong";

		userList = JdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void updateData(WoosongVO vo) {
//		String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		jdbcTemplate.update(
//				sql,
//				new Object[] { user.getFirstName(), user.getLastName(),
//						user.getGender(), user.getCity(), user.getUserId() });
	}

	@Override
	public void deleteData(String id) {
		String sql = "delete from user where user_id=" + id;
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate.update(sql);

	}

	@Override
	public WoosongVO getUser(String num) {
//		List<User> userList = new ArrayList<User>();
//		String sql = "select * from user where user_id= " + id;
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		userList = jdbcTemplate.query(sql, new UserRowMapper());
//		return userList.get(0);
		return null;
	}

}