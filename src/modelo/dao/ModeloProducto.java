package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Producto;
import modelo.bean.Talla;

public class ModeloProducto extends Conector{

	public ArrayList<Producto> getAll() {
		// TODO implementar
		return null;
	}

	public Producto get(int id) {
		// TODO implementar
		return null;
	}

	public void insert(Producto producto) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement(
					"insert into productos (nombre, stock, fecha_compra,color,made_in,precio,descuento,tallas) values (?, ?, ?, ?, ?, ?,?,?)");
			pst.setString(1, producto.getNombre());
			pst.setInt(2, producto.getStock());
			pst.setDate(3, new java.sql.Date(producto.getFecha_compra().getTime()));
			pst.setString(4, producto.getColor());
			pst.setString(5, producto.getMade_in());
			pst.setDouble(6, producto.getPrecio());
			pst.setInt(7, producto.getDescuento());
			pst.setString(8, producto.getTallas());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Producto producto) {
		// TODO implementar
	}

	public void delete(int id) {
		// TODO implementar
	}

	public ArrayList<Producto> deLaTalla(Talla talla) {
		// TODO implementar, un poco mas dificil
		return null;
	}
}
