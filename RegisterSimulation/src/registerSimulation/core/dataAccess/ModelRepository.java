package registerSimulation.core.dataAccess;

import java.util.List;
import java.util.function.Predicate;

public interface ModelRepository<T> {
	void add(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> getAll();

	T get(Predicate<T> predicate);// i�inde stream kullan�laca�� yer

	List<T> getAll(Predicate<T> predicate);// i�inde stream kullan�laca�� yer
}
