package lab.io.rush.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lab.io.rush.exception.MovieTicketNotFoundException;
import lab.io.rush.model.MovieTicket;
import lab.io.rush.model.SnapRecord;
import lab.io.rush.service.MovieTicketService;
import lab.io.rush.service.SnapRecordService;
import lab.io.rush.service.UserService;
import lab.io.rush.service.mailUtil;

@Controller
public class SnapTicketController {

	@Autowired
	private UserService userService;
	@Autowired
	private SnapRecordService snapRecordService;
	@Autowired
	private MovieTicketService movieTicketService;
	@Autowired
	private mailUtil mailUtil;
	   /**
     * 电影票抢购接口
     *
     * @param movieId 电影票编号
     * @return json数据  包含抢购的状态信息和抢购记录
	 * @throws MovieTicketNotFoundException 
     */
    @RequestMapping("/snap/{movieId}")
    public String snapMovieTicket(@PathVariable Integer movieId,
                                          HttpSession session) throws MovieTicketNotFoundException {
    	Integer userid = (Integer)session.getAttribute("user_id");
    		System.out.println(userid+"-----"+movieId);
    	   SnapRecord snapRecord = new SnapRecord();
    	   snapRecord.setM_id(movieId);
    	   snapRecord.setU_id(userid);
    	   snapRecord.setSnapTime(new Date());
    	 if(snapRecordService.canTouch(userid, movieId))
    	 { snapRecordService.insert(snapRecord);
    	 MovieTicket movieTicket = movieTicketService.getMovieTicket(movieId);
    	 movieTicket.setNumber(movieTicket.getNumber()-1);
    	 System.out.println("--------number="+movieTicket.getNumber()+"------");
    	 movieTicketService.updateMovieTicket(movieTicket);
    	 String email = userService.getUser(userid).getEmail();
    	 	 System.out.println(email);
    	 mailUtil.send(email, "XXX抢票系统", "恭喜你！抢票成功！");
    	 
    	 return "success";
    	 	}
    	 else return "false";
    	}
}
