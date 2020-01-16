package com.john.alltasks.common.models;

import lombok.Data;

import java.io.Serializable;

/**
 * author: zhaowen.he
 * date: 2020/1/16
 * ticket:
 * description:
 */
@Data
public class QueryFilter implements Serializable {

    private Integer start;

    private Integer count;

}
