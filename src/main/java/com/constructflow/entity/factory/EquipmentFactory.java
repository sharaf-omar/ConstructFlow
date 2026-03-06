package com.constructflow.entity.factory;

import com.constructflow.entity.Equipment;
import com.constructflow.entity.Resource;

public class EquipmentFactory extends ResourceFactory {
    @Override
    public Resource createResource() {
        return new Equipment(); // Returns an Equipment object
    }
}