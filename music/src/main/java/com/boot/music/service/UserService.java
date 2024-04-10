package com.boot.music.service;

import com.boot.music.entity.User;
import com.boot.music.repositories.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User registerUser(User user) {
        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String encodedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

                user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null; // Đăng nhập thất bại
    }
}

