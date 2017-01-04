package lab.io.rush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.io.rush.exception.UserNotFoundException;
import lab.io.rush.model.User;
import lab.io.rush.repository.UserRepository;
@Service("userService") 
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);		
	}

	@Override
	public User update(User user) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User us = userRepository.findOne(user.getUser_id());
		if(us==null) throw new UserNotFoundException();
		if(user.getEmail()!=null) us.setEmail(user.getEmail());
		if(user.getPassword()!=null) us.setPassword(user.getPassword());
		return null;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		User us = userRepository.findOne(id);
		return us;
	}

}
