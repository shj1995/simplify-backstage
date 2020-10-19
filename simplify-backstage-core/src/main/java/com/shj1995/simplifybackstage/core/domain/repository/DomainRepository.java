package com.shj1995.simplifybackstage.core.domain.repository;

import com.shj1995.simplifybackstage.core.domain.Domain;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author shj1995
 * @since 1.0.0
 */
public interface DomainRepository<T extends Domain> extends PagingAndSortingRepository<T, String> {
}
