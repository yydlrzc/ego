package com.bjsxt.ego.manager.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.domain.PageResult;
import com.bjsxt.domain.PictureResult;
import com.bjsxt.ego.manager.service.ManagerItemService;
import com.bjsxt.ego.pojo.TbItem;
import com.bjsxt.ego.pojo.TbItemDesc;
import com.bjsxt.ego.pojo.TbItemParam;
import com.bjsxt.ego.pojo.TbItemParamItem;
import com.bjsxt.ego.rpc.service.TbItemService;
import com.bjsxt.utils.FtpUtils;
import com.bjsxt.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消费者处理服务结果的实现类
 * @author ASUS
 */
@Service
public class ManagerItemServiceImpl implements ManagerItemService {

    @Value("${FTP_HOST}")
    private String host;
    @Value("${FTP_PORT}")
    private Integer port;
    @Value("${FTP_USERNAME}")
    private String username;
    @Value("${FTP_PASSWORD}")
    private String password;
    @Value("${FTP_PATHNAME}")
    private String pathname;
    @Value("${HTTP_URL}")
    private String url;

    @Autowired
    private TbItemService tbItemServiceProxy;

    @Override
    public PageResult<TbItem> loadItemManagerService(Integer page, Integer rows) {
        return tbItemServiceProxy.loadTbItemList(page,rows);
    }

    @Override
    public EgoResult updateTbItemStatus(Long id, Boolean flag) {
        TbItem tbItem = new TbItem();
        tbItem.setId(id);
        if (flag) {
            tbItem.setStatus((byte) 2);
        } else {
            tbItem.setStatus((byte) 1);
        }
        return tbItemServiceProxy.updateTbItemStatus(tbItem);
    }

    @Override
    public EgoResult deleteTbItem(String ids) {
        String[] split = ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String id : split) {
            list.add(Long.parseLong(id));
        }
        return tbItemServiceProxy.deleteTbItem(list);
    }

    @Override
    public PictureResult saveItemImage(MultipartFile mf) {
        PictureResult result = null;
        try {
            //获得新的文件名字
            String remote = IDUtils.genImageName();
            //获得文件原始的名字
            String oldName = mf.getOriginalFilename();
            remote = remote + oldName.substring(oldName.lastIndexOf("."));
            InputStream is = mf.getInputStream();
            FtpUtils.uploadFile(host,port,username,password,pathname,remote,is);
            result = new PictureResult();
            result.setUrl(url + "/jd/" + remote);
            result.setError(0);
            return result;
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        result = new PictureResult();
        result.setUrl("url");
        result.setError(1);
        return result;
    }

    @Override
    public EgoResult saveItemService(TbItem tbItem, String desc,String paramJson) {
        try {
            Date date = new Date();
            Long id = IDUtils.genItemId();
            tbItem.setId(id);
            tbItem.setStatus((byte) 1);
            tbItem.setCreated(date);
            tbItem.setUpdated(date);
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemDesc(desc);
            tbItemDesc.setCreated(date);
            tbItemDesc.setUpdated(date);
            tbItemDesc.setItemId(id);
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setItemId(id);
            tbItemParamItem.setParamData(paramJson);
            tbItemParamItem.setCreated(date);
            tbItemParamItem.setUpdated(date);
            tbItemServiceProxy.saveTbItem(tbItem, tbItemDesc, tbItemParamItem);
            return EgoResult.ok();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult updateItemService(TbItem tbItem, String desc) {
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(tbItem.getId());
        Date date = new Date();
        tbItem.setUpdated(date);
        tbItemDesc.setUpdated(date);
        return tbItemServiceProxy.updateTbItem(tbItem, tbItemDesc);
    }
}
