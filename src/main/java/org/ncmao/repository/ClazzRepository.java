package org.ncmao.repository;

import org.ncmao.domain.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Date 2018/6/15 14:33
 * @description
 */
@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Long> {
}
