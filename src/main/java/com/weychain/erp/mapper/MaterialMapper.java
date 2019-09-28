package com.weychain.erp.mapper;

import java.util.List;

import com.weychain.erp.domain.DO.MaterialExample;
import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.Material;

public interface MaterialMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int countByExample(MaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int deleteByExample(MaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int insert(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int insertSelective(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    List<Material> selectByExample(MaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    Material selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_material
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Material record);
}