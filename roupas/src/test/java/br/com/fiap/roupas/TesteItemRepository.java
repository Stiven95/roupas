package br.com.fiap.roupas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.entity.Item;
import br.com.fiap.entity.Order;
import br.com.fiap.entity.Product;
import br.com.fiap.repository.ItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteItemRepository {

}
