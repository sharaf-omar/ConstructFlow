package com.constructflow.entity.flyweight;

/**
 * FLYWEIGHT PATTERN - Flyweight Material
 * Immutable flyweight material object.
 * Represents a shared material instance to reduce memory usage.
 */
public class FlyweightMaterial {
    private final int materialID;
    private final String name;
    private final String type;

    public FlyweightMaterial(int materialID, String name, String type) {
        this.materialID = materialID;
        this.name = name;
        this.type = type;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }

    public void useOnTask(String taskId, int quantity, String unit, String site) {
        System.out.println(
            "Using " + quantity + " " + unit + " of " + name +
            " for task " + taskId + " at " + site
        );
    }
}