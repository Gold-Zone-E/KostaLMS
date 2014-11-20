package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vo.WoosongVO;


public interface UserDao {
	public void insertData(WoosongVO vo, HttpServletRequest requset);

	public List<WoosongVO> getUserList();

	public void updateData(WoosongVO vo);

	public void deleteData(String num);

	public WoosongVO getUser(String num);

}