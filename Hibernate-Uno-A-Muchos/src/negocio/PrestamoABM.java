package negocio;

import dao.PrestamoDao;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		//Implementar: si el no existe el prestamo lanzar la excepción 
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if(p == null){
			throw new Exception("No se puede traer este prestamo");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traerPrestamo(c);
	}
	
	public int agregar(int cantCuotas, double interes, double monto, GregorianCalendar fecha, Cliente cliente) throws Exception{
		
		
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		List<Prestamo> lista = null;
		
		lista = traerPrestamo(cliente);
		
		for (Prestamo prestamo : lista) {
			if(p.equals(prestamo)){
				throw new Exception("Este prestamo ya existe en la BD");
			}
		}
		
		return 0;
	}
	
	public void modificar(Prestamo p) throws Exception{

		dao.actualizar(p);
	}
	
	/* Pendiente implementar 
	 * * Alta, Modificar */ 
}
