package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.CabeceraVenta;
import com.krakedev.inventarios.entidades.DetalleVentas;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CabeceraVentasBDD {
	public void registrarVenta(CabeceraVenta cabeceraVenta) throws KrakeDevException {
        Connection con = null;
        PreparedStatement ps = null, psDet = null, psHis = null, psActCabecera = null;
        ResultSet rsClave = null;

        try {
            con = ConexionBDD.obtenerConexion();
            con.setAutoCommit(false); 
            String sqlCabecera = " INSERT INTO cabecera_ventas (fecha, subtotal, iva, total) VALUES (?, ?, ?, ?) ";
            ps = con.prepareStatement(sqlCabecera, Statement.RETURN_GENERATED_KEYS);

            Date fechaActual = new Date();
            ps.setDate(1, new java.sql.Date(fechaActual.getTime()));
            ps.setBigDecimal(2, BigDecimal.ZERO);
            ps.setBigDecimal(3, BigDecimal.ZERO);
            ps.setBigDecimal(4, BigDecimal.ZERO);
            ps.executeUpdate();

            rsClave = ps.getGeneratedKeys();
            int codigoCabecera = 0;
            if (rsClave.next()) {
                codigoCabecera = rsClave.getInt(1);
            }

            BigDecimal totalSinIva = BigDecimal.ZERO;
            BigDecimal totalIva = BigDecimal.ZERO;
            BigDecimal totalConIva = BigDecimal.ZERO;

            String sqlDetalle = " INSERT INTO detalle_ventas (cabecera_de_ventas, producto, cantidad, precio_venta, subtotal, subtotal_iva) VALUES (?, ?, ?, ?, ?, ?) ";
            String sqlHistorial = " INSERT INTO historial_stock (fecha, referencia, producto, cantidad) VALUES (?, ?, ?, ?) ";

            for (DetalleVentas det : cabeceraVenta.getDetalles()) {
                BigDecimal cantidad = BigDecimal.valueOf(det.getCantidad());
                BigDecimal subtotal = det.getPrecioVenta().multiply(cantidad);
                BigDecimal iva = subtotal.multiply(new BigDecimal("0.12"));
                BigDecimal subtotalConIva = subtotal.add(iva);

                psDet = con.prepareStatement(sqlDetalle);
                psDet.setInt(1, codigoCabecera);
                psDet.setInt(2, det.getProducto().getCodigoProducto());
                psDet.setInt(3, det.getCantidad());
                psDet.setBigDecimal(4, det.getPrecioVenta());
                psDet.setBigDecimal(5, subtotal);
                psDet.setBigDecimal(6, subtotalConIva);
                psDet.executeUpdate();

                psHis = con.prepareStatement(sqlHistorial);
                psHis.setTimestamp(1, new Timestamp(fechaActual.getTime()));
                psHis.setString(2, "VENTA: " + codigoCabecera);
                psHis.setInt(3, det.getProducto().getCodigoProducto());
                psHis.setInt(4, -det.getCantidad());
                psHis.executeUpdate();

                totalSinIva = totalSinIva.add(subtotal);
                totalIva = totalIva.add(iva);
                totalConIva = totalConIva.add(subtotalConIva);
            }

            String sqlActualizarCabecera = " UPDATE cabecera_ventas SET subtotal = ?, iva = ?, total = ? WHERE codigo = ? ";
            psActCabecera = con.prepareStatement(sqlActualizarCabecera);
            psActCabecera.setBigDecimal(1, totalSinIva);
            psActCabecera.setBigDecimal(2, totalIva);
            psActCabecera.setBigDecimal(3, totalConIva);
            psActCabecera.setInt(4, codigoCabecera);
            psActCabecera.executeUpdate();

            con.commit(); 
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); 
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw new KrakeDevException("ERROR AL REGISTRAR VENTA. DETALLE: " + e.getMessage(), e);
        } finally {
            try {
                if (rsClave != null) rsClave.close();
                if (ps != null) ps.close();
                if (psDet != null) psDet.close();
                if (psHis != null) psHis.close();
                if (psActCabecera != null) psActCabecera.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
