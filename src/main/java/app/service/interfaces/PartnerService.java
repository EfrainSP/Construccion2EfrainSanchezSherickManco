
package app.service.interfaces;

import AppDto.GuestDto;
import AppDto.PartnerDto;
import AppDto.UserDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto) throws Exception;
    
     GuestDto getGuestById(long guestId) throws Exception;
     
     public void updateGuestStatus(GuestDto guestDto) throws Exception;
     
      public void addfunds () throws Exception;
      
      public void createinvoice() throws Exception;
}
