package com.example.demo.services;


import com.example.demo.entities.User;
import com.example.demo.entities.UserData;
import com.example.demo.repositories.UserDataRepository;
import com.example.demo.repositories.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    
    @Autowired
    private UserDataRepository userDataRepository;


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


    public void save(InputStream inputStream) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            Cell cell = cellIterator.next();
            String name = cell.getStringCellValue();
            cell = cellIterator.next();
            String rut = cell.getStringCellValue();
            cell = cellIterator.next();
            String field1 = cell.getStringCellValue();
            cell = cellIterator.next();
            String field2 = cell.getStringCellValue();

            User user = User.builder().nombre(name).rut(rut).build();
            User u = userRepository.save(user);

            UserData userData = UserData.builder().campo1(field1).campo2(field2).user(u).build();
            userDataRepository.save(userData);

        }
        inputStream.close();




    }

}
