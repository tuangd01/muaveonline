package io.github.tubean.eureka.image.controller;

import io.github.tubean.eureka.image.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
		
	@RequestMapping("/images")
	public List<Image> getImages() {
		int random_int = (int)(Math.random()*(50-25+1)+25);
		List<Image> images = new ArrayList<Image>();
		for(int i = 0; i < random_int;i++) {
			int random_num = (int)(Math.random()*(50-25+1)+25);
			int random_url = (int)(Math.random()*(50-25+1)+25);
			images.add(new Image(i,"Số"+random_num,"vja.com/booking/"+i+"/"+random_url+"/"+random_num));
		}
			
		return images;
	}
}