package com.shj1995.simplifybackstage.core.controller;

import com.shj1995.simplifybackstage.core.domain.Domain;
import com.shj1995.simplifybackstage.core.service.DomainService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author shj1995
 * @since 1.0.0
 */
public interface DomainController<T extends Domain> {

    DomainService<T> domainManager();

    @PostMapping("")
    default ApiResult<T> create(@RequestBody T domain) {
        System.out.println("default post /{id} request");
        return ApiResult.newSuccessResult(this.domainManager().save(domain));
    }

    @GetMapping("/{id}")
    default ApiResult<T> getById(@PathVariable String id) {
        System.out.println("default get /{id} request");
        ApiResult<T> result;
        if (StringUtils.isBlank(id)) {
            result = ApiResult.newErrorResult(ApiErrorInfo.A0101, "数据未找到");
        } else {
            T domain = this.domainManager().get(id);
            if (domain == null) {
                result = ApiResult.newErrorResult(ApiErrorInfo.B0101, null);
            } else {
                result = ApiResult.newSuccessResult(domain);
            }
        }
        return result;
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

    @PutMapping("")
    default ApiResult<T> update(@RequestBody T domain) {
        System.out.println("default put / request");
        String id = domain.getId();
        if (this.domainManager().notExists(id)) {
            return ApiResult.newErrorResult(ApiErrorInfo.B0101, null);
        }
        this.domainManager().save(domain);
        return ApiResult.newSuccessResult(this.domainManager().save(domain));
    }

    @GetMapping("/all")
    default ApiResult<List<T>> listAll() {
        return ApiResult.newSuccessResult(this.domainManager().findAll());
    }

    @GetMapping("/list")
    default ApiResult<ResultSet<T>> list(@RequestParam int pi, @RequestParam int ps) {
        Pageable page = PageRequest.of(pi - 1, ps);
        return ApiResult.newSuccessResult(this.domainManager().findAll(page));
    }
}
