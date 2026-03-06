package com.constructflow.entity.factory;

import com.constructflow.entity.Material;
import com.constructflow.entity.Resource;

public class MaterialFactory extends ResourceFactory {
    @Override
    public Resource createResource() {
        return new Material(); // Returns a Material object
    }
}