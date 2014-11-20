package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import vo.WoosongVO;

public class UserExtractor implements ResultSetExtractor<WoosongVO> {

	public WoosongVO extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {

		WoosongVO vo = new WoosongVO();

		vo.setNum(resultSet.getInt(1));
		vo.setWriter(resultSet.getString(2));
		vo.setPassword(resultSet.getString(3));
		vo.setSub(resultSet.getString(4));
		vo.setFile_path(resultSet.getString(5));
		
		return vo;
	}

}