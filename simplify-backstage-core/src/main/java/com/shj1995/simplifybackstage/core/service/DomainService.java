package com.shj1995.simplifybackstage.core.service;

import com.google.common.collect.Lists;
import com.shj1995.simplifybackstage.core.controller.ResultSet;
import com.shj1995.simplifybackstage.core.domain.Domain;
import com.shj1995.simplifybackstage.core.domain.repository.DomainRepository;
import com.shj1995.simplifybackstage.core.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shj1995
 * @since 1.0.0
 */
public interface DomainService<T extends Domain> {

    DomainRepository<T> domainRepository();

    default T save(T domain) {
        if (StringUtils.isBlank(domain.getId())) {
            domain.setId(UUIDUtils.generatorUUID());
        }
        return domainRepository().save(domain);
    }

    default void delete(String id) {
        this.domainRepository().deleteById(id);
    }

    default T get(String id) {
        return domainRepository().findById(id).orElse(null);
    }

    default List<T> listAll() {
        List<T> list = new ArrayList<>();
        domainRepository().findAll().forEach(list::add);
        return list;
    }

    default boolean exists(String id) {
        return domainRepository().existsById(id);
    }

    default boolean notExists(String id) {
        return domainRepository().existsById(id);
    }

    default ResultSet<T> findAll(Pageable pageable) {
        ResultSet<T> rs = new ResultSet<T>();
        Page<T> page = this.domainRepository().findAll(pageable);
        rs.setList(page.getContent());
        rs.setPageIndex(page.getNumber() + 1);
        rs.setPageSize(page.getSize());
        rs.setPageTotal(page.getTotalPages());
        rs.setTotal((int) page.getTotalElements());
        return rs;
    }

    default List<T> findAll() {
        return Lists.newArrayList(this.domainRepository().findAll());
    }
}
