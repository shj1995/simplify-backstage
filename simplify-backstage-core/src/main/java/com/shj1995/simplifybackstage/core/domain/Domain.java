package com.shj1995.simplifybackstage.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 * @author shj1995
 * @since 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Domain implements Cloneable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7887781814478783826L;

    @Id
    protected String id;

    @CreatedBy
    @Column(length = 32)
    protected String createdUser;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    protected Date createTime;

    @LastModifiedBy
    @Column(length = 32)
    protected String lastModifiedUser;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifyTime;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Domain) {
            return StringUtils.equals(this.id, ((Domain) obj).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
