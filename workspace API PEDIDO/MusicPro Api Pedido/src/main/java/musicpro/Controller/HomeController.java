package musicpro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import musicpro.Service.ProductoService;
import musicpro.entity.Producto;

@RestController
@Tag(name="Controlador de servicio Pedido")
@RequestMapping("/api/producto")
public class HomeController {
	@Autowired
	private final ProductoService productoService;
	
	//IR A LA RUTA  http://localhost:8080/swagger-ui/index.html
	public HomeController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	// 3. Servicio para listar los productos en stock
	
	@Tag(name="1. Listado de Productos")
	@GetMapping("/")
	@ApiOperation(value="Listar productos")
	public List<Producto> findAllProductsInStock() {
		return productoService.findAllProductsInStock();
	}
		
		
	//5. Servicio para generar un pedido.
	@Tag(name="2. Generar un pedido")
	@ApiOperation(value="Genera pedido en tienda")
	@PostMapping("/pedido/{lista}")
	public String generarPedido(@RequestBody List<Producto> lista) {
		return productoService.generarPedido(lista);
	}
	
	

	
	
}
