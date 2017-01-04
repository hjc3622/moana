package lab.io.rush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lab.io.rush.model.SnapRecord;

public interface SnapRecordRepository extends JpaRepository<SnapRecord,Integer>{

	@Query("select t from SnapRecord t Where t.u_id =?1")
	public SnapRecord selectByUid(int id);	
	
	@Query("select t from SnapRecord t Where t.m_id =?1")
	public List<SnapRecord> selectByMovieId(int movieId);
	
	@Query("select t from SnapRecord t where t.u_id =:uid and t.m_id =:mid")
	public List<SnapRecord> selectByUidAndMovieId(@Param("uid")int uid, @Param("mid")int mid);
}
