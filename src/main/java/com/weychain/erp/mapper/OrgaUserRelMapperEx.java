package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.OrgaUserRel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/12 9:13
 */
@Mapper
public interface OrgaUserRelMapperEx {

    int addOrgaUserRel(OrgaUserRel orgaUserRel);

    int updateOrgaUserRel(OrgaUserRel orgaUserRel);
}
