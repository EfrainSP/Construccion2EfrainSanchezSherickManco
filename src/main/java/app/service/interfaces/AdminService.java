package app.service.interfaces;

import AppDto.PartnerDto;
import AppDto.UserDto;

public interface AdminService {
    
	public void createPartner(PartnerDto PartnerDto) throws Exception;
}
