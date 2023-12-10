package com.dayin.insurance.forum.service;

import com.dayin.insurance.forum.dto.ThreadDTO;
import com.dayin.insurance.forum.dto.ThreadPostDTO;
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

@Service
@AllArgsConstructor
public class ThreadPostService {

    private final ThreadRepository threadRepository;
    private final ThreadPostRepository threadPostRepository;

    public Page<ThreadPost> findByThreadId(String threadId, Pageable pageable) {
        return threadPostRepository.findAllByThreadId(threadId, pageable);
    }

    @Transactional
    public void save(ThreadPostDTO threadPostDTO) throws BusinessException {
        Thread thread = threadRepository.findById(threadPostDTO.getThreadId()).orElseThrow(() -> new BusinessException(String.format("thread id '%s' not valid", threadPostDTO.getThreadId())));
        ThreadPost threadPost = new ThreadPost();
        threadPost.setThread(thread);
        threadPost.setTitle(threadPostDTO.getTitle());
        threadPost.setContent(threadPostDTO.getContent());
        threadPost.setGoogleId(threadPostDTO.getGoogleId());
        threadPost.setCreatedBy(threadPostDTO.getCreatedBy());

        threadPostRepository.save(threadPost);
    }
}
