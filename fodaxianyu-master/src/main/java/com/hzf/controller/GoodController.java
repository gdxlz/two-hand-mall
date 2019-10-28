package com.hzf.controller;

import com.hzf.entity.Good;
import com.hzf.entity.GoodPicture;
import com.hzf.entity.Pictures;
import com.hzf.entity.User;
import com.hzf.service.GoodService;
import com.hzf.service.PictureService;
import com.hzf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;
    //定义一页商品的个数
    public static final int PAGE_SIZE = 8;


//    查找所有的商品的信息以及一张图片
    @ResponseBody
    @GetMapping("/queryAllGoodPicture")
    public ModelAndView queryAllGoodPicture(
            @RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo)
    {
        ModelAndView mv =new ModelAndView();
//        PageHelper.startPage(pageNo,PAGE_SIZE);
        List<GoodPicture> list = goodService.findAllGoodPicture();
//        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("goodPictureList",list);
//        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("index");
        for (GoodPicture goodPicture:list
                ) {
            System.out.println(goodPicture);
        }
        return mv;
    }

//    根据用户点击输入的id查找商品，以及相关的用户，图片信息
    @RequestMapping(value="/showGoodDetail/{goodId}",method=RequestMethod.GET)
    public ModelAndView showGoodDetail(@PathVariable Integer goodId){
        System.out.println(goodId);
//    通过商品id获取商品信息
        Good good = goodService.findGoodById(goodId);
        int uid = good.getUserId();
        System.out.println(uid);
//     通过商品的用户id查找用户的详细信息
        User user = userService.findUserById(uid);
//    通过商品的id获取图片信息
        List<Pictures> list= pictureService.findPictureById(goodId);
        ModelAndView mv =new ModelAndView();
        mv.addObject("good", good);
        mv.addObject("user", user);
        mv.addObject("pictures", list);
        mv.setViewName("GoodDetail");
        System.out.println(good);
        System.out.println(user);
        for (Pictures pic:list
             ) {
            System.out.println(pic);
        }
        return mv;
    }
//上传商品
    @RequestMapping("/saveGood")
    public String saveGood(HttpServletRequest request, Good good2, Pictures ima, MultipartFile pic){

        User cur_user = (User)request.getSession().getAttribute("user");
        int uid=cur_user.getUid();
        good2.setUserId(uid);
        good2.setStatus(0);
        System.out.print(good2);
        goodService.saveGood(good2);


       // String path=request.getSession().getServletContext().getRealPath("/uploads/");

        String path = System.getProperty("user.dir");
        String picturePath = path + "\\src\\main\\resources\\static\\goodPicture";
        File file=new File(picturePath);
        if (!file.exists()){
            file.mkdir();
        }

        String picname=pic.getOriginalFilename();
//部分浏览器上传照片时将完整路径也上传的情况下，只获取文件最后的名字
        int unixSep = picname.lastIndexOf('/');
        int winSep = picname.lastIndexOf('\\');
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1)  {
            picname = picname.substring(pos + 1);
        }
       // picname = picname.substring(picname.lastIndexOf("\\")+1);
        String uuid= UUID.randomUUID().toString().replace("-","");
        picname=uuid+"_"+picname;
        System.out.print(picname+"---------");
        System.out.print(picturePath);
        try {
            pic.transferTo(new File(picturePath,picname));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Pictures pictures=new Pictures();
//      获得最新的商品的id
        int gid=goodService.findLastGood();
        System.out.println("-------------------------");
        System.out.println(gid);
        pictures.setGoodId(gid);
        pictures.setPictureUrl(picname);
        System.out.println(pictures);
        pictureService.savePic(pictures);


        return "redirect:/good/queryAllGoodPicture";
    }

}
