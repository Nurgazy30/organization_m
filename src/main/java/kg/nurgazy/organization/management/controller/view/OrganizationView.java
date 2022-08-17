package kg.nurgazy.organization.management.controller.view;

import kg.nurgazy.organization.management.entity.FileEntity;
import kg.nurgazy.organization.management.entity.OrganizationEntity;
import kg.nurgazy.organization.management.service.FileService;
import kg.nurgazy.organization.management.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

public class OrganizationView {

    @Getter
    private List<OrganizationEntity> organizations;

    @Setter
    private OrganizationService organizationService;

    @Setter
    private FileService fileService;

    @Getter
    @Setter
    private Long selectedOrganization;

    @Getter
    private List<FileEntity> fileList;

    @Getter
    @Setter
    private StreamedContent file;

    @PostConstruct
    public void init() {
        organizations = organizationService.getAll();
        selectedOrganization = null;
    }

    public StreamedContent download(FileEntity obj) throws IOException {
//        ByteArrayInputStream bais = new ByteArrayInputStream(obj.getFileObject());

        return DefaultStreamedContent.builder()
                .writer((os) -> {
                    try {
                        os.write(obj.getFileObject());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .build();

//        return   DefaultStreamedContent.builder()
//                .name(obj.getFileName())
//                .contentType(MimeTypes.getMimeType(obj.getFileExtension()))
//                .stream(() -> bais)
//                .build();

    }


    public void files() {
        System.out.println("SELECTED ORGANIZATION: " + selectedOrganization) ;
        if (selectedOrganization != null) {
            fileList = fileService.getOrganizationFiles(selectedOrganization);
            fileList.forEach(elem -> System.out.println(elem.getFileName()));
        }
    }

}
