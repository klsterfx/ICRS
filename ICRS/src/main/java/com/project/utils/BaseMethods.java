package com.project.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.project.model.PredictionVO;

@Component
public class BaseMethods {

	public static String getUsername() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}
	
	public static void predictCollegeAPI(PredictionVO predictionVO) {
		try {
			URL url = new URL("http://127.0.0.1:5000/predict");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");

			// Set the request body data
			String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"courseName\"\r\n\r\n");
			sb.append(predictionVO.getCourseName()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"degreeName\"\r\n\r\n");
			sb.append(predictionVO.getDegreeName()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"collegeType\"\r\n\r\n");
			sb.append(predictionVO.getCollegeType()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"scholarships\"\r\n\r\n");
			sb.append(predictionVO.getScholarships()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"entranceExam\"\r\n\r\n");
			sb.append(predictionVO.getEntranceExam()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"library\"\r\n\r\n");
			sb.append(predictionVO.getLibrary()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"meritRank\"\r\n\r\n");
			sb.append(predictionVO.getMeritRank()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"sportComplex\"\r\n\r\n");
			sb.append(predictionVO.getSportComplex()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"tutionFeesRange\"\r\n\r\n");
			sb.append(predictionVO.getTutionFeesRange()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"placementPercentage\"\r\n\r\n");
			sb.append(predictionVO.getPlacementPercentage()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"year\"\r\n\r\n");
			sb.append(predictionVO.getYear()).append("\r\n");

			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"city\"\r\n\r\n");
			sb.append(predictionVO.getCityVO().getCityId()).append("\r\n");

			// getid
			sb.append("--").append(boundary).append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"predictionId\"\r\n\r\n");
			sb.append(predictionVO.getPredictionId()).append("\r\n");

			String requestBodyData = sb.toString();

			System.out.println(requestBodyData);

			// Enable output on the connection
			conn.setDoOutput(true);

			// Write the request body data to the connection output stream
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(requestBodyData);

			wr.writeBytes("\r\n--" + boundary + "--\r\n");
			wr.flush();
			wr.close();


			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			

			System.out.println("Output from Server .... \n");

			conn.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
