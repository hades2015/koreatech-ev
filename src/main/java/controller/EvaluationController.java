package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/evaluation")
@Controller
public class EvaluationController {
	
	@RequestMapping("")
	public String evaluationMain() {
		return "evaluation";
	}
}
