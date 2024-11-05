package app.service.interfaces;

import AppDto.UserDto;

public interface LoginService {
	public void login(UserDto userDto) throws Exception;
	public void logout();
}
