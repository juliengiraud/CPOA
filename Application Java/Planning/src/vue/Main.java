package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import metier.*;
import persistance.modelDAO.*;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        ProjectionDAO projectionDAO = new ProjectionDAO();
        
        ArrayList<Projection> projections = (ArrayList<Projection>) projectionDAO.getProjections();
        
        projections.forEach((projection) -> {
            System.out.println(projection.toString());
        });
        
        //System.out.println();
    
    }

}
