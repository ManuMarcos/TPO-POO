package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Factura {

	//Attributes
	private static int generador = 1000;
	private static final float iva = (float) 0.21;
	private int numero;
	private char tipo;
	private Date fecha;
	private float importeNeto;
	private float precioTotal;
	private float importeIva;
	private Cliente cliente;
	private ArrayList<FacturaRenglon> renglones;
	
	
	//Methods
	//Constructor
	public Factura(Cliente cliente) {
		this.numero = generador;
		generador ++;
		this.renglones = new ArrayList<FacturaRenglon>();
		this.cliente = cliente;
		this.setTipoFactura(cliente.getTipoCliente());
		this.fecha = Calendar.getInstance().getTime();
	}
	
	
	public int getNumero() {
		return numero;
	}
	
	public void agregarRenglon(String descripcion, int cantidad, float precioUnitario) {
		FacturaRenglon renglon = new FacturaRenglon(descripcion, cantidad, precioUnitario);
		this.renglones.add(renglon);
		this.importeNeto += renglon.getImporte();
		this.importeIva += renglon.getImporte() * iva;
		this.precioTotal = this.importeNeto + this.importeIva;
	}
	
	private void setTipoFactura(TipoCliente tipoCliente) {
		if (this.cliente.getTipoCliente() == TipoCliente.EMPRESA) {
			this.tipo = 'A';
		}
		else {
			this.tipo = 'B';
		}
	}
	
	public float getPrecioTotal() {
		return this.precioTotal;
	}
	
	public ArrayList<FacturaRenglon> getRenglones(){
		return this.renglones;
	}
	
	public String toString() {
		String factura = "";
		for(FacturaRenglon renglon : this.renglones) {
			factura += renglon.toString() + "\n" ;
		}
		factura += " Importe Neto: " + this.importeNeto;
		factura += " Importe Iva: " + this.importeIva;
		factura += " Precio total: " + this.precioTotal+ "\n";
		factura += this.tipo;
		return factura;
	}
	
	public FacturaView toView() {
		return new FacturaView(this.numero,this.fecha, this.renglones, this.cliente.toView(), this.tipo, this.importeIva, this.importeNeto, this.precioTotal); 
	}

	
	
}
