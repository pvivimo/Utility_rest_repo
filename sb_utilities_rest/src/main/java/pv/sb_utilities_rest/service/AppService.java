package pv.sb_utilities_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pv.sb_utilities_rest.db.Database;
import pv.sb_utilities_rest.dto.UtilityDto;
import pv.sb_utilities_rest.model.Utility;

@Service
public class AppService {
	
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public UtilityDto getUtilityById(int utilityId) {
		
		UtilityDto uDto = null;
		
		Utility utility = db.getUtilityById(utilityId);
		if(utility != null) {
			
			uDto = new UtilityDto(
						utility.getId(),
						utility.getName()
					);
					
		}
		
		return uDto;
	}

}
