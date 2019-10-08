package com.xhw.logbackreceive.controller;

import com.alibaba.fastjson.JSONArray;
import com.xhw.logbackreceive.treetest.LogsDirectory;
import com.xhw.logbackreceive.treetest.TreeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xhw
 * @Date: 2019-09-25 10:24
 * @Description:
 */
@Controller
public class IndexController {

   /* @RequestMapping("/index")
    public String index(){
        return "simpleData";
    }
*/
   //首页
    @GetMapping("/directory")
    public String geDirectory(Map<String,Object> map){
        String projectUrl = System.getProperty("user.dir");
        System.out.println("projectUrl:"+projectUrl);
        List<TreeEntity> list=new ArrayList<>();
        LogsDirectory.execute(new File(projectUrl+"/logs/"),list,0);
        String s = JSONArray.toJSONString(list);
        System.out.println(s+"-----------");
        map.put("directoryJson",list);
        return "simpleData";
    }
}
