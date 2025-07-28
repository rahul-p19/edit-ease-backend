package tech.rahulpandey.backend.repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.repository.CrudRepository;
import tech.rahulpandey.backend.model.MailList;

public interface MailListRepository extends CrudRepository<MailList, String> {
    MailList findByEmail(String email);
}
