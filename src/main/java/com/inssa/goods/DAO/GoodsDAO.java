package com.inssa.goods.DAO;

import com.inssa.goods.VO.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDAO {
    //SQL의 id명으로 SQL을 실행시킬 메소드 만들기
    //데이터베이스에서 뭘 가져오고 뭘 줄건지 설정
    //()안에 있는 걸 가져와서 public 뒤에 있는 걸 반환
    /*<select id="selectAll" resultType="GoodsVO">
    <insert id="insert">
    <select id="selectByGno" resultType="GoodsVO">
    <update id="updateByGno">
    <delete id="deleteByGno">*/

    public List<GoodsVO> selectAll() throws Exception;
    public void insert(GoodsVO goodsVO) throws Exception;
    public GoodsVO selectByGno(int gno) throws Exception;
    public void update(GoodsVO goodsVO) throws Exception;
    public void deleteByGno(int gno) throws Exception;
}