package com.shj1995.simplifybackstage.core.controller;

import com.shj1995.simplifybackstage.core.domain.Domain;
import lombok.Data;

import java.util.List;

/**
 * @author shj1995
 * @since 1.0.0
 */
@Data
public class ResultSet<T extends Domain> {
    private int total = 0;
    private List<T> list;
    private int pageTotal = 0;
    private int pageIndex = 1;
    private int pageSize = 10;
}
