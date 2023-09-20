package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CollegeVO;
import com.project.service.CollegeService;
import com.project.utils.BaseMethods;

@Controller
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping(value = "/admin/addCollege")
	public ModelAndView adminIndex() {
		
		String username = BaseMethods.getUsername();
		
		return new ModelAndView("admin/addCollege","collegeVO",new CollegeVO());
	}
	
	@PostMapping(value = "/admin/saveCollege")
	public ModelAndView addColleges(@ModelAttribute CollegeVO collegeVO){
		
		System.out.println("clg name :: " + collegeVO.getCollegeName());
		this.collegeService.saveCollege(collegeVO);
		
		return new ModelAndView("redirect:/admin/addCollege");
	}
	
	@GetMapping(value = "/admin/viewColleges")
	public ModelAndView viewColleges(@ModelAttribute CollegeVO collegeVO){
		
		List<CollegeVO> colleges = this.collegeService.searchCollege();
		
		return new ModelAndView("/admin/viewCollege","colleges",colleges);
	}
	
	@GetMapping(value = "/admin/editCollege")
	public ModelAndView editColleges(@RequestParam int id){
		
		List<CollegeVO> colleges = this.collegeService.getCollegeById(id);
		CollegeVO collegeVO = colleges.get(0);
		 
		return new ModelAndView("/admin/addCollege","collegeVO",collegeVO);
	}
	
	@GetMapping(value = "/admin/deleteCollege")
	public ModelAndView deleteColleges(@RequestParam int id){
		
		List<CollegeVO> colleges = this.collegeService.getCollegeById(id);
		CollegeVO collegeVO = colleges.get(0);
		 
		collegeVO.setStatus(false);
		this.collegeService.saveCollege(collegeVO);
		
		return new ModelAndView("redirect:/admin/viewColleges");
	}
}
