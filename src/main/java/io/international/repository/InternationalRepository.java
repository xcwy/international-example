package io.international.repository;

import io.international.entity.International;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Davis on 17/1/6.
 */
public interface InternationalRepository extends JpaRepository<International, String> {
}
