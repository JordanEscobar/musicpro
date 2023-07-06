package musicpro.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import musicpro.Service.ProductoService;
import musicpro.entity.Producto;


@RestController
@Tag(name="Controlador de servicio Actualizar pedido")
@RequestMapping("/api/producto")
public class HomeController {
	@Autowired
	private final ProductoService productoService;
	
	//IR A LA RUTA  http://localhost:8080/swagger-ui/index.html
	public HomeController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}	

	// Servicio para listar los productos en stock
	@Tag(name="1. Listar productos con stock")
	@GetMapping("/{id}")
	@ApiOperation(value="Listar productos con Stock")
	public List<Producto> findAllProductsInStock() {
		return productoService.findAllProductsInStock();
	}
	
	
	//Servicio para actualizar el stock en particular de un producto
	@Tag(name="2 Actualizar Stock")
	@ApiOperation(value="Actualizar Stock de productos")
	@ApiParam(value ="Nuevo Stock en numero" , required = true , example ="10")
	@PutMapping("/actualizarStock/{stock}/{id}")
		public void actualizarStock(@PathVariable @Valid Integer id, @PathVariable @Valid  Integer stock) throws Exception {
			productoService.actualizarStock(stock, id);
			ResponseEntity.ok(Boolean.TRUE);		
		}
	
	
	

	
	
}
