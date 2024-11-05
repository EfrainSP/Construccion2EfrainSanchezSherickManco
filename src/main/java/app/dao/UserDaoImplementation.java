
package app.dao;

import app.dao.interfaces.UserDao;
import AppDto.UserDto;
import app.dao.repositories.UserRepository;
import app.helpers.Helpers;
import app.model.Person;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public  class UserDaoImplementation implements UserDao {
        @Autowired
        UserRepository userRepository;
         public UserDto findByUsername(UserDto userDto) throws Exception {
             
		User user =userRepository.findByUsername(userDto.getUsername());
                if (user == null) {
        // Manejar el caso en que el usuario no fue encontrado
        throw new Exception("Usuario no encontrado");
    }
                return Helpers.parse(user);
	}
    public boolean existsByUsername(UserDto userDto) throws Exception {
		return userRepository.existsByUsername(userDto.getUsername());
		}
    public void createUser(UserDto userDto) throws Exception {
		User user = Helpers.parse(userDto);
		userRepository.save(user);
                userDto.setId(user.getId());
    }
}


    
   