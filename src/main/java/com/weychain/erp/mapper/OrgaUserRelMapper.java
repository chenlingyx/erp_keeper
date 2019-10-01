package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.OrgaUserRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrgaUserRelMapper {


    int countByExample(OrgaUserRel example);



    int deleteByExample(OrgaUserRel example);




    int deleteByPrimaryKey(Long id);



    int insert(OrgaUserRel record);



    int insertSelective(OrgaUserRel record);



    OrgaUserRel selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRel example);



    int updateByExample(@Param("record") OrgaUserRel record, @Param("example") OrgaUserRel example);



    int updateByPrimaryKeySelective(OrgaUserRel record);

    int updateByPrimaryKey(OrgaUserRel record);
}