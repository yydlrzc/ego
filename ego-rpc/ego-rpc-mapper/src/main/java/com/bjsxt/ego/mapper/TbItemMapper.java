package com.bjsxt.ego.mapper;

import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    long countByExample(TbItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int deleteByExample(TbItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int insert(TbItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int insertSelective(TbItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    List<TbItem> selectByExample(TbItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    TbItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int updateByPrimaryKeySelective(TbItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item
     *
     * @mbg.generated Wed Sep 26 20:48:54 CST 2018
     */
    int updateByPrimaryKey(TbItem record);
}