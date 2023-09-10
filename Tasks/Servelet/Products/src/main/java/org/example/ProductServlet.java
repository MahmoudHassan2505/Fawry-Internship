package org.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebFilter("/product/*")
public class ProductServlet extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        ProductRepository repository = new ProductRepository();
        System.out.println(request.getServletPath());
        String uri = request.getServletPath().substring(9);
        switch (uri) {
            case "list": {
                List<ProductModel> products = repository.listAll();
                request.setAttribute("productList", products);
                request.getRequestDispatcher("/ListProduct.jsp").forward(request, response);
                break;
            }
            case "add": {
                request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
                break;

            }
            case "addProduct": {

                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("ProductName");

                repository.add(name, id);

                response.sendRedirect("list");

                break;


            }
            case "remove": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("ProductName");

                repository.remove(name,id);


                System.out.println("removing");
                System.out.println(request.getServletPath());
                response.sendRedirect("product/list");

            }

            default:
                response.getWriter().println("Error666");
        }
    }
}
