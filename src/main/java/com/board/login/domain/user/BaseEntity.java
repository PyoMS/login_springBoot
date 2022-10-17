package com.board.login.domain.user;

import com.board.login.domain.user.entity.UserAccount;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY")
    private UserAccount createBy;

    @ManyToOne(fetch = FetchType.LAZY) // ManyToOne 이유는?
    @JoinColumn(name = "UPDATED_BY")
    private UserAccount updateBy;

    @CreatedDate
    private LocalDateTime createdDateTime;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;

}
