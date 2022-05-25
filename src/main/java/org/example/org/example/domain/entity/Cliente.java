package org.example.org.example.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name="cliente")

public class Cliente {
//    @Id define a PK dessa entidade
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)//Indentifica o autoincrement
    @Column(name = "id")
    private Integer id;
    @Column(name= "nome", length = 100) //não é necessário porque o prórpio entity já define que são campos de coluna
    private String nome;
    @Column(name="cpf", length = 11)
    private String cpf;
//mapeamento de pedidos, para obter todos os pedidos de cliente
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;
//o set não aceita itens repetidos
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public Cliente( String nome) {

        this.nome = nome;
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
