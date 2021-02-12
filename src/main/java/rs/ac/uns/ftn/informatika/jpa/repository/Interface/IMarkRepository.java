package rs.ac.uns.ftn.informatika.jpa.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.informatika.jpa.model.Mark;

public interface IMarkRepository extends JpaRepository<Mark, Long> {

    @Override
	public <S extends Mark> S save(S entity);
}
