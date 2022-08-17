package kg.nurgazy.organization.management.service;

import kg.nurgazy.organization.management.entity.FileEntity;

import java.util.List;

public interface FileService {

    List<FileEntity> getOrganizationFiles(Long id);

    void saveFile(FileEntity entity);

    void deleteFile(Long id);
}
