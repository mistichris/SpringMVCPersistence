package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Contact;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Mar 7, 2024
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
