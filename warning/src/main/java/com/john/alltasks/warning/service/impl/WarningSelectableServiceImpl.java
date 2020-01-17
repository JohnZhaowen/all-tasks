package com.john.alltasks.warning.service.impl;

import com.google.common.collect.Lists;
import com.john.alltasks.warning.enums.WarningImpactEnum;
import com.john.alltasks.warning.enums.WarningMethodEnum;
import com.john.alltasks.warning.models.WarningSelectableVO;
import com.john.alltasks.warning.service.WarningSelectableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/1/17
 * ticket:
 * description:
 */
@Service
@Slf4j
public class WarningSelectableServiceImpl implements WarningSelectableService {

    private static final String WARNING_METHOD = "warningMethod";

    private static final String WARNING_IMPACT = "warningImpact";

    @Override
    public WarningSelectableVO getWarningMethodSelectables() {
        return new WarningSelectableVO(WARNING_METHOD, WarningMethodEnum.getNames());
    }

    @Override
    public WarningSelectableVO getWarningImpactSelectables() {
        return new WarningSelectableVO(WARNING_IMPACT, WarningImpactEnum.getNames());
    }

    @Override
    public List<WarningSelectableVO> getSelectables() {
        return Lists.newArrayList(getWarningMethodSelectables(), getWarningImpactSelectables());
    }
}


