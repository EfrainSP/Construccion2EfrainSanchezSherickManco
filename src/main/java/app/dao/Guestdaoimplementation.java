
package app.dao;

import AppDto.GuestDto;
import AppDto.PartnerDto;
import AppDto.UserDto;
import app.helpers.Helpers;
import app.model.Guest;
import app.dao.interfaces.GuestDao;
import app.dao.repositories.GuestRepository;
import app.model.Partner;
import app.model.User;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sherick
 */
@Service
@Getter
@Setter
@NoArgsConstructor
public class Guestdaoimplementation  implements GuestDao{
    @Autowired
    GuestRepository guestrepository;
    
    
   
       public GuestDto findByUserId(UserDto userDto) throws Exception {
        User user = Helpers.parse(userDto);
        Guest guest = guestrepository.findByUser(user);
        if (guest == null) {
            return null;
        }
        return Helpers.parse(guest);
    }
    @Override
     public boolean existsById(GuestDto GuestDto) throws Exception {
         return guestrepository.existsById(GuestDto.getId());
                
	}
    @Override
      public void createGuest(GuestDto GuestDto) throws Exception {	
	Guest guest = Helpers.parse(GuestDto);
        guestrepository.save(guest);
        GuestDto.setId(guest.getId());
	}
      @Override
     public GuestDto getGuestById(long guestId) throws Exception{
         Optional<Guest> optionalGuest = guestrepository.findById(guestId);
               return Helpers.parse(optionalGuest.get());
             
     }
     
     public void ActivateStatus(GuestDto guestDto) throws Exception{
         Guest  guest= Helpers.parse(guestDto);
         guestrepository.save(guest);
     }
}
