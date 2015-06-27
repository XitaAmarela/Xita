package Dao;

import java.util.List;

public interface GenericaDAO<T> {

	public T persist(T t);
	public void delete(Long id);
	public void delete(T t);
	public List<T> listAll();
	public T buscarPorId(Long id);
	
}
