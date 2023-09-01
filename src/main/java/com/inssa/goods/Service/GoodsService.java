package com.inssa.goods.Service;

import com.inssa.goods.VO.GoodsVO;

import java.util.List;

public interface GoodsService {
    //DAO에 내용 그대로 복붙
    public List<GoodsVO> selectAll() throws Exception;
    public void insert(GoodsVO goodsVO) throws Exception;
    public GoodsVO selectByGno(int gno) throws Exception;
    public void update(GoodsVO goodsVO) throws Exception;
    public void deleteByGno(int gno) throws Exception;
}
