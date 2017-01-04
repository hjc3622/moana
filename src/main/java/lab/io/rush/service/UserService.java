package lab.io.rush.service;

import lab.io.rush.exception.UserNotFoundException;
import lab.io.rush.model.User;

public interface UserService {

	public void add(User user);
	
	public User update(User user)throws UserNotFoundException;
	
	public User getUser(int id);
}
