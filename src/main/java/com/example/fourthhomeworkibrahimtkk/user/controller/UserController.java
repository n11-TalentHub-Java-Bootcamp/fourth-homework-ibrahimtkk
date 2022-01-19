package com.example.fourthhomeworkibrahimtkk.user.controller;

import com.example.fourthhomeworkibrahimtkk.generator.validation.ValidationResult;
import com.example.fourthhomeworkibrahimtkk.generator.validation.ValidationService;
import com.example.fourthhomeworkibrahimtkk.user.dto.UserDto;
import com.example.fourthhomeworkibrahimtkk.user.dto.request.UserSaveRequest;
import com.example.fourthhomeworkibrahimtkk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
//    private final ValidationService<UserSaveRequest> saveUserValidationService;


    @PostMapping
    public ResponseEntity create(@RequestBody UserSaveRequest userSaveRequest){

//        final ValidationResult validationResult = saveUserValidationService.validate(userSaveRequest);
//        if (!validationResult.getIsValid()) {
//            // TODO: error dondur
//            ResponseEntity.ok();
//        }

        final UserDto usrUserDto = userService.save(userSaveRequest);

        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername(@PathVariable String username){

        final UserDto userDto = userService.findByUsername(username);

        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
