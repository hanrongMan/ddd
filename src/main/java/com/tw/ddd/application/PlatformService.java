package com.tw.ddd.application;

import java.util.List;

public interface PlatformService {
    /**
     * 增加停车boy
     *
     * @param name
     */
    void addParkingBoy(String name);

    /**
     * 增加停车经理
     *
     * @param name
     */
    void addParkingManager(String name);

    /**
     * 增加停车场
     *
     * @param name
     * @param capacity
     */
    void buildParkingLot(String name, int capacity);

    /**
     * 指派停车boy归停车经理管理
     *
     * @param parkingBoyId
     * @param parkingManagerId
     */
    void assignParkingBoyToParkingManager(String parkingBoyId, String parkingManagerId);

    /**
     * 分配一批停车场给停车boy
     *
     * @param parkingLotIds
     * @param parkingBoyId
     */
    void distributeParkingLotsToParkingBoy(List<String> parkingLotIds, String parkingBoyId);
}
