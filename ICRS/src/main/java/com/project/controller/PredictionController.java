package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.PredictedCollege;
import com.project.model.CityVO;
import com.project.model.PredictionVO;
import com.project.model.StateVO;
import com.project.service.PredictionService;
import com.project.service.StateCityService;
import com.project.utils.BaseMethods;

@Controller
public class PredictionController {

	@Autowired
	private PredictionService predictionService;

	@Autowired
	private StateCityService stateCityService;

	@GetMapping(value = "user/addPredictionParameters")
	public ModelAndView addPredictionDetails() {

		/* List<CollegeVO> collegeList = this.collegeService.searchCollege(); */

		List<StateVO> stateList = this.stateCityService.searchState();

		return new ModelAndView("user/addPredictionParameter", "predictionVO", new PredictionVO())
				.addObject("stateList", stateList);
	}

	@PostMapping(value = "user/savePredictionParameters")
	public ModelAndView savePredictionParameters(@ModelAttribute PredictionVO predictionVO) {

		this.predictionService.savePredictionVO(predictionVO);

		System.out.println("prediction id :::" + predictionVO.getPredictionId());

		BaseMethods.predictCollegeAPI(predictionVO);

		return new ModelAndView("redirect:/user/addPredictionParameters");
	}

	@GetMapping(value = "user/getCitiesByStateId")
	public ResponseEntity getCitiesByStateId(@RequestParam int id) {

		List<CityVO> cityList = this.stateCityService.getCityByStateId(id);

		return new ResponseEntity<>(cityList, HttpStatus.OK);
	}

	@GetMapping(value = "user/viewPrediction")
	public ModelAndView viewPrediction() {

		List<Object[]> predictionList = new ArrayList<>();
		predictionList = predictionService.searchPredictionCollegeDetails();

		List<PredictedCollege> predictedCollegeList = new ArrayList<>();
		for (Object[] ls1 : predictionList) {
			PredictedCollege college = new PredictedCollege();
			college.setPredictedCollege(ls1[0].toString());
			college.setCollegeType(ls1[1].toString());
			college.setCourseName(ls1[2].toString());
			college.setDegreeName(ls1[3].toString());
			college.setPlacementPercentage(ls1[4].toString());
			college.setTutionFeesRange(ls1[5].toString());
			predictedCollegeList.add(college);
		}
		System.out.println(predictedCollegeList.get(0));
		System.out.println(predictedCollegeList.size());

		return new ModelAndView("user/viewPredictions", "predictedCollegeList", predictedCollegeList);

	}

}
