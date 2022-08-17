package kg.nurgazy.organization.management.service.impl;

import kg.nurgazy.organization.management.entity.FileEntity;
import kg.nurgazy.organization.management.repository.FileDao;
import kg.nurgazy.organization.management.service.FileService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FileServiceImpl implements FileService {

    private FileDao fileDao;

    @Override
    public List<FileEntity> getOrganizationFiles(Long id) {
        return fileDao.getFiles(id);
    }

    @Override
    public void saveFile(FileEntity entity) {
        fileDao.saveFiles(entity);
    }

    @Override
    public void deleteFile(Long id) {
        fileDao.deleteFiles(id);
    }

}
