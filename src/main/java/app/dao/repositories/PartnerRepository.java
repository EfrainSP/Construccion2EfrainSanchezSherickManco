
package app.dao.repositories;

import AppDto.PartnerDto;
import app.model.Partner;
import app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Sherick
 */
@Repository
public interface PartnerRepository extends JpaRepository <Partner, Long> {


    
    public boolean existsById(Long id);

    public Partner findByUserId(User user);

    public Partner findByMoney(double monto);
    public Partner findByid(Long id);
    @Modifying
    @Transactional
    @Query("UPDATE Partner p SET p.money = :money WHERE p.userId.id = :userId")
    void updateMoneyByUserId(@Param("money") Double monto, @Param("userId") Long userId);
  
}
