package jdbcdemo.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jdbcdemo.dao.*;
import jdbcdemo.dao.uow.UnitOfWork;
import jdbcdemo.domain.*;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	System.out.println( "Inicjalizacja" );
    	
    	RepositoryCatalog workdb = new JdbcCatalogFactory().HsqlDbWorkDb();
    	workdb.people().createTable();
    	workdb.cars().add(new Car("vw", "GWE 6666"));
/*
    	// Deklaruje przed try/catch bo inaczej nie widoczne w dalszej części
		Connection connection = null;
		UnitOfWork uow;
		RepositoryCatalog repo = null;
    	
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		repo = new JdbcRepositoryCatalog(connection, uow); //nie widze powodu, żeby to było w w/w trycatchu
		
		// Jak już się połączyłem to mogę produkować reposy 
    	Repository<Person> peopleRepo = repo.people();;
    	Repository<Car> carsRepo = repo.cars();
		*/
		System.out.println( "Wypełnianie przestrzeni" );
		
		
		/*
    	peopleRepo.add(new Person("Jan", "Kowalski", 30));    	
    	carsRepo.add(new Car("vw", "GWE 6666"));
    	
    	Car vw2bmw = new Car("bmw", "GWE 6666");
    	vw2bmw.setId(0);
    	
    	carsRepo.update(vw2bmw);
    	
    	System.out.println( "Ludzie:" );
    	System.out.println(peopleRepo.toString());
    	
    	System.out.println( "Auta:" );
    	System.out.println(carsRepo.toString());
    	*/
    	System.out.println( "Zakończenie" );
    	
    	
    	
    }
}
