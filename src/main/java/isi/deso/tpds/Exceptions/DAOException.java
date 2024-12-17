package isi.deso.tpds.Exceptions;

import java.sql.SQLException;

public class DAOException extends SQLException {
    public DAOException(String e) {
        super(e);
    }
    
}
