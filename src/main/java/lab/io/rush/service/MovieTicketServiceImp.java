package lab.io.rush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import lab.io.rush.exception.MovieTicketNotFoundException;
import lab.io.rush.model.MovieTicket;
import lab.io.rush.repository.MovieTicketRepository;


@Service("movieTicketService") 
public class MovieTicketServiceImp implements MovieTicketService{

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	@Override
	public void addMovieTicket(MovieTicket movieTicket) {
		// TODO Auto-generated method stub
		movieTicketRepository.save(movieTicket);
	}

	@Override
	public MovieTicket updateMovieTicket(MovieTicket movieTicket) throws  MovieTicketNotFoundException{
		// TODO Auto-generated method stub
		MovieTicket mTicket=movieTicketRepository.findOne(movieTicket.getMovie_id());
		if(mTicket==null) throw new MovieTicketNotFoundException();
		if(movieTicket.getName()!=null)
			mTicket.setName(movieTicket.getName());
		if(movieTicket.getNumber()>=0)
			mTicket.setNumber(movieTicket.getNumber());
		if(movieTicket.getCreateTime()!=null)
			mTicket.setCreateTime(movieTicket.getCreateTime());
		if(movieTicket.getStartTime()!=null)
			mTicket.setStartTime(movieTicket.getStartTime());
		if(movieTicket.getEndTime()!=null)
			mTicket.setEndTime(movieTicket.getEndTime());
		movieTicketRepository.save(mTicket);
		return mTicket;
	}

	@Override
	public void delMovieTicket(MovieTicket movieTicket) throws MovieTicketNotFoundException{
		// TODO Auto-generated method stub
		MovieTicket mTicket = movieTicketRepository.findOne(movieTicket.getMovie_id());
		if(mTicket==null) throw new MovieTicketNotFoundException();
		else{
			movieTicketRepository.delete(mTicket);
		}
	}

	@Override
	public MovieTicket getMovieTicket(int id) {
		// TODO Auto-generated method stub
		return movieTicketRepository.findOne(id);
	}

	@Override
	public List<MovieTicket> getAllMovieTicket() {
		// TODO Auto-generated method stub
		return movieTicketRepository.findAll();
	}
	

}
