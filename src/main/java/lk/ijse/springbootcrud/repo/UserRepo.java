package lk.ijse.springbootcrud.repo;

import lk.ijse.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE id=?1", nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM user WHERE id=?1 AND address=?2", nativeQuery = true)
    User getUserByUserIDAndAddress(String userId, String address);
}
