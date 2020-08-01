package sample;

import java.sql.Connection;
import sample.connection;

public class factory {

    protected static final Connection conn  = connection.getInstance();

    public static DAO getInstructeur(){
        return new InstructeurDAO(conn);
    }
}
