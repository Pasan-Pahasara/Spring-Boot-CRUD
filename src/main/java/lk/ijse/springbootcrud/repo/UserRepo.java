package lk.ijse.springbootcrud.repo;

import lk.ijse.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM USER WHERE ID = ?1",nativeQuery = true)
    User getUserByUserID(String userId);
}
