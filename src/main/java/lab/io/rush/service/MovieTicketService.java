package lab.io.rush.service;

import lab.io.rush.exception.MovieTicketNotFoundException;
import lab.io.rush.model.MovieTicket;
import lab.io.rush.repository.MovieTicketRepository;

import java.util.*;

import org.springframework.stereotype.Service;


public interface MovieTicketService {

	//add
	public void addMovieTicket(MovieTicket movieTicket);
	
	public MovieTicket updateMovieTicket(MovieTicket movieTicket) throws MovieTicketNotFoundException;
	
	public void delMovieTicket(MovieTicket movieTicket) throws MovieTicketNotFoundException;
	
	public MovieTicket getMovieTicket(int id);
	
	public List<MovieTicket> getAllMovieTicket();
	
	
}
