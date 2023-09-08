package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {

    ProductRepository productRepository = new ProductRepository();

    // /products/edit/435

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println("path: " + path);
        String[] pathParts = path.split("/");

        System.out.println(Arrays.asList(pathParts));

        String op = pathParts[1];


        if (op.equals("edit")) {
            String id = pathParts[2];
            System.out.println("Editting prod #" + id);
        } else if (op.equals("list")) {
            response.setContentType("application/json");
            List<Product> products = productRepository.findProducts();
            response.getWriter().println("[");
            for (Product p : products) {
                response.getWriter().println("{");
                response.getWriter().println("\"name\":\"" + p.getName() + "\",");
                response.getWriter().println("\"price\":\"" + p.getPrice() + "\"");
                response.getWriter().println("}");
            }
            response.getWriter().println("]");
        }

    }
}
