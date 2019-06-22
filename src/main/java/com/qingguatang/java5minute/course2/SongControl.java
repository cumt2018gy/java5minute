package com.qingguatang.java5minute.course2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongControl {
  //  @ResponseBody
    @RequestMapping(value = "/song")
    public String getSong(@RequestParam(name = "id", required = false) String songId) {
//判断songId的信息
        if (songId == null) {
            songId = "1";
        }
        if (songId.equals("1")) {
            return"course2/1.html";
        } else {
            return"course2/other.html";
        }
    }
}
