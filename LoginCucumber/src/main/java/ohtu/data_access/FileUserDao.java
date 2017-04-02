/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

/**
 *
 * @author ilkka
 */
public class FileUserDao implements UserDao {

    private String filename;

    public FileUserDao(String filename) {
        this.filename = filename;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();

        try {
            Scanner fs = new Scanner(new File(filename));
            while (fs.hasNextLine()) {
                String[] row = fs.nextLine().split(":");
                users.add(new User(row[0], row[1]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei voitu lukea");
        }

        return users;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(user.getUsername() + ":" + user.getPassword() + "\n");
            fw.close();
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen epäonnistui");
        }
    }

}
