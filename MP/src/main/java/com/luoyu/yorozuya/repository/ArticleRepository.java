package com.luoyu.yorozuya.repository;

import com.luoyu.yorozuya.entity.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 文章DAO
 *
 * @author ganxiang20970
 *         2017-08-29 18:54
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleInfo, Long>{
}
