/**
 * Generate time : 2020-11-18 16:28:56
 * Version : 1.0
 */
package com.baosight.iplatim.im.mb.domain;

import com.baosight.iplatim.common.im.domain.Timmbs01;

import java.util.Map;

/**
 * Timmbs01
 *
 */
public class IMMBS01 extends Timmbs01 {
    private static final long serialVersionUID = 1L;

    /**
     * initialize the metadata.
     */
    public void initMetaData() {
        super.initMetaData();

    }

    /**
     * the constructor.
     */
    public IMMBS01() {
        initMetaData();
    }


    /**
     * get the value from Map.
     *
     * @param map - source data map
     */
    @Override
    public void fromMap(Map map) {
        super.fromMap(map);
    }

    /**
     * set the value to Map.
     */
    @Override
    public Map toMap() {

        Map map = super.toMap();
        return map;
    }
}