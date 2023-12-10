package com.dayin.insurance.forum.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "THREADS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Thread extends BaseEntity {

    private String title;
    private String content;
    @Column(name = "google_id")
    private String googleId;

    @Override
    public String getPrefix() {
        return "TH";
    }
}
