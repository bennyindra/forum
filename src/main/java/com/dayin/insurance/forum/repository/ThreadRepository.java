package com.dayin.insurance.forum.repository;

import com.dayin.insurance.forum.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, String> {
    Page<Thread> findAllByGoogleId(String googleId, Pageable pageable);
}
