package nl.hva.web;


import nl.hva.web.model.Product;
import nl.hva.web.model.ShoppingItem;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Peter
 */
@WebServlet(urlPatterns = {
    "/products", "/viewProductDetails",
    "/addToCart", "/viewCart"})
public class WebShopServlet extends HttpServlet {

    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "Bravo 32' HDTV",
                "Low-cost HDTV from renowned TV manufacturer",
                159.95F));
        products.add(new Product(2, "Bravo BluRay Player",
                "High quality stylish BluRay player", 99.95F));
        products.add(new Product(3, "Bravo Stereo System",
                "5 speaker hifi system with iPod player",
                129.95F));
        products.add(new Product(4, "Bravo iPod player",
                "An iPod plug-in that can play multiple formats",
                39.95F));
        products.add(new Product(5, "Awsome",
                "This is my awsome Italian product",
                39.95F));
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        String uri = request.getRequestURI();
        String uri2 = request.getRequestURI();
        if (uri.endsWith("/products")) {
            sendProductList(response);
        } else if (uri.endsWith("/viewProductDetails")) {
            // add some code here
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            String productid = request. getParameter("id");
            Product product = getProduct(Integer.parseInt(productid));

            if (product != null) {
            writer.println("<html><head>"
                    + "<title>Product Details</title></head>"
                    + "<body><h2>Product Details</h2>"
                    + "<form method='POST'>");
            writer.println("<input type='hidden' name='id' "+ "value='" + productid + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                    + product.getName() + "</td></tr>");
            writer.println("<tr><td>Description:</td><td>"
                    + product.getDescription() + "</td></tr>");
            writer.println("<tr>" + "<tr>"
                    + "<td><input name='quantity'/></td>"
                    + "<td><input type='submit' value='Buy'/>"
                    + "</td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='products'>Product List</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("No product found");
        }
             //sendProductDetails(response);
        } else if (uri.endsWith("viewCart")) {
response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><head><title>Shopping Cart</title>" + "</head>");
            writer.println("<body><a href='products'>" + "Product List</a>");
            HttpSession session = request.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
            if (cart != null) {
                writer.println("<table>");
                writer.println("<tr><th>Quantity</th><th>Product</th><th>Price</th><th>Amount</th></tr>");
                // add some code here          
                float totaal = 0; 
                for (ShoppingItem product : cart)
                {
                    float subtotaal = product.getQuantity() * product.getPrice();
                    totaal = totaal + subtotaal;
                    writer.println("<tr><td style='width:200px;text-align:center;'>"+product.getQuantity()+"</td><td style='width:200px;text-align:center;'>"+ product.getName() + "</td><td style='width:200px;text-align:center;'>"+ product.getPrice() + "</td><td style='width:200px;text-align:center;'>"+subtotaal+"</td></tr>");
                } 
                writer.println("<tr><td></td><td></td><td></td><td>Totaal: "+totaal+"</td></tr>");
                writer.println("</table>");
            }
            writer.println("</body></html>");        } 
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession();
        List<ShoppingItem> cart = null;
        // add to cart
        int productId = 0;
        int quantity = 0;
        float price = 0;
        String name = null;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String productid = request. getParameter("id");
        Product products = getProduct(Integer.parseInt(productid));
        name = products.getName();
        price = Float.valueOf(products.getPrice());
        try {
            productId = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity")); 
        } catch (NumberFormatException e) {
        }
        Product product = getProduct(productId);
        if (product != null && quantity >= 0) {
            ShoppingItem shoppingItem = new ShoppingItem(product, quantity, price, name);
            if (session.getAttribute(CART_ATTRIBUTE) == null)
            {
                cart = new ArrayList<ShoppingItem>();
                cart.add(new ShoppingItem(product, quantity, price, name));
            }
            else
            {
                cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
                cart.add(new ShoppingItem(product, quantity, price, name));
            }
            session.setAttribute(CART_ATTRIBUTE, cart);
        }
        sendProductList(response);
    }

    private void sendProductList(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Products</title>"
                + "</head><body><h2>Products</h2>");
        writer.println("<ul>");
        for (Product product : products) {
            writer.println("<li>" + product.getName() + "("
                    + currencyFormat.format(product.getPrice())
                    + ") (" + "<a href='viewProductDetails?id="+ product.getId() + "'>Details</a>)");
        }
        writer.println("</ul>");
        writer.println("<a href='viewCart'>View Cart</a>");
        writer.println("</body></html>");

    }

    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
