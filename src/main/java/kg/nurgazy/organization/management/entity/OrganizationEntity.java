package kg.nurgazy.organization.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class OrganizationEntity extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "property_form")
    private PropertyFormType propertyForm;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "legal_form")
    private LegalFormType legalForm;

    @Column(name = "director_full_name")
    private String directorFullName;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "fax")
    private String fax;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "website")
    private String website;

    @Column(name = "address")
    private String address;

    @Column(name = "registration_num")
    private String registrationNumber;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "license_num")
    private String licenseNumber;

    @Column(name = "license_date")
    private LocalDate licenseDate;
}
