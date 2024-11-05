package app.dao.interfaces;

import AppDto.UserDto;

public interface UserDao {
    
	public UserDto findByUsername(UserDto userDto) throws Exception;

	public boolean existsByUsername(UserDto userDto) throws Exception;
	
	public void createUser(UserDto userDto) throws Exception;


}
