package com.constructflow.dao.adapter;

import com.constructflow.entity.Project;
import java.util.Map;
import java.util.Date;

/**
 * ADAPTER PATTERN - External Data Adapter
 * Adapter interface for converting external data formats to internal entities.
 */
public interface DataAdapter {
    /**
     * Converts external data format to Project entity.
     */
    Project convertToProject(Object externalData);
    
    /**
     * Gets the data source type.
     */
    String getSourceType();
}
