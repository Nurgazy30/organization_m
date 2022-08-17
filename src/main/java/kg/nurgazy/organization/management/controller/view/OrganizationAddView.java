package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.FileEntity;
import kg.nurgazy.organization.management.entity.LegalFormType;
import kg.nurgazy.organization.management.entity.OrganizationEntity;
import kg.nurgazy.organization.management.entity.PropertyFormType;
import kg.nurgazy.organization.management.service.FileService;
import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrganizationAddView {

    private OrganizationEntity organization;
    private List<FileEntity> fileEntityList;

    //Service variables
    private OrganizationService organizationService;
    private FileService fileService;



    @PostConstruct
    public void init(){
        organization = new OrganizationEntity();
        fileEntityList = new ArrayList<>();
    }


    public LegalFormType[] getLegalForms() {
        return LegalFormType.values();
    }

    public PropertyFormType[] getPropertyForms() {
        return PropertyFormType.values();
    }

    public void handleFilesUpload(FileUploadEvent event) {

            var file = event.getFile();
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(file.getFileName());
            try {
                fileEntity.setFileObject(file.getInputStream().readAllBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileEntity.setFileExtension(file.getFileName().split("\\.")[1]);
            fileEntity.setFileSize(file.getSize());
            fileEntityList.add(fileEntity);

    }

    public void formHandle() {

        var id = organizationService.save(organization);
        var organization1 = organizationService.getById( id);
        for(FileEntity file : fileEntityList ){
            file.setOrganization(organization1);
            fileService.saveFile(file);
        }

        organization = new OrganizationEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Запись успешно добавлена!"));

    }

}
