package Tp.DS.Exceptions;

import java.sql.SQLException;

public class DAOException extends SQLException {

    public DAOException(String e) {
        super(e);
    }

    public DAOException(String error_al_eliminar_item_de_menú_por_ID, SQLException e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
