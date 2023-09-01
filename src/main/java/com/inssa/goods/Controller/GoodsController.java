package com.inssa.goods.Controller;

import com.inssa.goods.Service.GoodsService;
import com.inssa.goods.VO.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    Logger log = LoggerFactory.getLogger("GoodsController");

    @Autowired
    GoodsService goodsService;  //Service를 주입

    //@RequestMapping(method=RequestMethod.GET, value="/")
    //이렇게도 사용 가능
    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        log.info("index 페이지 작업");
        /*log.warn("index 경고문구");
        log.error("index 오류문구");*/
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }

    //상품목록
    @GetMapping("/goods-list")
    public ModelAndView list(HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        log.info("목록 페이지 작업");
        //메소드의 선언된 모양 그대로(GoodsService 참조)
        //    public List<GoodsVO> selectAll() throws Exception;
        log.info("목록 데이터베이스 처리");
        List<GoodsVO> lists = goodsService.selectAll(); //데이터베이스 처리 후 저장

        log.info("목록페이지 이동");
        ModelAndView mav = new ModelAndView("/goods/list");
        mav.addObject("lists",lists);  //저장
        return mav;
    }

    //상품 상세페이지
    @GetMapping("/goods-view")
    public ModelAndView view(@RequestParam("gno") int gno,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        GoodsVO list = goodsService.selectByGno(gno);
        //인수값을 전달받을 수 있도록 값을 받을 수 있는 변수선언
        ModelAndView mav = new ModelAndView("/goods/view");
        mav.addObject("list", list);
        return mav;
    }

    //상품등록
    @GetMapping("/goods-insert")
    public ModelAndView insert(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/goods/insert");
        return mav;
    }

    //상품등록처리
    @PostMapping("/goods-insert")
    public ModelAndView insertProc(@ModelAttribute("GoodsVO") GoodsVO goodsVO,
                                   @RequestParam("file") MultipartFile uploadFile,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        //    public void insert(GoodsVO goodsVO) throws Exception;
        //이미지 업로드 작업
        String fileName = uploadFile.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/images/");

        try {
            uploadFile.transferTo(new File(filePath + fileName));
            //업로드를 성공했으면
            goodsVO.setGimgfile(fileName);  //파일이름을 VO를 통해서 데이터베이스에 저장하는 작업
            //파일 처리 오류시 데이터베이스 처리도 중단
            goodsService.insert(goodsVO);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        //데이터베이스 처리문이 try문 밖에 있으면 파일처리 오류가 발생해도 작업하겠다는 뜻
        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }

    //상품수정
    @GetMapping("/goods-update")
    public ModelAndView update(@RequestParam("gno") int gno,
                               HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        //    public GoodsVO selectByGno(int gno) throws Exception;
        GoodsVO goods = goodsService.selectByGno(gno);

        ModelAndView mav = new ModelAndView("/goods/update");
        mav.addObject("goods", goods);
        return mav;
    }

    //상품수청처리
    @PostMapping("/goods-update")
    public ModelAndView updateProc(@ModelAttribute("GoodsVO") GoodsVO goodsVO,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{
        //    public void update(GoodsVO goodsVO) throws Exception;
        goodsService.update(goodsVO);

        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }

    //상품삭제처리
    @GetMapping("/goods-delete")
    public ModelAndView deleteProc(@RequestParam("gno") int gno,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws Exception{
        //    public void deleteByGno(int gno) throws Exception;
        goodsService.deleteByGno(gno);
        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }

    //관리자 상품목록 페이지
    @GetMapping("/goods-list2")
    public ModelAndView list2(HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
        List<GoodsVO> lists = goodsService.selectAll();

        ModelAndView mav = new ModelAndView("/goods/list2");
        mav.addObject("lists", lists);
        return mav;
    }

}
