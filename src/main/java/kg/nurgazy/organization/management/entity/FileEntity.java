package kg.nurgazy.organization.management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="files")
public class FileEntity extends BaseEntity {

    @Column(name = "file_content")
    private byte[] fileObject;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "file_ext")
    private String fileExtension;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;
}
