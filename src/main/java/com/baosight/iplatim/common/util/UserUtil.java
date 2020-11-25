//package com.baosight.iplatim.common.util;
//
//import com.baosight.erp.api.ERPApi;
//import com.baosight.erp.security.domain.IJob;
//import com.baosight.erp.security.domain.IJobUser;
//import com.baosight.erp.security.domain.IOrganization;
//import com.baosight.erp.security.domain.IUser;
//import com.baosight.erp.util.ERPUserSessionUtils;
//import com.baosight.iplat4j.core.data.ibatis.dao.Dao;
//import com.baosight.iplat4j.core.ei.EiConstant;
//import com.baosight.iplat4j.core.ei.EiInfo;
//import com.baosight.iplat4j.core.exception.PlatException;
//import com.baosight.iplat4j.core.ioc.spring.PlatApplicationContext;
//import com.baosight.iplat4j.core.security.sso.SSOCredential;
//import com.baosight.iplat4j.core.service.soa.XLocalManager;
//import com.baosight.iplat4j.core.web.threadlocal.ThreadConstants;
//import com.baosight.iplat4j.core.web.threadlocal.UserSession;
//import com.baosight.pscs.common.pm.api.PmCallApiFactory;
//import com.baosight.pscs.common.pm.domain.Tpmjpa1;
//import com.baosight.pscs.common.pm.domain.Tpmjpa3;
//import com.baosight.pscs.common.util.bizTrans.CollectionUtils;
//import com.baosight.pscs.common.util.bizTrans.JavaBeanUtil;
//import org.apache.commons.lang.StringUtils;
//
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 当前登陆人信息.
// *
// * @author kankan
// *
// */
//public class UserUtil {
//
//	/**
//	 * 当前人账号.
//	 */
//	public static String getLoginId() {
//		if (!getUserId().trim().equals("")) {
//			return getUserId();
//		} else {
//			return StringUtils.defaultIfEmpty((String) UserSession.getLoginName(), " ");
//		}
//	}
//
//	/**
//	 * 当前人工号.
//	 */
//	public static String getUserId() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getUser().getEname(), " ");
//	}
//
//	/**
//	 * 当前人姓名.
//	 */
//	public static String getUserCname() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getUser().getCname(), " ");
//	}
//
//	/**
//	 * 取得登录人岗位号.
//	 * 11-2, 暂时修改.
//	 */
//	public static String getJobId() {
////		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getJob().getEname(), " ");
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getUser().getEname(), " ");
//	}
//
//	/**
//	 * 取得岗位名称.
//	 * 11-2, 暂时修改.
//	 */
//	public static String getJobName() {
////		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getJob().getCname(), " ");
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getUser().getCname(), " ");
//	}
//
//	/**
//	 * 取得公司代码.
//	 */
//	public static String getCompanyId() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getCompany().getEname(), " ");
//	}
//
//	/**
//	 * 取得公司名称.
//	 */
//	public static String getCompanyName() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getCompany().getCname(), " ");
//	}
//
//	/**
//	 * 取得部门代码.
//	 */
//	public static String getDeptId() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getOrganization().getEname(), " ");
//	}
//
//	/**
//	 * 取得部门名称.
//	 */
//	public static String getDeptName() {
//		return StringUtils.defaultIfEmpty(ERPUserSessionUtils.getOrganization().getCname(), " ");
//	}
//
//	/**
//	 * 当前人采购组织.
//	 */
//	public static String getPurOrgId() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.PUR_ORG_ID),
//				getPurOrgByjobId());
//	}
//
//	/**
//	 * purBillTo.
//	 */
//	public static String getPurBillTo() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.PUR_BILL_TO),
//				getPurBillToBYJobId());
//	}
//
//	/**
//	 * purBillName.
//	 */
//	public static String getPurBillName() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.PUR_BILL_NAME),
//				" ");
//	}
//
//	/**
//	 * 当前人采购组织名称.
//	 */
//	public static String getPurOrgName() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.PUR_ORG_NAME),
//				getDeptName(getPurOrgByjobId()));
//	}
//
//	/**
//	 * 当前人帐套.
//	 */
//	public static String getDrawBillTo() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.BILL_TO),
//				" ");
//	}
//
//	/**
//	 * 当前人帐套名称.
//	 */
//	public static String getDrawBillName() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.BILL_NAME),
//				" ");
//	}
//
//	/**
//	 * 当人所在公司.
//	 */
//	public static String getRootDept() {
//	    if(" ".equals(getJobId())){
//	        return " ";
//        }
//		return getJobId().substring(0, 4);
//	}
//
//	/**
//	 * 当前人默认领用地区.
//	 */
//	public static String getAreaId() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.AREA_ID), " ");
//	}
//
//	/**
//	 * 当前人默认采购地区.
//	 */
//	public static String getPurAreaId() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.PUR_AREA_ID), " ");
//	}
//
//	/**
//	 * 当前人默认到货点.
//	 */
//	public static String getShiptoId() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.SHIPTO_ID), " ");
//	}
//
//	/**
//	 * 取得当前用户的IP地址.
//	 */
//	public static String getIpAddress() {
//		return UserSession.getIpaddress();
//	}
//
//	/**
//	 * email.
//	 */
//	public static String getEmail() {
//		return ERPUserSessionUtils.getUser().getEmail();
//	}
//
//	/**
//	 * address.
//	 */
//	public static String getAddress() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.ADDRESS), " ");
//	}
//
//	/**
//	 * mobilePhone.
//	 */
//	public static String getMobilePhone() {
//		return ERPUserSessionUtils.getUser().getMobile();
//	}
//
//	/**
//	 * telPhone.
//	 */
//	public static String getTelPhone() {
//		return ERPUserSessionUtils.getUser().getMobile();
//	}
//
//	/**
//	 * contactFax.
//	 */
//	public static String getContactFax() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.CONTACT_FAX), " ");
//	}
//
//	/**
//	 * movFlag.
//	 */
//	public static String getMovFlag() {
//		return StringUtils.defaultIfEmpty((String) UserSession.getInSessionProperty(BizUserConstants.MOVFLAG), " ");
//	}
//
//	/**
//	 * 根据部门代码获取部门名称.
//	 *
//	 * @param deptId 部门代码.
//	 * @return 部门名称.
//	 * @throws Exception
//	 */
//	public static String getDeptNameByDeptId(String deptId) {
//		Tpmjpa3 bean = new Tpmjpa3();
//		bean.setOrgId(deptId);
//		List<Tpmjpa3> pmjpa3s = PmCallApiFactory.getPmCallApiInstance().getDepartmentInfo(bean);
//		if (pmjpa3s.size() > 0){
//			return pmjpa3s.get(0).getOrgName();
//		} else {
//			return "";
//		}
//	}
//
//	/**
//	 * 根据岗号获取人员.
//	 *
//	 * @param jobId
//	 * @return
//	 */
//	public static UserOrg getUseOrgByJob(String jobId) {
//		UserOrg userOrg = new UserOrg();
//
//		IJob job = ERPApi.getJobApi().getJob(jobId);
//
//		List<IJobUser> listJobUser = ERPApi.getJobApi().listUser(job);
//		if(listJobUser.isEmpty()){
//			userOrg = initUserOrg(userOrg, null, job);
//		}else{
//			IUser user = ERPApi.getJobApi().listUser(job).get(0).getUser();
//
//			userOrg = initUserOrg(userOrg, user, job);
//		}
//
//		return userOrg;
//	}
//
//	/**
//	 * 根据工号获取人员.
//	 *
//	 * @param userId
//	 * @return
//	 */
//	public static UserOrg getUseOrgByUserId(String userId) {
//		UserOrg userOrg = new UserOrg();
//
//		String ename = ERPUserSessionUtils.getUser().getEname();
//		String id = ERPUserSessionUtils.getUser().getId();
//
//		IUser user = ERPApi.getUserApi().getUser(ename);
//		IOrganization organization = ERPApi.getUserApi().getOrganization(user);
//
//		List<IJobUser> listJobUser = ERPApi.getUserApi().listJob(user, organization);
//
//		if(listJobUser.isEmpty()){
//			userOrg = initUserOrg(userOrg, user, null);
//		}else{
//			IJob job = ERPApi.getUserApi().listJob(user, organization).get(0).getJob();
//
//			userOrg = initUserOrg(userOrg, user, job);
//		}
//
//		return userOrg;
//	}
//
//	/**
//	 * 在Jsp当中塞用户信息.
//	 *
//	 * @param session
//	 * @param loginId
//	 * @return
//	 */
//	public static String addUserInfoToSessionInJsp(HttpSession session, String loginId) {
////		List<UserOrg> userOrgs = PmRestCall.getUserOrg(loginId, "");
//		// 还在等ERP接口，目前默认用户为空
//		List<UserOrg> userOrgs = new ArrayList<>();
//		userOrgs.add(new UserOrg());
//		String returnFlag = "";
//		if (userOrgs.size() == 1) {
//			UserOrg userOrg = userOrgs.get(0);
//			/** 只有一个岗位号 */
//			returnFlag = "1";
//			setUserValue(session, userOrg);
//
//		} else if (userOrgs.size() > 1) {
//			/** 工号不止一个岗位号 */
//			returnFlag = "2";
//		} else {
//			/** 没有查询到有效岗位信息 */
//			returnFlag = "0";
//		}
//		return returnFlag;
//	}
//
//	/**
//	 * 在service当中塞用户信息.
//	 *
//	 * @param jobId
//	 * @throws Exception
//	 */
//	public static void addUserInfoToSessionInService(String jobId) {
//		UserOrg userOrg = getUseOrgByJob(jobId);
//		setUserValue(null, userOrg);
//	}
//
//	/**
//	 * 在service当中塞用户信息.
//	 *
//	 * @param jobId
//	 * @throws Exception
//	 */
//	public static void addUserInfoToSessionInService(String jobId, String movFlag) {
//		UserOrg userOrg = getUseOrgByJob(jobId);
//		userOrg.setMovFlag(movFlag);
//		setUserValue(null, userOrg);
//	}
//
//	/**
//	 * 塞用户信息.
//	 *
//	 * @param session
//	 * @param userOrg
//	 */
//	private static void setUserValue(HttpSession session, UserOrg userOrg) {
//		setUserValue(session, ThreadConstants.LOGINNAME_PROPERTY, userOrg.getUserId());
//
//		setUserValue(session, BizUserConstants.USER_LOGIN_ID, userOrg.getUserId());
//		setUserValue(session, BizUserConstants.USER_CNAME, userOrg.getUserName());
////		setUserValue(session, BizUserConstants.DD_BILL_NAME, userOrg.getDrawBillName());
////		setUserValue(session, BizUserConstants.DD_BILL_TO, userOrg.getDrawBillTo());
//		setUserValue(session, BizUserConstants.BILL_NAME, userOrg.getDrawBillName());
//		setUserValue(session, BizUserConstants.BILL_TO, userOrg.getDrawBillTo());
//		setUserValue(session, BizUserConstants.DEPT_ID, userOrg.getDeptId());
//		setUserValue(session, BizUserConstants.DEPT_NAME, userOrg.getDeptName());
//		setUserValue(session, BizUserConstants.JOB_ID, userOrg.getPostId());
//		setUserValue(session, BizUserConstants.JOB_NAME, userOrg.getPostName());
//		setUserValue(session, BizUserConstants.PUR_ORG_ID, userOrg.getPurOrgId());
//		setUserValue(session, BizUserConstants.PUR_ORG_NAME, userOrg.getPurOrgName());
//		setUserValue(session, BizUserConstants.SHIPTO_ID, userOrg.getShipToId());
//		setUserValue(session, BizUserConstants.PUR_BILL_TO, userOrg.getPurBillTo());
//		setUserValue(session, BizUserConstants.PUR_BILL_NAME, userOrg.getPurBillName());
//		setUserValue(session, BizUserConstants.AREA_ID, userOrg.getAreaId());
//		setUserValue(session, BizUserConstants.PUR_AREA_ID, userOrg.getPurAreaId());
//		setUserValue(session, BizUserConstants.EMAIL, userOrg.getEmail());
//		setUserValue(session, BizUserConstants.ADDRESS, userOrg.getAddress());
//		setUserValue(session, BizUserConstants.MOBILE_PHONE, userOrg.getMobilePhone());
//		setUserValue(session, BizUserConstants.TEL_PHONE, userOrg.getTelPhone());
//		setUserValue(session, BizUserConstants.MOVFLAG, userOrg.getMovFlag());
//
////		if(1 ==1){
////			Tpmjpd7 d7 = new Tpmjpd7();
////			d7.setTypeId("PSCS-LOGIN");
////			d7.setReserve01(userOrg.getUserId());
////			d7.setReserve02(userOrg.getPostId());
////			CatchLog.writeTxMsg(d7);
////		}
//	}
//
//	/**
//	 * 塞用户信息.
//	 *
//	 * @param session
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	private static void setUserValue(HttpSession session, String key, String value) {
//		if (session == null) {
//			UserSession.setOutSessionProperty(key, value);
//		} else {
//			session.setAttribute(key, value);
//		}
//	}
//
////	/**
////	 * 查询自定义消息通知
////	 * @param inInfo
////	 * @return
////	 */
////	public static EiInfo queryMessageNotify (Dao dao,EiInfo inInfo) {
////
////		try {
////
////			List<Tpmwat1> list=(List<Tpmwat1>)inInfo.get("dataList");
////			List<Tpmwat1> reList= new ArrayList();
////			Map map=new HashMap();
////			for (int i = 0; i < list.size(); i++) {
////				Tpmwat1 bean=new Tpmwat1();
////				bean.fromMap(list.get(i).toMap());
////				map.put("sqlString", bean.getNotifySql());
////				int count =dao.count("PMWACommon.queryMessageNotify", map);
////				if(count>0){
////					String desc = bean.getNotifyDesc();
////					desc=desc.replaceAll("\\?", String.valueOf(count));
////					bean.setNotifyDesc(desc);
////					reList.add(bean);
////				}
////			}
////
////
////			inInfo.addBlock("data").set("countList", reList);
////			inInfo.setStatus(EiConstant.STATUS_SUCCESS);
////			return inInfo;
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////			inInfo.setStatus(EiConstant.STATUS_FAILURE);
////			inInfo.setMsg(e.getMessage());
////			return inInfo;
////		}
////
////	}
//
//	/**
//	 * 传入目标系统名（目前影像系统为BFMSIMG）. 返回单点登陆验证条件语句. 获取参数条件语句后直接拼接至目标url之后.
//	 *
//	 * @param targetSystemEname
//	 * @return
//	 */
//	public static String getSSOAuthenString(String targetSystemEname) {
//		String authenString = "p_username=#userName#&p_password=#credential#&p_authen=#authen#";
//		String userName = UserSession.getLoginName();
//		String authenType = "Trust";
//		SSOCredential credentialChecker = (SSOCredential) PlatApplicationContext.getBean(authenType);
//		String cre = credentialChecker.composeCredential(userName, targetSystemEname);
//		authenString = authenString.replace("#userName#", userName).replace("#credential#", cre).replace("#authen#",
//				authenType);
//		return authenString;
//	}
//
//	/**
//	 * getPurOrgByjobId.
//	 *
//	 * @return
//	 */
//	public static String getPurOrgByjobId() {
//		Map map = new HashMap();
//		map.put("stateId", "1");
//		map.put("ddBillTo", getDrawBillTo());
//		map.put("itemType", "C");
//		Dao dao = (Dao) PlatApplicationContext.getBean("dao");
//		List<Map> queryResult = dao.query("PMJPB1.query", map);
//		return queryResult.size() > 0 ? queryResult.get(0).get("purOrgId").toString() : " ";
//	}
//
//	/**
//	 * getPurBillToBYJobId.
//	 *
//	 * @return
//	 */
//	public static String getPurBillToBYJobId() {
//		Map map = new HashMap();
//		map.put("stateId", "1");
//		map.put("ddBillTo", getDrawBillTo());
//		map.put("itemType", "C");
//		Dao dao = (Dao) PlatApplicationContext.getBean("dao");
//		List<Map> queryResult = dao.query("PMJPB1.query", map);
//		return queryResult.size() > 0 ? queryResult.get(0).get("purBillTo").toString() : " ";
//	}
//
//	/**
//	 * getDeptName.
//	 *
//	 * @return
//	 */
//	public static String getDeptName(String deptId) {
//		Map map = new HashMap();
//		map.put("stateId", "1");
//		map.put("orgIdPmjpa31", deptId);
//		Dao dao = (Dao) PlatApplicationContext.getBean("dao");
//		List<Tpmjpa3> queryResult = dao.query("PMJPA3.query", map);
//		return queryResult.size() > 0 ? queryResult.get(0).getOrgName().toString() : " ";
//	}
//
//	/**
//     * 根据账套获取公司别.
//     *
//     * @param billTo
//     * @return
//     */
//    public static String getCompanyBill(String billTo) throws PlatException {
//        if (StringUtils.isBlank(billTo)){
//			throw new PlatException("账套不能为空！");
//		}
//
//        Tpmjpa1 bean = new Tpmjpa1();
//        bean.setAllBillTo(billTo);
//        List<Tpmjpa1> lists = getCompanyBillToInfo(bean, "");
//        return lists.size() == 1 ? lists.get(0).getReserve1() : "数据有误!";
//    }
//
//    /**
//     * 获取公司帐套信息.
//     * @throws PlatException
//     */
//    public static List<Tpmjpa1> getCompanyBillToInfo(Tpmjpa1 bean, String sqlCon) throws PlatException {
//        // 调用微服务
//
//        EiInfo inInfo = new EiInfo();
//		inInfo.addBlock(EiConstant.queryBlock);
//		inInfo.getBlock(EiConstant.queryBlock).addBlockMeta(bean.eiMetadata);
//		inInfo.getBlock(EiConstant.queryBlock).addRow(CollectionUtils.tranMapKeyValueToHashMap(bean.toMap()));
//		inInfo.setCell(EiConstant.queryBlock, 0, "sqlCon", sqlCon.replaceAll("#prefix#", "T"));
//
//		inInfo.set(EiConstant.serviceName, "PMCommon");
//		inInfo.set(EiConstant.methodName, "getDistributionPoint");
//		inInfo = XLocalManager.call(inInfo);
//
//		List<Map> datas = inInfo.getBlock(EiConstant.resultBlock).getRows();
//		List<Tpmjpa1> pmjpa1s = new ArrayList<Tpmjpa1>();
//		Tpmjpa1 transBean = null;
//		for (Map map : datas) {
//			transBean = new Tpmjpa1();
//			JavaBeanUtil.copyMap2Pojo(transBean, map, true);
//			pmjpa1s.add(transBean);
//		}
//
//		return pmjpa1s;
//    }
//
//	/**
//	 * 根据ERP接口获取的User Job对象，生成UserOrg.
//	 * @param userOrg
//	 * @param user
//	 * @param job
//	 * @return
//	 */
//	private static UserOrg initUserOrg(UserOrg userOrg, IUser user, IJob job){
//
//		if(null != user){
//			userOrg.setUserId(user.getId());
//			userOrg.setUserName(user.getCname());
//			userOrg.setTelPhone(user.getMobile());
//			userOrg.setEmail(user.getEmail());
//		}
//
//		if(null != job){
//			userOrg.setPostId(job.getId());
//			userOrg.setPostCode(job.getEname());
//			userOrg.setPostName(job.getCname());
//
//			userOrg.setDeptId(job.getOrganization().getEname());
//			userOrg.setDeptName(job.getOrganization().getCname());
//		}
//
//		return userOrg;
//	}
//}
