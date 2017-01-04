package lab.io.rush.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab.io.rush.model.MovieTicket;
import lab.io.rush.service.MovieTicketService;


@Controller
//@RequestMapping("/wel")  
public class MovieTicketController {

	@Autowired
	private MovieTicketService movieTicketService;
	  /**
     * 获取电影票
     *
     */
	@RequestMapping(value="/list")
	public @ResponseBody HashMap<String,List> list(){
		HashMap<String,List> t = new HashMap<String,List>();
		List<MovieTicket> mt= movieTicketService.getAllMovieTicket();
		t.put("mt", mt);

		 return t;
	}
 
	@RequestMapping(value="/getlist")
	public String getList(){
		return "getlist";
	}
    /**
     * 判断电影票抢购状态
     *
     * @param ticke 电影票对象
     * @return 返回状态字符串
     */
    public String getStatus( MovieTicket ticket) {
        Date date = new Date();
        if (ticket.getStartTime().after(date))
            return "未开始";
        else if (ticket.getEndTime().before(date))
            return "已结束";
        else
            return "正在抢购";
    }
	
}
