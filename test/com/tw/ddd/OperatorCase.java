package com.tw.ddd;

import com.tw.ddd.application.PlatformService;
import com.tw.ddd.application.impl.PlatformServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * 模拟运营人员
 */
public class OperatorCase {

    private PlatformService platformService;

    @Before
    public void setUp() {
        platformService = new PlatformServiceImpl();
    }

    @Test
    public void recruitParkingManager() {
        platformService.addParkingManager("jack");
    }

}
