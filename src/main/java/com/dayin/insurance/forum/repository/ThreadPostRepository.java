package com.dayin.insurance.forum.repository;

import com.dayin.insurance.forum.entity.ThreadPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadPostRepository extends JpaRepository<ThreadPost, String> {

    public Page<ThreadPost> findAllByThreadId(String threadId, Pageable pageable);
}
