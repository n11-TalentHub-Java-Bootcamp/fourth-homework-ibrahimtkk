package com.example.fourthhomeworkibrahimtkk.user.service;

import com.example.fourthhomeworkibrahimtkk.user.dto.UserDto;
import com.example.fourthhomeworkibrahimtkk.user.dto.request.UserSaveRequest;
import com.example.fourthhomeworkibrahimtkk.user.entity.User;
import com.example.fourthhomeworkibrahimtkk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserDto save(UserSaveRequest userSaveRequestDto) {

        final User user = User.builder()
                .id(userSaveRequestDto.getId())
                .username(userSaveRequestDto.getUsername())
                .name(userSaveRequestDto.getName())
                .password(userSaveRequestDto.getPassword())
                .build();

        final User savedUser = userRepository.save(user);
        return UserDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .name(savedUser.getName())
                .build();
    }

    public UserDto findByUsername(String username) {
        final User user = userRepository.findByUsername(username);

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
