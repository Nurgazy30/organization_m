package kg.nurgazy.organization.management.repository;

import kg.nurgazy.organization.management.config.HibernateUtil;
import kg.nurgazy.organization.management.entity.FileEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FileDao {

    public List<FileEntity> getFiles(Long id) {

        Transaction transaction = null;
        List<FileEntity> entityList = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();

            Query query = session.createQuery("from FileEntity where organization_id = :id");
            query.setParameter("id", id);
            entityList = query.list();

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return entityList;
    }

    public void saveFiles(FileEntity entity) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteFiles(Long organizationId ) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
            transaction = session.beginTransaction();

            Query query = session.createQuery("delete from FileEntity where organization_id = :id");
            query.setParameter("id", organizationId);
            query.executeUpdate();

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction!= null) {
                transaction.rollback();
            }
        }
    }
}
