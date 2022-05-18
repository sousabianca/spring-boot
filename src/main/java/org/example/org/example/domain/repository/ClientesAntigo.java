package org.example.org.example.domain.repository;

import org.example.org.example.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//Com essa annotation o spring entende que vai ser feito operações com a base de dados
//E as exceptions serão traduzidas
@Repository
public class ClientesAntigo {
    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    Entity Manager é uma interface que faz todas as operações na base com as entidades
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public Cliente salvar(Cliente cliente){
//        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        entityManager.persist(cliente);
        return cliente;
    }
    @Transactional
    public Cliente atualizar (Cliente cliente){
//        jdbcTemplate.update(UPDATE, new Object[]{
//                cliente.getNome(), cliente.getId()});
        entityManager.merge(cliente);
            return cliente;
        };
    @Transactional
    public void deletar(Cliente cliente){
        if (!entityManager.contains(cliente)) {
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar (Integer id){
//        jdbcTemplate.update(DELETE, new Object[]{id});
          Cliente cliente = entityManager.find(Cliente.class, id);
          deletar(cliente);
    }
    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome (String nome){
        String jpql = "select c from Cliente c where c.nome like :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" +nome+ "%");
        return query.getResultList();
    }

//    O RowMapper mapeia o resultado do bd para uma classe
    @Transactional(readOnly = true)
    public List<Cliente> obterTodos(){
//        return jdbcTemplate.query(SELECT_ALL, obterClienteRowMapper());
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

//    private RowMapper<Cliente> obterClienteRowMapper() {
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //return new Cliente(rs.getString("nome"));
//                Integer id = rs.getInt("id");
//                String nome = rs.getString("nome");
//                return new Cliente(id, nome);
//            }
//        };
//    }

}
