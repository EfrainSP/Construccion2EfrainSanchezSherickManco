
package app.dao.repositories;

import app.model.Guest;
import app.model.Partner;
import app.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sherick
 */
@Repository
public interface GuestRepository extends JpaRepository <Guest, Long>{

    public boolean existsById(Long id);
    Optional<Guest> findById(Long guestId);

    public Guest findByUser(User user);
    
}
