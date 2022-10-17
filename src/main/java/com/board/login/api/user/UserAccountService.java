package com.board.login.api.user;

import com.board.login.common.exception.UserNotFoundException;
import com.board.login.domain.user.entity.UserAccount;
import com.board.login.domain.user.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Transactional
    public UserAccount findUserAccountByLoginId(String loginId) {
        log.info("service - loginId : " + loginId);
        return userAccountRepository.findAllByLoginId(loginId).orElseThrow(UserNotFoundException::new);
    }
}
