package com.qingguatang.java5minute.course5;

import com.qingguatang.java5minute.course4.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CommentPostControl {
    private static Map<String, List<Comment>> comments = new HashMap<>();//hasmap

    @RequestMapping(value = "/comment/post")
    public String post(@RequestParam(value = "songId") String songId, Comment comment) {
        Date commentTime = new Date();
        comment.setCommentTime(commentTime);
        comment.setId(UUID.randomUUID().toString());
        comments.computeIfAbsent(songId, k -> new ArrayList<>()).add(comment);
        List<Comment> commentList = comments.get(songId);
        //UUID 是 Java 提供的一种生成随机数的方法，这句代码可以提供一个全局唯一的字符串，格式为： XXX-XXX-XXX-XXX ，长度为36位，这是我们在企业中使用非常频繁的一种 id 生成方式，因为它可以绝对唯一。
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                if (o1.getCommentTime().after(o2.getCommentTime())) {
                    return -1;
                }
                return 1;
            }
        });
        return "redirect:/songinfo?songId="+songId;
    }

    public static List<Comment> getComments(String songId) {
        return comments.get(songId);
    }
}
