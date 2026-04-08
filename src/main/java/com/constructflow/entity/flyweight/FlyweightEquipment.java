package com.constructflow.entity.flyweight;

/**
 * FLYWEIGHT PATTERN - Flyweight Equipment
 * Immutable flyweight equipment object.
 * Represents a shared equipment instance to reduce memory usage.
 */
public class FlyweightEquipment {
    private final int equipmentID;
    private final String name;
    private final String type;

    public FlyweightEquipment(int equipmentID, String name, String type) {
        this.equipmentID = equipmentID;
        this.name = name;
        this.type = type;
    }

    public int getEquipmentID() {
        return equipmentID;
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

    public void useOnTask(String taskId, String site, int hoursUsed) {
        System.out.println(name + " used on " + taskId + " at " + site + " for " + hoursUsed + " hours");
    }
}