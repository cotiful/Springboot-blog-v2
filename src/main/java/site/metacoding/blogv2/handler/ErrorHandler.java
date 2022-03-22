package site.metacoding.blogv2.handler;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.metacoding.blogv2.web.api.dto.ResponseDto;

//모든 exception을 낚아채줌 
@RestControllerAdvice
public class ErrorHandler {
    // 어떤 오류가 뜰지 모르니 부모로 잡는다
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseDto<String> error1(RuntimeException e) {
        return new ResponseDto<String>(-1, "실패", e.getMessage());
    }
}
