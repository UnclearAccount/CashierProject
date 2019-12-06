package profit;
import Connection.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProfitModel {
    int totalProfit = 0;
    public ProfitModel(){        
    }
        public int getTotalProfit(int totalProfit){
        totalProfit = 0;
        try{
        String query = "SELECT * FROM historytransaction";
        Statement statement = DatabaseConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
           String tempTotalProfit = resultSet.getString("profit");
           totalProfit  = Integer.parseInt(tempTotalProfit);
           this.totalProfit = this.totalProfit +totalProfit;
        }
    }catch(SQLException sQLException){
        JOptionPane.showMessageDialog(null, "CANT PROCESS YOUT TRANSACTION");
    }
    return this.totalProfit;
    }
}