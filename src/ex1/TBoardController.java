package ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class TBoardController {
	@RequestMapping(value="/save.kosta", method=RequestMethod.POST)
	
	public ModelAndView save(@ModelAttribute("tvo") TBoardVO tvo) {
		System.out.println("TVO: sub" + tvo.getSub());
		// Dao�� ������ �� ���� �ְ�, ����!
		return new ModelAndView("success");
	}
}
