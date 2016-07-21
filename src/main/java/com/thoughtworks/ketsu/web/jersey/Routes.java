package com.thoughtworks.ketsu.web.jersey;

import com.thoughtworks.ketsu.domain.product.Product;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private final String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }


    public URI productUrl(Product product) {
        return URI.create(String.format("%sproducts/%s", baseUri, product.getId()));
    }
}
