package site.metacoding.blogv2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IOC 컨테이너에 등록됨.
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User 회원가입(JoinDto joinDto) {
        // save하면 db에 Insert하고 insert된 결과를 다시 return 해준다.
        return userRepository.save(joinDto.toEntity());
    }
}
