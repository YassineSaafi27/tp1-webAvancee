// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.BeanPerson;

public class Controller extends HttpServlet {
   public Controller() {
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      String var3 = var1.getParameter("firstName");
      String var4 = var1.getParameter("lastName");
      String var5 = var1.getParameter("birthDay");
      String var6 = var1.getParameter("sex");
      BeanPerson var7 = new BeanPerson(var3, var4, var5, var6);
      var1.setAttribute("person", var7);
      DateTimeFormatter var8 = DateTimeFormatter.ofPattern("MM/dd/uuuu");
      LocalDate var9 = LocalDate.parse(var5, var8);
      String var10;
      if (var9.getYear() < 1990) {
         var10 = "/old.jsp";
      } else {
         var10 = "/young.jsp";
      }

      RequestDispatcher var11 = var1.getRequestDispatcher(var10);
      var11.forward(var1, var2);
   }
}
