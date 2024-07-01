package himedia.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
	// 업로드 폼
	@RequestMapping({"", "/form"})
	public String form() {
		return "fileupload/form";
	}

}
