package aula01_2405;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteConexaoBD {

	private static Connection con;
	private static Statement st;
	private static PreparedStatement ps;

	private static String url = "jdbc:mysql://localhost:3306/vendas";

	public static void main(String[] args) {
		try {
			con = DriverManager.getConnection(url, "root", "fiap");

			st = con.createStatement();

			//String nome = "José";
			//String email = "jose@teste";

			//st.execute("INSERT INTO CLIENTES (NOME, EMAIL) " + " VALUES('" + nome + "','" + email + "')");

			//st.close();			
			//===========================================================================
			//===========================================================================
			
//			String nome = "Gilberto";
//            String email = "giba@gmail";
//			
//			String sql = "INSERT INTO CLIENTES (NOME, EMAIL) VALUES (?,?)";
//            
//			  ps = con.prepareStatement(sql);
//            ps.setString(1, nome);
//            ps.setString(2, email);
//            
//            ps.execute();
//            con.close();
            
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTES");
            
            while(rs.next()) {
            	System.out.println(rs.getString("nome"));
            	System.out.println(rs.getString("email"));
            }
            
            con.close();


			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
