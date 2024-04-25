package edu.miu.eprescribtionsystem.Services;


import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.User;
import edu.miu.eprescribtionsystem.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(String username){
        return userRepository.findByUsername(username).orElseThrow(NotFoundException::new);
    }

    public void deleteById(String username){
        User user=findById(username);
        userRepository.delete(user);
    }

    public User update(String username, User user) {
        User user1 = findById(username);
        user.setUsername(username);
        return userRepository.save(user);
    }

    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }


}
