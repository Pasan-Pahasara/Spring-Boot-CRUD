package lk.ijse.springbootcrud.repo;

import lk.ijse.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
