package musicpro.Service;

import java.util.List;

import musicpro.entity.Producto;

public interface ProductoService {
	
	public Producto CrearProducto(Producto producto);
	
	public void modificarProducto(Producto producto, Integer id);
	
	public List<Producto> findAll();
	
	public List<Producto> findAllProductsInStock();
	
	public void EliminarProducto (Integer id);
	 
	

}
