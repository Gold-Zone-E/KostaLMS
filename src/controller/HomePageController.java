package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import services.UserService;
import vo.WoosongVO;

@Controller
public class HomePageController {

	@Autowired
	UserService userService;

//	@RequestMapping("/add.kosta")
	// public ModelAndView registerUser(@ModelAttribute WoosongVO vo) {
	// public ModelAndView save(@ModelAttribute("tvo") TBoardVO tvo) {
	// public ModelAndView save(@RequestParam("wfile") MultipartFile wfile,
	// HttpServletRequest request) {
//	public ModelAndView registerUser(@ModelAttribute WoosongVO vo,
//			HttpServletRequest request) {
//		List<String> genderList = new ArrayList<String>();
//		genderList.add("male");
//		genderList.add("female");
//
//		List<String> cityList = new ArrayList<String>();
//		cityList.add("delhi");
//		cityList.add("gurgaon");
//		cityList.add("meerut");
//		cityList.add("noida");
//
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);
//		return new ModelAndView("register", "map", map);
//	}

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute WoosongVO vo) {

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		List<String> cityList = new ArrayList<String>();
		cityList.add("delhi");
		cityList.add("gurgaon");
		cityList.add("meerut");
		cityList.add("noida");

		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		return new ModelAndView("register", "map", map);
	}

	@RequestMapping(value = "/upsave.kosta", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("mfile") MultipartFile mfile,
			HttpServletRequest request) {
		System.out.println(mfile);

		// 이미지가 저장될 절대 경로를 지정
		// 세션을 생성
		HttpSession session = request.getSession();
		// 시스템에 맞는 documentroot 경로를 가져온다.
		String r_path = session.getServletContext().getRealPath("/");
		System.out.println(r_path);
		// 이미지를 업로드할 경로
		String img_path = "img\\";
		System.out.println(img_path);
		// 조합해서 이미지가 저장될 경로값을 구현!
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		// upload된 파일 이름을 path에 설정
		String oriFn = mfile.getOriginalFilename();
		path.append(oriFn);
		System.out.println(path);
		// 이미지가 저장될 절대 경로를 지정 끝 ------------------------
		// 파일 업로드
		File f = new File(path.toString());
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("success2");
		mav.addObject("imgName", oriFn);
		return mav;
	}
	
	@RequestMapping("/insert.kosta")
	//public String inserData(@ModelAttribute WoosongVO vo) {
	public String inserData(@ModelAttribute("vo") WoosongVO vo, HttpServletRequest request) {
		if (vo != null) 		
		userService.insertData(vo, request);
		return "redirect:/getList.kosta";
	}

	@RequestMapping("/getList.kosta")
	public ModelAndView getUserLIst() {
		List<WoosongVO> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList);
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam String id,
			@ModelAttribute WoosongVO vo) {
		//
		// user = userService.getUser(id);
		//
		// List<String> genderList = new ArrayList<String>();
		// genderList.add("male");
		// genderList.add("female");
		//
		// List<String> cityList = new ArrayList<String>();
		// cityList.add("delhi");
		// cityList.add("gurgaon");
		// cityList.add("meerut");
		// cityList.add("noida");
		//
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("genderList", genderList);
		// map.put("cityList", cityList);
		// map.put("user", user);
		//
		// return new ModelAndView("edit", "map", map);
		return null;
	}

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute WoosongVO vo) {
		userService.updateData(vo);
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return "redirect:/getList";
	}
}