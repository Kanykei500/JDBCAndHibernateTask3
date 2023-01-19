package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private Connection connection;

    public UserDaoJdbcImpl() {
        this.connection = Util.getConnection();

    }

    public void createUsersTable() {
        String sql = " create table if not exists users (id serial primary key ,name varchar not null ,last_name varchar not null,age int)";
        try (Statement statement = connection.createStatement();) {
            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void dropUsersTable() {
        String sql = "drop table users";
        try (PreparedStatement pr  = connection.prepareStatement(sql)) {
            pr.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users(name, last_name,age)values (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            if (id==0)
                throw new Exception();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String sql = " delete from users where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "select * from users";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                allUsers.add(new User(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
               // return allUsers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allUsers;
    }


        public void cleanUsersTable () {
        String sql="truncate table users";
            try (Statement statement = connection.createStatement()){
                statement.execute(sql);


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }