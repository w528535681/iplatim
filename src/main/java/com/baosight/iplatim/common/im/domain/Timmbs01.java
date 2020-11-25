/**
* Generate time : 2020-11-18 16:28:56
* Version : 1.0
*/
package com.baosight.iplatim.common.im.domain;
import com.baosight.iplat4j.core.util.NumberUtils;
import com.baosight.iplat4j.core.ei.EiColumn;
import com.baosight.iplat4j.core.data.DaoEPBase;
import java.util.HashMap;
import java.util.Map;
import com.baosight.iplat4j.core.util.StringUtils;

/**
* Timmbs01
* 
*/
public class Timmbs01 extends DaoEPBase {

                private Integer id = 0;		/* 主键*/
                private String rctor = " ";		/* 记录创建责任者*/
                private String rctime = " ";		/* 记录创建时刻*/
                private String rrtor = " ";		/* 记录修改责任者*/
                private String rrtime = " ";		/* 记录修改时刻*/
                private String rdtor = " ";		/* 修改/删除责任者*/
                private String rdtime = " ";		/* 修改/删除时间*/
                private String rstate = " ";		/* 归档标记*/
                private String rdel = " ";		/* 删除标记*/
                private String comName = " ";		/* 公司(帐套)中文*/
                private String comCode = " ";		/* 公司(帐套)代码*/
                private String itemCode = " ";		/* 指标代码*/
                private String itemName = " ";		/* 指标简称*/
                private String itemDes = " ";		/* 指标描述*/
                private String measUnit = " ";		/* 计量单位*/
                private String algoSub = " ";		/* 子项算法*/
                private String algoPar = " ";		/* 母项算法*/
                private String dataType = " ";		/* 数据类型*/
                private String itemCodePerf = " ";		/* 实绩指标代码*/
                private String bc001 = " ";		/* 备用字符001*/
                private String bc002 = " ";		/* 备用字符002*/
                private String bc003 = " ";		/* 备用字符003*/
                private String bc004 = " ";		/* 备用字符004*/
                private String bc005 = " ";		/* 备用字符005*/
                private String bc006 = " ";		/* 备用字符006*/
                private String bc007 = " ";		/* 备用字符007*/
                private String bc008 = " ";		/* 备用字符008*/
                private String bc009 = " ";		/* 备用字符009*/
                private String bc010 = " ";		/* 备用字符010*/
                private String bc011 = " ";		/* 备用字符011*/
                private String bc012 = " ";		/* 备用字符012*/
                private String bc013 = " ";		/* 备用字符013*/
                private String bc014 = " ";		/* 备用字符014*/
                private String bc015 = " ";		/* 备用字符015*/
                private String bc016 = " ";		/* 备用字符016*/
                private String bc017 = " ";		/* 备用字符017*/
                private String bc018 = " ";		/* 备用字符018*/
                private String bc019 = " ";		/* 备用字符019*/
                private String bc020 = " ";		/* 备用字符020*/
                private Integer bn001 = Integer.valueOf(0);		/* 备用数值001*/
                private Integer bn002 = Integer.valueOf(0);		/* 备用数值002*/
                private Integer bn003 = Integer.valueOf(0);		/* 备用数值003*/
                private Integer bn004 = Integer.valueOf(0);		/* 备用数值004*/
                private Integer bn005 = Integer.valueOf(0);		/* 备用数值005*/
                private Integer bn006 = Integer.valueOf(0);		/* 备用数值006*/
                private Integer bn007 = Integer.valueOf(0);		/* 备用数值007*/
                private Integer bn008 = Integer.valueOf(0);		/* 备用数值008*/
                private Integer bn009 = Integer.valueOf(0);		/* 备用数值009*/
                private Integer bn010 = Integer.valueOf(0);		/* 备用数值010*/
                private Integer bn011 = Integer.valueOf(0);		/* 备用数值011*/
                private Integer bn012 = Integer.valueOf(0);		/* 备用数值012*/
                private Integer bn013 = Integer.valueOf(0);		/* 备用数值013*/
                private Integer bn014 = Integer.valueOf(0);		/* 备用数值014*/
                private Integer bn015 = Integer.valueOf(0);		/* 备用数值015*/
                private Integer bn016 = Integer.valueOf(0);		/* 备用数值016*/
                private Integer bn017 = Integer.valueOf(0);		/* 备用数值017*/
                private Integer bn018 = Integer.valueOf(0);		/* 备用数值018*/
                private Integer bn019 = Integer.valueOf(0);		/* 备用数值019*/
                private Integer bn020 = Integer.valueOf(0);		/* 备用数值020*/
/**
* initialize the metadata
*/
public void initMetaData() {
EiColumn eiColumn;

        eiColumn = new EiColumn("id");
        eiColumn.setPrimaryKey(true);
        eiColumn.setDescName("主键");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rctor");
        eiColumn.setDescName("记录创建责任者");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rctime");
        eiColumn.setDescName("记录创建时刻");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rrtor");
        eiColumn.setDescName("记录修改责任者");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rrtime");
        eiColumn.setDescName("记录修改时刻");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rdtor");
        eiColumn.setDescName("修改/删除责任者");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rdtime");
        eiColumn.setDescName("修改/删除时间");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rstate");
        eiColumn.setDescName("归档标记");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("rdel");
        eiColumn.setDescName("删除标记");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("comName");
        eiColumn.setDescName("公司(帐套)中文");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("comCode");
        eiColumn.setDescName("公司(帐套)代码");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("itemCode");
        eiColumn.setDescName("指标代码");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("itemName");
        eiColumn.setDescName("指标简称");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("itemDes");
        eiColumn.setDescName("指标描述");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("measUnit");
        eiColumn.setDescName("计量单位");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("algoSub");
        eiColumn.setDescName("子项算法");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("algoPar");
        eiColumn.setDescName("母项算法");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("dataType");
        eiColumn.setDescName("数据类型");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("itemCodePerf");
        eiColumn.setDescName("实绩指标代码");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc001");
        eiColumn.setDescName("备用字符001");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc002");
        eiColumn.setDescName("备用字符002");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc003");
        eiColumn.setDescName("备用字符003");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc004");
        eiColumn.setDescName("备用字符004");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc005");
        eiColumn.setDescName("备用字符005");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc006");
        eiColumn.setDescName("备用字符006");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc007");
        eiColumn.setDescName("备用字符007");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc008");
        eiColumn.setDescName("备用字符008");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc009");
        eiColumn.setDescName("备用字符009");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc010");
        eiColumn.setDescName("备用字符010");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc011");
        eiColumn.setDescName("备用字符011");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc012");
        eiColumn.setDescName("备用字符012");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc013");
        eiColumn.setDescName("备用字符013");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc014");
        eiColumn.setDescName("备用字符014");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc015");
        eiColumn.setDescName("备用字符015");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc016");
        eiColumn.setDescName("备用字符016");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc017");
        eiColumn.setDescName("备用字符017");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc018");
        eiColumn.setDescName("备用字符018");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc019");
        eiColumn.setDescName("备用字符019");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bc020");
        eiColumn.setDescName("备用字符020");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn001");
        eiColumn.setDescName("备用数值001");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn002");
        eiColumn.setDescName("备用数值002");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn003");
        eiColumn.setDescName("备用数值003");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn004");
        eiColumn.setDescName("备用数值004");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn005");
        eiColumn.setDescName("备用数值005");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn006");
        eiColumn.setDescName("备用数值006");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn007");
        eiColumn.setDescName("备用数值007");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn008");
        eiColumn.setDescName("备用数值008");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn009");
        eiColumn.setDescName("备用数值009");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn010");
        eiColumn.setDescName("备用数值010");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn011");
        eiColumn.setDescName("备用数值011");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn012");
        eiColumn.setDescName("备用数值012");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn013");
        eiColumn.setDescName("备用数值013");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn014");
        eiColumn.setDescName("备用数值014");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn015");
        eiColumn.setDescName("备用数值015");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn016");
        eiColumn.setDescName("备用数值016");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn017");
        eiColumn.setDescName("备用数值017");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn018");
        eiColumn.setDescName("备用数值018");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn019");
        eiColumn.setDescName("备用数值019");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("bn020");
        eiColumn.setDescName("备用数值020");
        eiMetadata.addMeta(eiColumn);


}
/**
* the constructor
*/
public Timmbs01() {
initMetaData();
}

        /**
        * get the id - 主键
        * @return the id
        */
        public Integer getId() {
        return this.id;
        }

        /**
        * set the id - 主键
        */
        public void setId(Integer id) {
        this.id = id;
        }
        /**
        * get the rctor - 记录创建责任者
        * @return the rctor
        */
        public String getRctor() {
        return this.rctor;
        }

        /**
        * set the rctor - 记录创建责任者
        */
        public void setRctor(String rctor) {
        this.rctor = rctor;
        }
        /**
        * get the rctime - 记录创建时刻
        * @return the rctime
        */
        public String getRctime() {
        return this.rctime;
        }

        /**
        * set the rctime - 记录创建时刻
        */
        public void setRctime(String rctime) {
        this.rctime = rctime;
        }
        /**
        * get the rrtor - 记录修改责任者
        * @return the rrtor
        */
        public String getRrtor() {
        return this.rrtor;
        }

        /**
        * set the rrtor - 记录修改责任者
        */
        public void setRrtor(String rrtor) {
        this.rrtor = rrtor;
        }
        /**
        * get the rrtime - 记录修改时刻
        * @return the rrtime
        */
        public String getRrtime() {
        return this.rrtime;
        }

        /**
        * set the rrtime - 记录修改时刻
        */
        public void setRrtime(String rrtime) {
        this.rrtime = rrtime;
        }
        /**
        * get the rdtor - 修改/删除责任者
        * @return the rdtor
        */
        public String getRdtor() {
        return this.rdtor;
        }

        /**
        * set the rdtor - 修改/删除责任者
        */
        public void setRdtor(String rdtor) {
        this.rdtor = rdtor;
        }
        /**
        * get the rdtime - 修改/删除时间
        * @return the rdtime
        */
        public String getRdtime() {
        return this.rdtime;
        }

        /**
        * set the rdtime - 修改/删除时间
        */
        public void setRdtime(String rdtime) {
        this.rdtime = rdtime;
        }
        /**
        * get the rstate - 归档标记
        * @return the rstate
        */
        public String getRstate() {
        return this.rstate;
        }

        /**
        * set the rstate - 归档标记
        */
        public void setRstate(String rstate) {
        this.rstate = rstate;
        }
        /**
        * get the rdel - 删除标记
        * @return the rdel
        */
        public String getRdel() {
        return this.rdel;
        }

        /**
        * set the rdel - 删除标记
        */
        public void setRdel(String rdel) {
        this.rdel = rdel;
        }
        /**
        * get the comName - 公司(帐套)中文
        * @return the comName
        */
        public String getComName() {
        return this.comName;
        }

        /**
        * set the comName - 公司(帐套)中文
        */
        public void setComName(String comName) {
        this.comName = comName;
        }
        /**
        * get the comCode - 公司(帐套)代码
        * @return the comCode
        */
        public String getComCode() {
        return this.comCode;
        }

        /**
        * set the comCode - 公司(帐套)代码
        */
        public void setComCode(String comCode) {
        this.comCode = comCode;
        }
        /**
        * get the itemCode - 指标代码
        * @return the itemCode
        */
        public String getItemCode() {
        return this.itemCode;
        }

        /**
        * set the itemCode - 指标代码
        */
        public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
        }
        /**
        * get the itemName - 指标简称
        * @return the itemName
        */
        public String getItemName() {
        return this.itemName;
        }

        /**
        * set the itemName - 指标简称
        */
        public void setItemName(String itemName) {
        this.itemName = itemName;
        }
        /**
        * get the itemDes - 指标描述
        * @return the itemDes
        */
        public String getItemDes() {
        return this.itemDes;
        }

        /**
        * set the itemDes - 指标描述
        */
        public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
        }
        /**
        * get the measUnit - 计量单位
        * @return the measUnit
        */
        public String getMeasUnit() {
        return this.measUnit;
        }

        /**
        * set the measUnit - 计量单位
        */
        public void setMeasUnit(String measUnit) {
        this.measUnit = measUnit;
        }
        /**
        * get the algoSub - 子项算法
        * @return the algoSub
        */
        public String getAlgoSub() {
        return this.algoSub;
        }

        /**
        * set the algoSub - 子项算法
        */
        public void setAlgoSub(String algoSub) {
        this.algoSub = algoSub;
        }
        /**
        * get the algoPar - 母项算法
        * @return the algoPar
        */
        public String getAlgoPar() {
        return this.algoPar;
        }

        /**
        * set the algoPar - 母项算法
        */
        public void setAlgoPar(String algoPar) {
        this.algoPar = algoPar;
        }
        /**
        * get the dataType - 数据类型
        * @return the dataType
        */
        public String getDataType() {
        return this.dataType;
        }

        /**
        * set the dataType - 数据类型
        */
        public void setDataType(String dataType) {
        this.dataType = dataType;
        }
        /**
        * get the itemCodePerf - 实绩指标代码
        * @return the itemCodePerf
        */
        public String getItemCodePerf() {
        return this.itemCodePerf;
        }

        /**
        * set the itemCodePerf - 实绩指标代码
        */
        public void setItemCodePerf(String itemCodePerf) {
        this.itemCodePerf = itemCodePerf;
        }
        /**
        * get the bc001 - 备用字符001
        * @return the bc001
        */
        public String getBc001() {
        return this.bc001;
        }

        /**
        * set the bc001 - 备用字符001
        */
        public void setBc001(String bc001) {
        this.bc001 = bc001;
        }
        /**
        * get the bc002 - 备用字符002
        * @return the bc002
        */
        public String getBc002() {
        return this.bc002;
        }

        /**
        * set the bc002 - 备用字符002
        */
        public void setBc002(String bc002) {
        this.bc002 = bc002;
        }
        /**
        * get the bc003 - 备用字符003
        * @return the bc003
        */
        public String getBc003() {
        return this.bc003;
        }

        /**
        * set the bc003 - 备用字符003
        */
        public void setBc003(String bc003) {
        this.bc003 = bc003;
        }
        /**
        * get the bc004 - 备用字符004
        * @return the bc004
        */
        public String getBc004() {
        return this.bc004;
        }

        /**
        * set the bc004 - 备用字符004
        */
        public void setBc004(String bc004) {
        this.bc004 = bc004;
        }
        /**
        * get the bc005 - 备用字符005
        * @return the bc005
        */
        public String getBc005() {
        return this.bc005;
        }

        /**
        * set the bc005 - 备用字符005
        */
        public void setBc005(String bc005) {
        this.bc005 = bc005;
        }
        /**
        * get the bc006 - 备用字符006
        * @return the bc006
        */
        public String getBc006() {
        return this.bc006;
        }

        /**
        * set the bc006 - 备用字符006
        */
        public void setBc006(String bc006) {
        this.bc006 = bc006;
        }
        /**
        * get the bc007 - 备用字符007
        * @return the bc007
        */
        public String getBc007() {
        return this.bc007;
        }

        /**
        * set the bc007 - 备用字符007
        */
        public void setBc007(String bc007) {
        this.bc007 = bc007;
        }
        /**
        * get the bc008 - 备用字符008
        * @return the bc008
        */
        public String getBc008() {
        return this.bc008;
        }

        /**
        * set the bc008 - 备用字符008
        */
        public void setBc008(String bc008) {
        this.bc008 = bc008;
        }
        /**
        * get the bc009 - 备用字符009
        * @return the bc009
        */
        public String getBc009() {
        return this.bc009;
        }

        /**
        * set the bc009 - 备用字符009
        */
        public void setBc009(String bc009) {
        this.bc009 = bc009;
        }
        /**
        * get the bc010 - 备用字符010
        * @return the bc010
        */
        public String getBc010() {
        return this.bc010;
        }

        /**
        * set the bc010 - 备用字符010
        */
        public void setBc010(String bc010) {
        this.bc010 = bc010;
        }
        /**
        * get the bc011 - 备用字符011
        * @return the bc011
        */
        public String getBc011() {
        return this.bc011;
        }

        /**
        * set the bc011 - 备用字符011
        */
        public void setBc011(String bc011) {
        this.bc011 = bc011;
        }
        /**
        * get the bc012 - 备用字符012
        * @return the bc012
        */
        public String getBc012() {
        return this.bc012;
        }

        /**
        * set the bc012 - 备用字符012
        */
        public void setBc012(String bc012) {
        this.bc012 = bc012;
        }
        /**
        * get the bc013 - 备用字符013
        * @return the bc013
        */
        public String getBc013() {
        return this.bc013;
        }

        /**
        * set the bc013 - 备用字符013
        */
        public void setBc013(String bc013) {
        this.bc013 = bc013;
        }
        /**
        * get the bc014 - 备用字符014
        * @return the bc014
        */
        public String getBc014() {
        return this.bc014;
        }

        /**
        * set the bc014 - 备用字符014
        */
        public void setBc014(String bc014) {
        this.bc014 = bc014;
        }
        /**
        * get the bc015 - 备用字符015
        * @return the bc015
        */
        public String getBc015() {
        return this.bc015;
        }

        /**
        * set the bc015 - 备用字符015
        */
        public void setBc015(String bc015) {
        this.bc015 = bc015;
        }
        /**
        * get the bc016 - 备用字符016
        * @return the bc016
        */
        public String getBc016() {
        return this.bc016;
        }

        /**
        * set the bc016 - 备用字符016
        */
        public void setBc016(String bc016) {
        this.bc016 = bc016;
        }
        /**
        * get the bc017 - 备用字符017
        * @return the bc017
        */
        public String getBc017() {
        return this.bc017;
        }

        /**
        * set the bc017 - 备用字符017
        */
        public void setBc017(String bc017) {
        this.bc017 = bc017;
        }
        /**
        * get the bc018 - 备用字符018
        * @return the bc018
        */
        public String getBc018() {
        return this.bc018;
        }

        /**
        * set the bc018 - 备用字符018
        */
        public void setBc018(String bc018) {
        this.bc018 = bc018;
        }
        /**
        * get the bc019 - 备用字符019
        * @return the bc019
        */
        public String getBc019() {
        return this.bc019;
        }

        /**
        * set the bc019 - 备用字符019
        */
        public void setBc019(String bc019) {
        this.bc019 = bc019;
        }
        /**
        * get the bc020 - 备用字符020
        * @return the bc020
        */
        public String getBc020() {
        return this.bc020;
        }

        /**
        * set the bc020 - 备用字符020
        */
        public void setBc020(String bc020) {
        this.bc020 = bc020;
        }
        /**
        * get the bn001 - 备用数值001
        * @return the bn001
        */
        public Integer getBn001() {
        return this.bn001;
        }

        /**
        * set the bn001 - 备用数值001
        */
        public void setBn001(Integer bn001) {
        this.bn001 = bn001;
        }
        /**
        * get the bn002 - 备用数值002
        * @return the bn002
        */
        public Integer getBn002() {
        return this.bn002;
        }

        /**
        * set the bn002 - 备用数值002
        */
        public void setBn002(Integer bn002) {
        this.bn002 = bn002;
        }
        /**
        * get the bn003 - 备用数值003
        * @return the bn003
        */
        public Integer getBn003() {
        return this.bn003;
        }

        /**
        * set the bn003 - 备用数值003
        */
        public void setBn003(Integer bn003) {
        this.bn003 = bn003;
        }
        /**
        * get the bn004 - 备用数值004
        * @return the bn004
        */
        public Integer getBn004() {
        return this.bn004;
        }

        /**
        * set the bn004 - 备用数值004
        */
        public void setBn004(Integer bn004) {
        this.bn004 = bn004;
        }
        /**
        * get the bn005 - 备用数值005
        * @return the bn005
        */
        public Integer getBn005() {
        return this.bn005;
        }

        /**
        * set the bn005 - 备用数值005
        */
        public void setBn005(Integer bn005) {
        this.bn005 = bn005;
        }
        /**
        * get the bn006 - 备用数值006
        * @return the bn006
        */
        public Integer getBn006() {
        return this.bn006;
        }

        /**
        * set the bn006 - 备用数值006
        */
        public void setBn006(Integer bn006) {
        this.bn006 = bn006;
        }
        /**
        * get the bn007 - 备用数值007
        * @return the bn007
        */
        public Integer getBn007() {
        return this.bn007;
        }

        /**
        * set the bn007 - 备用数值007
        */
        public void setBn007(Integer bn007) {
        this.bn007 = bn007;
        }
        /**
        * get the bn008 - 备用数值008
        * @return the bn008
        */
        public Integer getBn008() {
        return this.bn008;
        }

        /**
        * set the bn008 - 备用数值008
        */
        public void setBn008(Integer bn008) {
        this.bn008 = bn008;
        }
        /**
        * get the bn009 - 备用数值009
        * @return the bn009
        */
        public Integer getBn009() {
        return this.bn009;
        }

        /**
        * set the bn009 - 备用数值009
        */
        public void setBn009(Integer bn009) {
        this.bn009 = bn009;
        }
        /**
        * get the bn010 - 备用数值010
        * @return the bn010
        */
        public Integer getBn010() {
        return this.bn010;
        }

        /**
        * set the bn010 - 备用数值010
        */
        public void setBn010(Integer bn010) {
        this.bn010 = bn010;
        }
        /**
        * get the bn011 - 备用数值011
        * @return the bn011
        */
        public Integer getBn011() {
        return this.bn011;
        }

        /**
        * set the bn011 - 备用数值011
        */
        public void setBn011(Integer bn011) {
        this.bn011 = bn011;
        }
        /**
        * get the bn012 - 备用数值012
        * @return the bn012
        */
        public Integer getBn012() {
        return this.bn012;
        }

        /**
        * set the bn012 - 备用数值012
        */
        public void setBn012(Integer bn012) {
        this.bn012 = bn012;
        }
        /**
        * get the bn013 - 备用数值013
        * @return the bn013
        */
        public Integer getBn013() {
        return this.bn013;
        }

        /**
        * set the bn013 - 备用数值013
        */
        public void setBn013(Integer bn013) {
        this.bn013 = bn013;
        }
        /**
        * get the bn014 - 备用数值014
        * @return the bn014
        */
        public Integer getBn014() {
        return this.bn014;
        }

        /**
        * set the bn014 - 备用数值014
        */
        public void setBn014(Integer bn014) {
        this.bn014 = bn014;
        }
        /**
        * get the bn015 - 备用数值015
        * @return the bn015
        */
        public Integer getBn015() {
        return this.bn015;
        }

        /**
        * set the bn015 - 备用数值015
        */
        public void setBn015(Integer bn015) {
        this.bn015 = bn015;
        }
        /**
        * get the bn016 - 备用数值016
        * @return the bn016
        */
        public Integer getBn016() {
        return this.bn016;
        }

        /**
        * set the bn016 - 备用数值016
        */
        public void setBn016(Integer bn016) {
        this.bn016 = bn016;
        }
        /**
        * get the bn017 - 备用数值017
        * @return the bn017
        */
        public Integer getBn017() {
        return this.bn017;
        }

        /**
        * set the bn017 - 备用数值017
        */
        public void setBn017(Integer bn017) {
        this.bn017 = bn017;
        }
        /**
        * get the bn018 - 备用数值018
        * @return the bn018
        */
        public Integer getBn018() {
        return this.bn018;
        }

        /**
        * set the bn018 - 备用数值018
        */
        public void setBn018(Integer bn018) {
        this.bn018 = bn018;
        }
        /**
        * get the bn019 - 备用数值019
        * @return the bn019
        */
        public Integer getBn019() {
        return this.bn019;
        }

        /**
        * set the bn019 - 备用数值019
        */
        public void setBn019(Integer bn019) {
        this.bn019 = bn019;
        }
        /**
        * get the bn020 - 备用数值020
        * @return the bn020
        */
        public Integer getBn020() {
        return this.bn020;
        }

        /**
        * set the bn020 - 备用数值020
        */
        public void setBn020(Integer bn020) {
        this.bn020 = bn020;
        }
