package com.bjsxt.ego.manager.service;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.PictureResult;
import com.bjsxt.ego.pojo.TbItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 消费者物品接口
 * @author ASUS
 */
public interface ManagerItemService {


    /**
     * 加载商品信息
     * @param page
     * @param rows
     * @return
     */
    public PageResult<TbItem> loadItemManagerService(Integer page, Integer rows);

    /**
     * 更新商品状态
     * @param id
     * @param flag
     * @return
     */
    public EgoResult updateTbItemStatus(Long id, Boolean flag);

    /**
     * 删除商品信息
     * @param ids
     * @return
     */
    public EgoResult deleteTbItem(String ids);

    /**
     * 上传商品图片
     * @param mf
     * @return
     */
    public PictureResult saveItemImage(MultipartFile mf);

    /**
     * 添加商品信息
     * @param tbItem
     * @param desc
     * @return
     */
    public EgoResult saveItemService(TbItem tbItem, String desc,String paramJson);

    /**
     * 更新商品信息
     * @param tbItem
     * @param desc
     * @return
     */
    public EgoResult updateItemService(TbItem tbItem, String desc);
}
