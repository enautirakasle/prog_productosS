package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Producto;
import modelo.bean.Talla;

public class ModeloProducto extends Conector{

	public ArrayList<Producto> getAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from productos");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setColor(rs.getString("color"));
				producto.setMade_in(rs.getString("made_in"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setDescuento(rs.getInt("descuento"));
				producto.setTallas(rs.getString("tallas"));
				
				productos.add(producto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
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
