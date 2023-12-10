package com.dayin.insurance.forum.controller;

import com.dayin.insurance.forum.dto.ThreadDTO;
import com.dayin.insurance.forum.dto.ThreadPostDTO;
import com.dayin.insurance.forum.entity.Thread;
import com.dayin.insurance.forum.entity.ThreadPost;
import com.dayin.insurance.forum.exception.BusinessException;
import com.dayin.insurance.forum.service.ThreadPostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/thread-posts")
@AllArgsConstructor
public class ThreadPostController {

    private final ThreadPostService threadPostService;

    @GetMapping
    public ResponseEntity<Page<ThreadPost>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, @RequestParam String threadId) {
        Pageable paging = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "createdTimestamp"));
        return ResponseEntity.ok(threadPostService.findByThreadId(threadId, paging));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ThreadPostDTO threadPostDTO) throws BusinessException {
        threadPostService.save(threadPostDTO);
    }
}
