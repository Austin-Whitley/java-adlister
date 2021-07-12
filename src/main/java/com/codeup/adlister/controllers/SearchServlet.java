package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")

public class SearchServlet extends HttpServlet {
    //this will search, take in all of the results inside our ads db to search through every title

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query"); //we call "query" parameter (this is referencing the navbar.jsp form name=query)
        List<Ad> results = DaoFactory.getAdsDao().searchByTitle(query); //create a variable named result that calls the DaoFactory and the getAdsDao method. Then we can call the .searchByTitle() method BECAUSE our getAdsDao IS an instance of MySQLAdsDao... i know its confusing but now we can go to MySQLAdsDao to see what our method looks like.
        req.setAttribute("ads", results);
        req.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(req, resp);
    }
}
