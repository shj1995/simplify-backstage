package com.shj1995.simplifybackstage.core.controller;

import com.shj1995.simplifybackstage.core.domain.TreeDomain;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author shj1995
 * @since 1.0.0
 */
public interface TreeDomainController<T extends TreeDomain<T>> extends DomainController<T> {

    @PostMapping("")
    default ApiResult<T> create(@RequestBody T domain) {
        System.out.println("default post /{id} request");
        return ApiResult.newSuccessResult(this.domainManager().save(domain));
    }

    @DeleteMapping("/{id}")
    default ApiResult<Boolean> delete(@PathVariable String id) {
        System.out.println("default delete /{id} request");
        if (this.domainManager().notExists(id)) {
            return ApiResult.newErrorResult(ApiErrorInfo.B0101, false);
        }
        this.domainManager().delete(id);
        return ApiResult.newSuccessResult(true);
    }
}
