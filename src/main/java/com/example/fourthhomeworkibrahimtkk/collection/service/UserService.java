package com.example.fourthhomeworkibrahimtkk.collection.service;

import com.example.fourthhomeworkibrahimtkk.collection.dto.UserDto;
import com.example.fourthhomeworkibrahimtkk.collection.dto.request.UserSaveRequest;
import com.example.fourthhomeworkibrahimtkk.collection.entity.User;
import com.example.fourthhomeworkibrahimtkk.collection.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        final Optional<User> optionalUser = userRepository.findByUsername(username);
        UserDto userDto = new UserDto();

        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            return UserDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .name(user.getName())
                    .build();
        }
        return userDto;


    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
