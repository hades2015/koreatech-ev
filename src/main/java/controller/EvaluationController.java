package controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/evaluation")
@Controller
public class EvaluationController {

	@RequestMapping("")
	public String evaluationMain(HttpSession session) {

		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("userInfo", user);

		return "evaluation";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createEvaluationView() {

		return "new_evaluation";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createEvaluation() {

		return "redirect:/evaluation/detail";
	}
}