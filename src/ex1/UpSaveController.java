package ex1;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UpSaveController {
	@RequestMapping(value="/upsave.kosta", method=RequestMethod.POST)
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
}
