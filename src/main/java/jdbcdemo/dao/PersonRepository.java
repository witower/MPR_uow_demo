package jdbcdemo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbcdemo.dao.mappers.ResultSetMapper;
import jdbcdemo.domain.Person;

public class PersonRepository extends RepositoryBase<Person> {
	
	public PersonRepository(Connection connection, ResultSetMapper<Person> mapper) throws SQLException{
		super(connection, mapper);
	}
	
	@Override
	protected String tableName() {
		return "person";
	}
	
	@Override
	protected String createTableSql() {
		return "CREATE TABLE person("
				+ "id INT GENERATED BY DEFAULT AS IDENTITY,"
				+ "name VARCHAR(20),"
				+ "surname VARCHAR(50),"
				+ "age INT"
				+ ")";
	}
	
	@Override
	protected String insertSql() {
		return "INSERT INTO person(name,surname,age) VALUES (?,?,?)";
	}
	
	@Override
	protected String updateSql() {
		return "UPDATE person SET (name, surname, age) = (?,?,?) WHERE id=?";
	}
	
	@Override
	protected String deleteSql() {
		return "DELETE FROM person WHERE id=?";
	}
	
	@Override
	protected String selectAllSql() {
		return "SELECT * FROM person";
	}
	
	@Override
	protected void setupInsert(Person person) throws SQLException {
		insert.setString(1, person.getName());
		insert.setString(2, person.getSurname());
		insert.setInt(3, person.getAge());
	}

	@Override
	protected void setupUpdate(Person person) throws SQLException {
		update.setString(1, person.getName());
		update.setString(2, person.getSurname());
		update.setInt(3, person.getAge());
		update.setInt(4, person.getId());
	}
}
