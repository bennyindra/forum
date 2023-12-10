package com.dayin.insurance.forum.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;
import lombok.Generated;
import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {
    @Id
    @Column(
                    length = 31)
    private String id;
    @CreatedBy
    @Column(
                    name = "created_by")
    private String createdBy;
    @CreationTimestamp
    @Column(
                    name = "created_timestamp")
    private Instant createdTimestamp;
    @LastModifiedBy
    @Column(
                    name = "updated_by")
    private String updatedBy;
    @UpdateTimestamp
    @Column(
                    name = "updated_timestamp")
    private Instant updatedTimestamp;
    @Column(
                    columnDefinition = "TINYINT(1)")
    private Boolean deleted;
    @Version
    @Column(
                    name = "version_field")
    private Integer versionField;

    public BaseEntity() {
        this.deleted = Boolean.FALSE;
    }

    @PrePersist
    public void prePersist() {
        this.id = this.getPrefix().concat("_").concat(ObjectId.get().toString());
    }

    public abstract String getPrefix();

    public boolean isDeleted() {
        return this.deleted;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getCreatedBy() {
        return this.createdBy;
    }

    @Generated
    public Instant getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    @Generated
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    @Generated
    public Instant getUpdatedTimestamp() {
        return this.updatedTimestamp;
    }

    @Generated
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Generated
    public Integer getVersionField() {
        return this.versionField;
    }

    @Generated
    public void setId(String id) {
        this.id = id;
    }

    @Generated
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Generated
    public void setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Generated
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Generated
    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Generated
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Generated
    public void setVersionField(Integer versionField) {
        this.versionField = versionField;
    }
}
