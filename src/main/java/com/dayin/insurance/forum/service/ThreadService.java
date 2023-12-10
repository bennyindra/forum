package com.dayin.insurance.forum.service;

import com.dayin.insurance.forum.dto.ThreadDTO;
import com.dayin.insurance.forum.entity.Thread;
import com.dayin.insurance.forum.entity.ThreadPost;
import com.dayin.insurance.forum.exception.BusinessException;
import com.dayin.insurance.forum.repository.ThreadPostRepository;
import com.dayin.insurance.forum.repository.ThreadRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ThreadService {

    private final ThreadRepository threadRepository;
    private final ThreadPostRepository threadPostRepository;

    public Page<Thread> findAll(Pageable pageable, String userId) {
        if (!userId.isEmpty()) {
            return threadRepository.findAllByGoogleId(userId, pageable);
        } else {
            return threadRepository.findAll(pageable);
        }

    }

    public Thread findById(String id) throws BusinessException {
        return threadRepository.findById(id).orElseThrow(() -> new BusinessException(String.format("thread with id : '%s' not found", id)));
    }

    @Transactional
    public void save(ThreadDTO threadDTO) {
        if (threadDTO.getGoogleId() != null) {
            Thread thread = threadRepository.findById(Optional.ofNullable(threadDTO.getId()).orElse("")).orElse(new Thread());
            thread.setTitle(threadDTO.getTitle());
            thread.setContent(threadDTO.getContent());
            thread.setGoogleId(threadDTO.getGoogleId());
            threadRepository.save(thread);
            ThreadPost threadPost = new ThreadPost();
            threadPost.setThread(thread);
            threadPost.setContent(thread.getContent());
            threadPost.setTitle(thread.getTitle());
            threadPost.setGoogleId(thread.getGoogleId());
            threadPostRepository.save(threadPost);
        }
    }
}
