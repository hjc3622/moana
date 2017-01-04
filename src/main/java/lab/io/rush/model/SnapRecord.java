package lab.io.rush.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SnapRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id", nullable = false)    
	private int id;
	@Column(name = "user_id", nullable = false)
	private int u_id;
	@Column(name = "movie_id",nullable = false)
	private int m_id;
	@Column(name = "snap_time", nullable = false)
	private Date snapTime;
	@Column(name = "number", nullable = false)
	private int num;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSnapTime() {
		return snapTime;
	}
	public void setSnapTime(Date snapTime) {
		this.snapTime = snapTime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
