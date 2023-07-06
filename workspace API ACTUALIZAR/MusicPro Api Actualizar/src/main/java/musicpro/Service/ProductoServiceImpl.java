package musicpro.Service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicpro.Repository.ProductoRepository;
import musicpro.entity.Producto;
import musicpro.Exception.RequestException;

@Service
public class ProductoServiceImpl implements ProductoService {
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
	public void actualizarStock(Integer stock, Integer id) {
		List<Producto> listaP = (List<Producto>) productoRepo.findAll();
		Integer stockActualizado = 0;
		Integer validar = 0;
		for (int i = 0; i < listaP.size(); i++) {
			if (listaP.get(i).getId() == id) {
				validar = validar + 1;
				Producto p = new Producto();
				p.setId(id);
				p.setCategoria(listaP.get(i).getCategoria());
				p.setNombre(listaP.get(i).getNombre());
				p.setDescripcion(listaP.get(i).getDescripcion());
				p.setPrecio(listaP.get(i).getPrecio());
				if (stock >= 0) {
					stockActualizado = listaP.get(i).getStock() + stock;
				} else {
					throw new RequestException("P-300", "Ingrese un stock válido");
				}
				p.setStock(stockActualizado);
				this.productoRepo.save(p);
			}
		}
		if (validar == 0) {
			throw new RequestException("P-300", "Producto Inválido");
		}
	}

}
