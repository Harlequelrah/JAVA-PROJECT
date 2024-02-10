/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Maxime
 */
public class HelpDao {
    
    public static List<Map<String, Object>> convertResultSetToMapList(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> result = new ArrayList<>();
        
        // Itérer sur les lignes du ResultSet
        while (resultSet.next()) {
            // Créer une nouvelle map pour chaque ligne
            Map<String, Object> row = new HashMap<>();
            
            // Itérer sur les colonnes de la ligne
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                // Récupérer le nom de la colonne
                String columnName = resultSet.getMetaData().getColumnName(i);
                
                // Récupérer la valeur de la colonne
                Object columnValue = resultSet.getObject(i);
                
                // Ajouter la paire clé-valeur à la map de la ligne
                row.put(columnName, columnValue);
            }
            
            // Ajouter la map de la ligne à la liste de résultats
            result.add(row);
        }
        
        return result;
    }
}


