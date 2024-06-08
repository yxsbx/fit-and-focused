package com.fitandfocused.repository;

import com.fitandfocused.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends BaseRepository<Review, Long> {
}
