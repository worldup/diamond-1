package com.opc.freshness.service.dao;

import com.opc.freshness.domain.po.SkuKindPo;
import com.opc.freshness.domain.vo.KindVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkuKindMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SkuKindPo record);

    int batchInsert(List<SkuKindPo> list);

    SkuKindPo selectByPrimaryKey(Integer id);

    List<KindVo> selectKind(@Param("skuId") Integer skuId, @Param("shopId") Integer shopId);

    int updateByPrimaryKeySelective(SkuKindPo record);
}