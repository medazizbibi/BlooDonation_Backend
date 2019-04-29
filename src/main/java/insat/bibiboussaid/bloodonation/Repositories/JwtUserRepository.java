package insat.bibiboussaid.bloodonation.Repositories;

import insat.bibiboussaid.bloodonation.Domain.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4201")
public interface JwtUserRepository extends JpaRepository<JwtUser, String> {
    JwtUser getJwtUserByUsername(String username);
}