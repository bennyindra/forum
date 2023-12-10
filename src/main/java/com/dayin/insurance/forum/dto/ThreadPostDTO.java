package com.dayin.insurance.forum.dto;


import com.dayin.insurance.forum.entity.ThreadPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ThreadPostDTO extends ThreadPost {
    private String threadId;
}
