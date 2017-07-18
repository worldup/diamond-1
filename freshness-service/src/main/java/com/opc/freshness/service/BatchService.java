package com.opc.freshness.service;

import com.opc.freshness.common.util.Pager;
import com.opc.freshness.domain.bo.BatchBo;
import com.opc.freshness.domain.po.BatchPo;
import com.opc.freshness.domain.vo.BatchLogVo;

import java.util.List;

/**
 * AUTHOR: qishang
 * DATE:2017/7/17.
 */
public interface BatchService {
    /**
     * 添加一个批次
     *
     * @param batchBo
     * @return
     */
    boolean addBatch(BatchBo batchBo);

    /**
     * 批次报损
     *
     * @param batchBo
     * @return
     */
    boolean batchLoss(BatchBo batchBo);

    /**
     * 批次废弃
     *
     * @param batchBo
     * @return
     */
    boolean batchAbort(BatchBo batchBo);

    /**
     * 待废弃列表
     *
     * @param shopId
     * @return
     */
    List<BatchPo> selectAbortList(Integer shopId);


    /**
     * @param shopId     门店Id
     * @param statusList 状态列表
     * @param pageNo     页码
     * @param pageSize   页面大小
     * @return
     */
    Pager<BatchLogVo> selectLogByPage(Integer shopId, List statusList, Integer pageNo, Integer pageSize);
}