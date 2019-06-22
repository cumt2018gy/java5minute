package com.qingguatang.java5minute.course7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MusicControl {
    private static final Map<String,String> musics = new HashMap<>();
@RequestMapping(value = "/song/music")
@ResponseBody
public String getMusicSrc(String songId){
    return musics.get(songId);
}
    @PostConstruct
    public void init(){
        musics.put("35847388",
                "http://m10.music.126.net/20190622135552/501293e7241fba025e7fa2a8e54de621/ymusic/de9a/6885/e183/effb8f74546c98fd619d51f22e2bfaaf.mp3");
        musics.put("2117009",
                "http://m10.music.126.net/20190622140209/057de5e3c62474866e7b8d6d4d60ccbd/ymusic/6428/0c3d/4a14/cef6263c9a09bfc03fafbb15f6a99533.mp3");
    }

}