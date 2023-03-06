package lk.ijse.springbootcrud.service;

import lk.ijse.springbootcrud.dto.UserDTO;
import lk.ijse.springbootcrud.entity.User;
import lk.ijse.springbootcrud.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        repo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> userList = repo.findAll();
        return modelMapper.map(userList, new TypeToken<List<User>>() {
        }.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        repo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO) {
        repo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    /**
     * user id > user details
     * SELECT * FROM User WHERE id= 2
     */
    public UserDTO getUserByUserID(String userID) {
        User user = repo.getUserByUserID(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    /**
     * user id,address > user details
     * SELECT * FROM User WHERE id= 2 AND address = "Galle"
     */
    public UserDTO getUserByUserIDAndAddress(String userId, String address) {
        User user = repo.getUserByUserIDAndAddress(userId, address);
        return modelMapper.map(user, UserDTO.class);
    }
}
