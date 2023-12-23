package org.example.app.bll.dto.mapping;

import org.example.app.bll.dto.AESWorkerDTO;
import org.example.app.dal.entities.AESWorker;

public class AESWorkerMapper {

    public static AESWorkerDTO toDto(AESWorker aesWorker) {
        return new AESWorkerDTO(aesWorker.getId(),
                aesWorker.getName(),
                aesWorker.getLogin(),
                aesWorker.getPassword());
    }

    public static AESWorker toEntity(AESWorkerDTO aesWorkerDTO) {
        AESWorker aesWorker = new AESWorker();
        aesWorker.setId(aesWorkerDTO.getId());
        aesWorker.setName(aesWorkerDTO.getName());
        aesWorker.setLogin(aesWorkerDTO.getLogin());
        aesWorker.setPassword(aesWorkerDTO.getPassword());
        return aesWorker;
    }
}