/**
* get the value from Map
*/
public void fromMap(Map map) {

                setId(NumberUtils.toInteger(StringUtils.toString(map.get("id")), id));
                setRctor(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rctor")), rctor));
                setRctime(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rctime")), rctime));
                setRrtor(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rrtor")), rrtor));
                setRrtime(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rrtime")), rrtime));
                setRdtor(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rdtor")), rdtor));
                setRdtime(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rdtime")), rdtime));
                setRstate(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rstate")), rstate));
                setRdel(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("rdel")), rdel));
                setComName(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("comName")), comName));
                setComCode(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("comCode")), comCode));
                setItemCode(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("itemCode")), itemCode));
                setItemName(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("itemName")), itemName));
                setItemDes(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("itemDes")), itemDes));
                setMeasUnit(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("measUnit")), measUnit));
                setAlgoSub(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("algoSub")), algoSub));
                setAlgoPar(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("algoPar")), algoPar));
                setDataType(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("dataType")), dataType));
                setItemCodePerf(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("itemCodePerf")), itemCodePerf));
                setBc001(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc001")), bc001));
                setBc002(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc002")), bc002));
                setBc003(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc003")), bc003));
                setBc004(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc004")), bc004));
                setBc005(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc005")), bc005));
                setBc006(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc006")), bc006));
                setBc007(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc007")), bc007));
                setBc008(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc008")), bc008));
                setBc009(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc009")), bc009));
                setBc010(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc010")), bc010));
                setBc011(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc011")), bc011));
                setBc012(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc012")), bc012));
                setBc013(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc013")), bc013));
                setBc014(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc014")), bc014));
                setBc015(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc015")), bc015));
                setBc016(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc016")), bc016));
                setBc017(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc017")), bc017));
                setBc018(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc018")), bc018));
                setBc019(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc019")), bc019));
                setBc020(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("bc020")), bc020));
                setBn001(NumberUtils.toInteger(StringUtils.toString(map.get("bn001")), bn001));
                setBn002(NumberUtils.toInteger(StringUtils.toString(map.get("bn002")), bn002));
                setBn003(NumberUtils.toInteger(StringUtils.toString(map.get("bn003")), bn003));
                setBn004(NumberUtils.toInteger(StringUtils.toString(map.get("bn004")), bn004));
                setBn005(NumberUtils.toInteger(StringUtils.toString(map.get("bn005")), bn005));
                setBn006(NumberUtils.toInteger(StringUtils.toString(map.get("bn006")), bn006));
                setBn007(NumberUtils.toInteger(StringUtils.toString(map.get("bn007")), bn007));
                setBn008(NumberUtils.toInteger(StringUtils.toString(map.get("bn008")), bn008));
                setBn009(NumberUtils.toInteger(StringUtils.toString(map.get("bn009")), bn009));
                setBn010(NumberUtils.toInteger(StringUtils.toString(map.get("bn010")), bn010));
                setBn011(NumberUtils.toInteger(StringUtils.toString(map.get("bn011")), bn011));
                setBn012(NumberUtils.toInteger(StringUtils.toString(map.get("bn012")), bn012));
                setBn013(NumberUtils.toInteger(StringUtils.toString(map.get("bn013")), bn013));
                setBn014(NumberUtils.toInteger(StringUtils.toString(map.get("bn014")), bn014));
                setBn015(NumberUtils.toInteger(StringUtils.toString(map.get("bn015")), bn015));
                setBn016(NumberUtils.toInteger(StringUtils.toString(map.get("bn016")), bn016));
                setBn017(NumberUtils.toInteger(StringUtils.toString(map.get("bn017")), bn017));
                setBn018(NumberUtils.toInteger(StringUtils.toString(map.get("bn018")), bn018));
                setBn019(NumberUtils.toInteger(StringUtils.toString(map.get("bn019")), bn019));
                setBn020(NumberUtils.toInteger(StringUtils.toString(map.get("bn020")), bn020));
}

/**
* set the value to Map
*/
public Map toMap() {

Map map = new HashMap();
                map.put("id",StringUtils.toString(id, eiMetadata.getMeta("id")));
                map.put("rctor",StringUtils.toString(rctor, eiMetadata.getMeta("rctor")));
                map.put("rctime",StringUtils.toString(rctime, eiMetadata.getMeta("rctime")));
                map.put("rrtor",StringUtils.toString(rrtor, eiMetadata.getMeta("rrtor")));
                map.put("rrtime",StringUtils.toString(rrtime, eiMetadata.getMeta("rrtime")));
                map.put("rdtor",StringUtils.toString(rdtor, eiMetadata.getMeta("rdtor")));
                map.put("rdtime",StringUtils.toString(rdtime, eiMetadata.getMeta("rdtime")));
                map.put("rstate",StringUtils.toString(rstate, eiMetadata.getMeta("rstate")));
                map.put("rdel",StringUtils.toString(rdel, eiMetadata.getMeta("rdel")));
                map.put("comName",StringUtils.toString(comName, eiMetadata.getMeta("comName")));
                map.put("comCode",StringUtils.toString(comCode, eiMetadata.getMeta("comCode")));
                map.put("itemCode",StringUtils.toString(itemCode, eiMetadata.getMeta("itemCode")));
                map.put("itemName",StringUtils.toString(itemName, eiMetadata.getMeta("itemName")));
                map.put("itemDes",StringUtils.toString(itemDes, eiMetadata.getMeta("itemDes")));
                map.put("measUnit",StringUtils.toString(measUnit, eiMetadata.getMeta("measUnit")));
                map.put("algoSub",StringUtils.toString(algoSub, eiMetadata.getMeta("algoSub")));
                map.put("algoPar",StringUtils.toString(algoPar, eiMetadata.getMeta("algoPar")));
                map.put("dataType",StringUtils.toString(dataType, eiMetadata.getMeta("dataType")));
                map.put("itemCodePerf",StringUtils.toString(itemCodePerf, eiMetadata.getMeta("itemCodePerf")));
                map.put("bc001",StringUtils.toString(bc001, eiMetadata.getMeta("bc001")));
                map.put("bc002",StringUtils.toString(bc002, eiMetadata.getMeta("bc002")));
                map.put("bc003",StringUtils.toString(bc003, eiMetadata.getMeta("bc003")));
                map.put("bc004",StringUtils.toString(bc004, eiMetadata.getMeta("bc004")));
                map.put("bc005",StringUtils.toString(bc005, eiMetadata.getMeta("bc005")));
                map.put("bc006",StringUtils.toString(bc006, eiMetadata.getMeta("bc006")));
                map.put("bc007",StringUtils.toString(bc007, eiMetadata.getMeta("bc007")));
                map.put("bc008",StringUtils.toString(bc008, eiMetadata.getMeta("bc008")));
                map.put("bc009",StringUtils.toString(bc009, eiMetadata.getMeta("bc009")));
                map.put("bc010",StringUtils.toString(bc010, eiMetadata.getMeta("bc010")));
                map.put("bc011",StringUtils.toString(bc011, eiMetadata.getMeta("bc011")));
                map.put("bc012",StringUtils.toString(bc012, eiMetadata.getMeta("bc012")));
                map.put("bc013",StringUtils.toString(bc013, eiMetadata.getMeta("bc013")));
                map.put("bc014",StringUtils.toString(bc014, eiMetadata.getMeta("bc014")));
                map.put("bc015",StringUtils.toString(bc015, eiMetadata.getMeta("bc015")));
                map.put("bc016",StringUtils.toString(bc016, eiMetadata.getMeta("bc016")));
                map.put("bc017",StringUtils.toString(bc017, eiMetadata.getMeta("bc017")));
                map.put("bc018",StringUtils.toString(bc018, eiMetadata.getMeta("bc018")));
                map.put("bc019",StringUtils.toString(bc019, eiMetadata.getMeta("bc019")));
                map.put("bc020",StringUtils.toString(bc020, eiMetadata.getMeta("bc020")));
                map.put("bn001",StringUtils.toString(bn001, eiMetadata.getMeta("bn001")));
                map.put("bn002",StringUtils.toString(bn002, eiMetadata.getMeta("bn002")));
                map.put("bn003",StringUtils.toString(bn003, eiMetadata.getMeta("bn003")));
                map.put("bn004",StringUtils.toString(bn004, eiMetadata.getMeta("bn004")));
                map.put("bn005",StringUtils.toString(bn005, eiMetadata.getMeta("bn005")));
                map.put("bn006",StringUtils.toString(bn006, eiMetadata.getMeta("bn006")));
                map.put("bn007",StringUtils.toString(bn007, eiMetadata.getMeta("bn007")));
                map.put("bn008",StringUtils.toString(bn008, eiMetadata.getMeta("bn008")));
                map.put("bn009",StringUtils.toString(bn009, eiMetadata.getMeta("bn009")));
                map.put("bn010",StringUtils.toString(bn010, eiMetadata.getMeta("bn010")));
                map.put("bn011",StringUtils.toString(bn011, eiMetadata.getMeta("bn011")));
                map.put("bn012",StringUtils.toString(bn012, eiMetadata.getMeta("bn012")));
                map.put("bn013",StringUtils.toString(bn013, eiMetadata.getMeta("bn013")));
                map.put("bn014",StringUtils.toString(bn014, eiMetadata.getMeta("bn014")));
                map.put("bn015",StringUtils.toString(bn015, eiMetadata.getMeta("bn015")));
                map.put("bn016",StringUtils.toString(bn016, eiMetadata.getMeta("bn016")));
                map.put("bn017",StringUtils.toString(bn017, eiMetadata.getMeta("bn017")));
                map.put("bn018",StringUtils.toString(bn018, eiMetadata.getMeta("bn018")));
                map.put("bn019",StringUtils.toString(bn019, eiMetadata.getMeta("bn019")));
                map.put("bn020",StringUtils.toString(bn020, eiMetadata.getMeta("bn020")));

return map;

}
}