package kg.nurgazy.organization.management.service.impl;

import kg.nurgazy.organization.management.entity.OrganizationEntity;
import kg.nurgazy.organization.management.repository.OrganizationDAO;
import kg.nurgazy.organization.management.service.OrganizationService;

import java.util.List;

public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDAO organizationDAO;

    @Override
    public OrganizationEntity getById(Long id) {
        return organizationDAO.getByID(id);
    }

    @Override
    public List<OrganizationEntity> getAll() {
        return organizationDAO.getAll();
    }

    @Override
    public Long save(OrganizationEntity entity) {
        return (Long) organizationDAO.saveOrganization(entity);
    }

    @Override
    public void update(OrganizationEntity entity) {
        organizationDAO.updateOrganization(entity);
    }

    @Override
    public void deleteById(Long id) {
        organizationDAO.deleteOrganization(id);
    }

    public void setOrganizationDAO(OrganizationDAO dao) {
        this.organizationDAO = dao;
    }
}
