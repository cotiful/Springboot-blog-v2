package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.domain.user.UserRepository;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;
import site.metacoding.blogv2.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IOC 컨테이너에 등록됨.
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User 회원수정(Integer id, UpdateDto updateDto) {
        // UPDATE user SET password = ?, email =?, addr =? WHERE id = ?
        Optional<User> userOp = userRepository.findById(id); // 영속화 디비 row를 영속성 컨텍스에 옮김.

        if (userOp.isPresent()) {

            // 영속화된 오브젝트 수정
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setEmail(updateDto.getEmail());
            userEntity.setAddr(updateDto.getAddr());
            return userEntity;
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다");
        }
    } // 트랜잭션이 걸려있으면 @Service 종료시에 변경감지해서 디비에 update. => 더티체킹.

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

    public User 회원정보(Integer id) {
        // id 가 현재 3번까지 밖에 없지만 5번이 실수로 들어와도 터지지 않도록 optional이 도와줌

        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다");
        }
        // User userEntity = userRepository.findById(id).get();
        // return userEntity;
    }
}
