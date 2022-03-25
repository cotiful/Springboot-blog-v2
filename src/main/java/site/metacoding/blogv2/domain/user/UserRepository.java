package site.metacoding.blogv2.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// :은 mlogin꺼를 바인딩 할 것 이다.
public interface UserRepository extends JpaRepository<User, Integer> {
    // excuteQuery
    @Query(value = "SELECT * FROM User WHERE username = :username AND password = :password", nativeQuery = true)
    User mLogin(@Param("username") String username, @Param("password") String password);

    // @Modifying //excuteUpdate
    // @Query(value = "UPDATE User SET password = :password, email =:email, addr
    // =:addr WHERE id = :id", nativeQuery = true)
    // void mUpdate(@Param("password") String password, @Param("email") String
    // email, @Param("addr")String addr, @Param("id")Integer id);
    // -> 이렇게 적으면 dirty checking을 할 필요가 없다.
}
