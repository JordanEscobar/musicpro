package musicpro.Service;

import java.util.List;
import java.util.Optional;
import musicpro.Exception.RequestException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicpro.Repository.ProductoRepository;
import musicpro.entity.Producto;
@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private final ProductoRepository productoRepo;
	
	public ProductoServiceImpl(ProductoRepository productoRepo) {
		super();
		this.productoRepo = productoRepo;
	}

	@Override
	@Transactional
	public List<Producto> findAll() {
		return (List<Producto>) productoRepo.findAll();
	}

	@Override
	@Transactional
	public List<Producto> findAllProductsInStock() {
		return productoRepo.findAllProductsInStock();
	}

	@Override
	@Transactional
	public Producto CrearProducto(Producto producto) {
		if(producto == null) {
			throw new RequestException("P-300", "DATOS INVÁLIDOS");	
		}
		return productoRepo.save(producto);
	}
	

	@Override
	@Transactional
	public void modificarProducto(Producto producto, Integer id) {
		if (producto != null && id > 0) {
					Optional<Producto> productoId = productoRepo.findById(id);
					Producto productoNueva = productoId.get();
					productoNueva.setCategoria(producto.getCategoria());
					productoNueva.setNombre(producto.getNombre());
					productoNueva.setDescripcion(producto.getDescripcion());
					productoNueva.setPrecio(producto.getPrecio());
					productoNueva.setStock(producto.getStock());
					if(productoNueva.getPrecio() == null || productoNueva.getPrecio() <= 0) {
						throw new RequestException("P-300", "PRECIO INVÁLIDOsss");	
					}
					this.productoRepo.save(productoNueva);
			}else {
					throw new RequestException("P-300", "DATOS INVÁLIDOS");	
		}
	}

	@Override
	@Transactional
	public void EliminarProducto(Integer id) {	
		List<Producto> lista = (List<Producto>)productoRepo.findAll();
		Integer validacionId = 0;
		if (id!=null) {
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getId() == id) {
					validacionId = validacionId + 1;
				}
			}
		}	
		if (validacionId > 0) {			
			productoRepo.deleteById(id);
		}else {
			throw new RequestException("P-300", "ID INVÁLIDO");	
		}
	} 
}
	
	
