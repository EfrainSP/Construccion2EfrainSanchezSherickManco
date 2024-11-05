package app.dao;

import AppDto.PartnerDto;
import app.dao.interfaces.PersonDao;
import AppDto.PersonDto;
import app.helpers.Helpers;
import app.model.Person;
import app.dao.repositories.PersonRepository;
import app.model.Partner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Getter
@Setter
@NoArgsConstructor
public  class Persondaoimplementation implements PersonDao{
    
    @Autowired
    PersonRepository personrepository ;
    public boolean existsByCedula(PersonDto personDto) throws Exception {
        
        return personrepository.existsByCedula(Helpers.parse(personDto).getCedula());
        
	}
    public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		personrepository.save(person);
                personDto.setId(person.getId());
                
	}
    public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		personrepository.delete(person);
    }
    public PersonDto findByCedula(PersonDto personDto) throws Exception {
         Person person = personrepository.findByCedula(personDto.getCedula());
         return Helpers.parse(person);
	}	
   public PersonDto findById(PersonDto personDto) throws Exception {
       Person person = personrepository.findByid(personDto.getId());
        return Helpers.parse(person);
        
    }
	
}