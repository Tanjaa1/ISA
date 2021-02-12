package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.jpa.model.Markk;

public interface IMarkRepository extends JpaRepository<Markk, Long> {

    @Override
	public <S extends Markk> S save(S entity);
}
