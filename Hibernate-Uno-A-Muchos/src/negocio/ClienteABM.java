package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao=new ClienteDao();
	
	public Cliente traerCliente(long idCliente) throws Exception{
		Cliente c= dao.traerCliente(idCliente);
		if(c==null){
			throw new Exception("No se pudo traer cliente");
		}
		// implementar si c es null lanzar Exception
		return c;
	}
	
	public Cliente traerCliente(int dni) throws Exception{
		Cliente c= dao.traerCliente(dni);
		if(c==null){
			throw new Exception("No se pudo traer cliente");
		}else if(c.getPrestamos() == null){
			throw new Exception("El cliente no tiene prestamos");
		}
		// implementar si c es null lanzar Exception
		return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento){
		//consultar si existe un cliente con el mismo dni, si existe arrojar la Excepcion
		
		Cliente c = null;
		
		try {
			c= traerCliente(dni);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			c=new Cliente(apellido, nombre, dni,fechaDeNacimiento);
			return dao.agregar(c);
		}
		
		return 0;
	}
	
	public void modificar(Cliente c) throws Exception{
		/* implementar antes de actualizar que no exista un cliente
con el mismo documento a modificar
y con el mismo id, lanzar la Exception */
		List<Cliente> lista = traerCliente();
		
		for (Cliente cliente : lista) {
			if(c.getDni() == cliente.getDni()){
				throw new Exception("No puede modificar porque ya existe el dni");
			}
		}
		dao.actualizar(c);
	}
	
	public void eliminar(long idCliente) throws Exception{/*en este caso es física en gral. no se se
aplicaría este caso de uso, si se hiciera habría que validar que el cliente no tenga
dependencias*/
		Cliente c=dao.traerCliente(idCliente);
		if(c == null){
			throw new Exception("No existe el cliente a eliminar");
		}
		//Implementar que si es null que arroje la excepción
		dao.eliminar(c);
	}
	
	public List<Cliente> traerCliente(){
		return dao.traerCliente();
	}
}