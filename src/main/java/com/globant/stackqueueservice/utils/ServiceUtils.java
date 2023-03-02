package com.globant.stackqueueservice.utils;

import com.globant.stackqueueservice.dao.OperationDao;
import com.globant.stackqueueservice.dto.UserDto;
import com.globant.stackqueueservice.entity.OperationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Component
@Slf4j
public class ServiceUtils {

    @Autowired
    OperationDao operationDao;

    public void saveOperation(UserDto userDto) {
        UUID uuid = UUID. randomUUID();
        log.info(uuid.toString());
        OperationEntity operation = OperationEntity.builder()
                .data("User: [ Name: ".concat(userDto.getName()).concat(" , Pet: ").concat(userDto.getPet()).concat(" ]"))
                .timestamp(Timestamp.from(Instant.now()))
                .id(uuid.toString())
                .build();
        operationDao.save(operation);
    }

    public void saveOperation(String data) {
        UUID uuid = UUID. randomUUID();
        log.info(uuid.toString());
        OperationEntity operation = OperationEntity.builder()
                .data(data)
                .timestamp(Timestamp.from(Instant.now()))
                .id(uuid.toString())
                .build();
        operationDao.save(operation);
    }
}

