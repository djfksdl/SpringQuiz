package com.quiz.lesson03.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewMapper {
	public Review selectReview(int id);
}
