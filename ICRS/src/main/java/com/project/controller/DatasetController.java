package com.project.controller;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DatasetVO;
import com.project.service.DatasetService;

@Controller
public class DatasetController {
	
	@Autowired
	private DatasetService dataSetService;	
	
	@GetMapping(value = "admin/uploadDataSet")
	public ModelAndView uploadDataSet() {
		return new ModelAndView("admin/uploadDataSet");
	}
	
	@PostMapping(value = "admin/saveDataSet")
	public ModelAndView saveDataSet(HttpServletRequest request,
			@RequestParam("file") List<MultipartFile> file, @RequestParam String fileName) {
		
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println("the path is :: " + path);
		String addDataSetFilePath = path + "documents\\datasetfiles\\";
		
		System.out.println("the addDataSetFilePath is :: " + addDataSetFilePath);
		
		for (MultipartFile multipartFile : file) {
			
			UUID uuid = UUID.randomUUID();

			StringTokenizer st = new StringTokenizer(multipartFile.getOriginalFilename(), ".");

			String extension = "";

			while (st.hasMoreTokens()) {
				extension = st.nextToken();
			}

			String dataSetFileToInsert = uuid + "." + extension;
			
			fileName += extension;
			
			try {
				byte barr[] = multipartFile.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(
						new FileOutputStream(addDataSetFilePath + "/" + dataSetFileToInsert));

				bout.write(barr);
				bout.flush();
				bout.close();
			
				DatasetVO datasetModel = new DatasetVO();
				
				datasetModel.setName(fileName);
				datasetModel.setDatasetFileName(dataSetFileToInsert);
				datasetModel.setDatasetPathName(addDataSetFilePath);
				
				this.dataSetService.saveDataSetVO(datasetModel);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/admin/uploadDataSet");
	}
	
	@GetMapping(value = "admin/viewDataSets")
	public ModelAndView viewDatasets() {
		
		List<DatasetVO> datasetList = this.dataSetService.getAllDatasetFiles();
		return new ModelAndView("admin/viewDatasets","datasetList",datasetList);
	}
	
}
