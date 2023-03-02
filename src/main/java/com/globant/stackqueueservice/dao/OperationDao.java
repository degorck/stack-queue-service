package com.globant.stackqueueservice.dao;

import com.globant.stackqueueservice.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<OperationEntity, Long> {
}