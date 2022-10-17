package com.board.login.domain.user.entity;

import com.board.login.domain.user.BaseEntity;
import com.board.login.domain.user.code.UserAccountStatus;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@ToString
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER_ACCOUNT")
public class UserAccount extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAccountId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 100)
    private String userDepartment;

    @Column(length = 100)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserAccountStatus userAccountStatus;

    @Builder
    public UserAccount(String loginId, String password, String userName, String userDepartment, String email,
                       UserAccountStatus userAccountStatus, UserAccount createdBy, UserAccount updatedBy) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.userDepartment = userDepartment;
        this.email = email;
        this.userAccountStatus = userAccountStatus;
        super.setCreateBy(createdBy);
        super.setUpdateBy(updatedBy);
    }
}
