package kg.nurgazy.organization.management.config;

import kg.nurgazy.organization.management.entity.EmployeeEntity;
import kg.nurgazy.organization.management.entity.OrganizationEntity;

public class CopyUtil {

    public static void updateEntity(EmployeeEntity src, EmployeeEntity dest) {
        dest.setOrganization(src.getOrganization());
        dest.setAddress(src.getAddress());
        dest.setBankAccount(src.getBankAccount());
        dest.setEmail(src.getEmail());
        dest.setFullName(src.getFullName());
        dest.setHomeTelNumber(src.getHomeTelNumber());
        dest.setMobTelNumber(src.getMobTelNumber());
        dest.setWorkTelNumber(src.getWorkTelNumber());
    }

    public static void updateEntity(OrganizationEntity src, OrganizationEntity dest){
        dest.setDirectorFullName(src.getDirectorFullName());
        dest.setOrganizationName(src.getOrganizationName());
        dest.setAddress(src.getAddress());
        dest.setFax(src.getFax());
        dest.setLegalForm(src.getLegalForm());
        dest.setLicenseDate(src.getLicenseDate());
        dest.setPropertyForm(src.getPropertyForm());
        dest.setRegistrationDate(src.getRegistrationDate());
        dest.setLicenseNumber(src.getLicenseNumber());
        dest.setRegistrationNumber(src.getRegistrationNumber());
        dest.setTelNumber(src.getTelNumber());
        dest.setWebsite(src.getWebsite());
    }
}
