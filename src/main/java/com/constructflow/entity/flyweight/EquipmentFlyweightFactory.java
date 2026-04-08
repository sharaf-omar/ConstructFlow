package com.constructflow.entity.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FLYWEIGHT PATTERN - Object Pool
 * Factory for creating and caching Equipment objects.
 * Prevents duplicate Equipment instances for the same equipment type.
 */
public class EquipmentFlyweightFactory {
    private static EquipmentFlyweightFactory instance;
    private Map<Integer, FlyweightEquipment> equipmentPool = new HashMap<>();
    
    public static synchronized EquipmentFlyweightFactory getInstance() {
        if (instance == null) {
            instance = new EquipmentFlyweightFactory();
        }
        return instance;
    }
    
    /**
     * Gets or creates equipment from the pool.
     */
    public FlyweightEquipment getEquipment(int equipmentID, String name, String type) {
        if (!equipmentPool.containsKey(equipmentID)) {
            System.out.println("[EquipmentFlyweightFactory] Creating new equipment instance: " + name);
            FlyweightEquipment equipment = new FlyweightEquipment(equipmentID, name, type);
            equipmentPool.put(equipmentID, equipment);
        } else {
            System.out.println("[EquipmentFlyweightFactory] Reusing cached equipment: " + name);
        }
        return equipmentPool.get(equipmentID);
    }
    
    /**
     * Gets the total number of unique equipment instances in the pool.
     */
    public int getPoolSize() {
        return equipmentPool.size();
    }
    
    /**
     * Gets pool statistics.
     */
    public void printPoolStats() {
        System.out.println("[EquipmentFlyweightFactory] Current pool size: " + equipmentPool.size() + " unique equipment");
    }
}
