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
    public UserDTO saveUser(UserDTO userDTO){
        repo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = repo.findAll();
        return modelMapper.map(userList,new TypeToken<List<User>>(){}.getType());
    }
}
