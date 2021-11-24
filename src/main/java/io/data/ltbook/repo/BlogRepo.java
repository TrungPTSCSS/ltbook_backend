package io.data.ltbook.repo;


import io.data.ltbook.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blog,Long> {
    List<Blog> findByTitle(String title);
}
