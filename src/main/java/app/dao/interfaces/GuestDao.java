package app.dao.interfaces;

import AppDto.GuestDto;
import AppDto.UserDto;
import AppDto.PartnerDto;
import java.util.List;

public interface GuestDao {
   public boolean existsById(GuestDto GuestDto) throws Exception;
   public void createGuest(GuestDto GuestDto) throws Exception;
   public GuestDto getGuestById(long guestId) throws Exception;
   public void ActivateStatus(GuestDto guestDto) throws Exception;
   public GuestDto findByUserId(UserDto userDto) throws Exception;
}