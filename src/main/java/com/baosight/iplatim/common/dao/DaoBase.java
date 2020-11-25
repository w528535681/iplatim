//package com.baosight.pscs.common.dao;
//
//import com.baosight.iplat4j.common.constant.EPResource;
//import com.baosight.iplat4j.core.data.DaoEPBase;
//import com.baosight.iplat4j.core.data.dao.NamedSqlDao;
//import com.baosight.iplat4j.core.data.ibatis.dao.Dao;
//import com.baosight.iplat4j.core.data.ibatis.dao.IbatisDaoUtils;
//import com.baosight.iplat4j.core.data.ibatis.dao.SqlMapDao;
//import com.baosight.iplat4j.core.data.ibatis.sql.sqlmap.execution.SqlExecutor;
//import com.baosight.iplat4j.core.data.ibatis.sql.sqlmap.execution.SqlHelper;
//import com.baosight.iplat4j.core.ei.EiBlock;
//import com.baosight.iplat4j.core.ei.EiConstant;
//import com.baosight.iplat4j.core.ei.EiInfo;
//import com.baosight.iplat4j.core.exception.PlatException;
//import com.baosight.iplat4j.core.ioc.spring.PlatApplicationContext;
//import com.baosight.iplatim.common.dao.DBoperation;
//import com.baosight.pscs.common.dao.model.CustomTable;
//import com.baosight.pscs.common.util.RecordUtils;
//import com.baosight.pscs.common.util.StringUtils;
//import com.baosight.pscs.common.util.bizTrans.Underline2Camel;
//import com.baosight.pscs.common.util.bizTrans.model.MqueryBean;
//import org.apache.log4j.Logger;
//import org.springframework.util.LinkedCaseInsensitiveMap;
//
//import java.util.*;
//
///**
// * DaoERPBase 数据库操作辅助类.
// *
// * @author kankan
// */
//@SuppressWarnings({"rawtypes", "unchecked"})
//public class DaoBase {
//    private static final long serialVersionUID = 1L;
//    private static volatile DaoBase daoBase = null;
//    public Dao dao = (Dao) PlatApplicationContext.getBean("dao");
//    // 新增 */
//    private String sqlConstantInsert = ".insert";
//    // 更新 */
//    private String sqlConstantUpdate = ".update";
//    // 删除 */
//    private String sqlConstantDelete = ".delete";
//    private String namedSqlDao = "namedSqlDao";
//    private String internalCodeStr = "internalCode";
//
//    /**
//     * dao get method.
//     */
//    public NamedSqlDao getSqlDao() {
//        NamedSqlDao getSqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
//        return getSqlDao;
//    }
//
//    private static final Logger LOGGER = Logger.getLogger(DaoBase.class);
//
//    /**
//     * daoERPBase get method.
//     */
//    public static DaoBase getInstance() {
//        if (daoBase == null) {
//            daoBase = new DaoBase();
//            synchronized (DaoBase.class) {
//                if (daoBase == null) {
//                    daoBase = new DaoBase();
//                }
//            }
//        }
//
//        return daoBase;
//    }
//
//    /**
//     * daoERPBase init method.
//     */
//    private DaoBase() {
//
//    }
//
//    /**
//     * insert method.
//     *
//     * @param obj
//     * @param sql
//     */
//    public void insert(Object obj, String sql) throws PlatException {
//        insert(obj,sql,true,true);
//        //DataTrace.fillRec(obj, DataTrace.REC_CREATE | DataTrace.INNER_ID);
//        //dao.insert(sql, obj);
//    }
//
//    /**
//     * insert method.
//     *
//     * @param sql
//     * @param obj
//     */
//    public void insert(String sql, Object obj) throws PlatException {
//
//        insert(obj,sql,true,true);
//        //DataTrace.fillRec(obj, DataTrace.REC_CREATE | DataTrace.INNER_ID);
//        //dao.insert(sql, obj);
//    }
//
//    /**
//     * insert method.
//     *
//     * @param obj             新增bean或者Map.
//     * @param sql             新增sqlId.
//     * @param addInternalCode 是否新增内码，如果是false,必须自己传入内码.
//     */
//    public void insert(Object obj, String sql, Boolean addId, Boolean addRctor) throws PlatException {
//        RecordUtils.setCreator(obj, addId, addRctor);
//        RecordUtils.setRevisor(obj);
//        dao.insert(sql, obj);
//    }
//
//    /**
//     * insert method.
//     *
//     * @param bean
//     * @param addInternalCode 是否新增内码，如果是false,要重新传内码.
//     * @param addJobId        是否给新增人岗位号赋值，如果是false,要重新传内码.
//     */
//    public void insert(DaoEPBase bean, Boolean addInternalCode, Boolean addJobId) throws PlatException {
//        RecordUtils.setCreator(bean, addInternalCode, addJobId);
//        RecordUtils.setRevisor(bean);
//        dao.insert(getTableId(bean) + sqlConstantInsert, bean);
//    }
//
//    /**
//     * update method.
//     *
//     * @param obj
//     * @param sql
//     */
//    public int update(Object obj, String sql) {
//        if (obj instanceof DaoEPBase) {
//            //DataTrace.fillRec((DaoEPBase)obj, DataTrace.REC_REVISE);
//            RecordUtils.setRevisor((DaoEPBase) obj, true);
//        } else if (obj instanceof Map) {
//            RecordUtils.setRevisor((Map) obj, true);
//            //DataTrace.fillRec((Map)obj, DataTrace.REC_REVISE);
//        }
//        return dao.update(sql, obj);
//    }
//
//    /**
//     * update method.
//     *
//     * @param sql
//     * @param obj
//     */
//    public int update(String sql, Object obj) {
//        if (obj instanceof DaoEPBase) {
//            //DataTrace.fillRec((DaoEPBase) obj, DataTrace.REC_REVISE);
//            RecordUtils.setRevisor((DaoEPBase) obj, true);
//        } else if (obj instanceof Map) {
//            //DataTrace.fillRec((Map) obj, DataTrace.REC_REVISE);
//            RecordUtils.setRevisor((Map) obj, true);
//        }
//        return dao.update(sql, obj);
//    }
//
//    /**
//     * update method.
//     *
//     * @param obj
//     * @param sql
//     * @param addJobId
//     */
//    public int update(Object obj, String sql, Boolean addJobId) {
//        if (obj instanceof DaoEPBase) {
//            RecordUtils.setRevisor((DaoEPBase) obj, addJobId);
//        } else if (obj instanceof Map) {
//            RecordUtils.setRevisor((Map) obj, addJobId);
//        }
//        return dao.update(sql, obj);
//    }
//
//    /**
//     * 逻辑删除.
//     *
//     * @param obj
//     * @param sql
//     * @param tableName
//     * @return
//     */
//    public int deleteLD(Object obj, String sql, String tableName) throws PlatException {
//        RecordUtils.setCommField(obj, DBoperation.DELETE_LD.toString(), tableName);
//        return dao.update(sql, obj);
//    }
//
//    /**
//     * 物理删除.
//     *
//     * @param sql
//     * @param obj
//     * @param tableName
//     * @return
//     */
//    public int deletePD(String sql, Object obj, String tableName) throws PlatException {
//        RecordUtils.setCommField(obj, DBoperation.DELETE_PD.toString(), tableName);
//        return dao.delete(sql, obj);
//    }
//
//    /**
//     * 逻辑删除.
//     *
//     * @param sql
//     * @param obj
//     * @param tableName
//     * @return
//     */
//    public int deleteLD(String sql, Object obj, String tableName) throws PlatException {
//        RecordUtils.setCommField(obj, DBoperation.DELETE_LD.toString(), tableName);
//        return dao.update(sql, obj);
//    }
//
//    /**
//     * 物理删除.
//     *
//     * @param obj
//     * @param sql
//     * @param tableName
//     * @return
//     */
//    public int deletePD(Object obj, String sql, String tableName) throws PlatException {
//        RecordUtils.setCommField(obj, DBoperation.DELETE_PD.toString(), tableName);
//        return dao.delete(sql, obj);
//    }
//
//    /**
//     * 物理删除.
//     *
//     * @param obj
//     * @param sql
//     * @param tableName
//     * @return
//     */
//    public int deletePDForstandard(Object obj, String sql, String tableName) throws PlatException {
//        RecordUtils.setCommField(obj, DBoperation.DELETE_PD.toString(), tableName);
//        return dao.delete(sql, obj);
//    }
//
//    /**
//     * 传入用生成工具生成的bean,调用sql语句bean名称+.insert.
//     *
//     * @param bean
//     */
//    public void insert(DaoEPBase bean) throws PlatException {
//        RecordUtils.setCreator(bean, true, false);
//        RecordUtils.setRevisor(bean);
//        dao.insert(getTableId(bean) + sqlConstantInsert, bean);
//    }
//
//    /**
//     * 传入用生成工具生成的bean,调用sql语句bean名称+.update.
//     *
//     * @param bean
//     */
//    public int update(DaoEPBase bean) {
//        RecordUtils.setRevisor(bean);
//        return dao.update(getTableId(bean) + sqlConstantUpdate, bean);
//    }
//
//    /**
//     * 传入用生成工具生成的bean,调用sql语句bean名称+.update.
//     *
//     * @param bean
//     */
//    public int deleteLD(DaoEPBase bean, String tableName) throws PlatException {
//        RecordUtils.setCommField(bean, DBoperation.DELETE_LD.toString(), tableName);
//        return dao.update(getTableId(bean) + sqlConstantUpdate, bean);
//    }
//
//    /**
//     * 传入用生成工具生成的bean,调用sql语句bean名称+.delete.
//     *
//     * @param bean
//     */
//    public int deletePD(DaoEPBase bean, String tableName) throws PlatException {
//        RecordUtils.setCommField(bean, DBoperation.DELETE_PD.toString(), tableName);
//        return dao.delete(getTableId(bean) + sqlConstantDelete, bean);
//    }
//
//    /**
//     * 获取表ID.
//     *
//     * @param bean
//     */
//    private String getTableId(DaoEPBase bean) {
//
//        Class c = bean.getClass();
//        String tableId = c.getSimpleName().toLowerCase();// 类名;
//        return tableId;
//    }
//
//    /**
//     * getCompleteRecord.
//     *
//     * @param internalCode
//     * @param standardXMLName
//     */
//    public DaoEPBase getCompleteRecord(String internalCode, String standardXMLName) throws PlatException {
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        if (StringUtils.isEmpty(internalCode)) {
//            throw new PlatException("内码不能为空");
//        }
//        map1.put(internalCodeStr, internalCode);
//        DaoEPBase daoEPBase = (DaoEPBase) dao.query(standardXMLName + ".query", map1).get(0);
//        return daoEPBase;
//    }
//
//    /**
//     * 查询方法.
//     *
//     * @param eiInfo
//     * @param blockId 要查询的值放到哪个块.
//     * @param bean    列头的bean.
//     * @param sqlName 查询的sqlName.
//     * @param map     查询条件map.
//     * @return
//     */
//    public EiInfo query(EiInfo eiInfo, String blockId, DaoEPBase bean, String sqlName, Map map) throws PlatException {
//
//        int offset = EiConstant.defaultOffset;
//        int limit = EiConstant.defaultLimit;
//        if (eiInfo.getBlock(blockId) == null) {
//            eiInfo.addBlock(blockId).addBlockMeta(bean.eiMetadata);
//        }
//        EiBlock eiBlock = eiInfo.getBlock(blockId);
//        if (eiBlock.getBlockMeta() == null) {
//            eiBlock.addBlockMeta(bean.eiMetadata);
//        }
//
//        if (eiBlock.get(EiConstant.offsetStr) != null) {
//            offset = eiBlock.getInt(EiConstant.offsetStr);
//        }
//        if (eiBlock.get(EiConstant.limitStr) != null) {
//            limit = eiBlock.getInt(EiConstant.limitStr);
//        }
//        String sql = IbatisDaoUtils.getQuerySql((SqlMapDao) dao, sqlName, map, offset, limit);
//        String strDbType = IbatisDaoUtils.getDbType((SqlMapDao) dao);
//        if (SqlHelper.DB_ORACLE.equals(strDbType) && limit != SqlExecutor.NO_MAXIMUM_RESULTS) {
//            if (0 < offset) {
//                sql = sql.replace("rownum <= ?", "rownum <= " + (offset + limit)).replace("rownum_ > ?",
//                        "rownum_ > " + offset);
//            } else {
//                sql = sql.replace("rownum <= ?", "rownum <= " + limit);
//            }
//        }
//        LOGGER.info(sql);
//        List<LinkedCaseInsensitiveMap> lists = getSqlDao().queryForList(sql);
//        List<HashMap> hashMapLists = new ArrayList<HashMap>();
//        for (LinkedCaseInsensitiveMap linkedCaseInsensitiveMap : lists) {
//            HashMap h = new HashMap<>();
//            h.putAll(linkedCaseInsensitiveMap);
//            hashMapLists.add(h);
//        }
//        // List lists= dao.query(sqlName, map, offset, limit);
//        int num = 0;
//        if (lists != null) {
//            num = lists.size();
//        }
//        if (num == 0) {
//            eiInfo.setMsgByKey(EPResource.EP_1001, null);
//            eiBlock.set(EiConstant.countStr, 0);
//        } else {
//            eiInfo.setMsgByKey(EPResource.EP_2000, new String[]{String.valueOf(num)});
//
//            String isCount = eiBlock.getString(EiConstant.isCountFlag);
//
//            eiBlock.set(EiConstant.countStr, num * 2);// 为了可以翻页
//            if (isCount != null && "true".equals(isCount)) {
//                String cSql = IbatisDaoUtils.getSql((SqlMapDao) dao, sqlName, map);
//                String countSql = SqlHelper.getCountSqlOracle(cSql);
//                LOGGER.info(countSql);
//                int count = getSqlDao().queryForInt(countSql);
//                eiBlock.set(EiConstant.countStr, count);// dao.count(sqlName, map)
//            }
//        }
//        eiBlock.setRows(hashMapLists);
//        eiBlock.set(EiConstant.offsetStr, offset);
//        eiBlock.set(EiConstant.limitStr, limit);
//
//        return eiInfo;
//    }
//
//    /**
//     * 查询方法.
//     *
//     * @param sqlName 查询的sqlName.
//     * @param map     查询条件map.
//     * @return
//     */
//    public List query(String sqlName, Map map) throws PlatException {
//        String sql = IbatisDaoUtils.getSql((SqlMapDao) dao, sqlName, map);
//        LOGGER.info(sql);
//        List<LinkedCaseInsensitiveMap> lists = getSqlDao().queryForList(sql);
//        List<HashMap> hashMapLists = new ArrayList<HashMap>();
//        for (LinkedCaseInsensitiveMap linkedCaseInsensitiveMap : lists) {
//            HashMap h = new HashMap<>();
//            h.putAll(linkedCaseInsensitiveMap);
//            hashMapLists.add(h);
//        }
//        return hashMapLists;
//    }
//
//    /**
//     * 可分页查询 返回Map对象.
//     *
//     * @param sqlName
//     * @param map
//     * @param limit
//     * @param offset
//     * @return
//     */
//    public List query(String sqlName, Map map, int offset, int limit) {
//        String sql = IbatisDaoUtils.getQuerySql((SqlMapDao) dao, sqlName, map, offset, limit);
//        LOGGER.info(sql);
//        List<LinkedCaseInsensitiveMap> lists = getSqlDao().queryForList(sql);
//        List<HashMap> hashMapLists = new ArrayList<HashMap>();
//        for (LinkedCaseInsensitiveMap linkedCaseInsensitiveMap : lists) {
//            HashMap h = new HashMap<>();
//            h.putAll(linkedCaseInsensitiveMap);
//            hashMapLists.add(h);
//        }
//        return hashMapLists;
//    }
//
//    /**
//     * 可分页查询.
//     *
//     * @param sqlName
//     * @param map
//     * @param limit
//     * @param offset
//     * @return
//     */
//    public List query(String sqlName, Map map, String offset, String limit) {
//        offset = StringUtils.isEmpty(offset) ? "0" : offset;
//        limit = StringUtils.isEmpty(limit) ? "10" : limit;
//        return dao.query(sqlName, map, Integer.valueOf(offset), Integer.valueOf(limit));
//    }
//
//    /**
//     * 移动端查询方法.
//     *
//     * @param sqlName
//     * @param mQuery
//     * @return
//     */
//    public List query(String sqlName, MqueryBean mQuery) {
//        if (mQuery.getLimit() != null) {
//            return dao.query(sqlName, mQuery.getInquMap(), mQuery.getOffset(), mQuery.getLimit());
//        } else {
//            return dao.query(sqlName, mQuery.getInquMap(), 0, 10);
//        }
//    }
//
//    /**
//     * 根据条件查询所有数据.
//     *
//     * @param sqlName
//     * @param map     条件Map.
//     * @return
//     */
//    public List queryAll(String sqlName, Map map) throws PlatException {
//        List lists = dao.query(sqlName, map, 0, -999999);
//
//        return lists;
//    }
//
//    /**
//     * 获取表字段集合.
//     *
//     * @param schema
//     * @param tableName
//     * @return
//     */
//    public CustomTable getFieldMapByTableName(String schema, String tableName) {
//        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean("namedSqlDao");
//        CustomTable ctable = null;
//        String exesql = "SELECT t.table_name,t.OWNER,t.COLUMN_NAME, t.DATA_TYPE, t.DATA_LENGTH, t.NULLABLE,"+
//                " t.COLUMN_ID, c.COMMENTS FROM all_tab_columns t, all_col_comments c WHERE t.table_name = c" +
//                ".table_name AND t.column_name = c.column_name AND t.table_name = '#tableName#' " +
//                " AND t.OWNER = '#schema#' ORDER BY t.COLUMN_ID ";
//
//        exesql = exesql.replaceAll("#tableName#", tableName);
//        exesql = exesql.replaceAll("#schema#", schema);
//        List<Map<String, String>> datas = sqlDao.queryForList(exesql);
//        Map fieldMap = null;
//        for (int i = 0; i < datas.size(); i++) {
//            if (i == 0) {
//                ctable = new CustomTable();
//                ctable.setTableName(datas.get(i).get("TABLE_NAME").trim());
//                ctable.setSchema(datas.get(i).get("OWNER").trim());
//            }
//            fieldMap = new HashMap();
//            fieldMap.put("fieldEname", datas.get(i).get("COLUMN_NAME"));
//            fieldMap.put("fieldCname", datas.get(i).get("COMMENTS"));
//            fieldMap.put("nulls", datas.get(i).get("NULLABLE"));
//            fieldMap.put("colType", datas.get(i).get("DATA_TYPE"));
//            ctable.getFieldMaps().add(fieldMap);
//        }
//        return ctable;
//    }
//
////    /**
////     * 获取表字段集合.
////     *
////     * @param tableName
////     * @return
////     */
////    private CustomTable getPCMAxx(String tableName) {
////        CustomTable ctable = null;
////        String[][] tpcma11 = {{"PSCS", "TPCMA11", "REC_CREATOR_ID", "创建人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_CREATOR_NAME", "创建人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_CREATOR_JOB_ID", "创建人岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_CREATE_TIME", "创建时刻", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_CREATE_AGENT_ID", "记录创建代理人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_CREATE_AGENT_NAME", "记录创建代理人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISOR_ID", "修改人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISOR_NAME", "修改人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISOR_JOB_ID", "修改人岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISE_TIME", "修改时刻", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISE_AGENT_ID", "记录修改代理人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "REC_REVISE_AGENT_NAME", "记录修改代理人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ARCHIVE_FLAG", "归档标记", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ARCHIVE_TIME", "归档时间", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ARCHIVE_USER_ID", "归档人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ARCHIVE_USER_NAME", "归档人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "INTERNAL_CODE", "内码（UUID）", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "DOCUMENT_ID", "文档编号", "N", "NUMBER"},
////                {"PSCS", "TPCMA11", "TENANT_ID", "租户", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_ID", "物料代码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_DESC", "物料短描述", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_DESC_MORE", "物料长描述", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "CATEGORY_CODE", "叶类代码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "CATEGORY_DESC", "叶类描述", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "COMM_CODE", "中类代码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "COMM_DESC", "中类描述", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "COMM_FMLY_CODE", "大类代码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "COMM_FMLY_DESC", "大类描述", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_UOM", "计量单位", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "TYPE_SPEC", "型号规格", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_NAME_E", "英文品名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_NAME", "中文品名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "ITEM_STATUS", "物料状态", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "TASK_ID", "", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "LEAF_INTERNAL_CODE", "叶类主键", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA11", "TAX_CODE", "", "N", "VARCHAR2"}};
////
////        String[][] tpcma12 = {{"PSCS", "TPCMA12", "REC_CREATOR_ID", "创建人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_CREATOR_NAME", "创建人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_CREATOR_JOB_ID", "创建人岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_CREATE_TIME", "创建时刻", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_CREATE_AGENT_ID", "记录创建代理人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_CREATE_AGENT_NAME", "记录创建代理人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISOR_ID", "修改人工号", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISOR_NAME", "修改人姓名", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISOR_JOB_ID", "修改人岗号", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISE_TIME", "修改时刻", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISE_AGENT_ID", "记录修改代理人工号", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "REC_REVISE_AGENT_NAME", "记录修改代理人姓名", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ARCHIVE_FLAG", "归档标记", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ARCHIVE_TIME", "归档时间", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ARCHIVE_USER_ID", "归档人工号", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ARCHIVE_USER_NAME", "归档人姓名", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "INTERNAL_CODE", "内码（UUID）", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "DOCUMENT_ID", "文档编号", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "TENANT_ID", "租户", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_GROUP_CODE", "物料代码组", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "PUR_ORG", "采购组织", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_ID", "物料代码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_SORT", "物料类型", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_UOM", "计量单位", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "MIN_QTY", "最小定单", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "QTY_MULTIPLE", "批量倍数", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "PRE_PRICE", "预算价", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "CURRENCY_CODE", "币种", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_CLASS", "采购 ABC 分类", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ITEM_STATUS", "物料状态", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "GLOBAL_ITEM_ID", "特控编号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "LOT_SRL_MGD", "批次控制", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_QA_RQD_FLAG", "质检标志", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_SL_RQD_FLAG", "是否自动预约", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "SHELF_LIFE", "保质期", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "SLUOM", "保质期单位", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "MIN_SH_SF_LIFE", "最小保质期", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "NET_WEIGHT", "单个重量", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "WEIGHT_UOM", "单重单位", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ACC_UOM", "管理四大类", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "LIFE_CYCLE_UOM", "生命周期单位", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "HS_CODE", "海关报关码", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "PROC_FUL_TYPE", "采购标准", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "PROC_MGMT_TYPE", "采购管理类型", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "CTRL_TYPE", "特控类型", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "BUYER_CODE", "执行采购员岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_PRVT_PART", "两用物资", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "MATERIAL_TYPE", "采购流程", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "PRICE_TYPE", "计价方式", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "INV_WASTE_FAC", "库存损耗率", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "SRC_BUYER_CODE", "寻源采购员岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "LIFE_CYCLE", "生命周期", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "CDM_LEAD_TIME", "采购提前期", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "LAST_PRICE", "最近采购价", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "SL_FLAG", "梳理标志", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_SUPP_TYPE", "供应商库存方式", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_SUPP_AMT", "供应商可用库存量", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "A_ITEM_PKG", "包装", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_ORDER_MIN", "最小起订量", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_PRO_CYC", "制造周期", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_EMER_CYC", "急件交货周期", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_IMG", "图片", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "A_IMG_LT", "图片略图", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_STDIDENTITY", "非标件标识", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_SELFPRODUCT", "是否自产材标识", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "BS_MATERIAL", "材质", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "BS_ADD_INFO", "附加信息", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "TEC_DESC", "申请备注", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ATT_CNT", "图档数量", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "RZFL", "认证分类", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "LSBS", "绿色标识", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE01", "预留字段01", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE02", "预留字段02", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE06", "预留字段06", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE07", "预留字段07", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE18", "预留字段18", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "RESERVE19", "预留字段19", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "MIN_INV", "最小库存", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "MAX_INV", "最大库存", "N", "NUMBER"},
////                {"PSCS", "TPCMA12", "PUR_BILL_TO", "采购帐套", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "LEGACY_ITEM", "老物料代码", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "TASK_ID", "", "N", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "SETTLEMENT_TYPE", "结算类型", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "SETTLEMENT_FLAG", "结算类型状态", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_CRUX_BJ", "是否关键备件", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "METERAGE_FLAG", "计量标志", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "APPROVE_TYPE", "专项审核分类", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "CONVERSION_RELATIONSHIP", "单位换算关系", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "ROUND_NUMBER_FLAG", "整数倍采购标志", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "VALUABLE_MATERIAL_FLAG", "贵重物资标志", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "STOCK_FLAG", "一级库存标志", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "IS_EXPENSE_TYPE", "是否费用类别控制", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE20", "预留字段20", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE21", "预留字段21", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE22", "预留字段22", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE23", "预留字段23", "Y", "VARCHAR2"},
////                {"PSCS", "TPCMA12", "RESERVE24", "预留字段24", "Y", "VARCHAR2"}};
////
////        String[][] tpgvm21 = {{"PSCS", "TPGVM21", "SUPP_ID", "供应商代码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "SUPP_NAME", "供应商名称", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ZONE_SIGN", "境内境外标志0-国内1-国际", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CH_SHORT_NAME", "中文简称", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BUSI_NUM", "营业执照注册号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BUSI_START_DATE", "营业执照生效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BUSI_END_DATE", "营业执照失效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BUSI_NUM_ATTACH_ID", "营业执照图片ID", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "BUSI_CHECK_YEAR", "营业执照年检年度", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "TAX_NUM", "税号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "TAX_START_DATE", "税号生效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "TAX_END_DATE", "税号失效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "TAX_NUM_ATTACH_ID", "税务证图片ID", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "ORG_NUM", "组织机构代码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ORG_START_DATE", "组织机构代码证生效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ORG_END_DATE", "组织机构代码证失效日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ORG_NUM_ATTACH_ID", "组织机构代码证图ID", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "ORG_CHECK_YEAR", "组织机构年检年度", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CERTIFICATE", "经营活动证明", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CERTIFICATE_ATTACH_ID", "经营活动证明图片ID", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "COMPANY_TYPE", "企业类型", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BUSI_SCOPE", "经营范围", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "PROFESSION", "所属行业", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REGISTER_ADDRESS", "注册地址", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CURRENY", "注册资本币种", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "INCORPORATOR", "法人代表或最高负责人", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ESTABLISHMENT_DATE", "公司成立日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "COUNTRY", "国家", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CITY", "城市", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IS_LISTED", "是否上市", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IS_IMPORT", "是否有进口权：0-否1-是", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IS_EXPORT", "是否有出口权：0-否1-是", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "LEGAL_PERSON", "法定授权人", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "MEMO", "备注", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATOR_ID", "创建人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATOR_NAME", "创建人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATOR_JOB_ID", "创建人岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATE_TIME", "创建时刻", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATE_AGENT_ID", "记录创建代理人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_CREATE_AGENT_NAME", "记录创建代理人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISOR_ID", "修改人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISOR_NAME", "修改人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISOR_JOB_ID", "修改人岗号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISE_TIME", "修改时刻", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISE_AGENT_ID", "记录修改代理人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REC_REVISE_AGENT_NAME", "记录修改代理人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ARCHIVE_FLAG", "归档标记", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ARCHIVE_TIME", "归档时间", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ARCHIVE_USER_ID", "归档人工号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ARCHIVE_USER_NAME", "归档人姓名", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "INTERNAL_CODE", "内码（UUID）", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "TASK_ID", "任务号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "DOCUMENT_ID", "文档编号", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "TENANT_ID", "租户", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "DUN_CODE", "邓白氏代码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BAOSTEEL_ORG_CODE", "宝钢组织机构码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "CORP_CODE", "上级法人客商代码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IDENTITY_CARD", "身份证号", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IS_SUB_COMPANY", "是否宝钢子公司", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "IS_MANUFACTURER", "是否制造商", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BGSF", "办公省份代码", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "PROVINCE", "省份", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "APPROVED_VENDOR_DATE", "供应商新增日期", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ASSET_RATE", "净资产率", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ASSET", "净资产", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "ENTRUSTED_LEGAL_PERSON", "委托法人", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "DWQF", "单位区分", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ZONE", "地区", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "SOCIAL_CREDIT_NUM", "统一社会信用代码证", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "SOCIAL_CREDIT_NUM_ATTACH_ID", "统一社会信用代码证图片ID", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "AGENT_FLAG", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "GET_CODE_DATE", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "NAME_CHANGE_DATE", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "REG_CAPITAL", "", "N", "NUMBER"},
////                {"PSCS", "TPGVM21", "COMPANY_TEL", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "POST_CODE", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "COMPANY_FAX", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "EMAIL", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ENGLISH_FULL_NAME", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "ENGLISH_SHORT_NAME", "", "N", "VARCHAR2"},
////                {"PSCS", "TPGVM21", "BSP_COMPANY_CODE", "", "N", "VARCHAR2"}};
////        if ("TPCMA11".equals(tableName)) {
////
////            Map fieldMap = null;
////            for (int i = 0; i < tpcma11.length; i++) {
////                if (i == 0) {
////                    ctable = new CustomTable();
////                    ctable.setTableName(tpcma11[i][1]);
////                    ctable.setSchema(tpcma11[i][0]);
////                }
////                fieldMap = new HashMap();
////                fieldMap.put("fieldEname", tpcma11[i][2]);
////                fieldMap.put("fieldCname", tpcma11[i][3]);
////                fieldMap.put("nulls", tpcma11[i][4]);
////                fieldMap.put("colType", tpcma11[i][5]);
////                ctable.getFieldMaps().add(fieldMap);
////            }
////
////        } else if ("TPCMA12".equals(tableName)) {
////            Map fieldMap = null;
////            for (int i = 0; i < tpcma12.length; i++) {
////                if (i == 0) {
////                    ctable = new CustomTable();
////                    ctable.setTableName(tpcma12[i][1]);
////                    ctable.setSchema(tpcma12[i][0]);
////                }
////                fieldMap = new HashMap();
////                fieldMap.put("fieldEname", tpcma12[i][2]);
////                fieldMap.put("fieldCname", tpcma12[i][3]);
////                fieldMap.put("nulls", tpcma12[i][4]);
////                fieldMap.put("colType", tpcma12[i][5]);
////                ctable.getFieldMaps().add(fieldMap);
////            }
////        } else if ("TPGVM21".equals(tableName)) {
////            Map fieldMap = null;
////            for (int i = 0; i < tpgvm21.length; i++) {
////                if (i == 0) {
////                    ctable = new CustomTable();
////                    ctable.setTableName(tpgvm21[i][1]);
////                    ctable.setSchema(tpgvm21[i][0]);
////                }
////                fieldMap = new HashMap();
////                fieldMap.put("fieldEname", tpgvm21[i][2]);
////                fieldMap.put("fieldCname", tpgvm21[i][3]);
////                fieldMap.put("nulls", tpgvm21[i][4]);
////                fieldMap.put("colType", tpgvm21[i][5]);
////                ctable.getFieldMaps().add(fieldMap);
////            }
////        }
////        return ctable;
////    }
//
//    /**
//     * 得到用于新增的sql.
//     *
//     * @param tableName
//     * @param dataMap
//     * @return
//     */
////    private String getStrForInsert(String schema, String tableName, Map dataMap) throws PlatException {
////        CustomTable ctTable = getFieldMapByTableName(schema, tableName);
////        if (ctTable == null) {
////            throw new PlatException("不存在的表名，不可新增！");
////        } else {
////            StringBuffer fieldStr = new StringBuffer();
////            StringBuffer valueStr = new StringBuffer();
////            for (int i = 0; i < ctTable.fieldMaps.size(); i++) {
////                if (i > 0 && i <= ctTable.fieldMaps.size() - 1) {
////                    fieldStr.append(",");
////                    valueStr.append(",");
////                }
////                String fieldEname = ctTable.getFieldMaps().get(i).get("fieldEname");
////                String fieldEnameCamel = Underline2Camel.underline2Camel(fieldEname, true);
////                fieldStr.append(fieldEname);
////                if (dataMap.containsKey(fieldEnameCamel)) {
////                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
////                        if ("".equals(dataMap.get(fieldEnameCamel).toString().trim())) {
////                            valueStr.append("null");
////                        } else {
////                            valueStr.append(dataMap.get(fieldEnameCamel).toString().trim());
////                        }
////                    } else {
////                        valueStr.append("'").append(dataMap.get(fieldEnameCamel)).append("'");
////                    }
////                } else {
////                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
////                        valueStr.append("0");
////                    } else {
////                        valueStr.append("' '");
////                    }
////                }
////            }
////            StringBuffer insStr = new StringBuffer();
////            insStr.append("INSERT INTO ");
////            insStr.append(ctTable.schema);
////            insStr.append(".");
////            insStr.append(ctTable.tableName);
////            insStr.append("(");
////            insStr.append(fieldStr);
////            insStr.append(")");
////            insStr.append("VALUES ");
////            insStr.append("(");
////            insStr.append(valueStr);
////            insStr.append(")");
////            return insStr.toString();
////        }
////    }
//
//    /**
//     * getStrForSelect.
//     *
//     * @param schema
//     * @param tableName
//     * @param queryCon
//     * @return
//     */
////    private String getStrForSelect(String schema, String tableName, String queryCon) throws PlatException {
////        CustomTable ctTable = getFieldMapByTableName(schema, tableName);
////        if (ctTable == null) {
////            throw new PlatException("不存在的表名，不可查询！");
////        } else {
////            StringBuffer buff = new StringBuffer();
////            buff.append("SELECT ");
////            for (int i = 0; i < ctTable.fieldMaps.size(); i++) {
////                String fieldEname = ctTable.getFieldMaps().get(i).get("fieldEname");
////                String fieldEnameCamel = Underline2Camel.underline2Camel(fieldEname, true);
////
////                if (i > 0 && i <= ctTable.fieldMaps.size() - 1) {
////                    buff.append(",");
////                }
////                buff.append(fieldEname).append(" as ").append("\"").append(fieldEnameCamel).append("\"");
////            }
////            buff.append(" From ").append(ctTable.schema).append(".").append(ctTable.tableName).append(" where 1=1")
////                    .append(queryCon);
////            return buff.toString();
////        }
////    }
//
//    /**
//     * getStrForSelect.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
////    private String getStrForUpdate(String schema, String tableName, Map dataMap, String internalCode)
////            throws PlatException {
////        StringBuffer updStr = getStrForUpdateNoWhere(schema, tableName, dataMap, internalCode);
////        updStr.append(" WHERE INTERNAL_CODE=").append("'").append(internalCode).append("'");
////        return updStr.toString();
////
////    }
//
//    /**
//     * getStrForUpdateNoWhere.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
////    private StringBuffer getStrForUpdateNoWhere(String schema, String tableName, Map dataMap, String internalCode)
////            throws PlatException {
////        CustomTable ctTable = getFieldMapByTableName(schema, tableName);
////        if (ctTable == null) {
////            throw new PlatException("不存在的表名，不可修改！");
////        } else {
////            StringBuffer updStr = new StringBuffer();
////            updStr.append("UPDATE ").append(ctTable.schema).append(".").append(ctTable.tableName).append(" SET ");
////            for (int i = 0; i < ctTable.fieldMaps.size(); i++) {
////                if (i > 0 && i <= ctTable.fieldMaps.size() - 1) {
////                    updStr.append(",");
////                }
////                String fieldEname = ctTable.getFieldMaps().get(i).get("fieldEname");
////                String fieldEnameCamel = Underline2Camel.underline2Camel(fieldEname, true);
////                updStr.append(fieldEname).append(" = ");
////                if (dataMap.containsKey(fieldEnameCamel)) {
////                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
////                        if ("".equals(dataMap.get(fieldEnameCamel).toString().trim())) {
////                            updStr.append("null");
////                        } else {
////                            updStr.append(dataMap.get(fieldEnameCamel).toString().trim());
////                        }
////                    } else {
////                        updStr.append("'").append(dataMap.get(fieldEnameCamel)).append("'");
////                    }
////                } else {
////                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
////                        updStr.append("0");
////                    } else {
////                        updStr.append("' '");
////                    }
////                }
////            }
////            return updStr;
////        }
////    }
//
//    /**
//     * getStrForUpdateNoWhereForPc.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
//    private String getStrForUpdateNoWhereForPc(String schema, String tableName, Map dataMap, String internalCode)
//            throws PlatException {
//        CustomTable ctTable = getFieldMapByTableName(schema, tableName);
//        if (ctTable == null) {
//            throw new PlatException("不存在的表名，不可修改！");
//        } else {
//            StringBuffer updStr = new StringBuffer();
//            updStr.append("UPDATE ").append(ctTable.schema).append(".").append(ctTable.tableName).append(" SET ");
//
//            for (int i = 0; i < ctTable.fieldMaps.size(); i++) {
//
//                String fieldEname = ctTable.getFieldMaps().get(i).get("fieldEname");
//                String fieldEnameCamel = Underline2Camel.underline2Camel(fieldEname, true);
//
//                if (dataMap.containsKey(fieldEnameCamel)) {
//                    if (StringUtils.isEmptySpace(StringUtils.getSValue(dataMap.get(fieldEnameCamel)))) {
//                        continue;
//                    }
//                    updStr.append(fieldEname).append(" = ");
//                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
//                        if ("".equals(dataMap.get(fieldEnameCamel).toString().trim())) {
//                            updStr.append("null");
//                        } else {
//                            updStr.append(dataMap.get(fieldEnameCamel).toString().trim());
//                        }
//                    } else {
//                        updStr.append("'").append(dataMap.get(fieldEnameCamel)).append("'");
//                    }
//
//                    updStr.append(",");
//
////                } else {
////                    if (ctTable.getFieldMaps().get(i).get("colType").trim().equals("DECIMAL")) {
////                        updStr.append("0");
////                    } else {
////                        updStr.append("' '");
////                    }
//                }
//            }
//
//            return updStr.substring(0, updStr.lastIndexOf(","));
//        }
//    }
//
//    /**
//     * getStrForPcUpdate.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
//    private String getStrForPcUpdate(String schema, String tableName, Map dataMap, String internalCode)
//            throws PlatException {
//        String updStr = getStrForUpdateNoWhereForPc(schema, tableName, dataMap, internalCode);
//
//        updStr = updStr + "  WHERE ITEM_ID=" + "'" + internalCode + "'";
//        return updStr.toString();
//
//    }
//
//    /**
//     * getStrForPcUpdate.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param item
//     * @return
//     */
//    private String getStrPcUpdate(String schema, String tableName, Map dataMap, String item,
//                                  String itemGroupCode) throws PlatException {
//        String updStr = getStrForUpdateNoWhereForPc(schema, tableName, dataMap, item);
//
//        updStr = updStr + "  WHERE ITEM_ID=" + "'" + item + "'" + "and ITEM_GROUP=" + "'" + itemGroupCode
//                + "'";
//        return updStr;
//
//    }
//
//    /**
//     * 直接到数据库查询表结构，用于新增.
//     *
//     * @param schema    表用户.
//     * @param tableName 表名.
//     * @param dataMap   数据集.
//     */
////    public int insertCustomTable(String schema, String tableName, Map dataMap) throws PlatException {
////        RecordUtils.setCreator(dataMap, true);
////        String insertStr = getStrForInsert(schema, tableName, dataMap);
////
////        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
////        return sqlDao.executeSql(insertStr);
////        // Map insertdataMap = new HashMap();
////        // insertdataMap.put("sqlString", insertStr);
////        // dao.insert("PMWACommon.exeInsSQL", insertdataMap);
////    }
//
//    /**
//     * 查询表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param queryCon
//     * @return
//     */
////    public List<Map<String, Object>> getCustomTable(String schema, String tableName, String queryCon)
////            throws PlatException {
////
////        String selectStr = getStrForSelect(schema, tableName, queryCon);
////        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
////        List<Map<String, Object>> datas = sqlDao.queryForList(selectStr);
////        return CollectionUtils.tranMapsKeyValueToHashMaps(datas);
////    }
//
//    /**
//     * 查询表结构中的数据:包含查询值为null的字段.
//     *
//     * @param schema
//     * @param tableName
//     * @param queryCon
//     * @return
//     */
////    public List<Map<String, Object>> getCustomTableConNull(String schema, String tableName, String queryCon)
////            throws PlatException {
////
////        String selectStr = getStrForSelect(schema, tableName, queryCon);
////        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
////        List<Map<String, Object>> datas = sqlDao.queryForList(selectStr);
////        return CollectionUtils.tranMapsKeyValueToHashMapsConNull(datas);
////    }
//
//    /**
//     * 更新表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
////    public int updateCustomTable(String schema, String tableName, Map dataMap, String internalCode)
////            throws PlatException {
////        // RecordUtils.setCreator(dataMap, true);
////        RecordUtils.setRevisor(dataMap);
////        String updStr = getStrForUpdate(schema, tableName, dataMap, internalCode);
////        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
////
////        return sqlDao.executeSql(updStr);
////    }
//
//    /**
//     * 更新表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
//    public int updateCustomTableForPc(String schema, String tableName, Map dataMap, String internalCode)
//            throws PlatException {
//        // RecordUtils.setCreator(dataMap, true);
//        RecordUtils.setRevisor(dataMap);
//        dataMap.remove(internalCodeStr);
//        String updStr = getStrForPcUpdate(schema, tableName, dataMap, internalCode);
//        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
//
//        return sqlDao.executeSql(updStr);
//    }
//
//    /**
//     * 更新表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param item
//     * @param itemGroupCode
//     * @return
//     */
//    public int updateCustomTablePc(String schema, String tableName, Map dataMap, String item,
//                                   String itemGroupCode) throws PlatException {
//        // RecordUtils.setCreator(dataMap, true);
//        RecordUtils.setRevisor(dataMap);
//        String updStr = getStrPcUpdate(schema, tableName, dataMap, item, itemGroupCode);
//        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
//
//        return sqlDao.executeSql(updStr);
//    }
//
//    /**
//     * 更新表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
////    public int updateCustomTableForPg(String schema, String tableName, Map dataMap, String internalCode)
////            throws PlatException {
////        RecordUtils.setCreator(dataMap, true);
////        dataMap.remove(internalCodeStr);
////        String updStr = getStrForPgUpdate(schema, tableName, dataMap, internalCode);
////        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
////
////        return sqlDao.executeSql(updStr);
////    }
//
//    /**
//     * 删除表结构中的数据.
//     *
//     * @param schema
//     * @param tableName
//     * @param delCon
//     * @return
//     */
//    public int deleteCustomTable(String schema, String tableName, Map<String, String> delCon)
//            throws PlatException {
//        String delStr = "DELETE FROM " + schema + "." + tableName;
//        delStr = delStr + " WHERE  ";
//        if (delCon.isEmpty()) {
//            throw new PlatException("删除出错，条件不为空");
//        }
//        String whereString = "";
//        Iterator keyIt = delCon.keySet().iterator();
//        if (keyIt.hasNext()) {
//            String key = String.valueOf(keyIt.next());
//            String value = String.valueOf(delCon.get(key));
//            if ("".equals(whereString)) {
//                whereString = key + " = '" + value + "'";
//            } else {
//                whereString = whereString + " AND " + key + " = '" + value + "'";
//            }
//        }
//        delStr = delStr + whereString;
//        NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean(namedSqlDao);
//        return sqlDao.executeSql(delStr);
//
//    }
//
//    /**
//     * getStrForPgUpdate.
//     *
//     * @param schema
//     * @param tableName
//     * @param dataMap
//     * @param internalCode
//     * @return
//     */
//    private String getStrForPgUpdate(String schema, String tableName, Map dataMap, String internalCode)
//            throws PlatException {
//        String updStr = getStrForUpdateNoWhereForPc(schema, tableName, dataMap, internalCode);
//
//        updStr = updStr + "  WHERE INTERNAL_CODE=" + "'" + internalCode + "'";
//        return updStr.toString();
//
//    }
//}
