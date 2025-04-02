package com.seip.Mars_CICD.repository;

import com.seip.Mars_CICD.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
