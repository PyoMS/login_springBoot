package com.board.login.api.user;

import com.board.login.domain.user.entity.UserAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/account")
public class UserAccountApi {

    private final UserAccountService userAccountService;

    @GetMapping("/")
    public UserAccount findUserAccountByLoginId(String loginId){
        log.info("api - loginId : " + loginId);
        return userAccountService.findUserAccountByLoginId(loginId);
    }
}
