package musicpro.Service;

import java.util.List;

import musicpro.entity.Producto;

public interface ProductoService {
	

	
	public List<Producto> findAll();
	
	public List<Producto> findAllProductsInStock();
	
	public void actualizarStock(Integer stock, Integer id);
	
	
	 
	

}
