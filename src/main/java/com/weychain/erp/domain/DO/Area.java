package com.weychain.erp.domain.DO;

public class Area {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column erp_area.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column erp_area.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column erp_area.area_code
     *
     * @mbggenerated
     */
    private Integer areaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column erp_area.city_code
     *
     * @mbggenerated
     */
    private Integer cityCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column erp_area.id
     *
     * @return the value of erp_area.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column erp_area.id
     *
     * @param id the value for erp_area.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column erp_area.name
     *
     * @return the value of erp_area.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column erp_area.name
     *
     * @param name the value for erp_area.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column erp_area.area_code
     *
     * @return the value of erp_area.area_code
     *
     * @mbggenerated
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column erp_area.area_code
     *
     * @param areaCode the value for erp_area.area_code
     *
     * @mbggenerated
     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column erp_area.city_code
     *
     * @return the value of erp_area.city_code
     *
     * @mbggenerated
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column erp_area.city_code
     *
     * @param cityCode the value for erp_area.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }
}