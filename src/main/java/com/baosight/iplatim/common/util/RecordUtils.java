//package com.baosight.iplatim.common.util;
//
//import com.baosight.iplat4j.core.data.DaoEPBase;
//import com.baosight.iplat4j.core.data.dao.NamedSqlDao;
//import com.baosight.iplat4j.core.data.ibatis.dao.Dao;
//import com.baosight.iplat4j.core.data.ibatis.dao.IbatisDaoUtils;
//import com.baosight.iplat4j.core.data.ibatis.dao.SqlMapDao;
//import com.baosight.iplat4j.core.ei.EiBlock;
//import com.baosight.iplat4j.core.ei.EiConstant;
//import com.baosight.iplat4j.core.exception.PlatException;
//import com.baosight.iplat4j.core.ioc.spring.PlatApplicationContext;
//import com.baosight.iplat4j.core.util.DateUtil;
//import com.baosight.pscs.common.dao.DBoperation;
//import com.baosight.pscs.common.util.bizTrans.EiInfoUtil;
//import com.baosight.pscs.common.util.bizUser.PscsUserUtil;
//import com.baosight.pscs.pm.jp.domain.Comparison;
//import com.baosight.pscs.pm.jp.domain.ComparisonData;
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import java.beans.IntrospectionException;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.*;
//
///**
// * 创建人、创建工具测试类.
// *
// * @author kankan
// */
//public class RecordUtils {
//
//	private static NamedSqlDao SQL_DAO = null;
//
//	private static void getSqlDao() {
//		// TODO Auto-generated method stub
//		if (SQL_DAO == null){
//			SQL_DAO = (NamedSqlDao) PlatApplicationContext.getBean("namedSqlDao");
//		}
//	}
//
//	private Dao dao = (Dao) PlatApplicationContext.getBean("dao");
//
//	protected static Log LOG = LogFactory.getLog(RecordUtils.class);
//
//	public static void setCreator(DaoEPBase bean, Boolean addId){
//		setCreator( bean, addId,false);
//	}
//	/**
//	 * 创建人 创建人姓名  创建时刻
//	 *
//	 * @param bean
//	 */
//	public static void setCreator(DaoEPBase bean, Boolean addId, Boolean addRctor) {
//		try {
//			// 创建人工号
//			BeanUtils.setProperty(bean, "rctor",
//					PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//							: PscsUserUtil.getUserId());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 创建人姓名
//			BeanUtils.setProperty(bean, "recCreatorName", PscsUserUtil.getUserCname());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 创建时刻
//			BeanUtils.setProperty(bean, "recCreateTime", DateUtil.curDateTimeStr14());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 创建人岗位号
//			if (addJobId) {
//				BeanUtils.setProperty(bean, "recCreatorJobId", PscsUserUtil.getJobId());
//			}
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 内码（UUID）
//			if (addInternalCode) {
//				BeanUtils.setProperty(bean, "internalCode", UUID.randomUUID().toString());
//			}
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//
//	}
//
//	/**
//	 * setRevisor.
//	 *
//	 * @param obj
//	 * @param addInternalCode
//	 */
//	public static void setCreator(Object obj, Boolean addInternalCode, Boolean addJobId) {
//		if (obj instanceof DaoEPBase) {
//			setCreator((DaoEPBase) obj, addInternalCode, addJobId);
//		} else if (obj instanceof Map) {
//			setCreator((Map) obj, addInternalCode);
//		}
//	}
//
//	/**
//	 * 创建人工号 创建人姓名 创建人岗号 创建时刻 记录创建代理人工号 记录创建代理人姓名.
//	 *
//	 * @param map
//	 */
//	public static void setCreator(Map map, Boolean addInternalCode) {
//		try {// 创建人工号
//			map.put("recCreator",
//					PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//							: PscsUserUtil.getUserId());
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 创建人姓名
//			map.put("recCreatorName", PscsUserUtil.getUserCname());
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 创建时刻
//			map.put("recCreateTime", DateUtil.curDateTimeStr14());
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 内码（UUID）
//			if (addInternalCode) {
//				map.put("internalCode", UUID.randomUUID().toString());
//			}
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 记录修改人姓名
//			map.put("recRevisorName", " ");
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 归档标记
//			map.put("archiveFlag", " ");
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 归档时间
//			map.put("archiveTime", " ");
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//		try {// 归档邮戳号
//			map.put("archiveStampNo", " ");
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * setRevisor.
//	 *
//	 * @param obj
//	 */
//	public static void setRevisor(Object obj) {
//		if (obj instanceof DaoEPBase) {
//			setRevisor((DaoEPBase) obj,true);
//		} else if (obj instanceof Map) {
//			setRevisor((Map) obj,true);
//
//		}
//	}
//
//	/**
//	 * 修改人工号 修改人姓名 修改人岗号 修改时刻 记录修改代理人工号 记录修改代理人姓名.
//	 *
//	 * @param bean
//	 */
//	public static void setRevisor(DaoEPBase bean) {
//		try {// 修改人工号
//			BeanUtils.setProperty(bean, "recRevisor",
//					PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//							: PscsUserUtil.getUserId());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改人姓名
//			BeanUtils.setProperty(bean, "recRevisorName", PscsUserUtil.getUserCname());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改时刻
//			BeanUtils.setProperty(bean, "recReviseTime", DateUtil.curDateTimeStr14());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * 修改人工号 修改人姓名 修改人岗号 修改时刻 记录修改代理人工号 记录修改代理人姓名.
//	 *
//	 * @param bean
//	 * @param addJobId
//	 */
//	public static void setRevisor(DaoEPBase bean, Boolean addJobId) {
//		try {// 修改人工号
//			BeanUtils.setProperty(bean, "recRevisor",
//					PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//							: PscsUserUtil.getUserId());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改人姓名
//			BeanUtils.setProperty(bean, "recRevisorName", PscsUserUtil.getUserCname());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改时刻
//			BeanUtils.setProperty(bean, "recReviseTime", DateUtil.curDateTimeStr14());
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改人岗位号
//			if(addJobId){
//				BeanUtils.setProperty(bean, "recRevisorJobId", PscsUserUtil.getJobId());
//			}
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * 修改人工号 修改人姓名 修改人岗号 修改时刻 记录修改代理人工号 记录修改代理人姓名.
//	 *
//	 * @param map
//	 * @param addJobId
//	 */
//	public static void setRevisor(Map map, Boolean addJobId) {
//		map.put("recRevisor",PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10
//				? "System" : PscsUserUtil.getUserId());
//		map.put("recRevisorName",PscsUserUtil.getUserCname());
//		map.put("recReviseTime", DateUtil.curDateTimeStr14());
//		if(addJobId){
//			map.put("recRevisorJobId",PscsUserUtil.getJobId());
//		}
//	}
//
//	/**
//	 * 清除修改人信息.
//	 *
//	 * @param bean
//	 */
//	public static void clearRevisor(DaoEPBase bean) {
//		try {// 修改人工号
//			BeanUtils.setProperty(bean, "recRevisor", "");
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改人姓名
//			BeanUtils.setProperty(bean, "recRevisorName", "");
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//		try {// 修改时刻
//			BeanUtils.setProperty(bean, "recReviseTime", "");
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * setRevisor.
//	 *
//	 * @param map
//	 */
//	public static void setRevisor(Map map) {
//		try {// 修改人工号
//			map.put("recRevisor",
//					PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//							: PscsUserUtil.getUserId());
//		} catch (PlatException e) {
//			LOG.debug("error", e);
//		}
//		try {// 修改人姓名
//			map.put("recRevisorName", PscsUserUtil.getUserCname());
//		} catch (PlatException e) {
//			LOG.debug("error", e);
//		}
//		try {// 修改时刻
//			map.put("recReviseTime", DateUtil.curDateTimeStr14());
//		} catch (PlatException e) {
//			LOG.debug("error", e);
//		}
//	}
//
//	/**
//	 * 设置删除数据的日志信息.
//	 *
//	 * @param bean
//	 * @param tablename
//	 *            数据表名.
//	 */
//	public static void setDelInfo(DaoEPBase bean, String tablename) {
//		try {
//			NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean("namedSqlDao");
//			String name = "";
//			try {
//				name = PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//						: PscsUserUtil.getUserId();
//			} catch (PlatException e) {
//				name = "system";
//			}
//			// sqlDao.executeSql(DEL_SQL.replace("#OBJCET_NAME#", tablename)
//			// .replace("#OBJECT_KEY#", BeanUtils.getProperty(bean, "internalCode"))
//			// .replace("#REC_DEL_USER#", name).replace("#REC_DEL_TIME#",
//			// DateUtil.curDateTimeStr14()));
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * 设置删除数据的日志信息.
//	 *
//	 * @param bean
//	 * @param tablename
//	 *            数据表名.
//	 */
//	public static void setDelInfo(Map bean, String tablename) {
//		try {
//			NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean("namedSqlDao");
//			String name = "";
//			try {
//				name = PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//						: PscsUserUtil.getUserId();
//			} catch (PlatException e) {
//				name = "system";
//			}
//			if (name.length() > 6){
//				name = name.substring(0, 6);
//			}
//			sqlDao.executeSql(DEL_SQL.replace("#OBJCET_NAME#", tablename)
//					.replace("#OBJECT_KEY#", BeanUtils.getProperty(bean, "internalCode"))
//					.replace("#REC_DEL_USER#", name).replace("#REC_DEL_TIME#", DateUtil.curDateTimeStr14()));
//		} catch (PlatException e) {
//			LOG.info("error", e);
//		} catch (NoSuchMethodException e) {
//			LOG.info("error", e);
//		} catch (InvocationTargetException e) {
//			LOG.info("error", e);
//		} catch (IllegalAccessException e) {
//			LOG.info("error", e);
//		}
//	}
//
//	/**
//	 * setCommField.
//	 *
//	 * @param obj
//	 * @param flag
//	 * @param tablename
//	 */
//	public static void setCommField(Object obj, String flag, String tablename) {
//		if (obj instanceof DaoEPBase) {
//			setCommField((DaoEPBase) obj, flag, tablename, false, false);
//		} else if (obj instanceof Map) {
//			setCommField((Map) obj, flag, tablename, false);
//		}
//	}
//
//	/**
//	 * 设置数据库操作的日志信息.
//	 *
//	 * @param bean
//	 * @param flag
//	 *            I:新增 U:更新 D:删除.
//	 * @param tablename
//	 *            数据表名.
//	 */
//	public static void setCommField(DaoEPBase bean, String flag, String tablename
//			, Boolean addInternalCode, Boolean addJobId) {
//		if (DBoperation.INSERT.equals(flag)) {
//			setCreator(bean, addInternalCode, addJobId);
//		} else if (DBoperation.UPDATE.equals(flag)) {
//			setRevisor(bean);
//		} else if (DBoperation.DELETE_LD.equals(flag)) {
//
//			setRevisor(bean);
//		} else if (DBoperation.DELETE_PD.equals(flag)) {
//			setDelInfo(bean, tablename);
//		}
//	}
//
//	/**
//	 * setCommField.
//	 *
//	 * @param map
//	 * @param flag
//	 * @param tablename
//	 * @param addInternalCode
//	 */
//	public static void setCommField(Map map, String flag, String tablename, Boolean addInternalCode) {
//		if (DBoperation.INSERT.equals(flag)) {
//			setCreator(map, addInternalCode);
//		} else if (DBoperation.UPDATE.equals(flag)) {
//			setRevisor(map);
//		} else if (DBoperation.DELETE_LD.equals(flag)) {
//			setDelInfo(map, tablename);
//		} else if (DBoperation.DELETE_PD.equals(flag)) {
//			setRevisor(map);
//		}
//	}
//
//	/**
//	 * setBatchDelPK.
//	 *
//	 * @param tablename
//	 * @param sqlName
//	 * @param param
//	 */
//	public static void setBatchDelPK(String tablename, String sqlName, Object param) {
//		try {
//			SqlMapDao dao = (SqlMapDao) PlatApplicationContext.getBean("dao");
//			String delSql = IbatisDaoUtils.getSql(dao, sqlName, param);
//			String upperCaseDelSql = delSql.toUpperCase();
//			String whereClause = delSql.substring(upperCaseDelSql.indexOf("FROM"));
//			String insertSql = "INSERT INTO IPLAT.TPMJPD4 SELECT '" + tablename + "',INTERNAL_CODE,'"
//					+ PscsUserUtil.getUserId() == null || (PscsUserUtil.getUserId() + "").length() > 10 ? "System"
//					: PscsUserUtil.getUserId() + "','" + DateUtil.curDateTimeStr14() + "' " + whereClause;
//			NamedSqlDao sqlDao = (NamedSqlDao) PlatApplicationContext.getBean("namedSqlDao");
//			sqlDao.executeSql(insertSql);
//		} catch (PlatException ex) {
//			LOG.info("error", ex);
//		}
//	}
//
//	/**
//	 * 比较两个对象差异数据.
//	 *
//	 * @param beforeobj
//	 * @param afterobj
//	 * @param cols
//	 *            比较字段.
//	 * @param different
//	 *            差异？.
//	 * @return
//	 */
//	public static List<Comparison> compareBean(DaoEPBase beforeobj, DaoEPBase afterobj, Map<String, String> cols,
//                                               boolean different) {
//		List<Comparison> sames = new ArrayList<Comparison>();
//		List<Comparison> differents = new ArrayList<Comparison>();
//		if (beforeobj == null){
//			throw new PlatException("beforeobj不能为空!");
//		}
//		if (afterobj == null){
//			throw new PlatException("afterobj不能为空!");
//		}
//		if (!beforeobj.getClass().isAssignableFrom(afterobj.getClass())) {
//			throw new PlatException("两个对象不相同，无法比较");
//		}
//
//		try {
//			// 去除对象所有字段
//			PropertyDescriptor[] descriptors = Introspector.getBeanInfo(beforeobj.getClass()).getPropertyDescriptors();
//
//			Set<String> keys = cols.keySet();
//			for (String col : keys) {
//				for (PropertyDescriptor descriptor : descriptors) {
//					String proname = descriptor.getName();
//					if (StringUtils.isNotEmpty(proname) && proname.equalsIgnoreCase(col)) {
//						Comparison comparison = new Comparison();
//						Method readmethod = descriptor.getReadMethod();
//						comparison.setBefore(readmethod.invoke(beforeobj));
//						comparison.setAfter(readmethod.invoke(afterobj));
//						comparison.setFieldType(descriptor.getPropertyType());
//						comparison.setField(proname);
//						comparison.setFieldName(cols.get(col));
//						if (comparison.isdifferent()) {
//							sames.add(comparison);
//						} else {
//							differents.add(comparison);
//						}
//					}
//				}
//			}
//		} catch (IntrospectionException e){
//			throw new PlatException(e);
//		} catch (InvocationTargetException e){
//			throw new PlatException(e);
//		} catch (IllegalAccessException e){
//			throw new PlatException(e);
//		}
//
//		if (different) {
//			return differents;
//		} else {
//			return sames;
//		}
//	}
//
//	/**
//	 * 比较两个对象差异数据.
//	 *
//	 * @param beforeMap
//	 * @param afterMap
//	 * @param cols
//	 *            比较字段.
//	 * @param different
//	 *            差异？.
//	 * @return
//	 */
//	public static List<Map> compareMap(Map<String, String> beforeMap, Map<String, String> afterMap,
//									   Map<String, String> cols, boolean different) {
//		List<Map> sames = new ArrayList<Map>();
//		List<Map> differents = new ArrayList<Map>();
//		if (beforeMap == null){
//			throw new PlatException("beforeobj不能为空!");
//		}
//		if (afterMap == null){
//			throw new PlatException("afterobj不能为空!");
//		}
//		if (!beforeMap.getClass().isAssignableFrom(afterMap.getClass())) {
//			throw new PlatException("两个对象不相同，无法比较");
//		}
//
//		Set<String> keys = cols.keySet();
//		for (String col : keys) {
//
//			Map comparison = new HashMap<>();
//			comparison.put("before", beforeMap.get(col));
//			comparison.put("after", afterMap.get(col));
//			comparison.put("field", StringUtils.getSValue(col));
//			comparison.put("fieldName", cols.get(col));
//
//			if (beforeMap.get(col).equals(afterMap.get(col))) {
//				comparison.put("different", true);
//				sames.add(comparison);
//
//			} else {
//				comparison.put("different", false);
//				differents.add(comparison);
//			}
//		}
//
//		if (different) {
//			return differents;
//		} else {
//			return sames;
//		}
//	}
//
//	/**
//	 * compareDifferentsObj.
//	 *
//	 * @param beforeObj
//	 *            之前的数据.
//	 * @param afterObj
//	 *            改变之后的数据.
//	 * @param compareMap
//	 *            要改变的内容.
//	 * @return
//	 */
//	public static List compareDifferentsObj(Object beforeObj, Object afterObj, Map<String, String> compareMap) {
//		try {
//			List comparisonList = null;
//			if (beforeObj instanceof DaoEPBase && afterObj instanceof DaoEPBase) {
//				/**
//				 * 如果没传比较的Map,就默认比较bean里面所有的值
//				 */
//				if (compareMap == null) {
//					DaoEPBase compare = (DaoEPBase) afterObj;
//					compareMap = EiInfoUtil.getFieldMap(compare.eiMetadata);
//				}
//				comparisonList = compareBean((DaoEPBase) beforeObj, (DaoEPBase) afterObj, compareMap, true);
//			} else if (beforeObj instanceof Map && afterObj instanceof Map) {
//				/**
//				 * 如果没传比较的Map,就默认Map里面所有的值
//				 */
//				if (compareMap == null) {
//					throw new PlatException("当传入的比较类型为Map,compareMap参数必填");
//				}
//				comparisonList = compareMap((Map) beforeObj, (Map) afterObj, compareMap, true);
//
//			}
//			return comparisonList;
//		} catch (PlatException e) {
//			e.printStackTrace();
//			throw new PlatException(e.getMessage());
//		}
//	}
//
//	/**
//	 * 获取EiBlock块中的分页信息.
//	 * @param eiBlock
//	 * @return
//	 */
//	public static Map getOffsetAndLimit(EiBlock eiBlock) {
//		Map map = new HashMap();
//		int offset = EiConstant.defaultOffset;
//		int limit = EiConstant.defaultLimit;
//
//		if(Objects.nonNull(eiBlock)){
//			offset = eiBlock.getInt(EiConstant.offsetStr);
//			limit = eiBlock.getInt(EiConstant.limitStr);
//
//			if(limit == 0){
//				limit = EiConstant.defaultLimit;
//			}
//		}
//
//		map.put(EiConstant.offsetStr,offset);
//		map.put(EiConstant.limitStr,limit);
//
//		return map;
//	}
//
////	/**
////	 * 把业务日志保存到Tpmjpd5表.
////	 *
////	 * @param bean
////	 */
////	public static void saveTpmjpd5(Tpmjpd5 bean) {
////		setCreator(bean, true);
////		sqlDao.executeSql(TPMJPD5_SQL.replace("#REC_CREATOR_ID#", bean.getRecCreatorId())
////				.replace("#REC_CREATOR_NAME#", bean.getRecCreatorName())
////				.replace("#REC_CREATOR_JOB_ID#", bean.getRecCreatorJobId())
////				.replace("#REC_CREATE_TIME#", bean.getRecCreateTime())
////				.replace("#INTERNAL_CODE#", bean.getInternalCode())
////				.replace("#OPERATION_MODULE#", bean.getOperationModule())
////				.replace("#OPERATION_PAGE#", bean.getOperationPage())
////				.replace("#OPERATION_BUTTON#", bean.getOperationButton())
////				.replace("#OPERATION_TYPE#", bean.getOperationType()).replace("#MESSAGE#", bean.getMessage())
////				.replace("#STATE#", bean.getState()));
////
////	}
//
////	/**
////	 * 审核履历日志保存到Tpmjpd6表.
////	 *
////	 * @param bean
////	 * @param dao
////	 */
////	public void saveTpmjpd6(Tpmjpd6 bean) {
////		try {
////			DaoERPBase.getInstance().insert(bean);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////
////	}
//
//	/**
//	 * getComparisonDataList.
//	 *
//	 * @param afrerMap
//	 * @param beforeMap
//	 * @param businessTable
//	 */
//	public static List<ComparisonData> getComparisonDataList(Map<String, Object> afrerMap,
//															 Map<String, Object> beforeMap, String businessTable) {
//		List<ComparisonData> compareList = new ArrayList<>();
//
//		for (String in : beforeMap.keySet()) {
//			ComparisonData dataComparison = new ComparisonData();
//			dataComparison.setBusinessKey(in);
//			dataComparison.setBusinessTable(businessTable);
//			dataComparison.setAfterData(afrerMap.get(in));
//			dataComparison.setBeforeData(beforeMap.get(in));
//			compareList.add(dataComparison);
//		}
//		return compareList;
//	}
//}