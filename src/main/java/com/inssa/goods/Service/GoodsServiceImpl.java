package com.inssa.goods.Service;

import com.inssa.goods.DAO.GoodsDAO;
import com.inssa.goods.VO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDAO goodsDAO;  //DAO주입

    //ctrl + i 눌러서 인터페이스에 있는 메소드들을 자동으로 삽입
    @Override
    public List<GoodsVO> selectAll() throws Exception {
        return goodsDAO.selectAll();
    }

    @Override
    public void insert(GoodsVO goodsVO) throws Exception {
        goodsDAO.insert(goodsVO);
    }

    @Override
    public GoodsVO selectByGno(int gno) throws Exception {
        return goodsDAO.selectByGno(gno);
    }

    @Override
    public void update(GoodsVO goodsVO) throws Exception {
        goodsDAO.update(goodsVO);
    }

    @Override
    public void deleteByGno(int gno) throws Exception {
        goodsDAO.deleteByGno(gno);
    }
}
