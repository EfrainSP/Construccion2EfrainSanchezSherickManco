package app.dao.interfaces;

import AppDto.PartnerDto;
import AppDto.UserDto;
import app.model.User;
import java.sql.Date;
import java.util.List;

public interface PartnerDao {

    public void createPartner(PartnerDto partnerDto) throws Exception;

    public PartnerDto findByUserId(UserDto userDto) throws Exception;

    public PartnerDto findByid(PartnerDto PartnerDto) throws Exception;

    public boolean existsById(UserDto UserDto) throws Exception;
    
    public PartnerDto getMoneyByPartner(double getMoney) throws Exception;
    
    public void addfunds(PartnerDto partnerDto) throws Exception;
}
