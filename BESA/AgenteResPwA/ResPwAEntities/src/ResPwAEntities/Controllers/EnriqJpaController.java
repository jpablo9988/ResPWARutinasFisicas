/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResPwAEntities.Controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ResPwAEntities.Cancion;
import ResPwAEntities.Controllers.exceptions.NonexistentEntityException;
import ResPwAEntities.Controllers.exceptions.PreexistingEntityException;
import ResPwAEntities.Enriq;
import ResPwAEntities.Frase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tesispepper
 */
public class EnriqJpaController implements Serializable {

    public EnriqJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Enriq enriq) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cancion cancionNombre = enriq.getCancionNombre();
            if (cancionNombre != null) {
                cancionNombre = em.getReference(cancionNombre.getClass(), cancionNombre.getNombre());
                enriq.setCancionNombre(cancionNombre);
            }
            Frase frase = enriq.getFrase();
            if (frase != null) {
                frase = em.getReference(frase.getClass(), frase.getFrasePK());
                enriq.setFrase(frase);
            }
            em.persist(enriq);
            if (cancionNombre != null) {
                cancionNombre.getEnriqList().add(enriq);
                cancionNombre = em.merge(cancionNombre);
            }
            if (frase != null) {
                frase.getEnriqList().add(enriq);
                frase = em.merge(frase);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEnriq(enriq.getParams()) != null) {
                throw new PreexistingEntityException("Enriq " + enriq + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Enriq enriq) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Enriq persistentEnriq = em.find(Enriq.class, enriq.getParams());
            Cancion cancionNombreOld = persistentEnriq.getCancionNombre();
            Cancion cancionNombreNew = enriq.getCancionNombre();
            Frase fraseOld = persistentEnriq.getFrase();
            Frase fraseNew = enriq.getFrase();
            if (cancionNombreNew != null) {
                cancionNombreNew = em.getReference(cancionNombreNew.getClass(), cancionNombreNew.getNombre());
                enriq.setCancionNombre(cancionNombreNew);
            }
            if (fraseNew != null) {
                fraseNew = em.getReference(fraseNew.getClass(), fraseNew.getFrasePK());
                enriq.setFrase(fraseNew);
            }
            enriq = em.merge(enriq);
            if (cancionNombreOld != null && !cancionNombreOld.equals(cancionNombreNew)) {
                cancionNombreOld.getEnriqList().remove(enriq);
                cancionNombreOld = em.merge(cancionNombreOld);
            }
            if (cancionNombreNew != null && !cancionNombreNew.equals(cancionNombreOld)) {
                cancionNombreNew.getEnriqList().add(enriq);
                cancionNombreNew = em.merge(cancionNombreNew);
            }
            if (fraseOld != null && !fraseOld.equals(fraseNew)) {
                fraseOld.getEnriqList().remove(enriq);
                fraseOld = em.merge(fraseOld);
            }
            if (fraseNew != null && !fraseNew.equals(fraseOld)) {
                fraseNew.getEnriqList().add(enriq);
                fraseNew = em.merge(fraseNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = enriq.getParams();
                if (findEnriq(id) == null) {
                    throw new NonexistentEntityException("The enriq with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Enriq enriq;
            try {
                enriq = em.getReference(Enriq.class, id);
                enriq.getParams();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enriq with id " + id + " no longer exists.", enfe);
            }
            Cancion cancionNombre = enriq.getCancionNombre();
            if (cancionNombre != null) {
                cancionNombre.getEnriqList().remove(enriq);
                cancionNombre = em.merge(cancionNombre);
            }
            Frase frase = enriq.getFrase();
            if (frase != null) {
                frase.getEnriqList().remove(enriq);
                frase = em.merge(frase);
            }
            em.remove(enriq);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Enriq> findEnriqEntities() {
        return findEnriqEntities(true, -1, -1);
    }

    public List<Enriq> findEnriqEntities(int maxResults, int firstResult) {
        return findEnriqEntities(false, maxResults, firstResult);
    }

    private List<Enriq> findEnriqEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Enriq.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Enriq findEnriq(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enriq.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnriqCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Enriq> rt = cq.from(Enriq.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
