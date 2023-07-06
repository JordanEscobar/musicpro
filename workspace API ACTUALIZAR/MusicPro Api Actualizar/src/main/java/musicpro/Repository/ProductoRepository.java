package musicpro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import musicpro.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	@Query(value = "SELECT * FROM producto p WHERE p.stock > 0", nativeQuery = true)
	public List<Producto> findAllProductsInStock();
	
}
