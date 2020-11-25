package com.baosight.iplatim.im.mb.service;

import com.baosight.iplat4j.core.ei.EiBlock;
import com.baosight.iplat4j.core.ei.EiConstant;
import com.baosight.iplat4j.core.ei.EiInfo;
import com.baosight.iplat4j.core.exception.PlatException;
import com.baosight.iplat4j.core.service.impl.ServiceEPBase;
import com.baosight.iplat4j.core.util.DateUtil;
import com.baosight.iplatim.common.constant.CommonConstant;
import com.baosight.iplatim.common.im.domain.Timmbs01;
import com.baosight.iplatim.im.mb.domain.IMMBS01;

import java.util.HashMap;
import java.util.Map;


/**
 * 计划指标属性维护.
 *
 * @author wy
 * @date 2020-11-18 14:51
 */

public class ServiceIMMBS01 extends ServiceEPBase {
    /**
     * 初始化.
     *
     * @param inInfo
     * @return
     */
    public EiInfo initLoad(EiInfo inInfo) {

        inInfo.addBlock(EiConstant.resultBlock);
        return inInfo;
    }

    /**
     * 查询.
     *
     * @param inInfo
     * @return
     */
    public EiInfo query(EiInfo inInfo) {
        try {
            inInfo.setCell(EiConstant.queryBlock, 0, "rdel", CommonConstant.DelFlag.NODEL);
            inInfo = super.query(inInfo,"IMMBS01.query", new IMMBS01());
        } catch (PlatException e) {
            e.printStackTrace();
            inInfo.setStatus(EiConstant.STATUS_FAILURE);
        }
        return inInfo;
    }

    /**
     * 新增.
     * @param inInfo
     * @return
     */
    public EiInfo insert(EiInfo inInfo) {
        try {
            EiBlock eiBlock = inInfo.getBlock(EiConstant.resultBlock);
            Timmbs01 timmbs01 = new Timmbs01();
            int rowsCount = eiBlock.getRowCount();
            String time = DateUtil.curDateTimeStr14();
            for (int i = 0; i < rowsCount; i++) {
                timmbs01.fromMap(eiBlock.getRow(i));
            }
            timmbs01.setRctime(time);
            timmbs01.setRdel(CommonConstant.DelFlag.NODEL);
            dao.insert("timmbs01.insert", timmbs01);
            inInfo.setStatus(EiConstant.STATUS_SUCCESS);
            inInfo.setMsg("添加成功,本次对[" + eiBlock.getRowCount() + "]条数据添加成功!");
        } catch (PlatException e) {
            e.printStackTrace();
            inInfo.setStatus(EiConstant.STATUS_FAILURE);
            inInfo.setMsg("添加失败,原因:");
            inInfo.setDetailMsg(e.getMessage());
        }
        //return query(inInfo);
        return inInfo;
    }


    /**
     * 更新.
     * @param inInfo
     * @return
     */
    public EiInfo update(EiInfo inInfo) {
        try {
            EiBlock eiBlock = inInfo.getBlock(EiConstant.resultBlock);
            Timmbs01 timmbs01 = new Timmbs01();
            int rowsCount = eiBlock.getRowCount();
            for (int i = 0; i < rowsCount; i++) {
                timmbs01.fromMap(eiBlock.getRow(i));
            }
            dao.insert("timmbs01.update", timmbs01);
            inInfo.setStatus(EiConstant.STATUS_SUCCESS);
            inInfo.setMsg("修改成功,本次对[" + eiBlock.getRowCount() + "]条数据修改成功!");
        } catch (PlatException e) {
            e.printStackTrace();
            inInfo.setStatus(EiConstant.STATUS_FAILURE);
            inInfo.setMsg("修改失败,原因:");
            inInfo.setDetailMsg(e.getMessage());
        }
        return query(inInfo);
    }

    /**
     * 删除.
     * @param inInfo
     * @return
     */
    public EiInfo delete(EiInfo inInfo) {
        try {
            EiBlock eiBlock = inInfo.getBlock(EiConstant.resultBlock);
            Timmbs01 timmbs01 = new Timmbs01();
            int rowsCount = eiBlock.getRowCount();
            String[] ids = new String[eiBlock.getRowCount()];
            for (int i = 0; i < rowsCount; i++) {
                String id = eiBlock.getCellStr(i, "id");
                timmbs01.fromMap(eiBlock.getRow(i));
                ids[i] = id;
            }
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("rdel",CommonConstant.DelFlag.DEL);
            parameters.put("ids", ids);
            //timmbs01.setRdel(CommonConstant.DelFlag.DEL);
            dao.delete("IMMBS01.updateDel", parameters);
            inInfo = query(inInfo);
            inInfo.setStatus(EiConstant.STATUS_SUCCESS);
            inInfo.setMsg("删除成功,本次对[" + eiBlock.getRowCount() + "]条数据删除成功!");
        } catch (PlatException e) {
            e.printStackTrace();
            inInfo.setStatus(EiConstant.STATUS_FAILURE);
            inInfo.setMsg("删除失败,原因:");
            inInfo.setDetailMsg(e.getMessage());
        }
        return inInfo;
    }
}
