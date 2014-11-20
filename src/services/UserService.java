package services;

import java.util.List;  

import javax.servlet.http.HttpServletRequest;

import vo.WoosongVO;
  
public interface UserService {  
  
 public void insertData(WoosongVO vo, HttpServletRequest requset);  
 public List<WoosongVO> getUserList();  
 public void deleteData(String num);  
 public WoosongVO getUser(String num);  
 public void updateData(WoosongVO vo);  
  
}  