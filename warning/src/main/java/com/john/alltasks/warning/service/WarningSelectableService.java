package com.john.alltasks.warning.service;

import com.john.alltasks.warning.models.WarningSelectableVO;

import java.util.List;

public interface WarningSelectableService {

    WarningSelectableVO getWarningMethodSelectables();

    WarningSelectableVO getWarningImpactSelectables();

    List<WarningSelectableVO> getSelectables();
}
