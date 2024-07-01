package himedia.myportal.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import himedia.myportal.services.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;
	
	// 업로드 폼
	@RequestMapping({"", "/form"})
	public String form() {
		return "fileupload/form";
	}
	
	// 업로드 액션
	@PostMapping("/upload")
	public String upload(@RequestParam("file1") MultipartFile file1,
						Model model) {
		System.out.println("원본 파일명:" + file1.getOriginalFilename());
		System.out.println("파일 사이즈:" + file1.getSize());
		System.out.println("파라미터 이름:" + file1.getName());
		
		// 실제 파일로 저장
		String saveFilename = fileUploadService.store(file1);
		model.addAttribute("imageFilename", saveFilename);
		
		return "fileupload/result";
	}
	
	  private static final String UPLOAD_DIRECTORY = "uploads";
	
	 @GetMapping("/board/write")
	    public String showUploadForm() {
	        return "uploadForm";
	    }

	    @PostMapping("/board/write")
	    public String handleFileUpload(@RequestParam("title") String title,
	                                   @RequestParam("content") String content,
	                                   @RequestParam("file") MultipartFile file1,
	                                   Model model) {
	        if (file1.isEmpty()) {
	            model.addAttribute("message", "파일이 비어 있습니다.");
	            return "result";
	        }

	        try {
	            // 파일 저장
	            String uploadPath = new File(UPLOAD_DIRECTORY).getAbsolutePath();
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }
	            File uploadFile = new File(uploadPath + File.separator + file1.getOriginalFilename());
	            file1.transferTo(uploadFile);

	        

	            model.addAttribute("message", "파일 업로드 성공");
	        } catch (IOException e) {
	            model.addAttribute("message", "파일 업로드 실패: " + e.getMessage());
	        }

	        return "result";
	    }
	}


