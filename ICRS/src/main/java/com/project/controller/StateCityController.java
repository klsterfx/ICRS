package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CityVO;
import com.project.model.StateVO;
import com.project.service.StateCityService;

@Controller
public class StateCityController {

	@Autowired
	private StateCityService stateCityServices;

	/******* for City CRUD ********/

	@GetMapping(value = "admin/addCity")
	public ModelAndView addCity() {

		List<StateVO> stateList = this.stateCityServices.searchState();

		return new ModelAndView("admin/addCity", "cityVO", new CityVO()).addObject("stateList", stateList);
	}

	@PostMapping(value = "admin/saveCity")
	public ModelAndView saveCity(@ModelAttribute CityVO cityVO) {

		this.stateCityServices.saveCity(cityVO);

		return new ModelAndView("redirect:/admin/addCity");
	}

	@GetMapping(value = "admin/viewCities")
	public ModelAndView saveCity() {

		List<CityVO> cityList = this.stateCityServices.searchCity();

		return new ModelAndView("admin/viewCities", "cityList", cityList);
	}
	
	@GetMapping(value = "admin/editCity")
	public ModelAndView editCity(@RequestParam int id) {

		List<CityVO> cityList = this.stateCityServices.getCityById(id);
		
		List<StateVO> stateList = this.stateCityServices.searchState();

		return new ModelAndView("admin/addCity", "cityVO", cityList.get(0)).addObject("stateList", stateList);
	}
	
	@GetMapping(value = "admin/deleteCity")
	public ModelAndView deleteCity(@RequestParam int id) {

		List<CityVO> cityList = this.stateCityServices.getCityById(id);
		CityVO cityVO = cityList.get(0);
		cityVO.setStatus(false);
		
		this.stateCityServices.saveCity(cityVO);

		return new ModelAndView("redirect:/admin/viewStates");
	}



	/************** for state CRUD ****************/

	@GetMapping(value = "admin/addState")
	public ModelAndView addState() {
		return new ModelAndView("admin/addState", "stateVO", new StateVO());
	}

	@PostMapping(value = "admin/saveState")
	public ModelAndView saveCity(@ModelAttribute StateVO stateVO) {

		this.stateCityServices.saveState(stateVO);
		return new ModelAndView("redirect:/admin/addState");
	}

	@GetMapping(value = "admin/viewStates")
	public ModelAndView saveStates() {

		List<StateVO> stateList = this.stateCityServices.searchState();

		System.out.println("State list" + stateList);

		return new ModelAndView("admin/viewStates","stateList", stateList);
	}
	
	@GetMapping(value = "admin/editState")
	public ModelAndView editState(@RequestParam int id) {

		List<StateVO> StateList = this.stateCityServices.getStateById(id);

		return new ModelAndView("admin/addState", "stateVO", StateList.get(0));
	}
	
	@GetMapping(value = "admin/deleteState")
	public ModelAndView deleteState(@RequestParam int id) {

		List<StateVO> stateList = this.stateCityServices.getStateById(id);
		StateVO stateVO = stateList.get(0);
		stateVO.setStatus(false);
		
		this.stateCityServices.saveState(stateVO);

		return new ModelAndView("redirect:/admin/viewStates");
	}

}
