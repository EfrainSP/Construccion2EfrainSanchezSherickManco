
package app.dao.repositories;

import AppDto.PersonDto;
import app.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.Person;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository <Person,Long> {

    public boolean existsByCedula(Long cedula);
    public Person findByCedula(Long cedula);
    public Person findByid(Long id);

}
