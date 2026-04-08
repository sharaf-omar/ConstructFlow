package com.constructflow.entity.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FLYWEIGHT PATTERN - Object Pool
 * Factory for creating and caching Material objects.
 * Prevents duplicate Material instances for the same material type.
 */
public class MaterialFlyweightFactory {
    private static MaterialFlyweightFactory instance;
    private Map<Integer, FlyweightMaterial> materialPool = new HashMap<>();
    
    public static synchronized MaterialFlyweightFactory getInstance() {
        if (instance == null) {
            instance = new MaterialFlyweightFactory();
        }
        return instance;
    }
    
    /**
     * Gets or creates material from the pool.
     */
    public FlyweightMaterial getMaterial(int materialID, String name, String type) {
        if (!materialPool.containsKey(materialID)) {
            System.out.println("[MaterialFlyweightFactory] Creating new material instance: " + name);
            FlyweightMaterial material = new FlyweightMaterial(materialID, name, type);
            materialPool.put(materialID, material);
        } else {
            System.out.println("[MaterialFlyweightFactory] Reusing cached material: " + name);
        }
        return materialPool.get(materialID);
    }
    
    /**
     * Gets the total number of unique material instances in the pool.
     */
    public int getPoolSize() {
        return materialPool.size();
    }
    
    /**
     * Gets pool statistics.
     */
    public void printPoolStats() {
        System.out.println("[MaterialFlyweightFactory] Current pool size: " + materialPool.size() + " unique materials");
    }
}
