package com.dayin.insurance.forum.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "THREAD_POSTS")
@Setter
@Getter
public class ThreadPost extends BaseEntity {

    private String title;
    private String content;
    @Column(name = "google_id")
    private String googleId;


    @JsonBackReference
    @JoinColumn(name = "thread_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Thread thread;

    @Override
    public String getPrefix() {
        return "TP";
    }
}
