package datos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import funciones.Funciones;

public class Prestamo {
	private long idPrestamo;
	private GregorianCalendar fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	private boolean cancelado;
	private List<Cuota> cuotas = new ArrayList<Cuota>();

	public Prestamo() {
	}

	public Prestamo(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Prestamo p = (Prestamo) obj;
		boolean iguales = false;
		
		if(this.cantCuotas == p.cantCuotas && this.cliente.getDni() == p.cliente.getDni() && this.interes == p.getInteres() && this.monto == p.getMonto()){
			iguales = true;
		}
		
		return iguales;
	}

	public String toString() {
		String prestamo = "Prestamo: $ " + monto + "\nFecha: " + Funciones.traerFechaCorta(fecha) + "\nInteres: "
				+ interes + "\nCant.de Cuotas: " + cantCuotas;
		return prestamo;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	
	public void setCuotas(){
		
	}
}
