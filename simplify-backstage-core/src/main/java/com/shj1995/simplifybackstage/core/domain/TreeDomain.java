package com.shj1995.simplifybackstage.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shj1995
 * @since 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class TreeDomain<T> extends Domain {

    protected String parentId;
    @OrderBy
    protected int sort;

    @Transient
    protected List<T> children = new ArrayList<>();

    protected String name;

    /**
     * 当前层级
     */
    protected String layer;

    public String getParentId() {
        return parentId == null ? "" : parentId;
    }
}
