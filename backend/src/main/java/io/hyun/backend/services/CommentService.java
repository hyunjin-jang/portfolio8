package io.hyun.backend.services;

import io.hyun.backend.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


}
