package com.qingguatang.java5minute.course3;


import com.qingguatang.java5minute.course3.model.songInfo;
import com.qingguatang.java5minute.course4.model.Comment;
import com.qingguatang.java5minute.course5.CommentPostControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class songInfoControl {
    private static Map<String, songInfo> songInfoMap = new HashMap<>();
    @Autowired
    private CommentPostControl commentPostControl;
    @RequestMapping(value = "/songinfo")
    public String index(String songId,ModelMap modelMap) {
        if (songId == null){
            songId = "35847388";
        }
        songInfo songInfo = songInfoMap.get(songId);
        modelMap.addAttribute("song", songInfo);
        List<Comment> comments = commentPostControl.getComments(songId);
        modelMap.addAttribute("comments",comments);
        return "index";

    }
    @RequestMapping(value = "/songinfo/get")
    @ResponseBody
    public  songInfo get(String songId){
        songInfo songInfo = songInfoMap.get(songId);
        return songInfo;
    }
    @PostConstruct
    public void init(){
        songInfo songInfo = new songInfo();
        songInfo.setId("35847388");
        songInfo.setName("Hello");
        songInfo.setSinger("Adele");
        songInfo.setAlbumName("Hello");
        songInfo.setCommentCount(10);
        songInfo.setAlbumImg("http://p1.music.126.net/PrO7oPvnjvH4xdujdGbf2w==/1407374890649284.jpg?param=130y130");
        songInfo.setLyrics("Hello, it's me<br/>你好吗 是我<br/>I was wondering if after all these years you'd like to meet");
        songInfoMap.put("35847388",songInfo);

        songInfo = new songInfo();
        songInfo.setId("2117009");
        songInfo.setName("空空如也");
        songInfo.setSinger("任然");
        songInfo.setAlbumName("26");
        songInfo.setCommentCount(12965);
        songInfo.setAlbumImg("http://p1.music.126.net/84FJjDgb51TmRqixaUpshg==/109951163094476391.jpg?param=130y130");
        songInfo.setLyrics("熟悉的 陌生的 这种感觉<br/>重复的 曾经的 那些情节<br/>也只是 怀念<br/>一滴滴 一点点 一页一篇<br/>分手了 也不过 三百多天<br/>可我却 害怕遇见<br/>我懵懵懂懂过了一年<br/>这一年似乎没有改变<br/>守着你离开后的世界<br/>空 空如也");
        songInfoMap.put("2117009",songInfo);
    }
}