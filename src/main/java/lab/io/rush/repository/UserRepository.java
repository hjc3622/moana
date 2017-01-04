package lab.io.rush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lab.io.rush.model.SnapRecord;
import lab.io.rush.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	@Query("select t from User t where t.email =:email and t.password =:password")
	public User selectByEmailAndPassword(@Param("email")String email, @Param("password")String password);


}
