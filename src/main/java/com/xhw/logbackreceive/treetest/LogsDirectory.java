package com.xhw.logbackreceive.treetest;

import java.io.File;
import java.util.List;

/**
 * @Auther: xhw
 * @Date: 2019-09-26 11:27
 * @Description:
 */
public class LogsDirectory {
    private static Integer tempA=1;
    private static Integer tempB=0;
    private static String projectUrl=System.getProperty("user.dir");
    public static List<TreeEntity> execute(File dir, List<TreeEntity> list, Integer pid) {
        File[] fs = dir.listFiles();
        for (File f : fs) {
            TreeEntity treeEntity=new TreeEntity();
            if (f.isDirectory()) {
                tempB=tempA;
                treeEntity.setId(tempA++);//1
                treeEntity.setPid(pid);//0
                treeEntity.setName(f.getName());

                /*String path = f.getPath();
                String replacePath = path.replace(projectUrl, "");
                treeEntity.setFileUrl(replacePath);*/
                treeEntity.setFileUrl(f.getPath());

                treeEntity.setParent(true);
                list.add(treeEntity);
                execute(f,list,tempB);
            }else {
                treeEntity.setId(tempA++);
                treeEntity.setPid(pid);
                treeEntity.setName(f.getName());

                /*String path = f.getPath();
                String replacePath = path.replace(projectUrl, "");
                treeEntity.setFileUrl(replacePath);*/
                treeEntity.setFileUrl(f.getPath());

                treeEntity.setParent(false);
                list.add(treeEntity);
            }
        }
        return list;
    }
}
