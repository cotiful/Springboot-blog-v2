package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IOC 컨테이너에 등록됨.
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User 회원가입(JoinDto joinDto) {
        // save하면 db에 Insert하고 insert된 결과를 다시 return 해준다.
        return userRepository.save(joinDto.toEntity());
    }

    // 받아서 userRepositoy에 줘야함. login 처리 쿼리를 JPA에서 제공해주지 않는다. nativeQuery는 하나씩 넘겨준다.
    // 한 번에 안 넘김
    public User 로그인(LoginDto loginDto) {
        User userEntity = userRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }
}
