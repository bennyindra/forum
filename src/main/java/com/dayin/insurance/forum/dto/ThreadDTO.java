package com.dayin.insurance.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ThreadDTO {
    private String id;
    private String title;
    private String content;
    private String googleId;
}
