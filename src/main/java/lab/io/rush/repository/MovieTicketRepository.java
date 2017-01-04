package lab.io.rush.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.io.rush.model.MovieTicket;


public interface MovieTicketRepository extends JpaRepository<MovieTicket, Integer>{

}
