package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.product.Product;
import com.thoughtworks.ketsu.domain.product.ProductRepository;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class ProductRepositoryTest {
  @Inject
  ProductRepository productRepository;

  @Test
  public void should_create_product_and_find_product_by_id() {
    Map<String, Object> info = TestHelper.productMap();
    productRepository.create(info);
    int id =Integer.valueOf(String.valueOf(info.get("id")));
    Optional<Product> productOptional = productRepository.findById(id);

    assertThat(productOptional.get().getId(), is(id));
  }
}
