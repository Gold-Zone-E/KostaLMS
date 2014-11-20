package services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import vo.WoosongVO;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public void insertData(WoosongVO vo, HttpServletRequest request) {
		userdao.insertData(vo, request);
	}
	
	@Override
	public List<WoosongVO> getUserList() {
		return userdao.getUserList();
	}
	
	@Override
	public void deleteData(String num) {
		userdao.deleteData(num);
	}

	@Override
	public WoosongVO getUser(String num) {
		return userdao.getUser(num);
	}

	@Override
	public void updateData(WoosongVO vo) {
		userdao.updateData(vo);
	}

}