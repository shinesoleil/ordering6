package com.thoughtworks.ketsu.web.jersey;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.payment.Payment;
import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.user.User;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

//    private final String baseUri;

    public Routes(UriInfo uriInfo) {
    }
//
//
//    public URI productUrl(Product product) {
//        return URI.create(String.format("%sproducts/%s", baseUri, product.getId()));
//    }


    public URI productUrl(Product product) {
        return URI.create("products/" + product.getId());
    }

    public URI userUrl(User user) {
        return URI.create("users/" + user.getId());
    }

    public URI orderUrl(Order order, int userId) {
        return URI.create("users/" + userId + "/orders/" + order.getId());
    }

    public URI paymentUrl(Payment payment, int userId) {
        return URI.create("users/" + userId + "/orders/" + payment.getOrderId());
    }
}
