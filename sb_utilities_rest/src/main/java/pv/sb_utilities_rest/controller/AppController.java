package pv.sb_utilities_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pv.sb_utilities_rest.dto.UtilityDto;
import pv.sb_utilities_rest.service.AppService;

@RestController
public class AppController {
	
	private AppService service;
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/utility/{uid}")
	private UtilityDto uDto(
				@PathVariable("uid") int utilityId
			) {
		
		UtilityDto uDto = service.getUtilityById(utilityId);
		
		return uDto;
	}
	

}
