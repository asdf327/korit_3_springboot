package com.example.cardatabase2.service;

import com.example.cardatabase2.domain.AppUser;
import com.example.cardatabase2.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = repository.findByUsername(username);

        UserBuilder builder = null;
        if (user.isPresent()){
            AppUser currentUser = user.get(); // // 자료형이 AppUser. UserBuilder가 아니라
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            // 그래서 이제 30번 라인에서 일종의 형변환을 해준겁니다 AppUser → UserBuilder로
            builder.password(currentUser.getPassword()); // "password"를 UserBuilder 자료형의 builder의 password에 대입
            builder.roles(currentUser.getRole()); // "USER"를 UserBuilder 자료형의 builder의 roles에 대입
        } else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }

        return builder.build();
    }
}
