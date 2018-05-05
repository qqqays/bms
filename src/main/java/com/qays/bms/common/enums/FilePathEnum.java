package com.qays.bms.common.enums;

import com.qays.bms.common.exception.CustomException;
import com.qays.bms.common.util.RunningSystem;

public enum FilePathEnum {
    winAbsolutionPath("E:/code/temp"),
    linuxAbsolutionPath("/home/temp"),
    relationPath("/upload-files/"),
    imagesPath("images/"),
    sysImg("images/system/");

    private String path;

    FilePathEnum(){

    }

    FilePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getRelationPath(String path) {
        return relationPath.getPath() + this.path + path + "/";
    }

    public String getAbsolutionPath(String path){
        if (RunningSystem.isWin10())
            return winAbsolutionPath.getPath() + this.path + path + "/";
        else if(RunningSystem.isLinux())
            return linuxAbsolutionPath.getPath() + this.path + path + "/";
        else
            throw new CustomException(ReturnCode.UNMATCHED_SYSTEM);
    }

    public static void main(String[] args) {
//        System.out.println(FilePathEnum.sysImg.getAbsolutionPath());
//        System.out.println(FilePathEnum.sysImg.getRelationPath());
//        System.out.println(FilePathEnum.relationPath.getCustomPath("system"));
        System.out.println(FilePathEnum.imagesPath.getAbsolutionPath("system"));

    }
}
