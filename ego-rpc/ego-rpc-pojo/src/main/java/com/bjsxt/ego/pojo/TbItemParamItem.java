package com.bjsxt.ego.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbItemParamItem implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_param_item.id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_param_item.item_id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    private Long itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_param_item.created
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_param_item.updated
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    private Date updated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_item_param_item.param_data
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    private String paramData;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_param_item.id
     *
     * @return the value of tb_item_param_item.id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_param_item.id
     *
     * @param id the value for tb_item_param_item.id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_param_item.item_id
     *
     * @return the value of tb_item_param_item.item_id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_param_item.item_id
     *
     * @param itemId the value for tb_item_param_item.item_id
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_param_item.created
     *
     * @return the value of tb_item_param_item.created
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_param_item.created
     *
     * @param created the value for tb_item_param_item.created
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_param_item.updated
     *
     * @return the value of tb_item_param_item.updated
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_param_item.updated
     *
     * @param updated the value for tb_item_param_item.updated
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_item_param_item.param_data
     *
     * @return the value of tb_item_param_item.param_data
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_item_param_item.param_data
     *
     * @param paramData the value for tb_item_param_item.param_data
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }
}