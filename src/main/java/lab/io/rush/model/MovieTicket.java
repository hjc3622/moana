package lab.io.rush.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;


@Entity
public class MovieTicket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "movie_id", nullable = false)    
	private int movie_id;
    
	@Column(name = "name",length = 64, nullable = false)
	private String name;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "start_time", nullable = false)
	private Date startTime;
	
	@Column(name = "end_time", nullable = false)
	private Date endTime;
	
	@Column(name = "create_time", nullable = false)
	private Date createTime;

	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "MovieTicket [id=" + movie_id + ", name=" + name + ", startTime=" + startTime
				+ ", endtime=" + endTime + "]";
	}
}
