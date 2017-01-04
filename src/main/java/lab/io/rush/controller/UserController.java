package lab.io.rush.controller;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab.io.rush.model.User;
import lab.io.rush.repository.UserRepository;
import lab.io.rush.service.UserService;
import redis.clients.jedis.Jedis;

@Controller 
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
    /**
     * 登录接口
     *
     * @param email 电子邮箱
     * @return 登录状态
     * @throws Exception 
     */
		@RequestMapping(value = "/login",method=RequestMethod.POST)
    public @ResponseBody ModelAndView login(HttpSession session, @RequestParam String email,@RequestParam String password) throws Exception{
			String pattern = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(email);
            if(!m.matches()){
                throw new Exception("邮箱格式不正确！");
            				}
								System.out.println("email:" + email);
            				User user = new User();
            				user.setEmail(email);
            				user.setPassword(password);
            				user.setUser_id(1);
            				userService.add(user);
            			   User user2 =userRepository.selectByEmailAndPassword(email, password);
					System.out.println("--------------------"+"user_id = "+user2.getUser_id());
            			   session.setAttribute("user_id", user2.getUser_id());
            			   					
            			   Jedis jedis = new Jedis("localhost");
            			   jedis.set("email", user2.getEmail());
            			   return new ModelAndView("redirect:/getlist");
		}
		@RequestMapping(value = "/tologin")
		public String toLogin(){
			return "login";
		}
		}
