package app.dao.repositories;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sherick
 */

@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    public User findByUsername(String Username);

    public boolean existsByUsername(String Username);
    
}
