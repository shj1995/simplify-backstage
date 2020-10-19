package com.shj1995.simplifybackstage.core.utils;

import java.util.UUID;

/**
 * @author shj1995
 * @since 1.0.0
 */
public class UUIDUtils {
    public static String generatorUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
